package csci318.demo.binder;

import csci318.demo.binder.binding.InOutBound;
import csci318.demo.model.Appliance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;


@EnableBinding(InOutBound.class)
public class Publisher {

    @Autowired
    private InOutBound inOutBound;

    public void publish(Appliance appliance) {
        inOutBound.outbound().send(MessageBuilder
                .withPayload(appliance).build());
    }

}
