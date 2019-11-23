package xyz.ruankun.laughingspork.entity;

import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 公司信息表

 */
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "sx_corporation")
public class SxCorporation {

	/**
	 *  主键
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	/**
	 *  学号,表示这条记录由某个学生填写
	 * default value: null
	 */
	@Column(name = "stu_no", nullable = false)
	private String stuNo;

	/**
	 * 统一社会信用代码
	 * default value: null
	 */
	@Column(name = "credit_code", nullable = false)
	private String creditCode;

	/**
	 * 企业名称
	 * default value: null
	 */
	@Column(name = "corp_name", nullable = false)
	private String corpName;

	/**
	 * 企业注册号
	 * default value: null
	 */
	@Column(name = "reg_code", nullable = false)
	private String regCode;

	/**
	 * 类型 (如：有限责任公司)
	 * default value: null
	 */
	@Column(name = "type", nullable = true)
	private String type;

	/**
	 * 法人
	 * default value: null
	 */
	@Column(name = "legal_person", nullable = true)
	private String legalPerson;

	/**
	 *  注册资本
	 * default value: null
	 */
	@Column(name = "register_capita", nullable = true)
	private String registerCapita;

	/**
	 *  创建日期
	 * default value: null
	 */
	@Column(name = "create_date", nullable = true)
	private String createDate;

	/**
	 * 开始营业日期
	 * default value: null
	 */
	@Column(name = "start_business", nullable = true)
	private String startBusiness;

	/**
	 *  营业期限截止日期
	 * default value: null
	 */
	@Column(name = "end_business", nullable = true)
	private String endBusiness;

	/**
	 * 工商信息登记机关
	 * default value: null
	 */
	@Column(name = "reg_authority", nullable = true)
	private String regAuthority;

	/**
	 * 核准日期
	 * default value: null
	 */
	@Column(name = "approval_date", nullable = true)
	private String approvalDate;

	/**
	 *  登记状态
	 * default value: null
	 */
	@Column(name = "reg_status", nullable = true)
	private String regStatus;

	/**
	 * 住所地址
	 * default value: null
	 */
	@Column(name = "address", nullable = true)
	private String address;

	/**
	 * 经营范围
	 * default value: null
	 */
	@Column(name = "business_scope", nullable = true)
	private String businessScope;

	/**
	 *  表示该公司信息后台管理员是否已经核实,默
认未核实
	 * default value: b'0'
	 */
	@Column(name = "is_corp_checked", nullable = true)
	private Boolean isCorpChecked;

	/**
	 *  数据库记录创建日期
	 * default value: CURRENT_TIMESTAMP
	 */
	@Column(name = "gmt_create", nullable = true)
	private java.util.Date gmtCreate;

	/**
	 *  数据库记录修改日期
	 * default value: null
	 */
	@Column(name = "gmt_modified", nullable = true)
	private java.util.Date gmtModified;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStuNo() {
		return this.stuNo;
	}
	
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	
	public String getCreditCode() {
		return this.creditCode;
	}
	
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	
	public String getCorpName() {
		return this.corpName;
	}
	
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	
	public String getRegCode() {
		return this.regCode;
	}
	
	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getLegalPerson() {
		return this.legalPerson;
	}
	
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	
	public String getRegisterCapita() {
		return this.registerCapita;
	}
	
	public void setRegisterCapita(String registerCapita) {
		this.registerCapita = registerCapita;
	}
	
	public String getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public String getStartBusiness() {
		return this.startBusiness;
	}
	
	public void setStartBusiness(String startBusiness) {
		this.startBusiness = startBusiness;
	}
	
	public String getEndBusiness() {
		return this.endBusiness;
	}
	
	public void setEndBusiness(String endBusiness) {
		this.endBusiness = endBusiness;
	}
	
	public String getRegAuthority() {
		return this.regAuthority;
	}
	
	public void setRegAuthority(String regAuthority) {
		this.regAuthority = regAuthority;
	}
	
	public String getApprovalDate() {
		return this.approvalDate;
	}
	
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}
	
	public String getRegStatus() {
		return this.regStatus;
	}
	
	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getBusinessScope() {
		return this.businessScope;
	}
	
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	
	public Boolean getIsCorpChecked() {
		return this.isCorpChecked;
	}
	
	public void setIsCorpChecked(Boolean isCorpChecked) {
		this.isCorpChecked = isCorpChecked;
	}

	@Override
	public String toString() {
		return "SxCorporation{" +
				"id=" + id +
				", stuNo='" + stuNo + '\'' +
				", creditCode='" + creditCode + '\'' +
				", corpName='" + corpName + '\'' +
				", regCode='" + regCode + '\'' +
				", type='" + type + '\'' +
				", legalPerson='" + legalPerson + '\'' +
				", registerCapita='" + registerCapita + '\'' +
				", createDate='" + createDate + '\'' +
				", startBusiness='" + startBusiness + '\'' +
				", endBusiness='" + endBusiness + '\'' +
				", regAuthority='" + regAuthority + '\'' +
				", approvalDate=" + approvalDate +
				", regStatus='" + regStatus + '\'' +
				", address='" + address + '\'' +
				", businessScope='" + businessScope + '\'' +
				", isCorpChecked=" + isCorpChecked +
				", gmtCreate=" + gmtCreate +
				", gmtModified=" + gmtModified +
				'}';
	}
}
