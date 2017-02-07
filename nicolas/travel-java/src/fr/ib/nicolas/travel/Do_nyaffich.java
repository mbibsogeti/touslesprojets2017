package fr.ib.nicolas.travel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Do_nyaffich  extends JFrame implements ActionListener
{
       private JLabel lb2; //sortir la déclaration ppour que ça soir accessible de partoutr
       

   //ensuite mete let..
	public Do_nyaffich(){
		super();
		this.setSize(500, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lb1= new JLabel("inscrire");
		getContentPane().add(lb1);
		//gauche haut largeur hauteur
		lb1.setBounds(10,10,100,25);	
		
		JButton bt1= new JButton("ok");
		getContentPane().add(bt1);
		//gauche haut largeur hauteur
		bt1.setBounds(10,200,60,25);
		
		JTextField tf1= new JTextField("ok");
		getContentPane().add(tf1);
		//gauche haut largeur hauteur
		tf1.setBounds(100,200,6,25);
		
		lb2= new JLabel("ok");
		getContentPane().add(lb2);
		//gauche haut largeur hauteur
		lb2.setBounds(150,20,60,25);
		// pensé a let implement action listener , sur le clic gauche de l'erreur.
		bt1.addActionListener(this);//qui ecoute le bouton 
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {   //commande actionné avec l appui du bouton 
		lb2.setText("allez");
	
		
	}
}
