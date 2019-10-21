package xyz.ruankun.laughingspork.entity;

import javax.persistence.*;

/**
 * null
 */
@Entity
@Table(name = "sx_stagemanage")
public class SxStagemanage {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	/**
	 * 报告册第一阶段开放:学生填写阶段1,教师评价阶段1
	 * default value: 1
	 */
	@Column(name = "is_report_stage1_open", nullable = false)
	private Boolean isReportStage1Open;

	/**
	 * 报告册第二阶段开放:学生填写阶段2,教师评价阶段2
	 * default value: 1
	 */
	@Column(name = "is_report_stage2_open", nullable = false)
	private Boolean isReportStage2Open;

	/**
	 * 报告册第三阶段开放:教师进行总评/打总成绩
	 * default value: 1
	 */
	@Column(name = "is_report_stage3_open", nullable = false)
	private Boolean isReportStage3Open;

	/**
	 * 鉴定表第一阶段开放:学生填写阶段
	 * default value: 1
	 */
	@Column(name = "is_identify_form_stage1_open", nullable = false)
	private Boolean isIdentifyFormStage1Open;

	/**
	 * 鉴定表第二阶段开放:其他角色(除学院领导小组)进行意见填写/打分
	 * default value: 1
	 */
	@Column(name = "is_identify_form_stage2_open", nullable = false)
	private Boolean isIdentifyFormStage2Open;

	/**
	 * 鉴定表第三阶段开放:学院领导小组意见填写/打分
	 * default value: 1
	 */
	@Column(name = "is_identify_form_stage3_open", nullable = false)
	private Boolean isIdentifyFormStage3Open;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Boolean getIsReportStage1Open() {
		return this.isReportStage1Open;
	}
	
	public void setIsReportStage1Open(Boolean isReportStage1Open) {
		this.isReportStage1Open = isReportStage1Open;
	}
	
	public Boolean getIsReportStage2Open() {
		return this.isReportStage2Open;
	}
	
	public void setIsReportStage2Open(Boolean isReportStage2Open) {
		this.isReportStage2Open = isReportStage2Open;
	}
	
	public Boolean getIsReportStage3Open() {
		return this.isReportStage3Open;
	}
	
	public void setIsReportStage3Open(Boolean isReportStage3Open) {
		this.isReportStage3Open = isReportStage3Open;
	}
	
	public Boolean getIsIdentifyFormStage1Open() {
		return this.isIdentifyFormStage1Open;
	}
	
	public void setIsIdentifyFormStage1Open(Boolean isIdentifyFormStage1Open) {
		this.isIdentifyFormStage1Open = isIdentifyFormStage1Open;
	}
	
	public Boolean getIsIdentifyFormStage2Open() {
		return this.isIdentifyFormStage2Open;
	}
	
	public void setIsIdentifyFormStage2Open(Boolean isIdentifyFormStage2Open) {
		this.isIdentifyFormStage2Open = isIdentifyFormStage2Open;
	}
	
	public Boolean getIsIdentifyFormStage3Open() {
		return this.isIdentifyFormStage3Open;
	}
	
	public void setIsIdentifyFormStage3Open(Boolean isIdentifyFormStage3Open) {
		this.isIdentifyFormStage3Open = isIdentifyFormStage3Open;
	}

	@Override
	public String toString() {
		return "SxStagemanage{" +
				"id=" + id +
				", isReportStage1Open=" + isReportStage1Open +
				", isReportStage2Open=" + isReportStage2Open +
				", isReportStage3Open=" + isReportStage3Open +
				", isIdentifyFormStage1Open=" + isIdentifyFormStage1Open +
				", isIdentifyFormStage2Open=" + isIdentifyFormStage2Open +
				", isIdentifyFormStage3Open=" + isIdentifyFormStage3Open +
				'}';
	}
}
