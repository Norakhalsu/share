package com.example.finalproject.Repository;

import com.example.project.Model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem,Integer> {
 //InventoryItem findInventoryItemById(Integer id);
}
