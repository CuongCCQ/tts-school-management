package api;

/**
 * AbstractVStudentAttId entity provides the base persistence definition of the
 * VStudentAttId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractVStudentAttId implements java.io.Serializable {

	// Fields

	private Integer studentId;
	private String name;
	private Integer classOfferId;
	private Integer absenceStatus;
	private Integer attendanceId;
	private Integer assigmentScheduleId;

	// Constructors

	/** default constructor */
	public AbstractVStudentAttId() {
	}

	/** minimal constructor */
	public AbstractVStudentAttId(Integer studentId, Integer classOfferId) {
		this.studentId = studentId;
		this.classOfferId = classOfferId;
	}

	/** full constructor */
	public AbstractVStudentAttId(Integer studentId, String name,
			Integer classOfferId, Integer absenceStatus, Integer attendanceId,
			Integer assigmentScheduleId) {
		this.studentId = studentId;
		this.name = name;
		this.classOfferId = classOfferId;
		this.absenceStatus = absenceStatus;
		this.attendanceId = attendanceId;
		this.assigmentScheduleId = assigmentScheduleId;
	}

	// Property accessors

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getClassOfferId() {
		return this.classOfferId;
	}

	public void setClassOfferId(Integer classOfferId) {
		this.classOfferId = classOfferId;
	}

	public Integer getAbsenceStatus() {
		return this.absenceStatus;
	}

	public void setAbsenceStatus(Integer absenceStatus) {
		this.absenceStatus = absenceStatus;
	}

	public Integer getAttendanceId() {
		return this.attendanceId;
	}

	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Integer getAssigmentScheduleId() {
		return this.assigmentScheduleId;
	}

	public void setAssigmentScheduleId(Integer assigmentScheduleId) {
		this.assigmentScheduleId = assigmentScheduleId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractVStudentAttId))
			return false;
		AbstractVStudentAttId castOther = (AbstractVStudentAttId) other;

		return ((this.getStudentId() == castOther.getStudentId()) || (this
				.getStudentId() != null
				&& castOther.getStudentId() != null && this.getStudentId()
				.equals(castOther.getStudentId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getClassOfferId() == castOther.getClassOfferId()) || (this
						.getClassOfferId() != null
						&& castOther.getClassOfferId() != null && this
						.getClassOfferId().equals(castOther.getClassOfferId())))
				&& ((this.getAbsenceStatus() == castOther.getAbsenceStatus()) || (this
						.getAbsenceStatus() != null
						&& castOther.getAbsenceStatus() != null && this
						.getAbsenceStatus()
						.equals(castOther.getAbsenceStatus())))
				&& ((this.getAttendanceId() == castOther.getAttendanceId()) || (this
						.getAttendanceId() != null
						&& castOther.getAttendanceId() != null && this
						.getAttendanceId().equals(castOther.getAttendanceId())))
				&& ((this.getAssigmentScheduleId() == castOther
						.getAssigmentScheduleId()) || (this
						.getAssigmentScheduleId() != null
						&& castOther.getAssigmentScheduleId() != null && this
						.getAssigmentScheduleId().equals(
								castOther.getAssigmentScheduleId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getStudentId() == null ? 0 : this.getStudentId().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37
				* result
				+ (getClassOfferId() == null ? 0 : this.getClassOfferId()
						.hashCode());
		result = 37
				* result
				+ (getAbsenceStatus() == null ? 0 : this.getAbsenceStatus()
						.hashCode());
		result = 37
				* result
				+ (getAttendanceId() == null ? 0 : this.getAttendanceId()
						.hashCode());
		result = 37
				* result
				+ (getAssigmentScheduleId() == null ? 0 : this
						.getAssigmentScheduleId().hashCode());
		return result;
	}

}