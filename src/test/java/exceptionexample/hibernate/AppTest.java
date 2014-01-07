package exceptionexample.hibernate;

import junit.framework.Test;

import gov.ic.geoint.gets.document.util.MockDocumentGenerator;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.joda.time.LocalDate;
import org.joda.time.convert.Converter;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;


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
        md.setRelevanceEnd(null);
          Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_YEAR, random.nextInt(120));
        md.setRelevanceStart(LocalDate.fromCalendarFields(cal));
        cal.add(Calendar.DAY_OF_YEAR, random.nextInt(3));
        md.setRelevanceEnd(LocalDate.fromCalendarFields(cal));
        

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
