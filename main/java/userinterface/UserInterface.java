package userinterface;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class UserInterface extends JFrame {

	private static final Dimension DEFAULT_SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

	public UserInterface() {
		super();
		setContentPane(new GameView());
		setSize(DEFAULT_SCREEN_SIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void display() {
		setVisible(true);
		GameView gameView = (GameView) getContentPane();
		gameView.paintComponent(getGraphics());
	}

	public Boolean hasContentPaneOfType(Class<? extends TypedJComponent> type) {
		return ((TypedJComponent) getContentPane()).getSubClass() == type;
	}

	public GameView getCageGraphic() {
		return (GameView) getContentPane();
	}

	public Boolean cageGraphic_HasBeenPainted() {
		return getCageGraphic().CageHasBeenPainted();
	}

}
