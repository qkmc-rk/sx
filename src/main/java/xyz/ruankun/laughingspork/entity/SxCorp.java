package xyz.ruankun.laughingspork.entity;

import javax.persistence.*;

/**
 * 实习公司负责人
 */
@Entity
@Table(name = "sx_corp")
public class SxCorp {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	/**
	 * 账号
	 * default value: null
	 */
	@Column(name = "account", nullable = false)
	private String account;

	/**
	 * 密码
	 * default value: null
	 */
	@Column(name = "password", nullable = false)
	private String password;

	/**
	 * 纳税人识别号
	 * default value: null
	 */
	@Column(name = "taxcode", nullable = true)
	private String taxcode;

	/**
	 * 负责人
	 * default value: null
	 */
	@Column(name = "principal", nullable = true)
	private String principal;

	/**
	 * 企业名称
	 * default value: null
	 */
	@Column(name = "corp", nullable = true)
	private String corp;
	
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
	
	public String getTaxcode() {
		return this.taxcode;
	}
	
	public void setTaxcode(String taxcode) {
		this.taxcode = taxcode;
	}
	
	public String getPrincipal() {
		return this.principal;
	}
	
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	
	public String getCorp() {
		return this.corp;
	}
	
	public void setCorp(String corp) {
		this.corp = corp;
	}

	@Override
	public String toString() {
		return "SxCorp{" +
				"id=" + id +
				", account='" + account + '\'' +
				", password='" + password + '\'' +
				", taxcode='" + taxcode + '\'' +
				", principal='" + principal + '\'' +
				", corp='" + corp + '\'' +
				'}';
	}
}
