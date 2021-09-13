package csci318.demo.service;

//@EnableBinding(InOnlyBinder.class)
public class TopBrand {
    /*
    @StreamListener(BinderRegister.INBOUND)
    public void process(KStream<?, Appliance> applianceKStream) {
        applianceKStream.
                map((k,v) ->{
                    String newkey = Integer.toString(v.getId());
                    String value = v.getBrand();
                    return KeyValue.pair(newkey, value);
                }).
                groupBy((keyIgnored, value)->value).count().toStream().print(Printed.toSysOut());

    }

     */
}
