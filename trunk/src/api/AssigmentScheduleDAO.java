package api;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * AssigmentSchedule entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see api.AssigmentSchedule
 * @author MyEclipse Persistence Tools
 */
public class AssigmentScheduleDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(AssigmentScheduleDAO.class);
    // property constants
    public static final String CLASS_OFFER_DETAIL_ID = "classOfferDetailId";
    public static final String DESCRIPTION = "description";

    public void save(AssigmentSchedule transientInstance) {
        log.debug("saving AssigmentSchedule instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(AssigmentSchedule persistentInstance) {
        log.debug("deleting AssigmentSchedule instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public void deleteByStaffID(List<SubjectAssignment> lstSubjectAssignments) {
        log.debug("deleting AssigmentSchedule instance");
        try {
            String querryString = "delete from AssigmentSchedule as model where model." + CLASS_OFFER_DETAIL_ID + "=?";
            Query query = getSession().createQuery(querryString);
            for (SubjectAssignment subjectAssignment : lstSubjectAssignments) {
                query.setParameter(0, subjectAssignment.getClassOfferDetailId());
                System.out.println(subjectAssignment.getClassOfferDetailId());
                query.executeUpdate();
            }




        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public AssigmentSchedule findById(java.lang.Integer id) {
        log.debug("getting AssigmentSchedule instance with id: " + id);
        try {
            AssigmentSchedule instance = (AssigmentSchedule) getSession().get(
                    "api.AssigmentSchedule", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(AssigmentSchedule instance) {
        log.debug("finding AssigmentSchedule instance by example");
        try {
            List results = getSession().createCriteria("api.AssigmentSchedule").add(Example.create(instance)).list();
            log.debug("find by example successful, result size: "
                    + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.debug("finding AssigmentSchedule instance with property: "
                + propertyName + ", value: " + value);
        try {
            String queryString = "from AssigmentSchedule as model where model."
                    + propertyName + "= ?";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, value);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List findByClassOfferDetailId(Object classOfferDetailId) {
        return findByProperty(CLASS_OFFER_DETAIL_ID, classOfferDetailId);
    }

    public List findByDescription(Object description) {
        return findByProperty(DESCRIPTION, description);
    }

    public List findAll() {
        log.debug("finding all AssigmentSchedule instances");
        try {
            String queryString = "from AssigmentSchedule";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public AssigmentSchedule merge(AssigmentSchedule detachedInstance) {
        log.debug("merging AssigmentSchedule instance");
        try {
            AssigmentSchedule result = (AssigmentSchedule) getSession().merge(
                    detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AssigmentSchedule instance) {
        log.debug("attaching dirty AssigmentSchedule instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(AssigmentSchedule instance) {
        log.debug("attaching clean AssigmentSchedule instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
