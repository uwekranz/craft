package userinterface;

import javax.swing.JComponent;

public class TypedJComponent extends JComponent {

	private final Class<? extends TypedJComponent> subClassType;

	public TypedJComponent() {
		super();
		subClassType = this.getClass();
	}

	public TypedJComponent(Class<? extends TypedJComponent> subClassType) {
		super();
		this.subClassType = subClassType;
	}

	public Class<? extends TypedJComponent> getSubClass() {
		return subClassType;
	}
}
