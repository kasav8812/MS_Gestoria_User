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
import com.totalplay.usuarios.model.UserAreaModel;
import com.totalplay.usuarios.model.UserRelationShip;
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
	
	@PostMapping("/usuariosAreas")
	public ResponseEntity<UserAreaModel> setUsuarioAreas(@RequestBody UserAreaModel[] user) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(userService.setUserAreas(user));
	}
	
	
	
	@PostMapping("/addUserRelationShip")
	public ResponseEntity<UserRelationShip> addUserRelationShip(@RequestBody UserRelationShip user) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(userService.addUserRelationShip(user));
	}
	
	@PutMapping
	public ResponseEntity<UserModel> updateUsuario(@RequestBody UserModel user) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UserModel> deleteUsuario(@PathVariable("id") Integer id) throws Exception {		
		return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
	}
	
	@GetMapping("getUserByEstado/{id}")
	public ResponseEntity<List<UserModel>> getUserByEstado(@PathVariable("id") String id) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByEstado(id));
	}
	
	
	@GetMapping("getUserByAdmin/{id}")
	public ResponseEntity<List<UserModel>> getUserByAdmin(@PathVariable("id") String id) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByAdmin(id));
	}
	
	
	@PostMapping("/updateUsr")
	public ResponseEntity<UserModel> updateUsr(@RequestBody UserModel user) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUsr(user));
	}
	
	
}
