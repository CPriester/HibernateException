package exceptionexample.hibernate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.joda.time.LocalDate;
import static org.junit.Assert.*;


/**
 * Unit test for simple App.
 */
public class AppTest {
 


   
    private static EntityManagerFactory emf;
    protected static EntityManager em = null;
     private static final Random random = new Random();
    ResultSet rs = null;
    Statement stmt = null;
    Connection connection = null;
    java.sql.Array array = null;
    int no;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @org.junit.Test
    public void testApp() throws Exception {
        App md = new App();
        
        md.setId("1132123");
        md.setRelevanceEnd(LocalDate.parse("2013-12-09"));
        md.setRelevanceStart(LocalDate.parse("2013-12-09"));


        System.out.println("mock document:" + md);

        EntityManager em = null;

        try {
            EntityManagerFactory factory = Persistence
                    .createEntityManagerFactory("hibernateH3");
            em = factory.createEntityManager();
            em.getTransaction().begin();
            em.persist(md);
//            em.flush();
//            em.clear();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
            fail(e.getMessage());
           
        }}
    
   
}
