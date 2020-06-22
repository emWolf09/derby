
package com.derby.entity;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;


/**
 * @author MAHESH NAGARWAL
 *
 */
@Entity
@Table(name = "userprofile")
@Data
//for second level cache TODO
//@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL,region = "userprofile")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
	@SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "user_seq")
	@Column(name="user_id")
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;
}
