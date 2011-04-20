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
 * ClassOffer entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see api.ClassOffer
 * @author MyEclipse Persistence Tools
 */

public class ClassOfferDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(ClassOfferDAO.class);
	// property constants
	public static final String CLASS_CODE = "classCode";
	public static final String MIN_STUDENT = "minStudent";
	public static final String MAX_STUDENT = "maxStudent";
	public static final String SEMESTER_ID = "semesterId";
	public static final String ID = "id";

	public void save(ClassOffer transientInstance) {
		log.debug("saving ClassOffer instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ClassOffer persistentInstance) {
		log.debug("deleting ClassOffer instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ClassOffer findById(java.lang.Integer id) {
		log.debug("getting ClassOffer instance with id: " + id);
		try {
			ClassOffer instance = (ClassOffer) getSession().get(
					"api.ClassOffer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ClassOffer instance) {
		log.debug("finding ClassOffer instance by example");
		try {
			List results = getSession().createCriteria("api.ClassOffer").add(
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
		log.debug("finding ClassOffer instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ClassOffer as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public void deleteBySemesterID(int  semesterID) {
		log.debug("delete ClassOffer by with Semester ");
		try {
			String queryString = "delete from ClassOffer as model where model."
					+SEMESTER_ID+"= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0,semesterID);
                        queryObject.executeUpdate();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByClassCode(Object classCode) {
		return findByProperty(CLASS_CODE, classCode);
	}

	public List findByMinStudent(Object minStudent) {
		return findByProperty(MIN_STUDENT, minStudent);
	}

	public List findByMaxStudent(Object maxStudent) {
		return findByProperty(MAX_STUDENT, maxStudent);
	}

	public List findBySemesterId(Object semesterId) {
		return findByProperty(SEMESTER_ID, semesterId);
	}

	public List findById(Object id) {
		return findByProperty(ID, id);
	}

	public List findAll() {
		log.debug("finding all ClassOffer instances");
		try {
			String queryString = "from ClassOffer";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ClassOffer merge(ClassOffer detachedInstance) {
		log.debug("merging ClassOffer instance");
		try {
			ClassOffer result = (ClassOffer) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ClassOffer instance) {
		log.debug("attaching dirty ClassOffer instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ClassOffer instance) {
		log.debug("attaching clean ClassOffer instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
         public List<ClassOffer> filterByObject(ClassOffer CO) {
        List<Object> params = new ArrayList<Object>();
        StringBuilder sqlBuider = new StringBuilder("from ClassOffer as model where 1=1");

        // search by class code
        if (CO.getClassCode() != null && !CO.getClassCode().isEmpty()) {
            sqlBuider.append("and model.classCode like ?");
            params.add("%" + CO.getClassCode() + "%");
        }
       
        Query queryObj = getSession().createQuery(sqlBuider.toString());
        for (int i = 0; i < params.size(); i++) {
            queryObj.setParameter(i, params.get(i));
        }
        List<ClassOffer> result = queryObj.list();


        return result;
}
}