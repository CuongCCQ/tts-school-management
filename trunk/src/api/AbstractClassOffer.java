package api;

/**
 * AbstractClassOffer entity provides the base persistence definition of the
 * ClassOffer entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractClassOffer implements java.io.Serializable {

	// Fields

	private Integer classOfferId;
	private String classCode;
	private Short minStudent;
	private Short maxStudent;
	private Integer semesterId;
	private Integer id;

	// Constructors

	/** default constructor */
	public AbstractClassOffer() {
	}

	/** full constructor */
	public AbstractClassOffer(Integer classOfferId, String classCode,
			Short minStudent, Short maxStudent, Integer semesterId, Integer id) {
		this.classOfferId = classOfferId;
		this.classCode = classCode;
		this.minStudent = minStudent;
		this.maxStudent = maxStudent;
		this.semesterId = semesterId;
		this.id = id;
	}

	// Property accessors

	public Integer getClassOfferId() {
		return this.classOfferId;
	}

	public void setClassOfferId(Integer classOfferId) {
		this.classOfferId = classOfferId;
	}

	public String getClassCode() {
		return this.classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public Short getMinStudent() {
		return this.minStudent;
	}

	public void setMinStudent(Short minStudent) {
		this.minStudent = minStudent;
	}

	public Short getMaxStudent() {
		return this.maxStudent;
	}

	public void setMaxStudent(Short maxStudent) {
		this.maxStudent = maxStudent;
	}

	public Integer getSemesterId() {
		return this.semesterId;
	}

	public void setSemesterId(Integer semesterId) {
		this.semesterId = semesterId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}