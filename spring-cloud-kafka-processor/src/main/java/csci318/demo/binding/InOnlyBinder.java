package csci318.demo.binding;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface InOnlyBinder {

    @Input(BinderRegister.INBOUND)
    KStream<?, ?> streamInOnly();

}
