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
 * Attendance entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see api.Attendance
 * @author MyEclipse Persistence Tools
 */
public class AttendanceDAO extends BaseHibernateDAO {

    private static final Log log = LogFactory.getLog(AttendanceDAO.class);
    // property constants
    public static final String ABSENCE_STATUS = "absenceStatus";
    public static final String DESCRIPTION = "description";
    public static final String STUDENT_ID = "studentId";
    public static final String ASSIGMENT_SCHEDULE_ID = "assigmentScheduleId";

    public void save(Attendance transientInstance) {
        log.debug("saving Attendance instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Attendance persistentInstance) {
        log.debug("deleting Attendance instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Attendance findById(java.lang.Integer id) {
        log.debug("getting Attendance instance with id: " + id);
        try {
            Attendance instance = (Attendance) getSession().get(
                    "api.Attendance", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(Attendance instance) {
        log.debug("finding Attendance instance by example");
        try {
            List results = getSession().createCriteria("api.Attendance").add(
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
        log.debug("finding Attendance instance with property: " + propertyName
                + ", value: " + value);
        try {
            String queryString = "from Attendance as model where model."
                    + propertyName + "= ?";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(0, value);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public void deleteByStaffID(List<AssigmentSchedule> lstSubjectAssignments) {
        log.debug("deleting AssigmentSchedule instance");
        try {
            String querryString = "delete from Attendance as model where model." + ASSIGMENT_SCHEDULE_ID + "=?";
            Query query = getSession().createQuery(querryString);
            for (AssigmentSchedule assumengtTemp : lstSubjectAssignments) {
                query.setParameter(0, assumengtTemp.getAssigmentScheduleId());
                query.executeUpdate();
            }




        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public List findByAbsenceStatus(Object absenceStatus) {
        return findByProperty(ABSENCE_STATUS, absenceStatus);
    }

    public List findByDescription(Object description) {
        return findByProperty(DESCRIPTION, description);
    }

    public List findByStudentId(Object studentId) {
        return findByProperty(STUDENT_ID, studentId);
    }

    //public list
    public List<FineObject> generateFineLevy(int classOfferId, int studentId) {
        try {
            String queryString = "EXEC sp_generate_fine_levy "
                    + " @studentId =? ,"
                    + " @classOfferId = ? ";
            Query queryObject = getSession().createSQLQuery(queryString);

            queryObject.setParameter(0, studentId);
            queryObject.setParameter(1, classOfferId);
            List<Object[]> lst = queryObject.list();
            List<FineObject> lstFineObj = new ArrayList<FineObject>();
            for (Object[] objArr : lst) {
                FineObject fObj = new FineObject();
                fObj.setNumberConduct(Integer.valueOf(objArr[1].toString()));
                fObj.setSubjectName(objArr[0].toString());
                fObj.setNumberOfAttendace(Integer.valueOf(objArr[2].toString()));
                fObj.setSubjectId(Integer.valueOf(objArr[3].toString()));
                lstFineObj.add(fObj);
            }
            return lstFineObj;
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public List findByAssigmentScheduleId(Object assigmentScheduleId) {
        return findByProperty(ASSIGMENT_SCHEDULE_ID, assigmentScheduleId);
    }

    public List findAll() {
        log.debug("finding all Attendance instances");
        try {
            String queryString = "from Attendance";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Attendance merge(Attendance detachedInstance) {
        log.debug("merging Attendance instance");
        try {
            Attendance result = (Attendance) getSession().merge(
                    detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Attendance instance) {
        log.debug("attaching dirty Attendance instance");
        try {
            getSession().saveOrUpdate("api.Attendance", instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Attendance instance) {
        log.debug("attaching clean Attendance instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void autoFillAttendaceForClass(int classOfferId, int assScheduleId) {
        List<StudentV2> allStudentByClassOfferId = new StudentDAO().getAllStudentByClassOfferId(classOfferId);
        List<Attendance> lstAtt = new ArrayList<Attendance>();
        getSession().beginTransaction();
        for (StudentV2 student : allStudentByClassOfferId) {
            Attendance attendance = new Attendance();
            attendance.setAssigmentScheduleId(assScheduleId);
            attendance.setAbsenceStatus(false);
            attendance.setStudentId(student.getStudentId());
            attendance.setDescription("");
            lstAtt.add(attendance);
            getSession().save(attendance);
        }
        getSession().getTransaction().commit();
        for (Attendance att : lstAtt) {
            getSession().evict(att);
        }
    }
}
