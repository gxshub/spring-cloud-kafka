package csci318.demo;

import csci318.demo.binder.binding.BoundName;
import csci318.demo.binder.binding.InOutBound;
import csci318.demo.model.Appliance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@SpringBootApplication
@EnableBinding(InOutBound.class)
public class SpringBootKafkaConsumer {

    //@Autowired
    //private InOutBound inOutBound;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaConsumer.class, args);
    }

    @StreamListener(BoundName.INBOUND)
    public void listen(Appliance appliance) {

        System.out.println(appliance.toString());

    }

}


