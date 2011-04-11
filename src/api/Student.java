package api;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
public class Student extends AbstractStudent implements java.io.Serializable {

    // Constructors
    /** default constructor */
    public Student() {
    }

    /** minimal constructor */
    public Student(Integer studentId) {
        super(studentId);
    }

   
}
