package csci318.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface Bindings {

    // The string "outbound" is from application.yml.
    @Input("outbound")
    MessageChannel outbound();
}
