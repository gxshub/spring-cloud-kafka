package csci318.demo.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutBinding {

    @Output(ChannelNames.OUTBOUND)
    MessageChannel outbound();

}
