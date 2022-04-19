package com.totalplay.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.totalplay.usuarios.model.CatalogoModel;
import com.totalplay.usuarios.service.RolService;

@RestController
@CrossOrigin("*")
@RequestMapping("/rol")
public class RolController {

	@Autowired
	private RolService rolService;
	
	@GetMapping
	public ResponseEntity<List<CatalogoModel>> rol() throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(rolService.getRoles());
	}
}
