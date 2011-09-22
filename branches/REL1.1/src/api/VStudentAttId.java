package api;

/**
 * VStudentAttId entity. @author MyEclipse Persistence Tools
 */
public class VStudentAttId extends AbstractVStudentAttId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public VStudentAttId() {
	}

	/** minimal constructor */
	public VStudentAttId(Integer studentId, Integer classOfferId) {
		super(studentId, classOfferId);
	}

	/** full constructor */
	public VStudentAttId(Integer studentId, String name, Integer classOfferId,
			Integer absenceStatus, Integer attendanceId,
			Integer assigmentScheduleId) {
		super(studentId, name, classOfferId, absenceStatus, attendanceId,
				assigmentScheduleId);
	}

}
