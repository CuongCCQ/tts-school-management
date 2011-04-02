package api;

/**
 * AbstractStaff entity provides the base persistence definition of the Staff
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStaff implements java.io.Serializable {

	// Fields

	private Integer staffId;
	private String staffCode;
	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private Boolean sex;
	private String email;
	private String photo;
	private String name;
	private Short age;

	// Constructors

	/** default constructor */
	public AbstractStaff() {
	}

	/** minimal constructor */
	public AbstractStaff(Integer staffId, String name) {
		this.staffId = staffId;
		this.name = name;
	}

	/** full constructor */
	public AbstractStaff(Integer staffId, String staffCode, String firstName,
			String middleName, String lastName, String address,
			String phoneNumber, Boolean sex, String email, String photo,
			String name, Short age) {
		this.staffId = staffId;
		this.staffCode = staffCode;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.sex = sex;
		this.email = email;
		this.photo = photo;
		this.name = name;
		this.age = age;
	}

	// Property accessors

	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getStaffCode() {
		return this.staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getSex() {
		return this.sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getAge() {
		return this.age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

}