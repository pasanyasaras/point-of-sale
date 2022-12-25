package com.springbootacademy.pointofsale.service.impl;

import com.springbootacademy.pointofsale.dto.request.RequestItemSaveDTO;
import com.springbootacademy.pointofsale.entity.Customer;
import com.springbootacademy.pointofsale.entity.Item;
import com.springbootacademy.pointofsale.service.ItemService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {



    @Override
    public String addItem(RequestItemSaveDTO requestItemSaveDTO) {
        return null;
    }
}
