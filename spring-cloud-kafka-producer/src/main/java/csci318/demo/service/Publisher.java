package csci318.demo.service;

import csci318.demo.service.binding.PublisherBinder;
import csci318.demo.model.Appliance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;


@EnableBinding(PublisherBinder.class)
public class Publisher {

    @Autowired
    private PublisherBinder inOutBound;

    public void publish(Appliance appliance) {
        inOutBound.outbound().send(MessageBuilder
                .withPayload(appliance).build());
    }

}
