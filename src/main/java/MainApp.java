import dao.StudentDao;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateSessionFactory;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateSessionFactory.getSession()) {

            StudentDao studentDao = new StudentDao();

            for (int i = 1; i <= 1000; i++) {
                studentDao.add(new Student("student " + i, false));
            }

            List<Student> studentList = studentDao.findAll();
            System.out.println(studentList.toString());

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
