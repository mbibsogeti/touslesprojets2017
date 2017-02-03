package fr.ib.obodrel.travel;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NewYorkFrame extends JFrame {
	private JButton _button1;
	private JTextField _tf1;
	private JLabel _result;
	public NewYorkFrame() {
		super();
		setSize(500, 400);
		setTitle("Name Registration");
		setVisible(true);	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		_button1 = new JButton("Ok");
		getContentPane().add(_button1);
		_button1.setBounds(10, 130, 250, 50);
		JLabel label1 = new JLabel("Enter your name :");
		getContentPane().add(label1);
		label1.setBounds(10, 10, 250, 50);
		_tf1 = new JTextField("ex : Toto");
		getContentPane().add(_tf1);
		_tf1.setBounds(10, 70, 250, 50);
		_result = new JLabel("...");
		getContentPane().add(_result);
		_result.setBounds(10, 190, 250, 50);
	}
	
	public JButton getButton1() {
		return _button1;
	}
	
	public JTextField getTF1() {
		return _tf1;
	}
	
	public JLabel getResult() {
		return _result;
	}
}
