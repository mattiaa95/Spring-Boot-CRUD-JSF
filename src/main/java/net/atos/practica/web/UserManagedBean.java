package net.atos.practica.web;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import net.atos.practica.model.dto.UserDto;
import net.atos.practica.service.UserService;

@ManagedBean
@Component
public class UserManagedBean extends GenericMsgBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3183017054438548186L;

	@Autowired
	UserService userService;

	private UserDto userDto;
    private List<UserDto> selectedUsers;
    private List<UserDto> filteredUsers;
	private List<UserDto> users;

	public UserManagedBean() {
		super();
	}

	@PostConstruct
	public void onInit() {
		userDto = new UserDto();
		users = new ArrayList<UserDto>();
		users = userService.findAll();
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public List<UserDto> getUsers() {
		return users;
	}
	
	public void setUsers(List<UserDto> users) {
		this.users = users;
	}
	

	public List<UserDto> getSelectedUsers() {
		return selectedUsers;
	}

	public void setSelectedUsers(List<UserDto> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}
	public List<UserDto> getFilteredUsers() {
		return filteredUsers;
	}

	public void setFilteredUsers(List<UserDto> filteredUsers) {
		this.filteredUsers = filteredUsers;
	}
	
	public void save() throws Exception {
		try {
			userService.createUser(userDto);
			users = userService.findAll();
			showInfoMessa("Usuario Nuevo Creado", getUserDto().toString());
		} catch (Exception e) {
			showErrorMessage("Usuario No Creado", e.toString());
		}
	}
	

	public void Delete() throws Exception {
		try {
			userService.deleteUser(userDto.getUsername());
			users = userService.findAll();
			showInfoMessa("Usuario borrado", getUserDto().toString());
		} catch (Exception e) {
			showErrorMessage("Usuario No borrado", e.toString());
		}
	}
	

	public void DeleteUsers() throws Exception {
		try {
			for (UserDto selectedUserDelete : selectedUsers) {
				userService.deleteUser(selectedUserDelete.getUsername());
			}
			users = userService.findAll();
			FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("dataTable:checkboxDT");
			showInfoMessa("Usuarios borrado", getUserDto().toString());
		} catch (Exception e) {
			showErrorMessage("Usuarios No borrado", e.toString());
		}
	}
	


}
