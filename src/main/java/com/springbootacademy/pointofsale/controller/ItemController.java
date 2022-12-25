package com.springbootacademy.pointofsale.controller;

import com.springbootacademy.pointofsale.dto.ItemDTO;
import com.springbootacademy.pointofsale.dto.request.RequestItemSaveDTO;
import com.springbootacademy.pointofsale.service.ItemService;
import com.springbootacademy.pointofsale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "/get-by-name1", params = "name")
    public ResponseEntity<StandardResponse> getItemByNameAndActiveState1(@RequestParam(value="name") String itemName){
        List<ItemDTO> itemDTOS = itemService.getItemByNameAndActiveState(itemName);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",itemDTOS), HttpStatus.OK
        );
        return response;
    }
}
