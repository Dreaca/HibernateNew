package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Laptop;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class O2M_Main {
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
        laptop.setStudent(student);

        Laptop hp = new Laptop();
        hp.setModel("hp");
        hp.setLapId(1002);
        hp.setStudent(student);

        List<Laptop> laps = new ArrayList<>();
        laps.add(laptop);
        laps.add(hp);
        student.setLaps(laps);

        session.save(hp);
        session.save(laptop);
        session.save(hp);
        session.save(student);
        transaction.commit();
        session.close();
    }
}