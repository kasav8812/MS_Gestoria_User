package com.totalplay.usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.totalplay.usuarios.service.StatusService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/status")
public class StatusController {

	private HttpStatus status;
	
	@Autowired
	private StatusService statusService;
	
	@GetMapping
	public ResponseEntity<?> getStatus(){
		log.info("getStatus");
		status = HttpStatus.OK;		
		return ResponseEntity.status(status).body(statusService.getStatus());
	}
}
