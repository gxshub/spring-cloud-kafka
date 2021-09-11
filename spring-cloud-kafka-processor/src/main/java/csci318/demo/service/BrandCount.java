package csci318.demo.service;

import csci318.demo.binding.BinderRegister;
import csci318.demo.binding.InOnlyBinder;
import csci318.demo.binding.InOutBinder;
import csci318.demo.model.Appliance;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding({InOnlyBinder.class, InOutBinder.class})
public class BrandCount {


    @StreamListener(BinderRegister.INBOUND)
    @SendTo(BinderRegister.OUTBOUND)
    public KStream<String, Long> process(KStream<Object, Appliance> applianceKStream) {
        return applianceKStream.
                map((key,appliance) ->{
                    String newkey = Integer.toString(appliance.getId());
                    String value = appliance.getBrand();
                    return KeyValue.pair(newkey, value);
                }).
                groupBy((keyIgnored, value)->value).count().toStream();
    }

    @StreamListener(BinderRegister.INBOUND)
    public void print(KStream<?, Appliance> applianceKStream) {
        applianceKStream.
                map((key,appliance) ->{
                    String newkey = Integer.toString(appliance.getId());
                    String value = appliance.getBrand();
                    return KeyValue.pair(newkey, value);
                }).
                groupBy((keyIgnored, value)->value).count().toStream().print(Printed.toSysOut());
    }
}
