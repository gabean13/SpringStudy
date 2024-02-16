package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;

    /**
     * 테스트용 코드
     */
    @PostConstruct
    public void postConstruct() {
        itemRepository.save(new Item("itemA", 20000, 20));
        itemRepository.save(new Item("itemB", 10000, 10));
    }

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable("itemId") Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "/basic/item";
    }

    @GetMapping("/add")
    public String addForm(){
        return "basic/addForm";
    }

//    @PostMapping("/add")
    public String addItemV1(@RequestParam("itemName")String itemName,
                           @RequestParam("price") Integer price,
                           @RequestParam("quantity") Integer quantity,
                           Model model){
        Item item = new Item(itemName, price, quantity);

        itemRepository.save(item);

        model.addAttribute("item", item);

        return "basic/item";
    }

    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item){
        itemRepository.save(item);
//        model.addAttribute("item", item); //자동 추가 생략 가능

        return "basic/item";
    }

    @GetMapping("/{itemId}/edit")
    public String editItem(@PathVariable("itemId") Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "/basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String postEditItem(@ModelAttribute("item") Item item, Model model){
        Item findItem = itemRepository.findById(item.getId());
        findItem.setItemName(item.getItemName());
        findItem.setPrice(item.getPrice());
        findItem.setQuantity(item.getQuantity());

        model.addAttribute("item", findItem);
        return "/basic/item";
    }


}