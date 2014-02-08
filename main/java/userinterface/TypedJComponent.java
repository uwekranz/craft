package userinterface;

import javax.swing.JComponent;

public class TypedJComponent extends JComponent {

	private static final long serialVersionUID = 2327194918604614238L;
	private final Class<? extends TypedJComponent> subClassType;

	public TypedJComponent() {
		super();
		subClassType = this.getClass();
	}

	public Class<? extends TypedJComponent> getSubClass() {
		return subClassType;
	}
}
