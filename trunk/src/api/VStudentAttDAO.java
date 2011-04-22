package api;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * VStudentAtt entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see api.VStudentAtt
 * @author MyEclipse Persistence Tools
 */
public class VStudentAttDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(VStudentAttDAO.class);

    // property constants
    public void save(VStudentAtt transientInstance) {
        log.debug("saving VStudentAtt instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(VStudentAtt persistentInstance) {
        log.debug("deleting VStudentAtt instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public VStudentAtt findById(api.VStudentAttId id) {
        log.debug("getting VStudentAtt instance with id: " + id);
        try {
            VStudentAtt instance = (VStudentAtt) getSession().get(
                    "api.VStudentAtt", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(VStudentAtt instance) {
        log.debug("finding VStudentAtt instance by example");
        try {
            List results = getSession().createCriteria("api.VStudentAtt").add(
                    Example.create(instance)).list();
            log.debug("find by example successful, result size: "
                    + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.debug("finding VStudentAtt instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from VStudentAtt as model where model."
                    + propertyName + "= ?";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, value);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List findAll() {
        log.debug("finding all VStudentAtt instances");
        try {
            String queryString = "from VStudentAtt";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public VStudentAtt merge(VStudentAtt detachedInstance) {
        log.debug("merging VStudentAtt instance");
        try {
            VStudentAtt result = (VStudentAtt) getSession().merge(
                    detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(VStudentAtt instance) {
        log.debug("attaching dirty VStudentAtt instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(VStudentAtt instance) {
        log.debug("attaching clean VStudentAtt instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public List<VStudentAtt> findByOfferAndAssScheduleId(int classOfferId, int assScheduleId) {
        try {
            String queryString = "from VStudentAtt as model where model.classOfferId=? and model.assigmentScheduleId=?";

            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, classOfferId);
            queryObject.setParameter(1, assScheduleId);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }
}
