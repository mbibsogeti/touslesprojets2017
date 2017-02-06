
package fr.ib.amine.travel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewYorkFrame extends JFrame implements ActionListener {
	//add unimplement 
	
	JLabel lb2;
	public NewYorkFrame() {
		super();
		setSize(500, 400);// on aurai pu mettre au début un this. ou un super
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		// JButton bt1= new JButton("OK");
		// getContentPane().add(bt1);
		// bt1.setBounds(10,200,60,25);// gauche, haut, largeur, hauteur
		
		JLabel lb1 = new JLabel("Inscrire");// écrire un mot ou phrase sur
											// l'interface
		getContentPane().add(lb1);
		lb1.setBounds(10, 10, 100, 15);

		JTextField tf1 = new JTextField(""); // faire un espace pour écrire dans
												// l'interface
		getContentPane().add(tf1);

		tf1.setBounds(200, 10, 120, 25);

		JButton bt1 = new JButton("OK"); // création d'un boutton dans
											// l'interface
		getContentPane().add(bt1);
		bt1.setBounds(10, 40, 310, 25);

		bt1.addActionListener(this);

		lb2 = new JLabel("..."); //
		getContentPane().add(lb2);
		lb2.setBounds(10, 80, 310, 15);
	}
	@ Override 
	public void actionPerformed(ActionEvent e) {
		lb2.setText("OK!");
	}

}
