package dataBase;


import EntiyСreature.Human;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Service {

    public static void main(String[] args) {
        Service service = new Service();
        service.createHumanTable();
    }

    public void createHumanTable() {
        Session session = openSession(Human.class);
        Transaction transaction =null;
        try {
            transaction = session.beginTransaction();

            session.createSQLQuery("CREATE TABLE HUMAN " +
                    "(ID INT PRIMARY KEY, NAME VARCHAR(255),BULLETS INT, GRENADES INT, BAG_CEMENT BOOLEAN);").executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
    }

    protected Session openSession(Class clazz) {
        Session session = buildSessionFactory(clazz).openSession();
        return session;
    }

    protected void closeSession(Session session) {
        session.close();
    }

    private static SessionFactory buildSessionFactory(Class clazz) {
        return new Configuration()
                .configure()
                .addAnnotatedClass(clazz)
                .buildSessionFactory();
    }

}
