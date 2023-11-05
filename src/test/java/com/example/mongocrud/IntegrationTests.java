package com.example.mongocrud;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MongoDBContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {IntegrationTests.Initializer.class})
public abstract class IntegrationTests {

    private static final MongoDBContainer MONGO_DB_CONTAINER = new MongoDBContainer("mongo:latest");

    static {
        MONGO_DB_CONTAINER.start();
    }

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues.of("spring.data.mongodb.uri=" + MONGO_DB_CONTAINER.getReplicaSetUrl()).applyTo(applicationContext.getEnvironment());
        }
    }

}
