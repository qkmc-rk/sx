package xyz.ruankun.laughingspork.entity;

import javax.persistence.*;

/**
 * 校内导师信息
 */
@Entity
@Table(name = "sx_teacher")
public class SxTeacher {

    /**
     * null
     * default value: null
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 教职工号
     * default value: null
     */
    @Column(name = "teacher_no", nullable = false)
    private String teacherNo;

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
     * 身份证号码
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherNo() {
        return this.teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
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

    @Override
    public String toString() {
        return "SxTeacher{" +
                "id=" + id +
                ", teacherNo='" + teacherNo + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", idCard='" + idCard + '\'' +
                ", college='" + college + '\'' +
                ", collegeCode='" + collegeCode + '\'' +
                '}';
    }
}
