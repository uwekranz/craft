package userinterface;

import java.awt.Component;

public class CageGraphic extends TypedJComponent {

	private Boolean hasBeenPainted = false;

	public CageGraphic() {
		super();
		add(new FoodGraphic());
		add(new SnakeGraphic());
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
}
