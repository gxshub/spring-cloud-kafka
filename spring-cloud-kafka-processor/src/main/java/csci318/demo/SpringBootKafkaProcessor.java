package csci318.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;


@SpringBootApplication
public class SpringBootKafkaProcessor {

    @Autowired
    private InteractiveQueryService interactiveQueryService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaProcessor.class, args);
    }
}
