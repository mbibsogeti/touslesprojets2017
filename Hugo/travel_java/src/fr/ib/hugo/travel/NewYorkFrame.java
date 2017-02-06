package fr.ib.hugo.travel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NewYorkFrame extends JFrame implements ActionListener {

	private JLabel lb2;
	
	public NewYorkFrame() {
		super();
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton bt1 = new JButton("OK");
		bt1.setBounds(10, 200, 60, 25);
		bt1.addActionListener(this);
		getContentPane().add(bt1);
		
		JLabel lb1= new JLabel("InscrireT");
		lb1.setBounds(10, 10, 100, 15);
		getContentPane().add(lb1);
		
		lb2=new JLabel("...");
		lb2.setBounds(10, 80, 310, 15);
		getContentPane().add(lb2);
		
		JTextField tf1=new JTextField("");
		tf1.setBounds(10, 50, 120, 25);
		getContentPane().add(tf1);
		tf1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		lb2.setText("Test");
		
	}

}
