package com.example.finalproject.Service;

import com.example.project.Api.ApiException;
import com.example.project.Model.InventoryItem;
//import com.example.project.Repository.InventoryItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryItemService {
//
//    private final InventoryItemRepository inventoryItemRepository;
//
//
//    public List<InventoryItem> getAllInventoryItem(){
//        return inventoryItemRepository.findAll();
//
//    }
//
//    public void addInventoryItem(Integer id ,InventoryItem inventoryItem ) {
//
//        InventoryItem inventoryItem1=inventoryItemRepository.findInventoryItemById(id);
//        if(inventoryItem1==null){
//            throw new ApiException("id not found");
//        }
//        inventoryItemRepository.save(inventoryItem);
//        }
//
//
//    public void updateInventoryItem(Integer id,InventoryItem inventoryItem){
//        InventoryItem inventoryItem1=inventoryItemRepository.findInventoryItemById(id);
//        if(inventoryItem1==null){
//            throw new ApiException("id not found");
//        }
//
//        inventoryItemRepository.save(inventoryItem);
//    }
//
//
//    public void deleteInventoryItem(Integer id){
//        InventoryItem inventoryItem1=inventoryItemRepository.findInventoryItemById(id);
//        if(inventoryItem1==null){
//            throw new ApiException("id not found");
//        }
//        inventoryItemRepository.delete(inventoryItem1);
//    }

    //---------------------------  end CRUD  ---------------------------------

}