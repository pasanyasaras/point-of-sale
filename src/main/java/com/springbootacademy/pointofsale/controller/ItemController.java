package com.springbootacademy.pointofsale.controller;

import com.springbootacademy.pointofsale.dto.ItemDTO;
import com.springbootacademy.pointofsale.dto.request.RequestItemSaveDTO;
import com.springbootacademy.pointofsale.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/get-by-name", params = "name")
    public List<ItemDTO> getItemByNameAndActiveState(@RequestParam(value="name") String itemName){
        List<ItemDTO> itemDTOS = itemService.getItemByNameAndActiveState(itemName);
        return itemDTOS;
    }
}
