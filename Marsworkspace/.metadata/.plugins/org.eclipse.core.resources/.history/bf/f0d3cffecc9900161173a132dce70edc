import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mindtree.entity.User;

public class Main {

	public static void main(String[] args) {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("User");
	      EntityManager em = emf.createEntityManager( );
	      EntityTransaction et=em.getTransaction();
	      User user=new User();
	      user.setEmail("gokulngone@gmail.com");
	      user.setName("gokul");
	      user.setAge(21);
	      //saving a user
	      et.begin();
	      em.persist(user);
	      et.commit( );
	      user.setEmail("raja123@gmail.com");
	      user.setName("raja");
	      user.setAge(20);
	      //saving a user
	      em.persist(user);
	      et.commit( );
	      //select the user
	      user=em.find(User.class, "gokulngone@gmail.com");
	      System.out.println(user.toString());
	      //select the user
	      user=em.find(User.class, "raja123@gmail.com");
	      System.out.println(user.toString());
	      //update a user
	      user=em.find(User.class, "gokulngone@gmail.com");
	      user.setName("Gokul Nagarajan");
	      et.commit();
	      //select the user
	      user=em.find(User.class, "gokulngone@gmail.com");
	      System.out.println(user.toString());
	      //delete a user
	      user=em.find(User.class, "raja123@gmail.com");
	      em.remove(user);
	      et.commit();
	      em.close( );
	      emf.close( );
	}

}
