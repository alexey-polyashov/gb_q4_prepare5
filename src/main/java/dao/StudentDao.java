package dao;

import model.Student;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

import java.util.List;

public class StudentDao {

    public Student findById(int id){
        Session session = HibernateSessionFactory.getSession().openSession();
        return session.find(Student.class, id);
    }

    public void add(Student student){
        Session session = HibernateSessionFactory.getSession().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
     }

    public void change(Student student){
        Session session = HibernateSessionFactory.getSession().openSession();
        session.beginTransaction();
        session.merge(student);
        session.getTransaction().commit();
    }

    public List<Student> findAll(){
        Session session = HibernateSessionFactory.getSession().openSession();
        return session.createQuery("From Students").list();
    }

    public void deleteById(int id){
        Session session = HibernateSessionFactory.getSession().openSession();
        session.beginTransaction();
        Student student = findById(id);
        session.delete(student);
        session.getTransaction().commit();
    }


}
