package csci318.demo.service;

/* This class computes a stream of brand quantities
 * and creates a state store for interactive queries.
 */

import csci318.demo.binding.ChannelNames;
import csci318.demo.binding.IOBinding;
import csci318.demo.model.Appliance;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.state.KeyValueStore;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;


@EnableBinding(IOBinding.class)
public class ApplianceStreamProcessing {
    
    public final static String STATE_STORE = "my-store";

    @StreamListener(ChannelNames.INBOUND)
    @SendTo(ChannelNames.OUTBOUND)
    public KStream<String, Long> process(KStream<Object, Appliance> applianceStream) {

        KTable<String, Long> brandQuantityTable = applianceStream.
                map((key,appliance) -> {
                    String newkey = Integer.toString(appliance.getId());
                    String value = appliance.getBrand();
                    return KeyValue.pair(newkey, value);
                }).
                groupBy((keyIgnored, value) -> value).count(
                Materialized.<String, Long, KeyValueStore<Bytes, byte[]>>as(STATE_STORE).
                        withKeySerde(Serdes.String()).
                        withValueSerde(Serdes.Long())
                );

        // use the following code for testing
        // brandQuantityTable.toStream().print(Printed.<String, Long>toSysOut().withLabel("console output"));

        return brandQuantityTable.toStream();
    }
    
}
