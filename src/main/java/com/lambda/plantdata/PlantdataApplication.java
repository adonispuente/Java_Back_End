package com.lambda.plantdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing
@SpringBootApplication
public class PlantdataApplication {

    /**
     * Connect to the system environment where environment variables live.
     */
    @Autowired
    private static Environment env;

    /**
     * If an environment variable is not found, set this to true
     */
    private static boolean stop = false;
    private static void checkEnvironmentVariable(String envvar)
    {
        if (System.getenv(envvar) == null)
        {
            stop = true;
        }
    }

    public static void main(String[] args) {
        checkEnvironmentVariable("OAUTHCLIENTID");
        checkEnvironmentVariable("OAUTHCLIENTSECRET");

        if (!stop)
        {
            // so run the application!
            SpringApplication.run(PlantdataApplication.class,
                    args);
        }
    }

}
