package net.atos.practica.model.converter;

import net.atos.practica.model.entity.UserEntity;
import net.atos.practica.model.dto.UserDto;

public class Converter {

	public static UserEntity userDtoToUserEntity(UserDto UserDto) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(UserDto.getName());
		userEntity.setUsername(UserDto.getUsername());
		userEntity.setEmail(UserDto.getEmail());
		userEntity.setDocument(UserDto.getDocument());
		userEntity.setDate(UserDto.getDate());
		return userEntity;
	}

	public static UserDto userEntityToUserDto(UserEntity UserEntity) {
		UserDto UserDto = new UserDto();
		UserDto.setName(UserEntity.getName());
		UserDto.setUsername(UserEntity.getUsername());
		UserDto.setEmail(UserEntity.getEmail());
		UserDto.setDocument(UserEntity.getDocument());
		UserDto.setDate(UserEntity.getDate());
		return UserDto;
	}
}
