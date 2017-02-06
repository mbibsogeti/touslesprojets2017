package fr.ib.marcantoine.travel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewYorkFrame extends JFrame 
	implements ActionListener {
	
	private JLabel lb2;
	
	NewYorkFrame() {
		super();
		// on peut utiliser this, super ou rien du tout ici.
		setSize(500, 400);
		this.setVisible(true);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
	
		JLabel lb1 = new JLabel ("Qu'en pensez-vous ?");
		getContentPane().add(lb1);
		lb1.setBounds(250, 0, 120, 30);
		
		JTextField tf1 = new JTextField ("Ecrivez donc quelque chose");
		getContentPane().add(tf1);
		tf1.setBounds(250, 200, 150, 50);
		
		JButton bt1 = new JButton ("hop !");
		getContentPane().add(bt1);
		// coordonnes x, y (0,0 = haut gauche), largeur bouton, hauteur bouton.
		bt1.setBounds(250, 300, 70, 50);
		bt1.addActionListener(this);

		lb2 = new JLabel ("...");
		getContentPane().add(lb2);
		lb2.setBounds(250, 80, 50, 10);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lb2.setText("Yop yop yop !");
	}
}
