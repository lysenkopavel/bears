package dataBase;


import EntiyСreature.Human;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Класс, отвечающий за работу с сущностью Human
 * @see Human
 */
public class ServiceHuman extends HibernateUtil{


    public static void main(String[] args) {
        ServiceHuman service = new ServiceHuman();
//        Human Ana = new Human("Ana",20,2,true);
//        service.addHumanInTable(Ana);
        Human humanSav = service.getHumanInTable(1);
//        System.out.println(humanSav.getName());
        //service.deletTableHuman();
        service.updateBullets(humanSav,humanSav.getId(),18);
        service.updateGrenades(humanSav,humanSav.getId(),1);

        HibernateUtil.closeSessionFactory();
    }

    /**
     * Метод изменяет кол-во пуль у игрока
     * @param human - игрок
     * @param id - айди игрока
     * @param bullets - какое кол-во пуль мы хотим установить у выбранного игрока
     * @return игрок, с обновленным инвентарем
     */
    public Human updateBullets(Human human,int id,int bullets) {
        Session session = getSessionFactory().openSession();
        Transaction transaction =null;
        try {
            transaction = session.beginTransaction();

            //session.load(Human.class,id);
            human.setBullets(bullets);
            session.update(human);
            //session.flush();

            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return human;
    }

    /**
     * Метод изменяет кол-во гранат у игрока
     * @param human - игрок
     * @param id - айди игрока
     * @param grenades - какое кол-во гранат мы хотим установить у выбраного игрока
     * @return игрок, с обновленным инвентарем
     */
    public Human updateGrenades(Human human,int id,int grenades) {
        Session session = getSessionFactory().openSession();
        Transaction transaction =null;
        try {
            transaction = session.beginTransaction();

            //session.load(Human.class,id);
            human.setGrenades(grenades);
            session.update(human);
            //session.flush();

            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return human;
    }

    /**
     * Метод изменяет наличие или отсутсвие мешка цемента у игрока
     * @param human - игрок
     * @param id - айди игрока
     * @param bagOfCement - будет мешок цемента у игрока или нет (true or false)
     * @return игрок, с обновленными инвентарем
     */
    public Human updateBagOfCement(Human human,int id,boolean bagOfCement) {
        Session session = getSessionFactory().openSession();
        Transaction transaction =null;
        try {
            transaction = session.beginTransaction();

            //session.load(Human.class,id);
            human.setBagOfCement(bagOfCement);
            session.update(human);
            //session.flush();

            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return human;
    }

    /**
     * Получает игрока из таблицы HUMAN по его id
     * @param id - айди игрока
     * @return игрок
     */
    public Human getHumanInTable(int id) {
        Human human = null;
        Session session = getSessionFactory().openSession();
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
        }
        return human;
    }

    /**
     * Добавляет в таблицу HUMAN нового игрока
     * Таблица создается автоматический, при добавлении певрого игрока
     * @param human - игрок
     */
    public void addHumanInTable(Human human) {
        Session session = getSessionFactory().openSession();
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
        }
    }

    /**
     * Удаляет таблицу HUMAN
     */
    public void deletTableHuman() {
        Session session = getSessionFactory().openSession();
        Transaction transaction =null;
        try {
            transaction = session.beginTransaction();

            session.createSQLQuery("DROP TABLE IF EXISTS Human").executeUpdate();

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

    /**
     * Создает таблицу HUMAN
     * МЕТОД НЕ РЕКОМЕНДУЕМ К ИСПОЛЬЗОВАНИЮ
     */
    public void createHumanTable() {
        Session session = getSessionFactory().openSession();
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
        }
    }



}
