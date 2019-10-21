package xyz.ruankun.laughingspork.entity;

import javax.persistence.*;

/**
 * 校外导师
 */
@Entity
@Table(name = "sx_corp_teacher")
public class SxCorpTeacher {

	/**
	 * null
	 * default value: null
	 */
	@Id
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
	 * 身份证号码
	 * default value: null
	 */
	@Column(name = "id_card", nullable = true)
	private String idCard;

	/**
	 * 企业
	 * default value: null
	 */
	@Column(name = "corp", nullable = true)
	private String corp;

	/**
	 * 单位
	 * default value: null
	 */
	@Column(name = "unit", nullable = true)
	private String unit;

	/**
	 * 工作
	 * default value: null
	 */
	@Column(name = "work", nullable = true)
	private String work;

	/**
	 * 姓名
	 * default value: null
	 */
	@Column(name = "name", nullable = true)
	private String name;

	/**
	 * 年龄
	 * default value: null
	 */
	@Column(name = "age", nullable = true)
	private Integer age;

	/**
	 * 性别
	 * default value: null
	 */
	@Column(name = "sex", nullable = true)
	private String sex;

	/**
	 * 电话
	 * default value: null
	 */
	@Column(name = "phone", nullable = true)
	private String phone;

	/**
	 * qq
	 * default value: null
	 */
	@Column(name = "qq", nullable = true)
	private String qq;

	/**
	 * 邮箱
	 * default value: null
	 */
	@Column(name = "mail", nullable = true)
	private String mail;

	/**
	 * 微信
	 * default value: null
	 */
	@Column(name = "wechat", nullable = true)
	private String wechat;

	/**
	 * 创建时间
	 * default value: CURRENT_TIMESTAMP
	 */
	@Column(name = "gmt_create", nullable = false)
	private java.util.Date gmtCreate;

	/**
	 * 更新时间
	 * default value: CURRENT_TIMESTAMP
	 */
	@Column(name = "gmt_modified", nullable = false)
	private java.util.Date gmtModified;
	
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
	
	public String getIdCard() {
		return this.idCard;
	}
	
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	public String getCorp() {
		return this.corp;
	}
	
	public void setCorp(String corp) {
		this.corp = corp;
	}
	
	public String getUnit() {
		return this.unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getWork() {
		return this.work;
	}
	
	public void setWork(String work) {
		this.work = work;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return this.age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getSex() {
		return this.sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getQq() {
		return this.qq;
	}
	
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getWechat() {
		return this.wechat;
	}
	
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	
	public java.util.Date getGmtCreate() {
		return this.gmtCreate;
	}
	
	public void setGmtCreate(java.util.Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	
	public java.util.Date getGmtModified() {
		return this.gmtModified;
	}
	
	public void setGmtModified(java.util.Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	@Override
	public String toString() {
		return "SxCorpTeacher{" +
				"id=" + id +
				", account='" + account + '\'' +
				", password='" + password + '\'' +
				", idCard='" + idCard + '\'' +
				", corp='" + corp + '\'' +
				", unit='" + unit + '\'' +
				", work='" + work + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", sex='" + sex + '\'' +
				", phone='" + phone + '\'' +
				", qq='" + qq + '\'' +
				", mail='" + mail + '\'' +
				", wechat='" + wechat + '\'' +
				", gmtCreate=" + gmtCreate +
				", gmtModified=" + gmtModified +
				'}';
	}
}
