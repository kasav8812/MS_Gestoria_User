package com.totalplay.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totalplay.usuarios.dao.SelectDao;
import com.totalplay.usuarios.model.CatalogoModel;

@Service
public class RolService {

	@Autowired
	private SelectDao selectDao;

	public List<CatalogoModel> getRoles() {
		return selectDao.getRoles();
	}

}
