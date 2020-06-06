package view.fx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.UserInterface;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GameOverDialogFX {

	private ActionListener newGameListener;
	private ActionListener quitGameListener;
	private UserInterfaceFX userInterface;

	public GameOverDialogFX(UserInterfaceFX userInterface, ActionListener newGameListener, ActionListener quitGameListener) {
		this.userInterface = userInterface;
		this.newGameListener = newGameListener;
		this.quitGameListener = quitGameListener;
	}

	public void show() {
		System.out.println("asdfdsf");
	}

}
