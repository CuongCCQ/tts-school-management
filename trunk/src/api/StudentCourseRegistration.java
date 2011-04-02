package api;

/**
 * StudentCourseRegistration entity. @author MyEclipse Persistence Tools
 */
public class StudentCourseRegistration extends
		AbstractStudentCourseRegistration implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public StudentCourseRegistration() {
	}

	/** minimal constructor */
	public StudentCourseRegistration(Integer studentRegistrationId,
			Integer classOfferId, Integer studentId) {
		super(studentRegistrationId, classOfferId, studentId);
	}

	/** full constructor */
	public StudentCourseRegistration(Integer studentRegistrationId,
			Integer classOfferId, Integer studentId, String note) {
		super(studentRegistrationId, classOfferId, studentId, note);
	}

}
