package csci318.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootKafkaProcessor {

    /*
    @Autowired
    private InOutBound bindings;

     */

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaProcessor.class, args);
    }

    /*
    @StreamListener(BoundName.INBOUND)
    @SendTo(BoundName.OUTBOUND)
    public KStream<String, Long> process(KStream<String, Appliance> applianceKStream) {
        return applianceKStream.groupByKey().count().toStream();
    }

     */

}
