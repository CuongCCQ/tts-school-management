package api;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractAssigmentSchedule entity provides the base persistence definition of
 * the AssigmentSchedule entity. @author MyEclipse Persistence Tools
 */
public abstract class AbstractAssigmentSchedule implements java.io.Serializable {

    // Fields
    private Integer assigmentScheduleId;
    private Integer classOfferDetailId;
    private Date startTime;
    private Integer MinuteToTeach;

    public Integer getMinuteToTeach() {
        return MinuteToTeach;
    }

    public void setMinuteToTeach(Integer MinuteToTeach) {
        this.MinuteToTeach = MinuteToTeach;
    }

    // Constructors
    /** default constructor */
    public AbstractAssigmentSchedule() {
    }

    /** minimal constructor */
    public AbstractAssigmentSchedule(Integer assigmentScheduleId,
            Integer classOfferDetailId) {
        this.assigmentScheduleId = assigmentScheduleId;
        this.classOfferDetailId = classOfferDetailId;
    }

    /** full constructor */
    // Property accessors
    public Integer getAssigmentScheduleId() {
        return this.assigmentScheduleId;
    }

    public void setAssigmentScheduleId(Integer assigmentScheduleId) {
        this.assigmentScheduleId = assigmentScheduleId;
    }

    public Integer getClassOfferDetailId() {
        return this.classOfferDetailId;
    }

    public void setClassOfferDetailId(Integer classOfferDetailId) {
        this.classOfferDetailId = classOfferDetailId;
    }

    public Date getDate() {
        return this.startTime;
    }

    public void setDate(Date date) {
        this.startTime = date;
    }

    public Timestamp getStartTime() {
        return new Timestamp(startTime.getTime());
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }
}
