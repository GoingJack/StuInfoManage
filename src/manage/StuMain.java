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
	JLabel welcome = new JLabel("��ӭ����ѧ����Ϣ����ϵͳ~");
	JLabel labname = new JLabel("���������Ա������");
	public JTextField txtname = new JTextField();
	JLabel labpwd = new JLabel("���������룺");
	public JPasswordField txtpwd = new JPasswordField();
	JButton btnin = new JButton("����");
	JPanel p;*/
	public static void main(String args[]){
		
		/*
		Frame fr = new Frame("Frame");
		
        fr.setSize(500,500);
        fr.setBackground(Color.blue);
        fr.setVisible(true);
		 */
	
	generate();     //��������ѧ����Ϣ
	
	LogIn login = new LogIn("login");
	login.show();
	//Menu  menu  = new Menu("menu");
	//menu.show();
	}
	public static void generate(){
		Student stu =new Student("1","����","��",22,"����","����Ӱ","ľ��");
		Student stu1 =new Student("2","����","��",24,"ɽ��","��ɽ","����");
		Student stu2 =new Student("3","����","Ů",30,"����","��Ӿ","����");
		StudentsInfo.put(stu);
		StudentsInfo.put(stu1);
		StudentsInfo.put(stu2);
		StudentsInfo.write();
	}
	
}
