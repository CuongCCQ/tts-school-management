package api;

/**
 * Attendance entity. @author MyEclipse Persistence Tools
 */
public class Attendance extends AbstractAttendance implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Attendance() {
	}

	/** minimal constructor */
	public Attendance(Integer attendanceId, Boolean absenceStatus,
			Integer studentId, Integer assigmentScheduleId) {
		super(attendanceId, absenceStatus, studentId, assigmentScheduleId);
	}

	/** full constructor */
	public Attendance(Integer attendanceId, Boolean absenceStatus,
			String description, Integer studentId, Integer assigmentScheduleId) {
		super(attendanceId, absenceStatus, description, studentId,
				assigmentScheduleId);
	}

}
