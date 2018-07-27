package net.atos.practica.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDto {
	String username;
	String name;
	String email;
	String document;
	Date date;

}
