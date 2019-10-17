package com.comtech.POS.system.service.impl;

import com.comtech.POS.system.builder.DTOBuider;
import com.comtech.POS.system.builder.EntityBuilder;
import com.comtech.POS.system.dto.ItemDTO;
import com.comtech.POS.system.entity.Item;
import com.comtech.POS.system.repository.ItemRepository;
import com.comtech.POS.system.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    EntityBuilder entityBuilder;
    @Autowired
    DTOBuider dtoBuider;
    @Override
    public Long add(ItemDTO itemDTO) {
        Item saved=itemRepository.save(entityBuilder.buildItemEntity(new Item() ,itemDTO));
        return null != saved ? saved.getCode(): null;
    }

    @Override
    public Long update(ItemDTO itemDTO) {
        Item saved=itemRepository.save(entityBuilder.buildItemEntity(new Item() , itemDTO));
        return null != saved ? saved.getCode() : null;
    }

    @Override
    public List<ItemDTO> searchLike(String searchText, Integer count, Integer page) {
        List<ItemDTO> list=new ArrayList<>();
        for (Item entity: itemRepository.search(searchText , count ,page)) {
            list.add(dtoBuider.buildItemDTO(entity));
        }
        return list;
    }

    @Override
    public ItemDTO get(Long cid) {
        return dtoBuider.buildItemDTO(itemRepository.getOne(cid));
    }

    @Override
    public Long delete(Long cid) {
        Item item=itemRepository.getOne(cid);
        item.setIsEnable(0);
        Item saved=itemRepository.save(item);
        return null != saved ? saved.getCode(): null;
    }
}
