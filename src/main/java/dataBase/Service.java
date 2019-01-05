package dataBase;


import EntiyСreature.Human;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Service extends HibernateUtil{

    public static void main(String[] args) {
        Service service = new Service();
        //service.createHumanTable();
//        Human Pasha = new Human("Pasha",20,2,true);
//        service.addHumanInTable(Pasha);
//        Human humanSav = service.getHumanInTable(1);
//        System.out.println(humanSav.getName());
        service.deletTableHuman();
    }

    /**
     * Получает игрока из таблицы HUMAN по его id
     * @param id - айди игрока
     * @return игрок
     */
    public Human getHumanInTable(int id) {
        Human human = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction =null;
        try {
            transaction = session.beginTransaction();

            human = session.get(Human.class,id);

            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
            HibernateUtil.closeSessionFactory();
        }
        return human;
    }

    /**
     * Добавляет в таблицу HUMAN нового игрока
     * @param human - игрок
     */
    public void addHumanInTable(Human human) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction =null;
        try {
            transaction = session.beginTransaction();

            session.save(human);

            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
            HibernateUtil.closeSessionFactory();
        }
    }

    public void deletTableHuman() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction =null;
        try {
            transaction = session.beginTransaction();

            session.createQuery("DELETE FROM Human").executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
            HibernateUtil.closeSessionFactory();
        }
    }

    /**
     * Создает таблицу HUMAN
     * МЕТОД НЕ РЕКОМЕНДУЕМ К ИСПОЛЬЗОВАНИЮ
     */
    public void createHumanTable() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction =null;
        try {
            transaction = session.beginTransaction();

            session.createSQLQuery("CREATE TABLE HUMAN" +
                    "(ID INT PRIMARY KEY, NAME VARCHAR(255),BULLETS INT, GRENADES INT, BAG_CEMENT BOOLEAN);").executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
            HibernateUtil.closeSessionFactory();
        }
    }



}
