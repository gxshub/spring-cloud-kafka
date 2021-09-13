package csci318.demo.binding;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface InBinding {

    @Input(ChannelNames.INBOUND)
    KStream<?, ?> streamInOnly();

}
