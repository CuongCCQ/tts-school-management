/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package api;

/**
 *
 * @author bo
 * @date May 12, 2011
 * @
 */
public class StudentAttendance extends Attendance {

    public StudentAttendance(String studentName, String studentCode,Attendance att) {
        this.studentName = studentName;
        this.studentCode = studentCode;
        this.setAbsenceStatus(att.getAbsenceStatus());
        this.setAssigmentScheduleId(att.getAssigmentScheduleId());
        this.setDescription(att.getDescription());
        this.setStudentId(att.getStudentId());
    }



    private String studentName;
    private String studentCode;

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}
