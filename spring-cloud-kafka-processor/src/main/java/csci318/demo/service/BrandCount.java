package csci318.demo.service;

import csci318.demo.binding.BinderRegister;
import csci318.demo.binding.InOutBinder;
import csci318.demo.model.Appliance;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;


@EnableBinding(InOutBinder.class)
public class BrandCount {

    @StreamListener(BinderRegister.INBOUND)
    @SendTo(BinderRegister.OUTBOUND)
    public KStream<String, Long> process(KStream<Object, Appliance> applianceStream) {

        KStream<String, Long> brandCountStream = applianceStream.
                map((key,appliance) -> {
                    String newkey = Integer.toString(appliance.getId());
                    String value = appliance.getBrand();
                    return KeyValue.pair(newkey, value);
                }).
                groupBy((keyIgnored, value) -> value).count().toStream();
        brandCountStream.print(Printed.<String, Long>toSysOut().withLabel("brand count"));
        return brandCountStream;
    }


}
