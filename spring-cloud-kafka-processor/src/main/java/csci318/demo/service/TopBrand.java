package csci318.demo.service;

import csci318.demo.binding.BinderRegister;
import csci318.demo.binding.InOnlyBinder;
import csci318.demo.model.Appliance;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(InOnlyBinder.class)
public class TopBrand {
    @StreamListener(BinderRegister.INBOUND)
    public void process(KStream<?, Appliance> applianceKStream) {
        applianceKStream.
                map((k,v) ->{
                    String newkey = Integer.toString(v.getId());
                    String value = v.getBrand();
                    return KeyValue.pair(newkey, value);
                }).
                groupBy((keyIgnored, value)->value).count().toStream().print(Printed.toSysOut());
        /* TODO */
    }
}
