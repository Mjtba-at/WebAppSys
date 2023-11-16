package edu.fra.uas;

import edu.fra.uas.v3autowired.MasterV3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringIoCApplication {

    @Autowired
    private MasterV3 masterV3;

    public static void main(String[] args) {
        SpringApplication.run(SpringIoCApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        CommandLineRunner action = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                // v3autowired
                masterV3.delegateWork();
            }
        };
        return action;
    }

}
