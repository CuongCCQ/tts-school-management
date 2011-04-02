package api;

/**
 * SubjectAssignment entity. @author MyEclipse Persistence Tools
 */
public class SubjectAssignment extends AbstractSubjectAssignment implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public SubjectAssignment() {
	}

	/** minimal constructor */
	public SubjectAssignment(Integer classOfferDetailId, Integer classOfferId,
			Integer subjectId, Integer staffId, Short numberOfLession,
			Short numberOfAssignment) {
		super(classOfferDetailId, classOfferId, subjectId, staffId,
				numberOfLession, numberOfAssignment);
	}

	/** full constructor */
	public SubjectAssignment(Integer classOfferDetailId, Integer classOfferId,
			Integer subjectId, Integer staffId, Integer minutesPerLession,
			Short numberOfLession, Short numberOfAssignment) {
		super(classOfferDetailId, classOfferId, subjectId, staffId,
				minutesPerLession, numberOfLession, numberOfAssignment);
	}

}
