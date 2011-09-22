package api;

/**
 * AbstractCourse entity provides the base persistence definition of the Course
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCourse implements java.io.Serializable {

	// Fields
	private Integer id;
	private String courseName;
	private String description;
	private String courseCode;

	// Constructors

	/** default constructor */
	public AbstractCourse() {
	}

	/** minimal constructor */
	public AbstractCourse(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractCourse(Integer id, String courseName,
			String description, String courseCode) {
		this.id = id;
		this.courseName = courseName;
		this.description = description;
		this.courseCode = courseCode;
	}
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCourseCode() {
		return this.courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}