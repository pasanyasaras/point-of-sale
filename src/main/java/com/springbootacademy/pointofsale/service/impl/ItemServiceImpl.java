package com.springbootacademy.pointofsale.service.impl;

import com.springbootacademy.pointofsale.dto.ItemDTO;
import com.springbootacademy.pointofsale.dto.request.RequestItemSaveDTO;
import com.springbootacademy.pointofsale.entity.Customer;
import com.springbootacademy.pointofsale.entity.Item;
import com.springbootacademy.pointofsale.repository.ItemRepository;
import com.springbootacademy.pointofsale.service.ItemService;
import com.springbootacademy.pointofsale.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String addItem(RequestItemSaveDTO requestItemSaveDTO) {
        Item item = modelMapper.map(requestItemSaveDTO,Item.class);
        if(!itemRepository.existsById((item.getItemId())))
        {
            itemRepository.save(item);
            return "Save successful";
        }
        else{
            throw new DuplicateKeyException("Already Added");
        }

    }

    @Override
    public List<ItemDTO> getItemByNameAndActiveState(String itemName) {
        boolean b = true;
        List<Item> items = itemRepository.findAllByItemNameAndActiveState(itemName,b);
//        List<ItemDTO> itemDTOS = modelMapper.map(items, new TypeToken<List<ItemDTO>>() {
//        }.getType());
        List<ItemDTO> itemDTOS = itemMapper.entityListToDtoList(items);
        return itemDTOS;
    }
}
