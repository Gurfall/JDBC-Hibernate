package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }
    Util util = new Util();

    @Override
    public void createUsersTable() {
        try (Session session = util.getSession().openSession()){
            session.beginTransaction();
            session.getTransaction().commit();

        } catch (SQLException ignored) {

        }

    }

    @Override
    public void dropUsersTable() {
        try (Session session = util.getSession().openSession()){
            session.beginTransaction();
            String sql = "DROP TABLE IF EXISTS \"User\"";
            session.createSQLQuery(sql).executeUpdate();
            session.getTransaction().commit();

        } catch (SQLException ignored) {

        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = util.getSession().openSession()){
            session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            session.getTransaction().commit();
            System.out.println("User с именем –" +name +" добавлен в базу данных");

        } catch (SQLException ignored) {        }
    }

    @Override
    public void removeUserById(long id) {

        try (Session session = util.getSession().openSession()){
            session.beginTransaction();
            String hql = "DELETE FROM  User WHERE id = :id";
            session.createQuery(hql)
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();

        } catch (SQLException ignored) {        }
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<User>();

        try (Session session = util.getSession().openSession()) {
            session.beginTransaction();
            String hql = "FROM  User";
            users = session.createQuery(hql, User.class).getResultList();
            session.getTransaction().commit();
        }
        catch (SQLException ignored) {

        }
        return users;
    }

    @Override
    public void cleanUsersTable() {

        try (Session session = util.getSession().openSession()) {
            session.beginTransaction();
            String hql = "DELETE FROM  User";
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
        }
        catch (SQLException ignored) {}
    }
}
