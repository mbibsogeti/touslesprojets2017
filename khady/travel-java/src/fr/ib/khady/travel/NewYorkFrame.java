package fr.ib.khady.travel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewYorkFrame extends JFrame implements ActionListener {
	  private JLabel lb2;

	public NewYorkFrame() {
		super(); // Pour appeler le constructeur de la classe mère
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lb1 = new JLabel("Inscrire");
		getContentPane().add(lb1);
		lb1.setBounds(10, 10, 100, 15);
		
		JTextField tf1 = new JTextField("Valider");
		getContentPane().add(tf1);
		tf1.setBounds(200, 10, 120, 25);

		JButton bt1 = new JButton("OK");
		getContentPane().add(bt1);
		bt1.setBounds(10, 80, 60, 25);
		bt1.addActionListener(this);
		
		lb2 = new JLabel();
		getContentPane().add(lb2);
		// gauche, haut, largeur, hauteur pour bt1 ci-dessous
		lb2.setBounds(50, 200, 310, 15);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		lb2.setText("Exit");
		
	}

}
