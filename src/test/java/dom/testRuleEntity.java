package dom;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class testRuleEntity extends TestCase {
    private SessionFactory sessionFactory;

    @Override
    public void setUp() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try{
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e){
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @Override
    public void tearDown() throws Exception {
        if (sessionFactory != null){
            sessionFactory.close();
        }
    }

    @SuppressWarnings("uncheked")
    public void testBasicUsage(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new RuleEntity(1,1,"Test PSM"));
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createQuery("from RuleEntity").list();
        for (RuleEntity rule : (List<RuleEntity>) list){
            System.out.println(rule.getId() + " : " + rule.getWorkflowId() + " : " + rule.getBinId() + " : " + rule.getTestId());
        }
        session.getTransaction().commit();
        session.close();
    }
}
