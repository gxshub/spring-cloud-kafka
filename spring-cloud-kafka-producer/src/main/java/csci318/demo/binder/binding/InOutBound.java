package csci318.demo.binder.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface InOutBound {

    @Output(BoundName.OUTBOUND)
    MessageChannel outbound();

}
