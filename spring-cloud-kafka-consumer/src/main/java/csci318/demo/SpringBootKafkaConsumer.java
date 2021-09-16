package csci318.demo;

import csci318.demo.binding.ConsumerBinding;
import csci318.demo.model.BrandQuantity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@SpringBootApplication
@EnableBinding(ConsumerBinding.class)
public class SpringBootKafkaConsumer {

	private static final Logger log = LoggerFactory.getLogger(SpringBootKafkaConsumer.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaConsumer.class, args);
	}

	@StreamListener(ConsumerBinding.INBOUND)
	public void consumer(BrandQuantity brandQuantity) {
		log.info(brandQuantity.toString());
	}
}
