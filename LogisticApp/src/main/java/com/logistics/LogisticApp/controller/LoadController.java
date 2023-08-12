package com.logistics.LogisticApp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.logistics.LogisticApp.exception.LoadNotFoundException;
import com.logistics.LogisticApp.model.Load;
import com.logistics.LogisticApp.repository.LoadRepository;

@RestController
public class LoadController {
	@Autowired
	LoadRepository loadRepository;
	
	@PostMapping("/load")
	Load newLoad(@RequestBody Load newLoad) {
		return loadRepository.save(newLoad);
	}
	
	@GetMapping("/loadAll")
	List<Load> getAllLoads() {
		return loadRepository.findAll();
	}

	@GetMapping("/load/{shipperId}")
	Load getLoadById(@PathVariable String shipperId) {
		return loadRepository.findById(shipperId)
				.orElseThrow(()->new LoadNotFoundException(shipperId));
				
	
	}
	@PutMapping("/load/{shipperId}")
	Load updateLoad(@RequestBody Load newLoad ,@PathVariable String shipperId) {
		return loadRepository.findById(shipperId)
				.map(load->{
					load.setLoadingPoint(load.getLoadingPoint());
					load.setUnloadingPoint(load.getUnloadingPoint());
					load.setProductType(load.getProductType());
					load.setProductType(load.getProductType());
					load.setTruckType(load.getTruckType());
					load.setNoOfTrucks(load.getNoOfTrucks());
					load.setWeight(load.getWeight());
					load.setComment(load.getComment());
					load.setShipdate(load.getShipdate());
					
					return loadRepository.save(load);
					
					
				}).orElseThrow(()->new LoadNotFoundException(shipperId));
				
	
	}
	@DeleteMapping("/load/{shipperId}")
	String deleteUser(@PathVariable String shipperId) {
		
		if(!loadRepository.existsById(shipperId)) {
				throw new LoadNotFoundException(shipperId);
	}
		loadRepository.deleteById(shipperId);
		return "User with id "+shipperId+" has been deleted success.";
			
		
	}
	
	
}
