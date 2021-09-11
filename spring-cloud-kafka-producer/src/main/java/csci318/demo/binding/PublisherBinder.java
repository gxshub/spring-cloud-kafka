package csci318.demo.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PublisherBinder {

    @Output(BinderRegister.OUTBOUND)
    MessageChannel outbound();

}
