package com.springbootacademy.pointofsale.controller;

import com.springbootacademy.pointofsale.dto.request.RequestItemSaveDTO;
import com.springbootacademy.pointofsale.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;


    @PostMapping(path="/save")
    public String saveItem(@RequestBody RequestItemSaveDTO requestItemSaveDTO){
        String add = itemService.addItem(requestItemSaveDTO);
        return "Saved";
    }
}
