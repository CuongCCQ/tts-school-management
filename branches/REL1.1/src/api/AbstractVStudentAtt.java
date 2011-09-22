package api;

/**
 * AbstractVStudentAtt entity provides the base persistence definition of the
 * VStudentAtt entity. @author MyEclipse Persistence Tools
 */
public abstract class AbstractVStudentAtt implements java.io.Serializable {

    // Fields
    private Integer studentId;
    private String name;
    private Integer classOfferId;
    private Boolean absenceStatus;
    private Integer attendanceId;
    private Integer assigmentScheduleId;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Boolean getAbsenceStatus() {
        return absenceStatus;
    }

    public void setAbsenceStatus(Boolean absenceStatus) {
        this.absenceStatus = absenceStatus;
    }

    public Integer getAssigmentScheduleId() {
        return assigmentScheduleId;
    }

    public void setAssigmentScheduleId(Integer assigmentScheduleId) {
        this.assigmentScheduleId = assigmentScheduleId;
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Integer getClassOfferId() {
        return classOfferId;
    }

    public void setClassOfferId(Integer classOfferId) {
        this.classOfferId = classOfferId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
