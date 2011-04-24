package api;

import aptech.util.AppUtil;
import java.io.File;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import project.Main;

/**
 * Configures and provides access to Hibernate sessions, tied to the
 * current thread of execution.  Follows the Thread Local Session
 * pattern, see {@link http://hibernate.org/42.html }.
 */
public class HibernateSessionFactory {

    /** 
     * Location of hibernate.cfg.xml file.
     * Location should be on the classpath as Hibernate uses  
     * #resourceAsStream style lookup for its configuration file. 
     * The default classpath location of the hibernate config file is 
     * in the default package. Use #setConfigFile() to update 
     * the location of the configuration file for the current session.   
     */
    private static String CONFIG_FILE_LOCATION = "hibernate.cfg.xml";
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static Configuration configuration = new Configuration();
    private static org.hibernate.SessionFactory sessionFactory;
    private static String configFile = CONFIG_FILE_LOCATION;

    static {
        try {
//            AppUtil.showErrMsg(Main.class.getResource("").getPath());
            String filePath = getConfigPath();
//            AppUtil.showErrMsg(filePath);
            File file = new File(filePath);
            configuration.configure(file);
//            AppUtil.showErrMsg("begin generate session");
            sessionFactory = configuration.buildSessionFactory();
//            AppUtil.showErrMsg("config completed "+sessionFactory.toString());
        } catch (MappingException mEx) {
            System.out.println("not well formed");
            AppUtil.showErrMsg("ZZ"+mEx.getMessage());
        } catch (Exception e) {
            AppUtil.showErrMsg("XX"+e.getMessage());
            System.err.println("%%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }
    }

    private static String getConfigPath() {
        String tempPath = Main.class.getResource("").getPath();
        if (!tempPath.startsWith("file")) {
            return CONFIG_FILE_LOCATION;
        } else {
            StringBuilder builder = new StringBuilder(tempPath.substring(6,tempPath.length()-1));
//            AppUtil.showErrMsg(builder.toString());
            int idx = builder.lastIndexOf("/");
            builder.delete(idx, builder.length());
//            AppUtil.showErrMsg(builder.toString());
            int idx1 = builder.lastIndexOf("/")+1;
            builder.delete(idx1, builder.length());
//            AppUtil.showErrMsg(builder.toString());
//            builder = new StringBuilder(temp2.substring(10));
//            builder.reverse();
            builder.append(CONFIG_FILE_LOCATION);
            return builder.toString();
        }

    }

    private HibernateSessionFactory() {
    }

    /**
     * Returns the ThreadLocal Session instance.  Lazy initialize
     * the <code>SessionFactory</code> if needed.
     *
     *  @return Session
     *  @throws HibernateException
     */
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();

        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession()
                    : null;
            threadLocal.set(session);
        }

        return session;
    }

    /**
     *  Rebuild hibernate session factory
     *
     */
    public static void rebuildSessionFactory() {
        try {
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.err.println("%%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }
    }

    /**
     *  Close the single hibernate session instance.
     *
     *  @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

    /**
     *  return session factory
     *
     */
    public static org.hibernate.SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     *  return session factory
     *
     *	session factory will be rebuilded in the next call
     */
    public static void setConfigFile(String configFile) {
        HibernateSessionFactory.configFile = configFile;
        sessionFactory = null;
    }

    /**
     *  return hibernate configuration
     *
     */
    public static Configuration getConfiguration() {
        return configuration;
    }
}
