package api;

/**
 * AbstractSubject entity provides the base persistence definition of the
 * Subject entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSubject implements java.io.Serializable {

	// Fields

	private Integer subjectId;
	private String subjectCode;
	private String subjectName;
	private String description;
	private Short status;

	// Constructors

	/** default constructor */
	public AbstractSubject() {
	}

	/** minimal constructor */
	public AbstractSubject(Integer subjectId, String subjectCode, Short status) {
		this.subjectId = subjectId;
		this.subjectCode = subjectCode;
		this.status = status;
	}

	/** full constructor */
	public AbstractSubject(Integer subjectId, String subjectCode,
			String subjectName, String description, Short status) {
		this.subjectId = subjectId;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.description = description;
		this.status = status;
	}

	// Property accessors

	public Integer getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectCode() {
		return this.subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

}