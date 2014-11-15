package manage;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Delete extends JPanel {

	JTextField number,name,special,grade,born,origo,hobby,age;
	JButton search,delete;
	JRadioButton boy,girl;
	ButtonGroup group=null;
	
	public Delete() {
		init();
	}

	public Delete(LayoutManager layout) {
		super(layout);
	}

	public Delete(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public Delete(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}
	
	
	public void init(){
		number=new JTextField(10);
		search=new JButton("��ѯ");
		//��ѯ�¼�����
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String searchnumber=number.getText();
				//�˴���Ӳ�ѯ����
				//��ʱ����
				Student stu = StudentsInfo.inquiry(searchnumber);
				if(stu != null){
					name.setText(stu.getName());
					if(stu.getSex().equals("��"))
					{
						boy.setSelected(true);
						girl.setSelected(false);
					}
					else if(stu.getSex().equals("Ů"))
					{
						girl.setSelected(true);
						boy.setSelected(false);
					}
					age.setText(String.valueOf(stu.getAge()));
					origo.setText(stu.getOrigo());
					hobby.setText(stu.getHobby());
				}
				else{
					 JOptionPane.showOptionDialog(null, "��ѧ�Ų����ڣ�","ɾ��ѧ����Ϣ",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
				}
			}
			});
		name=new JTextField(10);
		name.setEditable(false);
		group=new ButtonGroup();
		boy=new JRadioButton("��");
		girl=new JRadioButton("Ů");
		group.add(boy);
		group.add(girl);
		age=new JTextField(10);
		age.setEditable(false);
		origo=new JTextField(10);
		origo.setEditable(false);
		hobby=new JTextField(10);
		hobby.setEditable(false);
		delete = new JButton("ȷ��ɾ��");
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ����","ɾ��ѧ����Ϣ",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null);
				if(option == JOptionPane.YES_OPTION){
					if(StudentsInfo.remove(number.getText())){
						number.setText("");
						name.setText("");
						origo.setText("");
						hobby.setText("");
						age.setText("");
						JOptionPane.showOptionDialog(null, "ɾ���ɹ���","ɾ��ѧ����Ϣ",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
					}
					else{
						JOptionPane.showOptionDialog(null, "ɾ��ʧ�ܣ�","ɾ��ѧ����Ϣ",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
					}
				}
			}
		});
		
		Box box1=Box.createHorizontalBox();
		box1.add(new JLabel("����Ҫ��ѯ��ѧ��:",JLabel.CENTER));
		box1.add(number);
		box1.add(search);
		Box box2=Box.createHorizontalBox();
		box2.add(new JLabel("����:",JLabel.CENTER));
		box2.add(name);
		Box box3=Box.createHorizontalBox();
		box3.add(new JLabel("�Ա�:",JLabel.CENTER));
		box3.add(boy);
		box3.add(girl);
		Box box4=Box.createHorizontalBox();
		box4.add(new JLabel("����:",JLabel.CENTER));
		box4.add(age);
		Box box5=Box.createHorizontalBox();
		box5.add(new JLabel("����:",JLabel.CENTER));
		box5.add(origo);
		Box box6=Box.createHorizontalBox();
		box6.add(new JLabel("����:",JLabel.CENTER));
		box6.add(hobby);
		Box box7=Box.createHorizontalBox();
		box7.add(delete);
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(box6);
		boxH.add(box7);
		this.add(boxH);
	}

}
