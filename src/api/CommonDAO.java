/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author bo
 * @date Apr 16, 2011
 * @
 */
public class CommonDAO extends BaseHibernateDAO {

    public Date getServerTime() {
        String queryString = "select dateadd(dd,0, datediff(dd,0, getDate()))";
        Query queryObject = getSession().createSQLQuery(queryString);
        java.sql.Timestamp date=null;
        List list = queryObject.list();
        if (list.size() > 0) {
            date = (java.sql.Timestamp) list.get(0);
        }
        return new Date(date.getTime());
    }

}
