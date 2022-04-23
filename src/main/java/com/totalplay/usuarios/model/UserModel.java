package com.totalplay.usuarios.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class UserModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String username;
	private boolean enabled;
	private String created;
	private String areaID;
	private List<String> role;	
	private List<Integer> rol;
	@JsonInclude(Include.NON_NULL)
	private String password;
}
