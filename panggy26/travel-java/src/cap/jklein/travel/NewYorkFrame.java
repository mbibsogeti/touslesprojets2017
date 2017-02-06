package cap.jklein.travel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewYorkFrame extends JFrame implements ActionListener {

	// ATTRIBUT //
	private JLabel lb2;

	// CONSTRUCTEUR //
	public NewYorkFrame() {
		// Appel du constructeur par défaut de JFrame
		super();
		// Choix d'une taille en pixels
		setSize(500, 400);
		setVisible(true);
		// Indique la fin de l'application lorsqu'on ferme la JFrame
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Pas de réorganisation lors du changement de taille de la JFrame
		getContentPane().setLayout(null);

		// Ajout de label, champ de texte et bouton
		JLabel lb1 = new JLabel("Inscrire");
		getContentPane().add(lb1);
		// Position du bouton (gauche, haut, largeur, hauteur)
		// Gauche et haut indiquent la position du coin supérieur gauche du bouton par rapport au coin supérieur gauche du ContentPane
		lb1.setBounds(10, 10, 100, 15);

		lb2 = new JLabel("...");
		getContentPane().add(lb2);
		lb2.setBounds(10, 100, 310, 15);

		JTextField tf1 = new JTextField("");
		getContentPane().add(tf1);
		tf1.setBounds(80, 10, 200, 25);

		JButton bt1 = new JButton("OK");
		getContentPane().add(bt1);
		bt1.setBounds(10, 40, 310, 25);
		// Interaction lorsqu'on appuie sur le bouton
		// ActionListener est une interface. Pour que la ligne ci-dessous compile, il faut que l'objet courant implémente ActionListener
		bt1.addActionListener(this);

	}

	// @Override est une annotation aidant le développeur
	@Override
	public void actionPerformed(ActionEvent arg0) {
		lb2.setText("OKAAAAAY !");
	}
}