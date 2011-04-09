package api;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractSemester entity provides the base persistence definition of the
 * Semester entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSemester implements java.io.Serializable {

	// Fields

	private Integer semesterId;
	private Date startDate;
	private Date endDate;
	private String description;

	// Constructors

	/** default constructor */
	public AbstractSemester() {
	}

	/** minimal constructor */
	public AbstractSemester(Integer semesterId) {
		this.semesterId = semesterId;
	}

	/** full constructor */
	public AbstractSemester(Integer semesterId, Timestamp startDate,
			Timestamp endDate, String description) {
		this.semesterId = semesterId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
	}

	// Property accessors

	public Integer getSemesterId() {
		return this.semesterId;
	}

	public void setSemesterId(Integer semesterId) {
		this.semesterId = semesterId;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}