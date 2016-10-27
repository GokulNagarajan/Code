import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mindtree.entity.Circle;
import com.mindtree.entity.Shape;
import com.mindtree.entity.Square;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//contextFactory context=new XmlcontextFactory(new FileSystemResource("Spring.xml"));
		ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
		Shape sh=(Shape) context.getBean("Shape");
		sh.setValue(3);
		sh.print();
		sh=(Square) context.getBean("Square");
		sh.setValue(5);
		sh.print();
		sh=(Circle) context.getBean("Circle");
		sh.setValue(7);
		sh.print();
		
	}

}
