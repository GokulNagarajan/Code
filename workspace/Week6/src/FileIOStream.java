import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import com.mindtree.entity.User;

public class FileIOStream {

	public static void main(String[] args) {
		System.out.println("Starting the file copy");
		try {
			//copy("D://TextFile//Userdata.txt", "D://TextFile//UserdataCopy.txt");
			System.out.println("\nCopy Completed");
			FileInputStream fis = new FileInputStream(
					"D://TextFile//dataCopy.txt");
			DataInputStream dis = new DataInputStream(fis);
			String s;
			System.out.println("\nOpening Copied File\n");
			while ((s = dis.readLine()) != null) {
				System.out.println(s);
			}
			System.out.println("\nClosing Copied File\n");
			if (dis != null)
				dis.close();
			if (fis != null)
				fis.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}

	public static void copy(String in, String out) throws IOException {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		java.io.DataOutputStream dos = null;
		java.io.DataInputStream dis = null;
		try {

			fos = new FileOutputStream(out);
			fis = new FileInputStream(in);
			dos = new DataOutputStream(fos);
			dis = new DataInputStream(fis);
			String s;
			User user = new User();
			s = "Userid\t\tUsername\tAge\tSalary";
			dos.writeBytes(s);
			s = "\n";
			dos.writeBytes(s);
			while ((s = dis.readLine()) != null) {
				String arr[] = s.split(",");
				user.setId(arr[0]);
				user.setName(arr[1]);
				user.setAge(Integer.parseInt(arr[2]));
				user.setSal(Double.parseDouble(arr[3]));
				dos.writeBytes(user.toString());
				s = "\n";
				dos.writeBytes(s);
			}
		} catch (IOException e) {
			throw new IOException("File cannot be accessed");
		} finally {
			if (dis != null)
				dis.close();
			if (dos != null)
				dos.close();
			if (fis != null)
				fis.close();
			if (fos != null)
				fos.close();
		}
	}
}