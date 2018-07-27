package net.atos.practica.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Table(name="USERS")
@Data
public class UserEntity {

		@Id
		@Column(name="username")
		String username;	
		@Column(name="name")
		String name;
		@Column(name="email")
		String email;
		@Column(name="document")
		String document;
		@Column(name="date")
		Date date;
		
}
