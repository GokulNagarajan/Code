import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mindtree.entity.Department;
import com.mindtree.entity.Student;

public class Main {

	public static void main(String[] args) {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1to1");
	      EntityManager em = emf.createEntityManager( );
	      EntityTransaction et=em.getTransaction();
	      et.begin();
	      Department d1=new Department();
	      d1.setName("cse");
	      em.persist(d1);
	      Department d2=new Department();
	      d2.setName("it");
	      em.persist(d2);
	      Department d3=new Department();
	      d3.setName("ece");
	      em.persist(d3);
	      Student s1=new Student();
	      s1.setName("gokul");
	      s1.setDepartment(d1);
	      em.persist(s1);
	      Student s2=new Student();
	      s2.setName("raja");
	      s2.setDepartment(d2);
	      em.persist(s2);
	      Student s3=new Student();
	      s3.setName("karan");
	      s3.setDepartment(d3);
	      em.persist(s3);
	      et.commit();
	      em.close();
	      emf.close();
	}

}