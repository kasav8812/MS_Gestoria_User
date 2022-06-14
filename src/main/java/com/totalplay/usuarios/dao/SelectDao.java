package com.totalplay.usuarios.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.totalplay.usuarios.model.CatalogoModel;
import com.totalplay.usuarios.model.StatsuVo;
import com.totalplay.usuarios.model.UserModel;
import com.totalplay.usuarios.model.UserAreaModel;

@Mapper
public interface SelectDao {

	public StatsuVo getStatus();

	List<UserModel> getAllUser();

	List<String> getRole(@Param("id") Integer id);

	List<CatalogoModel> getRoles();

	void deleteRole(Integer id);

	Integer setUser(@Param("user") UserModel user);

	Integer setAreaUser(@Param("user") UserAreaModel user);

	Integer setUserRole(@Param("iduser") Integer iduser, @Param("idrole") Integer idrole);
	
	void updateUser(@Param("user") UserModel user);

	Integer deleteUser(@Param("id") Integer id);
	
	UserModel getUser(@Param("id") Integer id);
}
