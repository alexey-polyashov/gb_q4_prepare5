package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSession(){
        if(sessionFactory == null){
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("build SeesionFactory failed :" + ex);
                throw new ExceptionInInitializerError(ex);
            }

        }
        return sessionFactory;
    }

    public static void close() {
        sessionFactory.close();
    }

}
