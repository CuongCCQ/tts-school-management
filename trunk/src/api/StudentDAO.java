package api;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * Student entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see api.Student
 * @author MyEclipse Persistence Tools
 */
public class StudentDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(StudentDAO.class);
    // property constants
    public static final String STUDENT_CODE = "studentCode";
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
    public static final String STATUS = "status";

    public void save(Student transientInstance) {
        log.debug("saving Student instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void savePhoto(Student student) {
        log.debug("saving Student instance");
        try {
            long id = student.getStudentId();
            String sql = "update Student set photo=? where studentid=? ";
            SQLQuery query = getSession().createSQLQuery(sql);
            query.setParameter(0, student.getPhoto());
            query.setParameter(1, id);
            int k = query.executeUpdate();
            System.out.println(k);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Student persistentInstance) {
        log.debug("deleting Student instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Student findById(java.lang.Integer id) {
        log.debug("getting Student instance with id: " + id);
        try {
            Student instance = (Student) getSession().get("api.Student", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public StudentV2 findByIdV2(java.lang.Integer id) {
        log.debug("getting Student instance with id: " + id);
        try {
            StudentV2 instance = (StudentV2) getSession().get("api.StudentV2", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List<StudentAttendance> getAllStudentByClassOfferId(Long classOfferId)
    {
         log.debug("getting Student ");
        try {
            String sql="from StudentV2";
            Query queryObject = getSession().createQuery(sql);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(Student instance) {
        log.debug("finding Student instance by example");
        try {
            List results = getSession().createCriteria("api.Student").add(
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
        log.debug("finding Student instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Student as model where model."
                    + propertyName + "= ?";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, value);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List findByStudentCode(Object studentCode) {
        return findByProperty(STUDENT_CODE, studentCode);
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

    public List findByStatus(Object status) {
        return findByProperty(STATUS, status);
    }

    public List findAll() {
        log.debug("finding all Student instances");
        try {
            String queryString = "from Student";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List findAllStudentV2() {
        log.debug("finding all StudentV2 instances");
        try {
            String queryString = "from StudentV2";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Student merge(Student detachedInstance) {
        log.debug("merging Student instance");
        try {
            Student result = (Student) getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Student instance) {
        log.debug("attaching dirty Student instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Student instance) {
        log.debug("attaching clean Student instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public List<StudentV2> filterByObject(StudentV2 st) {
        List<Object> params = new ArrayList<Object>();
        StringBuilder sqlBuider = new StringBuilder("from StudentV2 as model where 1=1");

        // search by student code
        if (st.getStudentCode() != null && !st.getStudentCode().isEmpty()) {
            sqlBuider.append("and model.studentCode like ?");
            params.add("%" + st.getStudentCode() + "%");
        }

        // search by address
        if (st.getAddress() != null && !st.getAddress().isEmpty()) {
            sqlBuider.append("and model.address like ?");
            params.add("%" + st.getAddress() + "%");
        }
        // search by phone number
        if (st.getPhoneNumber() != null && !st.getPhoneNumber().isEmpty()) {
            sqlBuider.append("and model.phoneNumber like ?");
            params.add("%" + st.getPhoneNumber() + "%");
        }
        // search by email
        if (st.getEmail() != null && !st.getEmail().isEmpty()) {
            sqlBuider.append("and model.email like ?");
            params.add("%" + st.getEmail() + "%");
        }

        // search by email
        if (st.getSex() != null) {
            sqlBuider.append("and model.sex = ?");
            params.add(st.getSex());
        }

        // search by name
        if (st.getName() != null && !st.getName().isEmpty()) {
            sqlBuider.append("and model.name like ?");
            params.add("%" + st.getName() + "%");
        }


        Query queryObj = getSession().createQuery(sqlBuider.toString());
        for (int i = 0; i < params.size(); i++) {
            queryObj.setParameter(i, params.get(i));
        }
        List<StudentV2> result = queryObj.list();


        return result;
    }
}
