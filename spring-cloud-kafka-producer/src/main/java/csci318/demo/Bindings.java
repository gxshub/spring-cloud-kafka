package csci318.demo;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Bindings {

    // The string "outbound1" is from application.yml.
    @Output("outbound1")
    MessageChannel outbound();
}
