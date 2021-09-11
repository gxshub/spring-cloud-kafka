package csci318.demo.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InOutBound {

    @Input(BoundName.INBOUND)
    SubscribableChannel inbound();
}
