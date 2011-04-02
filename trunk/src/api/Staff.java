package api;

/**
 * Staff entity. @author MyEclipse Persistence Tools
 */
public class Staff extends AbstractStaff implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Staff() {
	}

	/** minimal constructor */
	public Staff(Integer staffId, String name) {
		super(staffId, name);
	}

	/** full constructor */
	public Staff(Integer staffId, String staffCode, String firstName,
			String middleName, String lastName, String address,
			String phoneNumber, Boolean sex, String email, String photo,
			String name, Short age) {
		super(staffId, staffCode, firstName, middleName, lastName, address,
				phoneNumber, sex, email, photo, name, age);
	}

}
