package manage;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn extends JFrame {

	//static final JFrame mainf=new JFrame();
    JLabel welcome=new JLabel("欢迎访问学生信息管理系统！");
	JLabel labname=new JLabel("请输入管理员姓名：");
	public JTextField txtname=new JTextField(10);
	 JLabel labpwd=new JLabel("请    输  入   密    码: ");
	public  JPasswordField txtpwd=new JPasswordField(10);
	JButton btnin=new JButton("进　　入");
    JPanel p;

	
	public LogIn() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super();
		init();
	}

	public LogIn(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
		init();
	}

	

	public LogIn(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
		init();
	}
	public LogIn(String title) throws HeadlessException {
		super(title);
        init();
	}
	
	public boolean handleEvent(Event e) 
    {
        if (e.id == Event.WINDOW_DESTROY) {
        	StudentsInfo.write();
            System.exit(0);
        }
         return super.handleEvent(e);
    }
	public void init(){
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		txtname.setText("");
		txtpwd.setText("");
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		this.add(labname);
		this.add(txtname);
		this.add(labpwd);
		this.add(txtpwd);
		this.add(btnin);
		GridBagConstraints s= new GridBagConstraints();//定义一个GridBagConstraints，
		s.fill = GridBagConstraints.BOTH;
		s.gridwidth=1;//该方法是设置组件水平所占用的格子数，如果为0，就说明该组件是该行的最后一个
        s.weightx = 0;//该方法设置组件水平的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
        s.weighty=0;//该方法设置组件垂直的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
        layout.setConstraints(labname, s);//设置组件
        s.gridwidth=0;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(txtname, s);
    	s.gridwidth=1;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(labpwd, s);//设置组件
        s.gridwidth=0;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(txtpwd, s);
    	s.gridwidth=0;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(btnin, s);//设置组件
        this.setSize(400,400);
		this.show();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String name=txtname.getText();
				String pwd=txtpwd.getText();
				txtname.setText("");
				txtpwd.setText("");
				boolean tof=false;
				if(name.equals("xu") && pwd.equals("123"))
					tof = true;
			    if(tof==false)
				{
					JOptionPane.showMessageDialog(null,"姓名输入错误或密码输入错误!","警告",JOptionPane.WARNING_MESSAGE);

				}
			    else if(tof==true)
				{

				   new Menu("学生信息管理系统");
				  setVisible(false);
				}
			}
		});
	}
}
