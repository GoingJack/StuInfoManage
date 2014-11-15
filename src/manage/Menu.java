package manage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Event;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Menu extends JFrame {
	Delete  delete;
	Input   input;
	Inquiry inquiry;
	Modify  modify;
	
	public Menu() throws HeadlessException {
		// TODO Auto-generated constructor stub
		init();
	}

	public Menu(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
		init();
	}

	public Menu(String title) throws HeadlessException {
		super(title);
		init();
	
	}

	public Menu(String title, GraphicsConfiguration gc) {
		super(title, gc);
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
		//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		StudentsInfo.read();
		delete  = new Delete();
		input   = new Input();
		inquiry = new Inquiry();
		modify  = new Modify();
		
		CardLayout card = new CardLayout();
		JPanel pnlCard = new JPanel(card);
		pnlCard.add(input, "input");
		pnlCard.add(delete, "delete");
		pnlCard.add(inquiry, "inquiry");
		pnlCard.add(modify, "modify");
		this.add(pnlCard);

		ActionListener al = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String ac = e.getActionCommand();
				if(ac.equals("¼��ѧ��������Ϣ"))
				{
					card.show(pnlCard, "input");
				}
				else if(ac.equals("��ѯѧ��������Ϣ"))
				{
					card.show(pnlCard, "inquiry");
				}
				else if(ac.equals("�޸�ѧ��������Ϣ"))
				{
					card.show(pnlCard, "modify");
				}
				else 
				{
					card.show(pnlCard, "delete");
				}
			}
		};
		
		ActionListener a2 = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String ac = e.getActionCommand();
				if(ac.equals("�ϴ�"))
				{
					//�ϴ�����
					try {
						StudentsInfo.up1();
						JOptionPane.showOptionDialog(null, "�ϴ��ɹ�","�ϴ�ѧ����Ϣ",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
					} catch (IOException e1) {
						JOptionPane.showOptionDialog(null, "�ϴ�ʧ��","�ϴ�ѧ����Ϣ",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
						e1.printStackTrace();
					}
				}
				else if(ac.equals("����"))
				{
					//���ض���
					try {
						StudentsInfo.down1();
						JOptionPane.showOptionDialog(null, "���سɹ�","����ѧ����Ϣ",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
					} catch (IOException e1) {
						JOptionPane.showOptionDialog(null, "����ʧ��","����ѧ����Ϣ",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
						e1.printStackTrace();
					}
				}
			}
		};
		
		
		ActionListener a3 = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				String ac = e.getActionCommand();
				if(ac.equals("�˳�������"))
				{
					setVisible(false);
					System.exit(0);
				}
				else if(ac.equals("���沢�˳�"))
				{
						StudentsInfo.write();
						setVisible(false);
						System.exit(0);
				}
			}
		};
		
		JMenuBar mainmenubar =  new JMenuBar();
		JMenu titlebar = new JMenu("�˵�ѡ��");
		JMenuItem menuinputs=new JMenuItem("¼��ѧ��������Ϣ");
		menuinputs.addActionListener(al);
		JMenuItem menumodify=new JMenuItem("�޸�ѧ��������Ϣ");
		menumodify.addActionListener(al);
		JMenuItem menuinquiry=new JMenuItem("��ѯѧ��������Ϣ");
		menuinquiry.addActionListener(al);
		JMenuItem menudelete=new JMenuItem("ɾ��ѧ��������Ϣ");
		menudelete.addActionListener(al);
		titlebar.add(menuinputs);
		titlebar.add(menumodify);
		titlebar.add(menuinquiry);
		titlebar.add(menudelete);
		
		
		JMenu remoteMenu = new JMenu("�ƶ�");
		JMenuItem upload = new JMenuItem("�ϴ�");
		upload.addActionListener(a2);
		JMenuItem download= new JMenuItem("����");
		download.addActionListener(a2);
		remoteMenu.add(upload);
		remoteMenu.add(download);
		
		JMenu otherMenu = new JMenu("����");
		JMenuItem exit1 = new JMenuItem("�˳�������");
		exit1.addActionListener(a3);
		JMenuItem exit2= new JMenuItem("���沢�˳�");
		exit2.addActionListener(a3);
		otherMenu.add(exit1);
		otherMenu.add(exit2);
		
		mainmenubar.add(titlebar);
		mainmenubar.add(remoteMenu);
		mainmenubar.add(otherMenu);
		this.setJMenuBar(mainmenubar);
		
		this.setSize(400, 400);
		this.show();
	}
}
