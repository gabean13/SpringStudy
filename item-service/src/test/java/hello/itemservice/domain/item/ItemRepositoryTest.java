package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    public ItemRepository itemRepository = new ItemRepository();
    @AfterEach
    public void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    public void itemSaveTest(){
        //given
        Item item = new Item("item1", 10000, 10);

        //when
        Item savedItem = itemRepository.save(item);

        //then
        assertThat(item).isEqualTo(savedItem);
    }

    @Test
    public void findAllTest(){
        Item item1 = new Item("item1", 10000, 10);
        Item item2 = new Item("item2", 20000, 20);
        itemRepository.save(item1);
        itemRepository.save(item2);

        //when
        List<Item> items = itemRepository.findAll();

        //then
        assertThat(items.size()).isEqualTo(2);
        assertThat(items).contains(item1, item2);
    }

    @Test
    public void updateItemTest(){
        Item item = new Item("item1", 10000, 10);
        Item itemParam = new Item("itemFix", 20000, 30);
        itemRepository.save(item);

        //when
        itemRepository.update(item.getId(), itemParam);

        //then
        assertThat(item.getItemName()).isEqualTo(itemParam.getItemName());
        assertThat(item.getPrice()).isEqualTo(itemParam.getPrice());
        assertThat(item.getQuantity()).isEqualTo(itemParam.getQuantity());
    }
}