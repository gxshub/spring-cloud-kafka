package csci318.demo;

import csci318.demo.model.Appliance;
import csci318.demo.service.Bindings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@SpringBootApplication
@EnableBinding(Bindings.class)
public class SpringBootKafkaConsumer {

    @Autowired
    private Bindings bindings;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaConsumer.class, args);
    }

    @StreamListener("inbound1")
    public void listen(Appliance appliance) {

        System.out.println(appliance.toString());

    }

}


