package manage;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StuMain {
	/*
	static final JFrame mainf = new JFrame();
	JLabel welcome = new JLabel("欢迎访问学生信息管理系统~");
	JLabel labname = new JLabel("请输入管理员姓名：");
	public JTextField txtname = new JTextField();
	JLabel labpwd = new JLabel("请输入密码：");
	public JPasswordField txtpwd = new JPasswordField();
	JButton btnin = new JButton("进入");
	JPanel p;*/
	public static void main(String args[]){
		
		/*
		Frame fr = new Frame("Frame");
		
        fr.setSize(500,500);
        fr.setBackground(Color.blue);
        fr.setVisible(true);
		 */
	
	generate();     //用于生成学生信息
	
	LogIn login = new LogIn("login");
	login.show();
	//Menu  menu  = new Menu("menu");
	//menu.show();
	}
	public static void generate(){
		Student stu =new Student("1","张三","男",22,"陕西","看电影","木有");
		Student stu1 =new Student("2","李四","男",24,"山东","爬山","其他");
		Student stu2 =new Student("3","王二","女",30,"北京","游泳","其他");
		StudentsInfo.put(stu);
		StudentsInfo.put(stu1);
		StudentsInfo.put(stu2);
		StudentsInfo.write();
	}
	
}
