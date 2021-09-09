package csci318.demo.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Bindings {

    // String "inbound1" is specified in application.yml
    @Input("inbound1")
    SubscribableChannel inbound();
}
