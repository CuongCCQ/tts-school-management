package api;

/**
 * AbstractSubjectAssignment entity provides the base persistence definition of
 * the SubjectAssignment entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSubjectAssignment implements java.io.Serializable {

	// Fields

	private Integer classOfferDetailId;
	private Integer classOfferId;
	private Integer subjectId;
	private Integer staffId;
	private Integer minutesPerLession;
	private Short numberOfLession;
	private Short numberOfAssignment;

	// Constructors

	/** default constructor */
	public AbstractSubjectAssignment() {
	}

	/** minimal constructor */
	public AbstractSubjectAssignment(Integer classOfferDetailId,
			Integer classOfferId, Integer subjectId, Integer staffId,
			Short numberOfLession, Short numberOfAssignment) {
		this.classOfferDetailId = classOfferDetailId;
		this.classOfferId = classOfferId;
		this.subjectId = subjectId;
		this.staffId = staffId;
		this.numberOfLession = numberOfLession;
		this.numberOfAssignment = numberOfAssignment;
	}

	/** full constructor */
	public AbstractSubjectAssignment(Integer classOfferDetailId,
			Integer classOfferId, Integer subjectId, Integer staffId,
			Integer minutesPerLession, Short numberOfLession,
			Short numberOfAssignment) {
		this.classOfferDetailId = classOfferDetailId;
		this.classOfferId = classOfferId;
		this.subjectId = subjectId;
		this.staffId = staffId;
		this.minutesPerLession = minutesPerLession;
		this.numberOfLession = numberOfLession;
		this.numberOfAssignment = numberOfAssignment;
	}

	// Property accessors

	public Integer getClassOfferDetailId() {
		return this.classOfferDetailId;
	}

	public void setClassOfferDetailId(Integer classOfferDetailId) {
		this.classOfferDetailId = classOfferDetailId;
	}

	public Integer getClassOfferId() {
		return this.classOfferId;
	}

	public void setClassOfferId(Integer classOfferId) {
		this.classOfferId = classOfferId;
	}

	public Integer getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getMinutesPerLession() {
		return this.minutesPerLession;
	}

	public void setMinutesPerLession(Integer minutesPerLession) {
		this.minutesPerLession = minutesPerLession;
	}

	public Short getNumberOfLession() {
		return this.numberOfLession;
	}

	public void setNumberOfLession(Short numberOfLession) {
		this.numberOfLession = numberOfLession;
	}

	public Short getNumberOfAssignment() {
		return this.numberOfAssignment;
	}

	public void setNumberOfAssignment(Short numberOfAssignment) {
		this.numberOfAssignment = numberOfAssignment;
	}

}