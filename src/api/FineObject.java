/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

/**
 *
 * @author bo
 * @date May 13, 2011
 * @
 */
public class FineObject {

    private String subjectName;
    private int numberConduct;
    private int numberOfAttendace;
    private int subjectId;

    public int getNumberConduct() {
        return numberConduct;
    }

    public void setNumberConduct(int numberConduct) {
        this.numberConduct = numberConduct;
    }

    public int getNumberOfAttendace() {
        return numberOfAttendace;
    }

    public void setNumberOfAttendace(int numberOfAttendace) {
        this.numberOfAttendace = numberOfAttendace;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
