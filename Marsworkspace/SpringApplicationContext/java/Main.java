import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.mindtree.entity.Circle;
import com.mindtree.entity.Shape;
import com.mindtree.entity.Square;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory bean=new XmlBeanFactory(new FileSystemResource("Spring.xml"));
		Shape sh=(Shape) bean.getBean("Shape");
		sh.setValue(3);
		sh.print();
		sh=(Square) bean.getBean("Square");
		sh.setValue(5);
		sh.print();
		sh=(Circle) bean.getBean("Circle");
		sh.setValue(7);
		sh.print();
		
	}

}
