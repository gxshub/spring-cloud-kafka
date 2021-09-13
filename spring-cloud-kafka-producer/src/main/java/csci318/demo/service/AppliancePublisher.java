package csci318.demo.service;

import csci318.demo.binding.OutBinding;
import csci318.demo.model.Appliance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;


@EnableBinding(OutBinding.class)
public class AppliancePublisher {

    @Autowired
    private OutBinding inOutBound;

    public void publish(Appliance appliance) {
        inOutBound.outbound().send(MessageBuilder
                .withPayload(appliance).build());
    }

}
