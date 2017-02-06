package fr.ib.obodrel.travel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class NewYorkTravelDestination extends UnitedStatesTravelDestination implements ActionListener {
	private NewYorkFrame _mainWindow;
	public NewYorkTravelDestination() {
		super();
		_DestinationName = "New York";
		_travelDuration = 8;
		_DestinationId = "ny";
		_LocationName = "Times Square";
		_meanOfTransport.setMeanOfTransport("p");
		_mainWindow = null;
	}

	protected void execute(Scanner cin) {
		_mainWindow = new NewYorkFrame();
		_mainWindow.getButton1().addActionListener(this);
		_mainWindow.getTF1().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		setUserName(_mainWindow.getTF1().getText());
		System.out.println("Your new usename is : "+_userName);
		_mainWindow.getResult().setText(_userName);
	}
}
