import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mindtree.entity.User;

public class Main {

	public static void main(String[] args) {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("userjpa");
	      EntityManager em = emf.createEntityManager( );
	      EntityTransaction et=em.getTransaction();
	      User u=new User();
	      u.setEmail("gokulngone@gmail.com");
	      u.setName("gokul");
	      u.setAge(21);
	      System.out.println("saving a User");
	      et.begin();
	      em.persist(u);
	      et.commit( );
	      /*
	      u.setEmail("raja123@gmail.com");
	      u.setName("raja");
	      u.setAge(20);
	      em.persist(u);
	      et.commit( );
	      System.out.println("Selecting a User");
	      u=em.find(User.class, "gokulngone@gmail.com");
	      System.out.println(u.toString());
	      System.out.println("Selecting a User");
	      u=em.find(User.class, "raja123@gmail.com");
	      System.out.println(u.toString());
	      System.out.println("Updating a u");
	      u=em.find(User.class, "gokulngone@gmail.com");
	      u.setName("Gokul Nagarajan");
	      et.commit();
	      System.out.println("Selecting a User");
	      u=em.find(User.class, "gokulngone@gmail.com");
	      System.out.println(u.toString());
	      System.out.println("Deleting a User");
	      u=em.find(User.class, "raja123@gmail.com");
	      em.remove(u);
	      et.commit();
	      */
	      em.close( );
	      emf.close( );
	}
}
