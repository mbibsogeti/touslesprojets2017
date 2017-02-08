import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * @author ib
 */
public class NewyorkFrame extends JFrame implements ActionListener {
	JLabel lb2;
	public NewyorkFrame(){
		super();
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lb1 = new  JLabel ("Inscrire");
		getContentPane().add(lb1);
		//gauche, haut, largeur, hauteur
		lb1.setBounds(10,10,100,15);
		
		JTextField tf1 = new JTextField ("");
		getContentPane().add(tf1);
		//gauche, haut, largeur, hauteur
		tf1.setBounds(200,10,120,25);
		
		JButton bt1=new JButton("ok");
		getContentPane().add(bt1);
		//gauche, haut, largeur, hauteur
		bt1.setBounds(10,40,310,25);
		bt1.addActionListener(this);
		
		 lb2 = new  JLabel(".....");
		getContentPane().add(lb2);
		//gauche, haut, largeur, hauteur
		lb2.setBounds(10,80,310,15);
	}

	@Override
	//Message quand on click sur ok
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		lb2.setText("ok !");
	}


}
