package csci318.demo.service;

import csci318.demo.model.BrandQuantity;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandInteractiveQuery {

    private InteractiveQueryService interactiveQueryService;

    //@Autowired
    public BrandInteractiveQuery(InteractiveQueryService interactiveQueryService) {
        this.interactiveQueryService = interactiveQueryService;
    }

    public BrandQuantity getBrandQuantity(String brandName) {
        if (keyValueStore().get(brandName) != null) {
            long quantity = keyValueStore().get(brandName);
            return new BrandQuantity(brandName, quantity);
        } else {
            return null; //TODO: should use an Exception here.
        }
    }

    public List<String> getBrandNames() {
        List<String> brandList = new ArrayList<>();
        KeyValueIterator<String, Long> all = keyValueStore().all();
        while (all.hasNext()) {
            String next = all.next().key;
            brandList.add(next);
        }
        return brandList;
    }

    private ReadOnlyKeyValueStore<String, Long> keyValueStore() {
        return this.interactiveQueryService.getQueryableStore(ApplianceStreamProcessing.STATE_STORE,
                QueryableStoreTypes.keyValueStore());
    }

}
