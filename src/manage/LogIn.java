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
    JLabel welcome=new JLabel("��ӭ����ѧ����Ϣ����ϵͳ��");
	JLabel labname=new JLabel("���������Ա������");
	public JTextField txtname=new JTextField(10);
	 JLabel labpwd=new JLabel("��    ��  ��   ��    ��: ");
	public  JPasswordField txtpwd=new JPasswordField(10);
	JButton btnin=new JButton("��������");
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
		GridBagConstraints s= new GridBagConstraints();//����һ��GridBagConstraints��
		s.fill = GridBagConstraints.BOTH;
		s.gridwidth=1;//�÷������������ˮƽ��ռ�õĸ����������Ϊ0����˵��������Ǹ��е����һ��
        s.weightx = 0;//�÷����������ˮƽ��������ȣ����Ϊ0��˵�������죬��Ϊ0�����Ŵ�������������죬0��1֮��
        s.weighty=0;//�÷������������ֱ��������ȣ����Ϊ0��˵�������죬��Ϊ0�����Ŵ�������������죬0��1֮��
        layout.setConstraints(labname, s);//�������
        s.gridwidth=0;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(txtname, s);
    	s.gridwidth=1;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(labpwd, s);//�������
        s.gridwidth=0;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(txtpwd, s);
    	s.gridwidth=0;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(btnin, s);//�������
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
					JOptionPane.showMessageDialog(null,"�����������������������!","����",JOptionPane.WARNING_MESSAGE);

				}
			    else if(tof==true)
				{

				   new Menu("ѧ����Ϣ����ϵͳ");
				  setVisible(false);
				}
			}
		});
	}
}
