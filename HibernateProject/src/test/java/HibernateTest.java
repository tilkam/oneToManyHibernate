import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;
import java.util.List;
import java.util.Set;


public class HibernateTest {
    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        Tutor newTutor = new Tutor("ABC234", "Bosse Bredsladd", 387787);
        Student student1 = new Student("Tilda Kampman");
        Student student2 = new Student("Marina Forsberg");
        Student student3 = new Student("Vilma Vorsberg");

        newTutor.addStudentToTeachingGroup(student1);
        newTutor.addStudentToTeachingGroup(student2);
        newTutor.addStudentToTeachingGroup(student3);

        List<Student> students = newTutor.getTeachingGroup();
        for(Student student: students) {
            System.out.println(student);
        }

        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

       /* session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(newTutor);*/


        tx.commit();
        session.close();

    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }


}
