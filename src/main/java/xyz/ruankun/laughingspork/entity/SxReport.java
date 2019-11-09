package xyz.ruankun.laughingspork.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Date;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "sx_report")
public class SxReport {

    /**
     * null
     * default value: null
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 关联学生学号
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
     * 第一阶段指导时间,应该为时间段，留varchar
     * default value: null
     */
    @Column(name = "stage1_guide_date", nullable = true)
    private String stage1GuideDate;

    /**
     * 第一阶段指导方式
     * default value: null
     */
    @Column(name = "stage1_guide_way", nullable = true)
    private String stage1GuideWay;

    /**
     * 第一阶段实习总结
     * default value: null
     */
    @Column(name = "stage1_summary", nullable = true)
    private String stage1Summary;

    /**
     * 第一阶段填写日期
     * default value: null
     */
    @Column(name = "stage1_date", nullable = true)
    private java.sql.Date stage1Date;

    /**
     * 第一阶段学院实习指导教师评语
     * default value: null
     */
    @Column(name = "stage1_comment", nullable = true)
    private String stage1Comment;

    /**
     * 第一阶段实习成绩评定
     * default value: null
     */
    @Column(name = "stage1_grade", nullable = true)
    private String stage1Grade;

    /**
     * 第一阶段实习成绩评定日期
     * default value: null
     */
    @Column(name = "stage1_grade_date", nullable = true)
    private java.sql.Date stage1GradeDate;

    /**
     * 第二阶段实习总结
     * default value: null
     */
    @Column(name = "stage2_summary", nullable = true)
    private String stage2Summary;

    /**
     * 第二阶段填写日期
     * default value: null
     */
    @Column(name = "stage2_date", nullable = true)
    private java.sql.Date stage2Date;

    /**
     * 第二阶段学院实习导师评语
     * default value: null
     */
    @Column(name = "stage2_comment", nullable = true)
    private String stage2Comment;

    /**
     * 第二阶段实习成绩评定
     * default value: null
     */
    @Column(name = "stage2_grade", nullable = true)
    private String stage2Grade;

    /**
     * 第二阶段实习成绩评定日期
     * default value: null
     */
    @Column(name = "stage2_grade_date", nullable = true)
    private java.sql.Date stage2GradeDate;

    /**
     * 学院实习指导老师总评
     * default value: null
     */
    @Column(name = "total_grade", nullable = true)
    private String totalGrade;

    /**
     * 学院实习指导老师总评成绩ABCDE
     * default value: null
     */
    @Column(name = "total_score", nullable = true)
    private String totalScore;

    /**
     * 第二阶段指导时间
     * default value: null
     */
    @Column(name = "stage2_guide_date", nullable = true)
    private String stage2GuideDate;

    /**
     * 第二阶段实习指导方式
     * default value: null
     */
    @Column(name = "stage2_guide_way", nullable = true)
    private String stage2GuideWay;


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

    public String getStage1GuideDate() {
        return this.stage1GuideDate;
    }

    public void setStage1GuideDate(String stage1GuideDate) {
        this.stage1GuideDate = stage1GuideDate;
    }

    public String getStage1GuideWay() {
        return this.stage1GuideWay;
    }

    public void setStage1GuideWay(String stage1GuideWay) {
        this.stage1GuideWay = stage1GuideWay;
    }

    public String getStage1Summary() {
        return this.stage1Summary;
    }

    public void setStage1Summary(String stage1Summary) {
        this.stage1Summary = stage1Summary;
    }

    public java.sql.Date getStage1Date() {
        return this.stage1Date;
    }

    public void setStage1Date(java.sql.Date stage1Date) {
        this.stage1Date = stage1Date;
    }

    public String getStage1Comment() {
        return this.stage1Comment;
    }

    public void setStage1Comment(String stage1Comment) {
        this.stage1Comment = stage1Comment;
    }

    public String getStage1Grade() {
        return this.stage1Grade;
    }

    public void setStage1Grade(String stage1Grade) {
        this.stage1Grade = stage1Grade;
    }

    public java.sql.Date getStage1GradeDate() {
        return this.stage1GradeDate;
    }

    public void setStage1GradeDate(java.sql.Date stage1GradeDate) {
        this.stage1GradeDate = stage1GradeDate;
    }

    public String getStage2Summary() {
        return this.stage2Summary;
    }

    public void setStage2Summary(String stage2Summary) {
        this.stage2Summary = stage2Summary;
    }

    public java.sql.Date getStage2Date() {
        return this.stage2Date;
    }

    public void setStage2Date(java.sql.Date stage2Date) {
        this.stage2Date = stage2Date;
    }

    public String getStage2Comment() {
        return this.stage2Comment;
    }

    public void setStage2Comment(String stage2Comment) {
        this.stage2Comment = stage2Comment;
    }

    public String getStage2Grade() {
        return this.stage2Grade;
    }

    public void setStage2Grade(String stage2Grade) {
        this.stage2Grade = stage2Grade;
    }

    public java.sql.Date getStage2GradeDate() {
        return this.stage2GradeDate;
    }

    public void setStage2GradeDate(java.sql.Date stage2GradeDate) {
        this.stage2GradeDate = stage2GradeDate;
    }

    public String getTotalGrade() {
        return this.totalGrade;
    }

    public void setTotalGrade(String totalGrade) {
        this.totalGrade = totalGrade;
    }

    public String getTotalScore() {
        return this.totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public String getStage2GuideDate() {
        return this.stage2GuideDate;
    }

    public void setStage2GuideDate(String stage2GuideDate) {
        this.stage2GuideDate = stage2GuideDate;
    }

    public String getStage2GuideWay() {
        return this.stage2GuideWay;
    }

    public void setStage2GuideWay(String stage2GuideWay) {
        this.stage2GuideWay = stage2GuideWay;
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

    @Override
    public String toString() {
        return "SxReport{" +
                "id=" + id +
                ", stuNo='" + stuNo + '\'' +
                ", gmtStart=" + gmtStart +
                ", gmtEnd=" + gmtEnd +
                ", stage1GuideDate='" + stage1GuideDate + '\'' +
                ", stage1GuideWay='" + stage1GuideWay + '\'' +
                ", stage1Summary='" + stage1Summary + '\'' +
                ", stage1Date=" + stage1Date +
                ", stage1Comment='" + stage1Comment + '\'' +
                ", stage1Grade='" + stage1Grade + '\'' +
                ", stage1GradeDate=" + stage1GradeDate +
                ", stage2Summary='" + stage2Summary + '\'' +
                ", stage2Date=" + stage2Date +
                ", stage2Comment='" + stage2Comment + '\'' +
                ", stage2Grade='" + stage2Grade + '\'' +
                ", stage2GradeDate=" + stage2GradeDate +
                ", totalGrade='" + totalGrade + '\'' +
                ", totalScore='" + totalScore + '\'' +
                ", stage2GuideDate='" + stage2GuideDate + '\'' +
                ", stage2GuideWay='" + stage2GuideWay + '\'' +
                '}';
    }
}
