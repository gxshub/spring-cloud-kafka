package csci318.demo;

import csci318.demo.model.Appliance;
import csci318.demo.service.BindingNames;
import csci318.demo.service.Bindings;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
public class SpringBootKafkaProcessor {

    @Autowired
    private Bindings bindings;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaProcessor.class, args);
    }

    @StreamListener(BindingNames.INBOUND)
    @SendTo(BindingNames.OUTBOUND)
    public KStream<String, Long> process(KStream<String, Appliance> applianceKStream) {
        return applianceKStream.groupByKey().count().toStream();
    }

}
