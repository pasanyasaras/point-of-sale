package com.springbootacademy.pointofsale.service.impl;

import com.springbootacademy.pointofsale.dto.request.RequestItemSaveDTO;
import com.springbootacademy.pointofsale.entity.Customer;
import com.springbootacademy.pointofsale.entity.Item;
import com.springbootacademy.pointofsale.repository.ItemRepository;
import com.springbootacademy.pointofsale.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemRepository itemRepository;

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
}
