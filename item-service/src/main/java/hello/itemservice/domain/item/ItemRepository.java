package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static Map<Long, Item> store = new HashMap<>();
    private static Long sequence = 0L;
    
    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        Item item = store.get(id);
        return item;
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item itemParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(itemParam.getItemName());
        findItem.setPrice(itemParam.getPrice());
        findItem.setQuantity(itemParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
    }
}
