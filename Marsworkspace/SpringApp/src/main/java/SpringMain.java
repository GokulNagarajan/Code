import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class SpringMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory bean=new XmlBeanFactory(new FileSystemResource("NewFile.xml"));
		Sample s=(Sample)bean.getBean("sample");
		s.print();
	}

}
