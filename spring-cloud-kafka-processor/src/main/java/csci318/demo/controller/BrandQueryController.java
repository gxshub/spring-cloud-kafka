package csci318.demo.controller;

import csci318.demo.model.BrandQuantity;
import csci318.demo.service.BrandInteractiveQuery;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BrandQueryController {

    @Autowired
    InteractiveQueryService interactiveQueryService;

    @GetMapping("/brand/{brandName}/quantity")
    BrandQuantity getBrandQuantityByName(@PathVariable String brandName) {
        ReadOnlyKeyValueStore<String, Long> keyValueStore =
                interactiveQueryService.getQueryableStore(BrandInteractiveQuery.STATE_STORE,
                        QueryableStoreTypes.keyValueStore());
        if (keyValueStore.get(brandName) != null) {
            long quantity = keyValueStore.get(brandName);
            return new BrandQuantity(brandName, quantity);
        } else {
            return null; //TODO: should use an Exception here.
        }
    }

    @GetMapping("/brands/all")
    List<String> getAllBrandNames() {
        ReadOnlyKeyValueStore<String, Long> keyValueStore =
                interactiveQueryService.getQueryableStore(BrandInteractiveQuery.STATE_STORE,
                        QueryableStoreTypes.keyValueStore());
        List<String> brandList = new ArrayList<>();
        KeyValueIterator<String, Long> all = keyValueStore.all();
        while (all.hasNext()) {
            String next = all.next().key;
            brandList.add(next);
        }
        return brandList;
    }

}
