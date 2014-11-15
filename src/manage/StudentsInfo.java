package manage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class StudentsInfo {

	public static Map<String,Student> studentsinfo = new  HashMap<String,Student>();
	public StudentsInfo() {
		
	}
	
	public static boolean put(Student stu){
		String s = new String(stu.getNumber());
		if(studentsinfo.containsKey(s))
			return false;
		else
			studentsinfo.put(s, stu);
		return true;
	}
	public static Student get(String s){
		if(studentsinfo.containsKey(s))
			return studentsinfo.get(s);
		else
			return null;
	}
	public static boolean write(){
		try {
				ObjectOutputStream oos;
				FileOutputStream fos = new FileOutputStream("student.txt");  
				oos = new ObjectOutputStream(fos);   
				for(String s :StudentsInfo.studentsinfo.keySet()){
					Student stu = studentsinfo.get(s);
					oos.writeObject(stu);
				}
				oos.close();
        	} catch (IOException e) {
				e.printStackTrace();
			} 
		return true;
	}
	
	public static boolean imagewrite(String inname,String outname){
		try {
			ObjectOutputStream oos;
			FileOutputStream fos = new FileOutputStream(outname); 
			FileInputStream fin = new FileInputStream(inname);  
			byte buffer[] = new byte[1024];
			int len=0;
			while((len = fin.read(buffer)) != -1){
				fos.write(buffer);
			}
    	} catch (IOException e) {
			e.printStackTrace();
		} 
	return true;
	}
	
	public static boolean read(){
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		Student stu;
		try{
			fis = new FileInputStream("student.txt");  
			ois = new ObjectInputStream(fis);  
			while(true)
			 {
				stu = (Student) ois.readObject();
				StudentsInfo.put(stu);
			  }
			}catch(Exception e){
			 }
			finally{
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		return true;
	}
	public static void print(){
		for(String s :StudentsInfo.studentsinfo.keySet()){
			System.out.println(studentsinfo.get(s).getName());
		}
	}
	public static void clear(){
		studentsinfo.clear();
	}
	public static Student inquiry(String s){
		Student stu ;
		if(studentsinfo.containsKey(s))
			return studentsinfo.get(s);
		else
			return null;
	}
	
	public static boolean remove(String s){
		if(studentsinfo.containsKey(s)){
			studentsinfo.remove(s);
			return true;
		}
		else
			return false;
	}
	
	public static boolean up() throws IOException{
		Socket sclient = null;
		FileInputStream infile = null;
			sclient = new Socket("127.0.0.1", 8899);
			infile = new FileInputStream("student.txt");
			OutputStream out = sclient.getOutputStream();
			out.write(1);                                   //先写1表示上传
			byte[] buffer = new byte[1024];
			int len ;
			while((len = infile.read(buffer)) != -1)
		      out.write(buffer, 0, len);
		infile.close();
		sclient.close();  
		return true;
	}
	
	public static boolean up1() throws IOException{
		 write();  //把内存中数据写回磁盘
		uphandle("student.txt");
		for(String filename : StudentsInfo.studentsinfo.keySet()){
			uphandle(filename+".jpg");
		}
		return true;
	}
	public static boolean uphandle(String filename)throws IOException{
		
		Socket sclient = null;
		FileInputStream infile = null;
			sclient = new Socket("127.0.0.1", 8899);
			infile = new FileInputStream(filename);
			//PrintWriter os=new PrintWriter(sclient.getOutputStream());
			OutputStream out = sclient.getOutputStream();
			out.write(1); //先写1表示上传
			int namelen = filename.length();
			out.write(namelen);
			out.write(filename.getBytes());
			byte[] buffer = new byte[1024];
			int len ;
			while((len = infile.read(buffer)) != -1)
		      out.write(buffer, 0, len);
		infile.close();
		sclient.close();  
		return true;
		
	}
	public static boolean down() throws IOException{
		Socket sclient = new Socket("127.0.0.1", 8899);
		PrintWriter os=new PrintWriter(sclient.getOutputStream());
		int m = 2;                                                 //先写2表示下载
		os.write(m);
		os.flush();

		FileOutputStream fos = null;
		fos = new FileOutputStream("down.txt");
		InputStream in = null;
		in = sclient.getInputStream();
		byte[] buffer = new byte[1024];
		int len;
		while((len=in.read(buffer)) != -1){
				fos.write(buffer,0,len);
			}
		fos.close();
		sclient.close();
		return true;
	}
	public static boolean down1() throws IOException{
		 	write();  //把内存中数据写回磁盘
		 	downhandle("student.txt");
		 	studentsinfo.clear();
		 	read();
			for(String filename : StudentsInfo.studentsinfo.keySet()){
				downhandle(filename+".jpg");
			}
		return true;
	}
	public static boolean downhandle(String filename) throws IOException{
		Socket sclient = new Socket("127.0.0.1", 8899);
		PrintWriter os=new PrintWriter(sclient.getOutputStream());
		int m = 2;                                                 //先写2表示下载
		os.write(m);
		os.write(filename.length());
		os.write(filename);
		os.flush();

		FileOutputStream fos = null;
		fos = new FileOutputStream(filename);
		InputStream in = null;
		in = sclient.getInputStream();
		byte[] buffer = new byte[1024];
		int len;
		while((len=in.read(buffer)) != -1){
				fos.write(buffer,0,len);
			}
		fos.close();
		sclient.close();
		return true;
	}
}
