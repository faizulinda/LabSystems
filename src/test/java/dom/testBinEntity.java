package dom;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class testBinEntity extends TestCase {
    private SessionFactory sessionFactory;

    @Override
    public void setUp() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e){
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public void tearDown() throws Exception {
        if (sessionFactory != null){
            sessionFactory.close();
        }
    }

    @SuppressWarnings("uncheked")
    public void testBasicUsage(){
        Session session = sessionFactory.openSession();
        //session.beginTransaction();
        //session.save(new BinEntity(2, "02"));
        //session.save(new BinEntity(3, "03"));
        //session.save(new BinEntity(4, "04"));
        //session.save(new BinEntity(5, "05"));
        //session.save(new BinEntity(6, "06"));
        //session.save(new BinEntity(7, "07"));
        //session.save(new BinEntity(8, "08"));
        //session.getTransaction().commit();
        //session.close();
//
        //session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createQuery("from BinEntity").list();
        for (BinEntity bin : (List<BinEntity>) list){
            System.out.println(bin.getId() + " : " + bin.getName());
        }
        session.getTransaction().commit();
        session.close();
    }
}
