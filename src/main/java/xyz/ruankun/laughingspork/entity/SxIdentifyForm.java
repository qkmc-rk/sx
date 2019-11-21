package xyz.ruankun.laughingspork.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import xyz.ruankun.laughingspork.util.constant.Rating;

import javax.persistence.*;
import java.sql.Date;

/**
 * 实习鉴定表
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "sx_identify_form")
public class SxIdentifyForm {

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
     * 实习开始时间
     * default value: null
     */
    @Column(name = "gmt_start", nullable = true)
    private java.sql.Date gmtStart;

    /**
     * 实习结束时间
     * default value: null
     */
    @Column(name = "gmt_end", nullable = true)
    private java.sql.Date gmtEnd;

    /**
     * 实习内容
     * default value: null
     */
    @Column(name = "sx_content", nullable = true)
    private String sxContent;

    /**
     * 自我总结
     * default value: null
     */
    @Column(name = "self_summary", nullable = true)
    private String selfSummary;

    /**
     * 校外导师意见
     * default value: null
     */
    @Column(name = "corp_teacher_opinion", nullable = true)
    private String corpTeacherOpinion;

    /**
     * 校外导师打分
     * default value: null
     */
    @Column(name = "corp_teacher_score", nullable = true)
    private String corpTeacherScore;

    /**
     * 校外导师意见填写日期
     * default value: null
     */
    @Column(name = "c_t_o_date", nullable = true)
    private java.sql.Date cTODate;

    /**
     * 实习单位意见
     * default value: null
     */
    @Column(name = "corp_opinion", nullable = true)
    private String corpOpinion;

    /**
     * 实习单位意见填写时间
     * default value: null
     */
    @Column(name = "c_o_date", nullable = true)
    private java.sql.Date cODate;

    /**
     * 实习单位导师成绩评定
     * default value: null
     */
    @Column(name = "corp_teacher_grade", nullable = true)
    private String corpTeacherGrade;

    /**
     * 实习单位导师成绩评定日期
     * default value: null
     */
    @Column(name = "c_t_g_date", nullable = true)
    private java.sql.Date cTGDate;

    /**
     * 学院导师成绩评定
     * default value: null
     */
    @Column(name = "teacher_grade", nullable = true)
    private String teacherGrade;

    /**
     * 学院导师成绩评定日期
     * default value: null
     */
    @Column(name = "t_g_date", nullable = true)
    private java.sql.Date tGDate;

    /**
     * 综合实习成绩评定
     * default value: null
     */
    @Column(name = "comprehsv_grade", nullable = true)
    private String comprehsvGrade;

    /**
     * 综合实习成绩评定日期
     * default value: null
     */
    @Column(name = "c_g_date", nullable = true)
    private java.sql.Date cGDate;

    /**
     * 学院实习领导小组意见
     * default value: null
     */
    @Column(name = "college_principal_opinion", nullable = true)
    private String collegePrincipalOpinion;

    /**
     * 学院实习领导小组意见填写日期
     * default value: null
     */
    @Column(name = "c_p_o_date", nullable = true)
    private java.sql.Date cPODate;

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

    public String getSxContent() {
        return this.sxContent;
    }

    public void setSxContent(String sxContent) {
        this.sxContent = sxContent;
    }

    public String getSelfSummary() {
        return this.selfSummary;
    }

    public void setSelfSummary(String selfSummary) {
        this.selfSummary = selfSummary;
    }

    public String getCorpTeacherOpinion() {
        return this.corpTeacherOpinion;
    }

    public void setCorpTeacherOpinion(String corpTeacherOpinion) {
        this.corpTeacherOpinion = corpTeacherOpinion;
    }

    public String getCorpTeacherScore() {
        return this.corpTeacherScore;
    }

    public void setCorpTeacherScore(String corpTeacherScore) {
        this.corpTeacherScore = corpTeacherScore;
    }

    public java.sql.Date getCTODate() {
        return this.cTODate;
    }

    public void setCTODate(java.sql.Date cTODate) {
        this.cTODate = cTODate;
    }

    public String getCorpOpinion() {
        return this.corpOpinion;
    }

    public void setCorpOpinion(String corpOpinion) {
        this.corpOpinion = corpOpinion;
    }

    public java.sql.Date getCODate() {
        return this.cODate;
    }

    public void setCODate(java.sql.Date cODate) {
        this.cODate = cODate;
    }

    public String getCorpTeacherGrade() {
        return this.corpTeacherGrade;
    }

    public void setCorpTeacherGrade(String corpTeacherGrade) {
        this.corpTeacherGrade = corpTeacherGrade;
    }

    public java.sql.Date getCTGDate() {
        return this.cTGDate;
    }

    public void setCTGDate(java.sql.Date cTGDate) {
        this.cTGDate = cTGDate;
    }

    public String getTeacherGrade() {
        return this.teacherGrade;
    }

    public void setTeacherGrade(String teacherGrade) {
        this.teacherGrade = teacherGrade;
    }

    public java.sql.Date getTGDate() {
        return this.tGDate;
    }

    public void setTGDate(java.sql.Date tGDate) {
        this.tGDate = tGDate;
    }

    public String getComprehsvGrade() {
        return Rating.getEnum(this.corpTeacherScore).compareTo(
                Rating.getEnum(this.teacherGrade)) > 0 ? this.corpTeacherScore : this.teacherGrade;
    }

    public void setComprehsvGrade(String comprehsvGrade) {
        this.comprehsvGrade = comprehsvGrade;
    }

    public java.sql.Date getCGDate() {
        return this.cGDate;
    }

    public void setCGDate(java.sql.Date cGDate) {
        this.cGDate = cGDate;
    }

    public String getCollegePrincipalOpinion() {
        return this.collegePrincipalOpinion;
    }

    public void setCollegePrincipalOpinion(String collegePrincipalOpinion) {
        this.collegePrincipalOpinion = collegePrincipalOpinion;
    }

    public java.sql.Date getCPODate() {
        return this.cPODate;
    }

    public void setCPODate(java.sql.Date cPODate) {
        this.cPODate = cPODate;
    }

    public Date getGmtStart() {
        return gmtStart;
    }

    public void setGmtStart(Date gmtStart) {
        this.gmtStart = gmtStart;
    }

    public Date getGmtEnd() {
        return gmtEnd;
    }

    public void setGmtEnd(Date gmtEnd) {
        this.gmtEnd = gmtEnd;
    }

    public Date getcTODate() {
        return cTODate;
    }

    public void setcTODate(Date cTODate) {
        this.cTODate = cTODate;
    }

    public Date getcODate() {
        return cODate;
    }

    public void setcODate(Date cODate) {
        this.cODate = cODate;
    }

    public Date getcTGDate() {
        return cTGDate;
    }

    public void setcTGDate(Date cTGDate) {
        this.cTGDate = cTGDate;
    }

    public Date gettGDate() {
        return tGDate;
    }

    public void settGDate(Date tGDate) {
        this.tGDate = tGDate;
    }

    public Date getcGDate() {
        return cGDate;
    }

    public void setcGDate(Date cGDate) {
        this.cGDate = cGDate;
    }

    public Date getcPODate() {
        return cPODate;
    }

    public void setcPODate(Date cPODate) {
        this.cPODate = cPODate;
    }

    @Override
    public String toString() {
        return "SxIdentifyForm{" +
                "id=" + id +
                ", stuNo='" + stuNo + '\'' +
                ", gmtStart=" + gmtStart +
                ", gmtEnd=" + gmtEnd +
                ", sxContent='" + sxContent + '\'' +
                ", selfSummary='" + selfSummary + '\'' +
                ", corpTeacherOpinion='" + corpTeacherOpinion + '\'' +
                ", corpTeacherScore='" + corpTeacherScore + '\'' +
                ", cTODate=" + cTODate +
                ", corpOpinion='" + corpOpinion + '\'' +
                ", cODate=" + cODate +
                ", corpTeacherGrade='" + corpTeacherGrade + '\'' +
                ", cTGDate=" + cTGDate +
                ", teacherGrade='" + teacherGrade + '\'' +
                ", tGDate=" + tGDate +
                ", comprehsvGrade='" + comprehsvGrade + '\'' +
                ", cGDate=" + cGDate +
                ", collegePrincipalOpinion='" + collegePrincipalOpinion + '\'' +
                ", cPODate=" + cPODate +
                '}';
    }
}
