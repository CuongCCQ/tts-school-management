package api;

/**
 * Staff entity. @author MyEclipse Persistence Tools
 */
public class StaffV2 extends AbstractStaff implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public StaffV2() {
	}

	/** minimal constructor */
	public StaffV2(Integer staffId, String name) {
		super(staffId, name);
	}
        public StaffV2(String name){
           super(name);
        }

	/** full constructor */
	

}
