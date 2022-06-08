package com.totalplay.usuarios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.totalplay.usuarios.dao.SelectDao;
import com.totalplay.usuarios.model.UserModel;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private SelectDao selectDao;

	public  List<UserModel> getUsers() {
		List<UserModel> listUser = new ArrayList<>();
		for(UserModel user : selectDao.getAllUser()) {
			user.setRole(selectDao.getRole(user.getId()));
			listUser.add(user);
		}
		return listUser;
	}

	@Transactional
	public UserModel setUser(UserModel user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		selectDao.setUser(user);
		for(Integer id: user.getRol()) {
			selectDao.setUserRole(user.getId(), id);
		}
		user.setRole(selectDao.getRole(user.getId()));
		user.setEnabled(true);
		user.setPassword(null);
		user.setRol(null);
		return user;
	}
	
	@Transactional
	public UserModel updateUser(UserModel user) {
		if(user.getPassword()!=null) {
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		}		
		selectDao.deleteRole(user.getId());
		selectDao.updateUser(user);
		for(Integer id: user.getRol()) {
			selectDao.setUserRole(user.getId(), id);
		}
		user.setEnabled(true);
		user.setRole(selectDao.getRole(user.getId()));
		user.setPassword(null);
		user.setRol(null);
	
		return user;
	}

	@Transactional
	public UserModel deleteUser(Integer id) {
		UserModel user = new UserModel();
		selectDao.deleteUser(id);
		System.out.println("fin: "+id );
		user = selectDao.getUser(id);
		user.setRole(selectDao.getRole(id));
		return user;
	}

}
