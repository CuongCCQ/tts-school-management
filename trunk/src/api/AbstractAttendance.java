package api;

/**
 * AbstractAttendance entity provides the base persistence definition of the
 * Attendance entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAttendance implements java.io.Serializable {

	// Fields

	private Integer attendanceId;
	private Short absenceStatus;
	private String description;
	private Integer studentId;
	private Integer assigmentScheduleId;

	// Constructors

	/** default constructor */
	public AbstractAttendance() {
	}

	/** minimal constructor */
	public AbstractAttendance(Integer attendanceId, Short absenceStatus,
			Integer studentId, Integer assigmentScheduleId) {
		this.attendanceId = attendanceId;
		this.absenceStatus = absenceStatus;
		this.studentId = studentId;
		this.assigmentScheduleId = assigmentScheduleId;
	}

	/** full constructor */
	public AbstractAttendance(Integer attendanceId, Short absenceStatus,
			String description, Integer studentId, Integer assigmentScheduleId) {
		this.attendanceId = attendanceId;
		this.absenceStatus = absenceStatus;
		this.description = description;
		this.studentId = studentId;
		this.assigmentScheduleId = assigmentScheduleId;
	}

	// Property accessors

	public Integer getAttendanceId() {
		return this.attendanceId;
	}

	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Short getAbsenceStatus() {
		return this.absenceStatus;
	}

	public void setAbsenceStatus(Short absenceStatus) {
		this.absenceStatus = absenceStatus;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getAssigmentScheduleId() {
		return this.assigmentScheduleId;
	}

	public void setAssigmentScheduleId(Integer assigmentScheduleId) {
		this.assigmentScheduleId = assigmentScheduleId;
	}

}