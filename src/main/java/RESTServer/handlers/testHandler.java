package RESTServer.handlers;

import dal.HibernateUtil;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Console;
import java.util.List;

public class testHandler {
    public void saveStudent(User user) {
        Transaction transaction = null;
        try(Session session= HibernateUtil.getSessionFactory().openSession()) {

        } catch ( Exception e){

        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();

            System.out.print("saved");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<User> getStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User", User.class).list();
        }
    }
}
