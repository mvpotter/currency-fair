/*
 * Created with IntelliJ IDEA.
 * User: michaelpotter
 * Date: 24/03/15
 * Time: 20:30
 */
package io.github.mvpotter.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class StaticApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(StaticApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StaticApplication.class);
    }

}
