package uk.task.waracle.CakeManagement.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import uk.task.waracle.CakeManagement.Exception.ResourceNotFoundException;
import uk.task.waracle.CakeManagement.Model.Cake;
import uk.task.waracle.CakeManagement.Model.CakeWrapper;
import uk.task.waracle.CakeManagement.Repository.CakeRepository;

@RestController
public class CakeController {
	
	@Autowired
	private CakeRepository cakeRepository;
	
	//get all cakes
	@GetMapping("/cakes")
	public CakeWrapper getAllCakes() {
		List<Cake> dataObJ = cakeRepository.findAll();

		if (dataObJ.size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Data found!");
		}
		CakeWrapper returnValue = new CakeWrapper(dataObJ);
		return returnValue;
	}
	
	//create cake
	@PostMapping("/cake")
	public Cake createCake(@Validated @RequestBody Cake cake) {
		return cakeRepository.save(cake);
	}
	//get cake by id
	@GetMapping("/cake/{id}")
	public ResponseEntity<Cake> getCakeById(@PathVariable(value = "id") long cakeId) throws ResourceNotFoundException {
		Cake cake = cakeRepository.findById(cakeId)
				.orElseThrow(() -> new ResourceNotFoundException("Cake not found for this id::" + cakeId));
		return ResponseEntity.ok().body(cake);
	}
	//update cake
	@PutMapping("/cake/{id}")
	public ResponseEntity<Cake> updateCakeDetails(@PathVariable(value = "id") long cakeId,
			@RequestBody Cake cakeDetails) throws ResourceNotFoundException {
		Cake cake = cakeRepository.findById(cakeId)
				.orElseThrow(() -> new ResourceNotFoundException("Cake not found for this id::" + cakeId));

		cake.setCakeName(cakeDetails.getCakeName());
		cake.setCakeType(cakeDetails.getCakeType());
		cake.setPrice(cakeDetails.getPrice());
		cakeRepository.save(cake);
		return ResponseEntity.ok().body(cake);
	}
	
	//delete cake
	@DeleteMapping("/cakes/{id}")
	public ResponseEntity<?> deleteCake(@PathVariable(value = "id") long cakeId) throws ResourceNotFoundException {
		cakeRepository.findById(cakeId)
				.orElseThrow(() -> new ResourceNotFoundException("Cake not found for this id::" + cakeId));
		cakeRepository.deleteById(cakeId);
		return ResponseEntity.ok().build();
	}
	
	

}
