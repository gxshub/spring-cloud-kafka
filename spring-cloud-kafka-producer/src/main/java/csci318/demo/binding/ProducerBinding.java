package csci318.demo.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProducerBinding {

    // Binding names here must be defined in application.yml
    static public final String OUTBOUND = "appliance-outbound";

    @Output(OUTBOUND)
    MessageChannel outbound();

}
