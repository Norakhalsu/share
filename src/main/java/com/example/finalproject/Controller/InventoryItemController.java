package com.example.finalproject.Controller;

import com.example.finalproject.Api.ApiResponse;

import com.example.finalproject.Model.InventoryItem;
import com.example.finalproject.Model.User;
import com.example.finalproject.Service.InventoryItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventoryItem")
@RequiredArgsConstructor
public class InventoryItemController {
    private final InventoryItemService inventoryItemService;

    Logger logger = LoggerFactory.getLogger(InventoryItemController.class);

//
//    @GetMapping("/get")
//    public ResponseEntity getAllInventoryItem(){
//        logger.info("get all InventoryItem");
//        return ResponseEntity.ok(inventoryItemService.getAllInventoryItem());
//    }
//
//
//    @PostMapping("/add")
//    public ResponseEntity addInventoryItem(@AuthenticationPrincipal User user,@RequestBody @Valid InventoryItem inventoryItem){
//        inventoryItemService.addInventoryItem(user.getId(), inventoryItem);
//        logger.info("InventoryItem added");
//        return ResponseEntity.ok(new ApiResponse("InventoryItem added"));
//    }
//
//
//    @PutMapping("/update")
//    public ResponseEntity updateInventoryItem(@AuthenticationPrincipal User user, @RequestBody @Valid InventoryItem inventoryItem){
//        inventoryItemService.updateInventoryItem(user.getId(), inventoryItem);
//        logger.info("InventoryItem updated");
//        return ResponseEntity.ok(new ApiResponse("InventoryItem updated"));
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity deleteInventoryItem( @PathVariable Integer id){
//        inventoryItemService.deleteInventoryItem(id);
//        logger.info("InventoryItem deleted");
//        return ResponseEntity.ok(new ApiResponse("InventoryItem deleted"));
//    }



//-------------------------------------   end CRUD  ---------------------------



}
