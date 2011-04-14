package api;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for Staff
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see api.Staff
 * @author MyEclipse Persistence Tools
 */

public class StaffDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(StaffDAO.class);
	// property constants
	public static final String STAFF_CODE = "staffCode";
	public static final String FIRST_NAME = "firstName";
	public static final String MIDDLE_NAME = "middleName";
	public static final String LAST_NAME = "lastName";
	public static final String ADDRESS = "address";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String SEX = "sex";
	public static final String EMAIL = "email";
	public static final String PHOTO = "photo";
	public static final String NAME = "name";
	public static final String AGE = "age";

	public void save(Staff transientInstance) {
		log.debug("saving Staff instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Staff persistentInstance) {
		log.debug("deleting Staff instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Staff findById(java.lang.Integer id) {
		log.debug("getting Staff instance with id: " + id);
		try {
			Staff instance = (Staff) getSession().get("api.Staff", id);
                        
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Staff instance) {
		log.debug("finding Staff instance by example");
		try {
			List results = getSession().createCriteria("api.Staff").add(
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
		log.debug("finding Staff instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Staff as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStaffCode(Object staffCode) {
		return findByProperty(STAFF_CODE, staffCode);
	}

	public List findByFirstName(Object firstName) {
		return findByProperty(FIRST_NAME, firstName);
	}

	public List findByMiddleName(Object middleName) {
		return findByProperty(MIDDLE_NAME, middleName);
	}

	public List findByLastName(Object lastName) {
		return findByProperty(LAST_NAME, lastName);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByPhoneNumber(Object phoneNumber) {
		return findByProperty(PHONE_NUMBER, phoneNumber);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByPhoto(Object photo) {
		return findByProperty(PHOTO, photo);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List findAll() {
		log.debug("finding all Staff instances");
		try {
			String queryString = "from Staff";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
          public List findAllStaffV2() {
        log.debug("finding all StaffV2 instances");
        try {
            String queryString = "from StaffV2";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }
        public List loadIdName() {
		log.debug("finding all Staff instances");
		try {
			String queryString = "select StaffId,Name from Staff";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Staff merge(Staff detachedInstance) {
		log.debug("merging Staff instance");
		try {
			Staff result = (Staff) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Staff instance) {
		log.debug("attaching dirty Staff instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Staff instance) {
		log.debug("attaching clean Staff instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
        public List<StaffV2> filterByObject(StaffV2 stf) {
        List<Object> params = new ArrayList<Object>();
        StringBuilder sqlBuider = new StringBuilder("from StaffV2 as model where 1=1");

        // search by student code
        if (stf.getStaffCode() != null && !stf.getStaffCode().isEmpty()) {
            sqlBuider.append("and model.staffCode like ?");
            params.add("%" + stf.getStaffCode() + "%");
        }

        // search by address
        if (stf.getAddress() != null && !stf.getAddress().isEmpty()) {
            sqlBuider.append("and model.address like ?");
            params.add("%" + stf.getAddress() + "%");
        }
        // search by phone number
        if (stf.getPhoneNumber() != null && !stf.getPhoneNumber().isEmpty()) {
            sqlBuider.append("and model.phoneNumber like ?");
            params.add("%" + stf.getPhoneNumber() + "%");
        }
        // search by email
        if (stf.getEmail() != null && !stf.getEmail().isEmpty()) {
            sqlBuider.append("and model.email like ?");
            params.add("%" + stf.getEmail() + "%");
        }

        // search by email
        if (stf.getSex() != null) {
            sqlBuider.append("and model.sex = ?");
            params.add(stf.getSex());
        }

        // search by name
        if (stf.getName() != null && !stf.getName().isEmpty()) {
            sqlBuider.append("and model.name like ?");
            params.add("%" + stf.getName() + "%");
        }


        Query queryObj = getSession().createQuery(sqlBuider.toString());
        for (int i = 0; i < params.size(); i++) {
            queryObj.setParameter(i, params.get(i));
        }
        List<StaffV2> result = queryObj.list();


        return result;
    }
}