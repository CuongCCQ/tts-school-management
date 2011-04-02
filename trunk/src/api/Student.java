package api;

import java.sql.Timestamp;

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

	/** full constructor */
	public Student(Integer studentId, Timestamp dateOfBirth,
			String studentCode, String firstName, String middleName,
			String lastName, String address, String phoneNumber, Boolean sex,
			String email, String photo, String name, Integer age, Short status) {
		super(studentId, dateOfBirth, studentCode, firstName, middleName,
				lastName, address, phoneNumber, sex, email, photo, name, age,
				status);
	}

}
