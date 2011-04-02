package api;

/**
 * Subject entity. @author MyEclipse Persistence Tools
 */
public class Subject extends AbstractSubject implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Subject() {
	}

	/** minimal constructor */
	public Subject(Integer subjectId, String subjectCode, Short status) {
		super(subjectId, subjectCode, status);
	}

	/** full constructor */
	public Subject(Integer subjectId, String subjectCode, String subjectName,
			String description, Short status) {
		super(subjectId, subjectCode, subjectName, description, status);
	}

}
