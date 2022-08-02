package com.totalplay.usuarios.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class UserRelationShip implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String tpguid_ad;
	private String tpguid_op;
}
