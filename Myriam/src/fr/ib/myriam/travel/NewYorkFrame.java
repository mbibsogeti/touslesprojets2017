package fr.ib.myriam.travel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewYorkFrame extends JFrame
// add unimplemented method
	implements ActionListener {
	
	JFrame jf = new JFrame();
	JLabel lb2 = new JLabel(" ... ");
	
	public NewYorkFrame(){
		super();
		this.setSize(500,400);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lb1 = new JLabel("Inscrire");
		getContentPane().add(lb1);
		// coordonnées x, y du coin supérieur gauche, largeur, hauteur
		lb1.setBounds(10,10,100,15);
		
		JTextField tx1 = new JTextField();
		getContentPane().add(tx1);
		// coordonnées x, y du coin supérieur gauche, largeur, hauteur
		tx1.setBounds(120,10,120,25);
		
		JButton bt1 = new JButton("OK");
		getContentPane().add(bt1);
		// coordonnées x, y du coin supérieur gauche, largeur, hauteur
		bt1.setBounds(250,10,60,25);
		bt1.addActionListener(this);
		
		getContentPane().add(lb2);
		// coordonnées x, y du coin supérieur gauche, largeur, hauteur
		lb2.setBounds(320,10,310,15);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		lb2.setText("OK !");
		
	}

}
