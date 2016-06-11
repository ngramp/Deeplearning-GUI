package util.hibernatesucks;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PostgresHibernateUtil {
    private static Configuration configuration = new Configuration();
    private static SessionFactory sessionFactory;
    private static Properties prop;

    private static SessionFactory buildSessionFactory() {
        try {

            prop = new Properties();

            String url = "127.0.0.1:5432/hstoreArrayCurddemo";
            prop.put("hibernate.dialect","com.vivekpatidar.postgres.demo.ArrayPostgreSQLDialect");
            prop.put("hibernate.connection.driver_class","org.postgresql.Driver");
            prop.put("hibernate.connection.url", "jdbc:postgresql://" + url);

            prop.put("hibernate.connection.username", "postgres");
            prop.put("hibernate.connection.password", "root");

            prop.put("hibernate.show_sql", "true");
            prop.put("hibernate.hbm2ddl.auto", "update");
            prop.put("hibernate.connection.isolation", "2");

            configuration.setProperties(prop);

            configuration.addAnnotatedClass(UserContact.class);

            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.out.println("Initital session factory build failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}