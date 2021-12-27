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

            System.out.println("Вывод всех студентов");
            List<Student> studentList = studentDao.findAll();
            System.out.println(studentList.toString());

            System.out.println();
            System.out.println("Удаление студента с id=2");
            studentDao.deleteById(2);
            System.out.println("Поиск студента с id=2");
            System.out.println(studentDao.findById(2));

            System.out.println();
            System.out.println("Изменение студента с id=3");
            Student student = studentDao.findById(3);
            student.setName("Имя изменено");
            studentDao.change(student);
            System.out.println("Поиск студента с id=3");
            System.out.println(studentDao.findById(3).toString());


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
