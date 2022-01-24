package se.astrom.springloppis.service;

import org.springframework.stereotype.Service;
import se.astrom.springloppis.entity.ItemEntity;
import se.astrom.springloppis.repository.ItemRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public ItemEntity createItem(ItemEntity itemEntity){
        return itemRepository.save(itemEntity);
    }

    public void deleteItem(Long itemId){
        ItemEntity foundItem = itemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);
        itemRepository.delete(foundItem);
    }

    public Optional<ItemEntity> findItemById(Long id){
        return itemRepository.findById(id);
    }

    public Iterable<ItemEntity> getItems(){
        return itemRepository.findAll();
    }


}
