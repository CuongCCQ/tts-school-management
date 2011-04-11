package api;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * SubjectAssignment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see api.SubjectAssignment
 * @author MyEclipse Persistence Tools
 */

public class SubjectAssignmentDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory
			.getLog(SubjectAssignmentDAO.class);
	// property constants
	public static final String CLASS_OFFER_ID = "classOfferId";
	public static final String SUBJECT_ID = "subjectId";
	public static final String STAFF_ID = "staffId";
	public static final String MINUTES_PER_LESSION = "minutesPerLession";
	public static final String NUMBER_OF_LESSION = "numberOfLession";
	public static final String NUMBER_OF_ASSIGNMENT = "numberOfAssignment";

	public void save(SubjectAssignment transientInstance) {
		log.debug("saving SubjectAssignment instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SubjectAssignment persistentInstance) {
		log.debug("deleting SubjectAssignment instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SubjectAssignment findById(java.lang.Integer id) {
		log.debug("getting SubjectAssignment instance with id: " + id);
		try {
			SubjectAssignment instance = (SubjectAssignment) getSession().get(
					"api.SubjectAssignment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SubjectAssignment instance) {
		log.debug("finding SubjectAssignment instance by example");
		try {
			List results = getSession().createCriteria("api.SubjectAssignment")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SubjectAssignment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from SubjectAssignment as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByClassOfferId(Object classOfferId) {
		return findByProperty(CLASS_OFFER_ID, classOfferId);
	}

	public List findBySubjectId(Object subjectId) {
		return findByProperty(SUBJECT_ID, subjectId);
	}

	public List findByStaffId(Object staffId) {
		return findByProperty(STAFF_ID, staffId);
	}

	public List findByMinutesPerLession(Object minutesPerLession) {
		return findByProperty(MINUTES_PER_LESSION, minutesPerLession);
	}

	public List findByNumberOfLession(Object numberOfLession) {
		return findByProperty(NUMBER_OF_LESSION, numberOfLession);
	}

	public List findByNumberOfAssignment(Object numberOfAssignment) {
		return findByProperty(NUMBER_OF_ASSIGNMENT, numberOfAssignment);
	}

	public List findAll() {
		log.debug("finding all SubjectAssignment instances");
		try {
			String queryString = "from SubjectAssignment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SubjectAssignment merge(SubjectAssignment detachedInstance) {
		log.debug("merging SubjectAssignment instance");
		try {
			SubjectAssignment result = (SubjectAssignment) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SubjectAssignment instance) {
		log.debug("attaching dirty SubjectAssignment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SubjectAssignment instance) {
		log.debug("attaching clean SubjectAssignment instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}