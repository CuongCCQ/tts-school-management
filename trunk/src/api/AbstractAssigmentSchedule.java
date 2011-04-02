package api;

import java.sql.Timestamp;

/**
 * AbstractAssigmentSchedule entity provides the base persistence definition of
 * the AssigmentSchedule entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAssigmentSchedule implements java.io.Serializable {

	// Fields

	private Integer assigmentScheduleId;
	private Integer classOfferDetailId;
	private Timestamp date;
	private String description;

	// Constructors

	/** default constructor */
	public AbstractAssigmentSchedule() {
	}

	/** minimal constructor */
	public AbstractAssigmentSchedule(Integer assigmentScheduleId,
			Integer classOfferDetailId) {
		this.assigmentScheduleId = assigmentScheduleId;
		this.classOfferDetailId = classOfferDetailId;
	}

	/** full constructor */
	public AbstractAssigmentSchedule(Integer assigmentScheduleId,
			Integer classOfferDetailId, Timestamp date, String description) {
		this.assigmentScheduleId = assigmentScheduleId;
		this.classOfferDetailId = classOfferDetailId;
		this.date = date;
		this.description = description;
	}

	// Property accessors

	public Integer getAssigmentScheduleId() {
		return this.assigmentScheduleId;
	}

	public void setAssigmentScheduleId(Integer assigmentScheduleId) {
		this.assigmentScheduleId = assigmentScheduleId;
	}

	public Integer getClassOfferDetailId() {
		return this.classOfferDetailId;
	}

	public void setClassOfferDetailId(Integer classOfferDetailId) {
		this.classOfferDetailId = classOfferDetailId;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}