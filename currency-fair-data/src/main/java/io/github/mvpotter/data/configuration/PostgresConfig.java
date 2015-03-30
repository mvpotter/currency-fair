/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 30/03/15
 * Time: 11:45
 */
package io.github.mvpotter.data.configuration;

import io.github.mvpotter.data.configuration.support.DBProfile;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@Profile(DBProfile.POSTGRES)
public class PostgresConfig {

    public static final String ENV_DATABASE_KEY = "DATABASE_URL";
    public static final String POSTGRES_DRIVER = "org.postgresql.Driver";

    private static final String URL_FORMAT = "jdbc:postgresql://%s:%s%s";

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        String dbProperty = System.getenv(ENV_DATABASE_KEY);
        if(dbProperty != null) {
            final URI uri = new URI(dbProperty);
            final String[] credentials = uri.getUserInfo().split(":");
            final String username = credentials[0];
            String password = "";
            if (credentials.length > 1) {
                password = credentials[1];
            }
            final String url = String.format(URL_FORMAT, uri.getHost(), uri.getPort(), uri.getPath());

            return DataSourceBuilder.create()
                    .driverClassName(POSTGRES_DRIVER)
                    .url(url)
                    .username(username)
                    .password(password)
                    .build();
        }

        throw new IllegalStateException("Unable to create data source");

    }

}
