package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Laptop;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = new Student();
        student.setId(1);
        student.setName("Buddhika");
        student.setAddress("Ratnapura");

        Laptop laptop = new Laptop();
        laptop.setLapId(10001);
        laptop.setModel("ThinkPad");

        student.setLaptop(laptop);

        session.save(laptop);
        session.save(student);
        transaction.commit();
        session.close();
    }
}