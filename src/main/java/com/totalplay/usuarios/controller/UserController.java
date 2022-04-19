package com.totalplay.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.totalplay.usuarios.model.UserModel;
import com.totalplay.usuarios.service.UserService;


@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserModel>> getUsuario() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
	}
	
	@PostMapping
	public ResponseEntity<UserModel> setUsuario(@RequestBody UserModel user) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(userService.setUser(user));
	}
	
	@PutMapping
	public ResponseEntity<UserModel> updateUsuario(@RequestBody UserModel user) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UserModel> deleteUsuario(@PathVariable("id") Integer id) throws Exception {		
		return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
	}
}
