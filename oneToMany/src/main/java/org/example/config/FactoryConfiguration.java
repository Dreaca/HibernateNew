package org.example.config;


import org.example.entity.Laptop;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    public static FactoryConfiguration factoryConfiguration;
    public static SessionFactory session;

    private FactoryConfiguration(){
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        session = configuration.buildSessionFactory();
    }
     public static FactoryConfiguration getInstance() {
        return factoryConfiguration == null ? new FactoryConfiguration() : factoryConfiguration;
    }
    public  Session getSession(){
        return session.openSession();
    }
}
