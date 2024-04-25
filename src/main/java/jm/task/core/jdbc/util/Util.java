package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String DB_URL = "JDBC:mysql://localhost:3306/mysql";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "west";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to establish a database connection", e);

        }
    }
    // реализуйте настройку соеденения с БД


private static final SessionFactory sessionFactory = buildSessionfactory();

private static final SessionFactory buildSessionfactory() {
    try {
        Configuration configuration = new Configuration();

        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");

        configuration.setProperty("hibernate,connection.irl", "jdbc:mysql://localhost:3306/mysql");

        configuration.setProperty("hibernate.connection.password", "west");

        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        registryBuilder.applySettings(configuration.getProperties());

        return configuration.buildSessionFactory(registryBuilder.build());
    } catch (Throwable ex) {

        System.out.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);

    }

    }
    public static SessionFactory getSessionFactory() {
    return sessionFactory;
    }
    public static void shutdown() {
    getSessionFactory().close();
    }
}
