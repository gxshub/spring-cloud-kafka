package csci318.demo.service.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PublisherBinder {

    @Output(BoundNames.OUTBOUND)
    MessageChannel outbound();

}
