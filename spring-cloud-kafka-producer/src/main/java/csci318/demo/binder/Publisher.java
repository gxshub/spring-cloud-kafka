package csci318.demo.binder;

import csci318.demo.binder.binding.InOutBound;
import csci318.demo.model.Appliance;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(InOutBound.class)
public class Publisher {

    private InOutBound binding;

    public Publisher(InOutBound binding) {
        this.binding = binding;
    }

    public void publish(Appliance appliance) {
        this.binding.outbound().send(MessageBuilder.withPayload(appliance).build());
    }

}
