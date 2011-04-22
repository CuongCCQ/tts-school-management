package api;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * StudentCourseRegistration entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see api.StudentCourseRegistration
 * @author MyEclipse Persistence Tools
 */
public class StudentCourseRegistrationDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(StudentCourseRegistrationDAO.class);
    // property constants
    public static final String CLASS_OFFER_ID = "classOfferId";
    public static final String STUDENT_ID = "studentId";
    public static final String NOTE = "note";

    public void save(StudentCourseRegistration transientInstance) {
        log.debug("saving StudentCourseRegistration instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(StudentCourseRegistration persistentInstance) {
        log.debug("deleting StudentCourseRegistration instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public void deleteByStudent(int studentID) {
        log.debug("deleting StudentCourseRegistration instance");
        try {
            String stringQuerry = "delete from StudentCourseRegistration as model where model.studentId = ?";
            Query queryObject = getSession().createQuery(stringQuerry);
            queryObject.setParameter(0, studentID);
            queryObject.executeUpdate();
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }

    }
    public Long countSudentInClass(int classID){
         log.debug("deleting StudentCourseRegistration instance");
        try {
            String stringQuerry = "select count (*) from StudentCourseRegistration as model where model."+CLASS_OFFER_ID+ "= ?";
            Query queryObject = getSession().createQuery(stringQuerry);
            queryObject.setParameter(0, classID);
            List lst=queryObject.list();
            return (Long)(lst.get(0));
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public StudentCourseRegistration findById(java.lang.Integer id) {
        log.debug("getting StudentCourseRegistration instance with id: " + id);
        try {
            StudentCourseRegistration instance = (StudentCourseRegistration) getSession().get("api.StudentCourseRegistration", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(StudentCourseRegistration instance) {
        log.debug("finding StudentCourseRegistration instance by example");
        try {
            List results = getSession().createCriteria(
                    "api.StudentCourseRegistration").add(
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
        log.debug("finding StudentCourseRegistration instance with property: "
                + propertyName + ", value: " + value);
        try {
            String queryString = "from StudentCourseRegistration as model where model."
                    + propertyName + "= ?";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, value);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List findByStudentCodeAndClassID(Object ClassOfferID, Object StudentID) {
        try {
            String queryString = "from StudentCourseRegistration as model where model.classOfferId= ? "
                    + "and model.studentId = ?";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, ClassOfferID);
            queryObject.setParameter(1, StudentID);
            return queryObject.list();
        } catch (RuntimeException e) {
            throw e;
        }

    }

    public List findByClassOfferId(Object classOfferId) {
        return findByProperty(CLASS_OFFER_ID, classOfferId);
    }

    public List findByStudentId(Object studentId) {
        return findByProperty(STUDENT_ID, studentId);
    }

    public List findByNote(Object note) {
        return findByProperty(NOTE, note);
    }

    public List findAll() {
        log.debug("finding all StudentCourseRegistration instances");
        try {
            String queryString = "from StudentCourseRegistration";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public StudentCourseRegistration merge(
            StudentCourseRegistration detachedInstance) {
        log.debug("merging StudentCourseRegistration instance");
        try {
            StudentCourseRegistration result = (StudentCourseRegistration) getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(StudentCourseRegistration instance) {
        log.debug("attaching dirty StudentCourseRegistration instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(StudentCourseRegistration instance) {
        log.debug("attaching clean StudentCourseRegistration instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public List<Student> getAllStudentOffClassByOfferId(int classOfferId) {
        try {
            String queryString = "SELECT DISTINCT st FROM StudentCourseRegistration scr,Student st"
                    + " WHERE scr.studentId=st.studentId"
                    + " AND scr.classOfferId=?";

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
