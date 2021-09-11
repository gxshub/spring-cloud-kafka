package csci318.demo.binding;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

public interface InOutBinder {

    @Input(BinderRegister.INBOUND)
    KStream<?, ?> streamIn();

    @Output(BinderRegister.OUTBOUND)
    KStream<?, ?> streamOut();
}
