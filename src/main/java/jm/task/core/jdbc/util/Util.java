package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    public Util() {
    }
    public Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres"; //
        String password = "qwaza1337";
        return DriverManager.getConnection(url, user, password);
    }
    public SessionFactory getSession() throws SQLException {
//        return new Configuration()
//                .configure("jdbc:postgresql://localhost:5432/postgres")
//                .buildSessionFactory()
//                .getCurrentSession();
        // ___________________________________________________________
//        Configuration configuration = new Configuration();
//        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
//        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
//        configuration.setProperty("hibernate.connection.username", "postgres");
//        configuration.setProperty("hibernate.connection.password", "qwaza1337");
//        configuration.setProperty("hibernate.show_sql", "true");
//        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
//        configuration.addAnnotatedClass(User.class);
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties())
//                .build();
//        return configuration.buildSessionFactory(serviceRegistry).getCurrentSession();
        //_______________________________________________________________________________
//        Configuration configuration = new Configuration();
//        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
//        configuration.setProperty("hibernate.connection.username", "postgres");
//        configuration.setProperty("hibernate.connection.password", "qwaza1337");
//        configuration.addAnnotatedClass(User.class);
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties())
//                .build();
//
//        // Создаем SessionFactory
//        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//
//        // Возвращаем новую сессию
//        return sessionFactory.openSession();
//
        return new Configuration().configure().buildSessionFactory();

    }

}
