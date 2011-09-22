package api;

/**
 * ClassOffer entity. @author MyEclipse Persistence Tools
 */
public class ClassOffer extends AbstractClassOffer implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public ClassOffer() {
	}

	/** full constructor */
	public ClassOffer(Integer classOfferId, String classCode, Integer minStudent,
			Integer maxStudent, Integer semesterId, Integer id) {
		super(classOfferId, classCode, minStudent, maxStudent, semesterId, id);
	}

}
