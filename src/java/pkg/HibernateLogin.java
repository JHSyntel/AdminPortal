

package pkg;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateLogin 
{
    public static Session s;
    public static Transaction tran;
    
    public HibernateLogin()
    {
        //int count=0;
//        Configuration cfg  = new Configuration().configure();
//        SessionFactory sf = cfg.buildSessionFactory();
//        s = sf.openSession();
//        Transaction tran = s.beginTransaction();
 
        //String somth = "admin1";//sub this with username from loginaction
        //String anth = "admin1pass";//sub this with password from loginaction
        //String query = "from Atmlogin where uname = " + "'" + somth + "'";
        //Query dbQuery = s.createQuery(query);
        //Query dbQuery = s.createQuery("from Atmlogin atm where atm.uname = :un");
        //String somth = "admin1";
        //dbQuery.setString("un", somth);
        //dbQuery.setParameter("un", "admin1");
        
//        List<Atmlogin> li = dbQuery.list();
//        for(Atmlogin a: li)
//        {
//            if(a.getUpass().equals(anth))
//            {
//                a.disp();
//                count++;
//            }
//        }
        
//        if(count > 0)
//        {
//            query = "from Atmlogin where upass = " + "'" + anth + "'";
//            dbQuery = s.createQuery(query);
//            List<Atmlogin> l = dbQuery.list();
//            for(Atmlogin a: l)
//            {
//                count++;
//            }
//        }
        
        //System.out.println(count);
        //tran.commit();
        //s.close();         
    }
    
    public static boolean validLogin(String username, String password)
    {
        Configuration cfg  = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        s = sf.openSession();
        tran = s.beginTransaction();
        
        String query = "from Atmlogin2 where uname = " + "'" + username + "'";
        Query dbQuery = s.createQuery(query);
        List<Atmlogin2> li = dbQuery.list();
        for(Atmlogin2 a: li)
        {
//            System.out.println(a.getUpass());
//            System.out.println(Hash.md5(password + a.getSalt().trim()));
            if(a.getUpass().trim().equals(Hash.md5(password + a.getSalt().trim())))
            {
//                System.out.println("TRUE");
                return true;
            }
        }
        return false;
    }
    
    public static void updatePass(String user, String pass, String salt)
    {
        String query = "Update Atmlogin2 Set upass=" + "'" + pass + "'" + ", salt="+ "'" + salt + "'" + "where uname=" + "'" + user + "'";
        Query dbQuery = s.createQuery(query);
        dbQuery.executeUpdate();
        tran.commit();
    }
    
    public static void validLogout()
    {
        s.close();
    }
    
//    public static void main(String[] args) 
//    {
//        HibernateLogin h = new HibernateLogin();
//        h.validLogin("admin2", "admin2pass");
//        
//        System.out.println("MAIN FINISHED");
//    }
}
