import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mindtree.entity.User;
import com.mindtree.entity.Question;

public class NtoN {
		static Configuration cfg=null;
		static SessionFactory sf=null;
		static Session session=null;
		public static void main(String[] args) {  
		    cfg=new Configuration();  
		    cfg.configure("hibernate.cfg.xml");  
		    sf=cfg.buildSessionFactory();  
		    session=sf.openSession(); 
		    //insert();
		    fetch();    
		}
		private static void fetch() {
			Query query=session.createQuery("from Question ");  
			 List<Question> list=query.list();  			          
			 Iterator<Question> iterator=list.iterator();  
			 while(iterator.hasNext()){  
			  Question question=iterator.next();  
			  System.out.println("question id:"+question.getId());  
			  System.out.println("question name:"+question.getName());  
			  System.out.println("answers.....");  
			  Map<String,User> map=question.getAnswers();  
			  Set<Map.Entry<String,User>> set=map.entrySet();  			  
			  Iterator<Map.Entry<String,User>> iteratoranswer=set.iterator();  
			  while(iteratoranswer.hasNext()){  
			   Map.Entry<String,User> entry=(Map.Entry<String,User>)iteratoranswer.next();  
			   System.out.println("answer name:"+entry.getKey());  
			   System.out.println("answer posted by.........");  
			   User user=entry.getValue();  
			   System.out.println("username:"+user.getUsername());  
			   System.out.println("user emailid:"+user.getEmail());  
			   System.out.println("user country:"+user.getCountry());  
			  }  
			 }  
			session.close();  			
		}
		private static void insert() {
			Transaction tx=session.beginTransaction();  		  
			HashMap<String,User> map1=new HashMap<String,User>();  
			map1.put("java is a programming language",  
			new User("Gokul Nagarajan","gokulngone@gmail.com","india"));  		  
			map1.put("java is a platform",  
			new User("Ashok Kumar","ashok24894@gmail.com","india"));  		  
			HashMap<String,User> map2=new HashMap<String,User>();  
			map2.put("servlet technology is a server side programming",  			  
			new User("John Milton","john@gmail.com","usa"));  
			map2.put("Servlet is an Interface",  
			new User("Jai Krishnan","jaikrish12@gmail.com","india"));  			  
			Question question1=new Question("What is java?",map1);  
			Question question2=new Question("What is servlet?",map2);  
			session.persist(question1);  
			session.persist(question2);  			  
			tx.commit();  
			//session.close();  
			System.out.println("successfully stored");  
		} 
}