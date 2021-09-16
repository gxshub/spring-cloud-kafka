package csci318.demo.binding;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

public interface StreamsBinding {

    // Binding names here must be defined in application.yml
    public static final String INBOUND = "appliance-inbound";
    public static final String OUTBOUND = "brand-outbound";

    @Input(INBOUND)
    KStream<?, ?> streamIn();

    @Output(OUTBOUND)
    KStream<?, ?> streamOut();
}
