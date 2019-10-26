package xyz.ruankun.laughingspork.entity;

import javax.persistence.*;

/**
 * 超级管理员的信息
 */
@Entity
@Table(name = "sx_root")
public class SxRoot {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	/**
	 * 超管账号
	 * default value: null
	 */
	@Column(name = "account", nullable = false)
	private String account;

	/**
	 * 超管密码
	 * default value: null
	 */
	@Column(name = "password", nullable = false)
	private String password;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAccount() {
		return this.account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SxRoot{" +
				"id=" + id +
				", account='" + account + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
