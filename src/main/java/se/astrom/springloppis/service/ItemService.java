package se.astrom.springloppis.service;

import org.springframework.stereotype.Service;
import se.astrom.springloppis.entity.ItemEntity;
import se.astrom.springloppis.repository.ItemRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final BeanScopesDemo beanScopesDemo;

    public ItemService(ItemRepository itemRepository, BeanScopesDemo beanScopesDemo){
        this.itemRepository = itemRepository;
        this.beanScopesDemo = beanScopesDemo;
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
