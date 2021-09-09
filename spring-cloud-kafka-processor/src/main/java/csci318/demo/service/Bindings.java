package csci318.demo.service;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

public interface Bindings {

    @Input(BindingNames.INBOUND)
    KStream<?, ?> streamIn();

    @Output(BindingNames.OUTBOUND)
    KStream<?, ?> streamOut();
}
