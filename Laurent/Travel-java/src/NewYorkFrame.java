import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NewYorkFrame extends JFrame implements ActionListener {

	private JLabel lb2;
	private JTextField tf1;
	public NewYorkFrame() throws HeadlessException {
		this(500,400,true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		//Création d'un bouton
		JButton bt1 = new JButton("Click me !");
		this.getContentPane().add(bt1);
		bt1.setBounds((500/2)-50, (300/2)-12, 100, 25);
		bt1.addActionListener(this); //Création d'un détecteur d'action
		
		//Création d'un label
		JLabel lb1 = new JLabel("Temptation");
		this.getContentPane().add(lb1);
		lb1.setBounds((500/2)-25, (100/2)-25, 150, 25);
		
		//Création d'une zone de texte
		tf1 = new JTextField("");
		this.getContentPane().add(tf1);
		tf1.setBounds((500/2)-75, (200/2)-25, 150, 50);
		
		lb2 = new JLabel("...");
		this.getContentPane().add(lb2);
		lb2.setBounds((500/2)-75, (400/2)-25, 250, 25);
		
	}

	public NewYorkFrame(short xTaille, short yTaille) throws HeadlessException {
		super();
		this.setSize(xTaille, yTaille);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public NewYorkFrame(int xTaille, int yTaille, boolean showFrame) throws HeadlessException {
		super();
		this.setSize(xTaille, yTaille);
		this.setVisible(showFrame);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		lb2.setText("I know you wouldn't resist !");
		tf1.setText("I got you, sucker !!!");
	}
}
