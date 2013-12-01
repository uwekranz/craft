package userinterface;

import java.awt.Component;
import java.awt.Graphics;

public class CageGraphic extends TypedJComponent {

	private boolean cageHasBeenPainted = false;
	private boolean foodHasBeenPainted = false;
	private boolean snakeHasBeenPainted = false;

	public CageGraphic() {
		super();
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		graphics.drawRect(100, 50, 100, 100);
		cageHasBeenPainted = true;
		graphics.drawOval(500, 500, 25, 25);
		foodHasBeenPainted = true;
		graphics.drawLine(1000, 100, 100, 100);
		snakeHasBeenPainted = true;
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
		return cageHasBeenPainted;
	}

	public SnakeGraphic getSnakeGraphic() {
		TypedJComponent[] typedComponents = this.getTypedComponents();
		for (TypedJComponent typedComponent : typedComponents) {
			if (typedComponent.getSubClass() == SnakeGraphic.class) {
				return (SnakeGraphic) typedComponent;
			}
		}
		return null;
	}

	public FoodGraphic getFoodGraphic() {
		TypedJComponent[] typedComponents = this.getTypedComponents();
		for (TypedJComponent typedComponent : typedComponents) {
			if (typedComponent.getSubClass() == FoodGraphic.class) {
				return (FoodGraphic) typedComponent;
			}
		}
		return null;
	}

	public Boolean FoodGraphicHasBeenPainted() {
		return foodHasBeenPainted;
	}

	public Boolean SnakeGraphicHasBeenPainted() {
		return snakeHasBeenPainted;
	}

}
