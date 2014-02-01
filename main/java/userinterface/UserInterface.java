package userinterface;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

public class UserInterface extends JFrame {

	private static final Dimension DEFAULT_SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

	public UserInterface() {
		super();
		setContentPane(new GameView());
		setSize(DEFAULT_SCREEN_SIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public UserInterface(GameView gameView) {
		super();
		setContentPane(gameView);
		setSize(DEFAULT_SCREEN_SIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void display() {
		setVisible(true);
		GameView gameView = (GameView) getContentPane();
		gameView.paintComponent(getGraphics());
	}

	public Boolean hasComponentOfType(Class<? extends TypedJComponent> type) {
		List<TypedJComponent> typedComponents = this.getTypedComponents();
		return typedComponents.contains(type);
	}

	public Boolean hasContentPaneOfType(Class<? extends TypedJComponent> type) {
		return ((TypedJComponent) getContentPane()).getSubClass() == type;
	}

	private List<TypedJComponent> getTypedComponents() {
		List<Component> components = getComponentsOfContentPane();
		components.add(getContentPane());
		return castComponentIntoTypedComponents(components);
	}

	private List<TypedJComponent> castComponentIntoTypedComponents(List<Component> components) {
		List<TypedJComponent> typedComponents = null;
		for (Component component : components) {
			typedComponents.add((TypedJComponent) component);
		}
		return typedComponents;
	}

	private List<Component> getComponentsOfContentPane() {
		Component[] components = getContentPane().getComponents();
		return Arrays.asList(components);
	}

	public GameView getCageGraphic() {
		return (GameView) getContentPane();
	}

	public Boolean cageGraphic_HasBeenPainted() {
		return getCageGraphic().CageHasBeenPainted();
	}

}
