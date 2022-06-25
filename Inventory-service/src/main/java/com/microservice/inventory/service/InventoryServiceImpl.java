package com.microservice.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.inventory.entity.Inventory;
import com.microservice.inventory.repository.InventoryRepository;
@Service
public class InventoryServiceImpl {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	
	public void addInventory(Inventory inv) {
		inventoryRepository.save(inv);	
	}

	
	public List<Inventory> getAllInventory() {
		return inventoryRepository.findAll();	 
	}

	
	public Optional<Inventory> getInventoryById(int invId) {
		return inventoryRepository.findById(invId);
	}

	
	public void updateInventory(int invId, Inventory inv) {
		inventoryRepository.save(inv);
	}

	
	public void deleteInvenotry(int invId) {
		inventoryRepository.deleteById(invId);
	}

}
