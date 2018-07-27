package net.atos.practica.service;



import java.util.List;
import net.atos.practica.model.entity.UserEntity;
import net.atos.practica.model.dto.UserDto;


public interface UserService {

	/**
	 * Método para la creacion de un usuario por defecto.
	 * @param UserRequest
	 * @throws Exception 
	 */
	public UserEntity createUser(UserDto UserDto) throws Exception;
	/**
	 * Método que devuelve todos los usuarios.
	 * @return
	 */
	public List<UserDto> findAll();
	/**
	 * Método para actualizar usuarios.
	 * @param UserRequest
	 * @throws Exception 
	 */
	public UserEntity updateUser(UserDto UserDto) throws Exception;
	/**
	 * Método para borrar usuarios.
	 * @param UserRequest
	 * @throws Exception 
	 */
	public void deleteUser(String username) throws Exception;

}
