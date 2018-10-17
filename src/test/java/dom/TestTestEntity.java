package dom;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TestTestEntity extends TestCase {
    private SessionFactory sessionFactory;

    @Override
    protected void setUp() throws Exception {
        MySessionFactory mySessionFactory = new MySessionFactory();
        sessionFactory = mySessionFactory.getSessionFactory();
    }

    @Override
    protected void tearDown() throws Exception {
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }

    @SuppressWarnings("uncheked")
    public void testBasicUsage(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new TestEntity("Test PSM_1", "Test"));
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createQuery("from TestEntity" ). list();
        for (TestEntity test : (List<TestEntity>) list){
            System.out.println(test.getCode() + " " + test.getName());
        }
        session.getTransaction().commit();
        session.close();
    }
}