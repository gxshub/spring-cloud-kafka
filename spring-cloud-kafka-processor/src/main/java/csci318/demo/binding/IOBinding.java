package csci318.demo.binding;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

public interface IOBinding {

    @Input(ChannelNames.INBOUND)
    KStream<?, ?> streamIn();

    @Output(ChannelNames.OUTBOUND)
    KStream<?, ?> streamOut();
}
