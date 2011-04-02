package api;

import java.sql.Timestamp;

/**
 * AssigmentSchedule entity. @author MyEclipse Persistence Tools
 */
public class AssigmentSchedule extends AbstractAssigmentSchedule implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public AssigmentSchedule() {
	}

	/** minimal constructor */
	public AssigmentSchedule(Integer assigmentScheduleId,
			Integer classOfferDetailId) {
		super(assigmentScheduleId, classOfferDetailId);
	}

	/** full constructor */
	public AssigmentSchedule(Integer assigmentScheduleId,
			Integer classOfferDetailId, Timestamp date, String description) {
		super(assigmentScheduleId, classOfferDetailId, date, description);
	}

}
