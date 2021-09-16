package csci318.demo.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerBinding {

    // Binding names here must be defined in application.yml
    static public final String INBOUND = "brand-inbound";

    @Input(INBOUND)
    SubscribableChannel inbound();

}
