package fr.ib.elodie.travel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewYorkFrame extends JFrame implements ActionListener {
	
	JLabel lbl2;
	JTextField tf1;
	
	public NewYorkFrame() {

		super();
		this.setTitle("NEW YORK");
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel label1 = new JLabel("INSCRIRE");
		getContentPane().add(label1);
		label1.setBounds(10, 10, 100, 15);
		
		tf1 = new JTextField("");
		getContentPane().add(tf1);
		tf1.setBounds(200, 10, 120, 25);
		
		JButton bouton1 = new JButton ("OK");
		getContentPane().add(bouton1);
		bouton1.setBounds(10, 40, 310, 25);
		bouton1.addActionListener(this);
		
		lbl2 = new JLabel ("...");
		getContentPane().add(lbl2);
		lbl2.setBounds(10, 80, 310, 15);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		tf1.setText("Ok!");
		
	}

}
