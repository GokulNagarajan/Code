import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mindtree.entity.Department;
import com.mindtree.entity.Student;

public class Main {

	public static void main(String[] args) {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1toN");
	      EntityManager em = emf.createEntityManager( );
	      EntityTransaction et=em.getTransaction();
	      Student s1=new Student();
	      s1.setName("gokul");
	      Student s2=new Student();
	      s2.setName("raja");
	      Student s3=new Student();
	      s3.setName("karan");
	      Department d1=new Department();
	      d1.setName("cse");
	      List<Student> list1=new ArrayList<Student>();
	      list1.add(s1);
	      list1.add(s2);
	      d1.setStudentList(list1);
	      Department d2=new Department();
	      d2.setName("it");
	      List<Student> list2=new ArrayList<Student>();
	      list2.add(s2);
	      list2.add(s3);
	      d2.setStudentList(list2);
	      Department d3=new Department();
	      d3.setName("ece");
	      List<Student> list3=new ArrayList<Student>();
	      list3.add(s3);
	      list3.add(s1);
	      d3.setStudentList(list3);
	      et.begin();
	      em.persist(s1);
	      em.persist(s2);
	      em.persist(s3);
	      et.commit();
	      et.begin();
	      em.persist(d1);
	      et.commit();
	      et.begin();
	      em.persist(d2);
	      et.commit();
	      et.begin();
	      em.persist(d3);
	      et.commit();
	      em.close();
	      emf.close();
	}

}
