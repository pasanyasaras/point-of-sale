package com.springbootacademy.pointofsale.service;

import com.springbootacademy.pointofsale.dto.request.RequestItemSaveDTO;

public interface ItemService {


    String addItem(RequestItemSaveDTO requestItemSaveDTO);
}
