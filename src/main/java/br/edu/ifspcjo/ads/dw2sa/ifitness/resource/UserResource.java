package br.edu.ifspcjo.ads.dw2sa.ifitness.resource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifspcjo.ads.dw2sa.ifitness.domain.model.*;
import br.edu.ifspcjo.ads.dw2sa.ifitness.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")

public class UserResource {
	
	@Autowired
	private UserRepository userRepository; 
	
	@GetMapping
	public List<User> list(){
		return userRepository.findAll();
	}

	@PostMapping
	public User create(@RequestBody User user, HttpServletResponse response) {
		return userRepository.save(user);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());			
		}
		return ResponseEntity.notFound().build();
	}		
}
