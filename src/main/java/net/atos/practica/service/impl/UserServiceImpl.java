package net.atos.practica.service.impl;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.atos.practica.model.entity.UserEntity;
import net.atos.practica.model.dto.UserDto;
import net.atos.practica.repository.UserRepository;
import net.atos.practica.service.UserService;
import net.atos.practica.model.converter.Converter;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public UserServiceImpl() {

	}

	@Override
	public UserEntity createUser(UserDto UserDto) throws Exception {
		if (userRepository.existsByUsername(UserDto.getUsername())) {
			throw new Exception("Existe_Usuario");
		} else {
			if(isNotAdult(UserDto)) {
				throw new Exception("Usuario_Menor");	                               
			}else {
				return userRepository.save(Converter.userDtoToUserEntity(UserDto));
			}
		}
	}

	@Override
	public UserEntity updateUser(UserDto UserDto) throws Exception {
		if (userRepository.existsByUsername(UserDto.getUsername())) {
			if(isNotAdult(UserDto)) {
				throw new Exception("Usuario_Menor");	                               
			}else {
				return userRepository.save(Converter.userDtoToUserEntity(UserDto));
			}
		} else {
			throw new Exception("No_Existe_Usuario");
		}
	}

	@Override
	public void deleteUser(String username) throws Exception {
		if (userRepository.existsByUsername(username)) {
			userRepository.deleteById(username);;
		} else {
			throw new Exception("No_Existe_Usuario");
		}
	}
	
	@Override
	public List<UserDto> findAll() {
			List<UserDto> users = new ArrayList<UserDto>();
			List<UserEntity> usersRaw = userRepository.findAll();
			for (UserEntity userRaw : usersRaw) {
				users.add(Converter.userEntityToUserDto(userRaw));
			}
			return users;
	}
	
	private boolean isNotAdult(UserDto UserDto) {
		return LocalDate.now().atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()-UserDto.getDate().getTime() < 568024200000L;                
	}

}
