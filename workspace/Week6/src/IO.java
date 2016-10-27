import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mindtree.entity.User;


public class IO {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		User u=new User();
		u.setId("M1037562");
		u.setName("Gokul");
		u.setAge(21);
		u.setSal(20000);
		FileOutputStream fout=new FileOutputStream("D:\\NewUser.txt");
		ObjectOutputStream out=new ObjectOutputStream(fout);
		out.writeObject(u);
		out.close();
		FileInputStream fin=new FileInputStream("D:\\NewUser.txt");
		ObjectInputStream in=new ObjectInputStream(fin);
		User u1=(User) in.readObject();
		System.out.println(u1.toString());
		in.close();
	}

}
