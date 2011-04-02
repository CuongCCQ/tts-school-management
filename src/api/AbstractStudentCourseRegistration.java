package api;

/**
 * AbstractStudentCourseRegistration entity provides the base persistence
 * definition of the StudentCourseRegistration entity. @author MyEclipse
 * Persistence Tools
 */

public abstract class AbstractStudentCourseRegistration implements
		java.io.Serializable {

	// Fields

	private Integer studentRegistrationId;
	private Integer classOfferId;
	private Integer studentId;
	private String note;

	// Constructors

	/** default constructor */
	public AbstractStudentCourseRegistration() {
	}

	/** minimal constructor */
	public AbstractStudentCourseRegistration(Integer studentRegistrationId,
			Integer classOfferId, Integer studentId) {
		this.studentRegistrationId = studentRegistrationId;
		this.classOfferId = classOfferId;
		this.studentId = studentId;
	}

	/** full constructor */
	public AbstractStudentCourseRegistration(Integer studentRegistrationId,
			Integer classOfferId, Integer studentId, String note) {
		this.studentRegistrationId = studentRegistrationId;
		this.classOfferId = classOfferId;
		this.studentId = studentId;
		this.note = note;
	}

	// Property accessors

	public Integer getStudentRegistrationId() {
		return this.studentRegistrationId;
	}

	public void setStudentRegistrationId(Integer studentRegistrationId) {
		this.studentRegistrationId = studentRegistrationId;
	}

	public Integer getClassOfferId() {
		return this.classOfferId;
	}

	public void setClassOfferId(Integer classOfferId) {
		this.classOfferId = classOfferId;
	}

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}