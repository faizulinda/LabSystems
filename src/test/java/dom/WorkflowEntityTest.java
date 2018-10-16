package dom;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;

import java.util.List;

public class WorkflowEntityTest extends TestCase {
    private SessionFactory sessionFactory;

    @Override
    protected void setUp() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try{
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        catch (Exception e){
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @Override
    protected void tearDown() throws Exception {
        if (sessionFactory != null){
            sessionFactory.close();
        }
    }

    @SuppressWarnings("uncheked")
    public void testBasicUsage(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new WorkflowEntity(1, "Workflow_1", "test workflow"));
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createQuery("from WorkflowEntity").list();
        for (WorkflowEntity workflow : (List<WorkflowEntity>) list){
            System.out.println(workflow.getId() + " " + workflow.getName() + " " +  workflow.getDescription());
        }
        session.getTransaction();
        session.close();
    }
}
