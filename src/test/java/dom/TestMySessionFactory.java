package dom;

import junit.framework.TestCase;
import org.hibernate.SessionFactory;

public class TestMySessionFactory extends TestCase {
    private SessionFactory sessionFactory;

    public void testGetSessionFactory(){
        MySessionFactory mySessionFactory = new MySessionFactory();
        sessionFactory = mySessionFactory.getSessionFactory();
        if (sessionFactory == null){
            throw new NullPointerException("Сессия не инициализирована");
        }
    }
}
