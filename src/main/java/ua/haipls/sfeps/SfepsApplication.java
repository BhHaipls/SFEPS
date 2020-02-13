package ua.haipls.sfeps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("ua.haipls.sfeps.domain")
public class SfepsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SfepsApplication.class, args);
    }

}
