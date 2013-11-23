package userinterface;

import java.awt.Component;
import java.awt.Graphics;

public class CageGraphic extends TypedJPanel {

	private Boolean hasBeenPainted = false;
	private SnakeGraphic snakeGraphic = new SnakeGraphic();

	public CageGraphic() {
		super();
		add(new FoodGraphic());
		add(snakeGraphic);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		hasBeenPainted = true;
	}

	public Boolean hasComponentOfType(Class<? extends TypedJComponent> type) {
		TypedJComponent[] typedComponents = this.getTypedComponents();
		for (TypedJComponent typedComponent : typedComponents) {
			if (typedComponent.getSubClass() == type) {
				return true;
			}
		}
		return false;
	}

	private TypedJComponent[] getTypedComponents() {
		Component[] components = this.getComponents();
		TypedJComponent[] typedComponents = new TypedJComponent[components.length];
		for (int index = 0; index < components.length; index++) {
			typedComponents[index] = (TypedJComponent) components[index];
		}
		return typedComponents;
	}

	public Boolean hasBeenPainted() {
		return hasBeenPainted;
	}

	public SnakeGraphic getSnakeGraphic() {
		return snakeGraphic;
	}
}
