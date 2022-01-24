package se.astrom.springloppis.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.astrom.springloppis.entity.ItemEntity;
import se.astrom.springloppis.service.ItemService;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemEntity> createItem(@RequestBody ItemEntity item){
        var createdItem = itemService.createItem(item);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @DeleteMapping("{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId){
        itemService.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{itemId}")
    public ResponseEntity<Optional<ItemEntity>> getItemById(@PathVariable Long itemId){
        var foundItem = itemService.findItemById(itemId);
        return new ResponseEntity<>(foundItem, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<ItemEntity>> getItems(){
        var itemsList = itemService.getItems();
        return new ResponseEntity<>(itemsList, HttpStatus.OK);
    }
}
