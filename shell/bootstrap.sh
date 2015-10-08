#!/usr/bin/env bash

sudo apt-get update

sudo wget --no-check-certificate https://github.com/aglover/ubuntu-equip/raw/master/equip_java8.sh && bash equip_java8.sh
sudo wget --no-check-certificate https://github.com/resilva87/ubuntu-equip/raw/master/equip_maven3.sh && bash equip_maven3.sh


# Edit the following to change the name of the database user that will be created:
PG_VERSION=9.3

sudo apt-get -y install "postgresql-$PG_VERSION" "postgresql-contrib-$PG_VERSION"

PG_CONF="/etc/postgresql/$PG_VERSION/main/postgresql.conf"
PG_HBA="/etc/postgresql/$PG_VERSION/main/pg_hba.conf"
PG_DIR="/var/lib/postgresql/$PG_VERSION/main"

sudo sh -c "cat > /etc/profile.d/currencyfair.sh" << 'EOF'
export APP_DB_USER=vagrant
export APP_DB_PASS=dbpass
export APP_DB_NAME=currencyfair
export DATABASE_URL=postgresql://$APP_DB_USER:$APP_DB_PASS@localhost:5432/$APP_DB_NAME
EOF

source /etc/profile.d/currencyfair.sh

# Edit postgresql.conf to change listen address to '*':
sed -i "s/#listen_addresses = 'localhost'/listen_addresses = '*'/" "$PG_CONF"

# Append to pg_hba.conf to add password auth:
echo "host    all             all             all                     md5" >> "$PG_HBA"

# Explicitly set default client_encoding
echo "client_encoding = utf8" >> "$PG_CONF"

# Restart so that all new config is loaded:
service postgresql restart

cat << EOF | su - postgres -c psql
-- Create the database user:
CREATE USER $APP_DB_USER WITH PASSWORD '$APP_DB_PASS';

-- Create the database:
CREATE DATABASE $APP_DB_NAME WITH OWNER=$APP_DB_USER
                                  LC_COLLATE='en_US.utf8'
                                  LC_CTYPE='en_US.utf8'
                                  ENCODING='UTF8'
                                  TEMPLATE=template0;
EOF