package api;

import java.sql.Timestamp;

/**
 * Semester entity. @author MyEclipse Persistence Tools
 */
public class Semester extends AbstractSemester implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Semester() {
	}

	/** minimal constructor */
	public Semester(Integer semesterId) {
		super(semesterId);
	}

	/** full constructor */
	public Semester(Integer semesterId, Timestamp startDate, Timestamp endDate,
			String description) {
		super(semesterId, startDate, endDate, description);
	}

}
