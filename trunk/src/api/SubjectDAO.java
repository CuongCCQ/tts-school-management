package api;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * Subject entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see api.Subject
 * @author MyEclipse Persistence Tools
 */
public class SubjectDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(SubjectDAO.class);
    // property constants
    public static final String SUBJECT_CODE = "subjectCode";
    public static final String SUBJECT_NAME = "subjectName";
    public static final String DESCRIPTION = "description";

    public void save(Subject transientInstance) {
        log.debug("saving Subject instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Subject persistentInstance) {
        log.debug("deleting Subject instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Subject findById(java.lang.Integer id) {
        log.debug("getting Subject instance with id: " + id);
        try {
            Subject instance = (Subject) getSession().get("api.Subject", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(Subject instance) {
        log.debug("finding Subject instance by example");
        try {
            List results = getSession().createCriteria("api.Subject").add(
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
        log.debug("finding Subject instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Subject as model where model."
                    + propertyName + "= ?";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, value);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List findBySubjectCode(Object subjectCode) {
        return findByProperty(SUBJECT_CODE, subjectCode);
    }

    public List findBySubjectName(Object subjectName) {
        return findByProperty(SUBJECT_NAME, subjectName);
    }

    public List findByDescription(Object description) {
        return findByProperty(DESCRIPTION, description);
    }

    public List findAll() {
        log.debug("finding all Subject instances");
        try {
            String queryString = "from Subject";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Subject merge(Subject detachedInstance) {
        log.debug("merging Subject instance");
        try {
            Subject result = (Subject) getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Subject instance) {
        log.debug("attaching dirty Subject instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Subject instance) {
        log.debug("attaching clean Subject instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public List<Subject> filterByObject(Subject st) {
        List<Object> params = new ArrayList<Object>();
        StringBuilder sqlBuider = new StringBuilder("from Subject as model where 1=1");

        // search by code
        if (st.getSubjectCode() != null && !st.getSubjectCode().isEmpty()) {
            sqlBuider.append("and model.subjectCode like ?");
            params.add("%" + st.getSubjectCode() + "%");
        }

        // search by name
        if (st.getSubjectName() != null && !st.getSubjectName().isEmpty()) {
            sqlBuider.append("and model.subjectName like ?");
            params.add("%" + st.getSubjectName() + "%");
        }
        // search by Description
        if (st.getDescription() != null && !st.getDescription().isEmpty()) {
            sqlBuider.append("and model.description like ?");
            params.add("%" + st.getDescription() + "%");
        }

        Query queryObj = getSession().createQuery(sqlBuider.toString());
        for (int i = 0; i < params.size(); i++) {
            queryObj.setParameter(i, params.get(i));
        }
        List<Subject> result = queryObj.list();


        return result;
    }

    public List<Subject> getAllSubjectByClassOfferId(int classOfferId) {
        try {
            String queryString = "SELECT distinct s FROM SubjectAssignment sa,Subject s"
                    + " WHERE sa.subjectId=s.subjectId"
                    + " AND sa.classOfferId=?";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, classOfferId);
            List list = queryObject.list();
            return list;
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }
}
