package api;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */
public class Course extends AbstractCourse implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(Integer id) {
		super(id);
	}

	/** full constructor */
	public Course(Integer id, String courseName,
			String description, String courseCode) {
		super(id, courseName, description, courseCode);
	}

}
