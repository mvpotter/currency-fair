#!/usr/bin/env bash

cd /vagrant
/opt/maven/bin/mvn -Dmaven.test.skip=true clean install
cd /vagrant/currency-fair-rest/target
java -jar currency-fair-rest-1.0-SNAPSHOT.jar