package xyz.ruankun.laughingspork.entity;

import javax.persistence.*;

/**
 * 学生信息
 */
@Entity
@Table(name = "sx_student")
public class SxStudent {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	/**
	 * 学号
	 * default value: null
	 */
	@Column(name = "stu_no", nullable = false)
	private String stuNo;

	/**
	 * 密码
	 * default value: null
	 */
	@Column(name = "password", nullable = false)
	private String password;

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
	 * 微信
	 * default value: null
	 */
	@Column(name = "wechat", nullable = true)
	private String wechat;

	/**
	 * 身份证号
	 * default value: null
	 */
	@Column(name = "id_card", nullable = true)
	private String idCard;

	/**
	 * 学院
	 * default value: null
	 */
	@Column(name = "college", nullable = true)
	private String college;

	/**
	 * 学院代码
	 * default value: null
	 */
	@Column(name = "college_code", nullable = true)
	private String collegeCode;

	/**
	 * 专业
	 * default value: null
	 */
	@Column(name = "major", nullable = true)
	private String major;

	/**
	 * 专业代码
	 * default value: null
	 */
	@Column(name = "major_code", nullable = true)
	private String majorCode;

	/**
	 * 组
	 * default value: null
	 */
	@Column(name = "group", nullable = true)
	private String group;

	/**
	 * 组代码
	 * default value: null
	 */
	@Column(name = "group_code", nullable = true)
	private String groupCode;

	/**
	 * 是否是小组长
	 * default value: 0
	 */
	@Column(name = "is_group_head", nullable = false)
	private Boolean isGroupHead;

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

	/**
	 * 实习企业信用代码
	 * default value: null
	 */
	@Column(name = "corp_taxcode", nullable = true)
	private String corpTaxcode;

	/**
	 * 企业名称
	 * default value: null
	 */
	@Column(name = "corp_name", nullable = true)
	private String corpName;

	/**
	 * 企业注册号
	 * default value: null
	 */
	@Column(name = "corp_reg_code", nullable = true)
	private String corpRegCode;

	/**
	 * 实习岗位
	 * default value: null
	 */
	@Column(name = "corp_position", nullable = true)
	private String corpPosition;

	/**
	 * 校内导师工号
	 * default value: null
	 */
	@Column(name = "teacher_no", nullable = true)
	private String teacherNo;

	/**
	 * 校外导师工号
	 * default value: null
	 */
	@Column(name = "corp_teacher_no", nullable = true)
	private String corpTeacherNo;
	
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
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	
	public String getWechat() {
		return this.wechat;
	}
	
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	
	public String getIdCard() {
		return this.idCard;
	}
	
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	public String getCollege() {
		return this.college;
	}
	
	public void setCollege(String college) {
		this.college = college;
	}
	
	public String getCollegeCode() {
		return this.collegeCode;
	}
	
	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}
	
	public String getMajor() {
		return this.major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getMajorCode() {
		return this.majorCode;
	}
	
	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}
	
	public String getGroup() {
		return this.group;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}
	
	public String getGroupCode() {
		return this.groupCode;
	}
	
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	public Boolean getIsGroupHead() {
		return this.isGroupHead;
	}
	
	public void setIsGroupHead(Boolean isGroupHead) {
		this.isGroupHead = isGroupHead;
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
	
	public String getCorpTaxcode() {
		return this.corpTaxcode;
	}
	
	public void setCorpTaxcode(String corpTaxcode) {
		this.corpTaxcode = corpTaxcode;
	}
	
	public String getCorpName() {
		return this.corpName;
	}
	
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	
	public String getCorpRegCode() {
		return this.corpRegCode;
	}
	
	public void setCorpRegCode(String corpRegCode) {
		this.corpRegCode = corpRegCode;
	}
	
	public String getCorpPosition() {
		return this.corpPosition;
	}
	
	public void setCorpPosition(String corpPosition) {
		this.corpPosition = corpPosition;
	}
	
	public String getTeacherNo() {
		return this.teacherNo;
	}
	
	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}
	
	public String getCorpTeacherNo() {
		return this.corpTeacherNo;
	}
	
	public void setCorpTeacherNo(String corpTeacherNo) {
		this.corpTeacherNo = corpTeacherNo;
	}

	@Override
	public String toString() {
		return "SxStudent{" +
				"id=" + id +
				", stuNo='" + stuNo + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", sex='" + sex + '\'' +
				", phone='" + phone + '\'' +
				", qq='" + qq + '\'' +
				", wechat='" + wechat + '\'' +
				", idCard='" + idCard + '\'' +
				", college='" + college + '\'' +
				", collegeCode='" + collegeCode + '\'' +
				", major='" + major + '\'' +
				", majorCode='" + majorCode + '\'' +
				", group='" + group + '\'' +
				", groupCode='" + groupCode + '\'' +
				", isGroupHead=" + isGroupHead +
				", gmtCreate=" + gmtCreate +
				", gmtModified=" + gmtModified +
				", corpTaxcode='" + corpTaxcode + '\'' +
				", corpName='" + corpName + '\'' +
				", corpRegCode='" + corpRegCode + '\'' +
				", corpPosition='" + corpPosition + '\'' +
				", teacherNo='" + teacherNo + '\'' +
				", corpTeacherNo='" + corpTeacherNo + '\'' +
				'}';
	}
}
