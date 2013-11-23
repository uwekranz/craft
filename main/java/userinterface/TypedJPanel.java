package userinterface;

import javax.swing.JPanel;

public abstract class TypedJPanel extends JPanel {
	private final Class<? extends TypedJPanel> subClassType;

	public TypedJPanel() {
		super();
		subClassType = this.getClass();
	}

	public TypedJPanel(Class<? extends TypedJPanel> subClassType) {
		super();
		this.subClassType = subClassType;
	}

	public Class<? extends TypedJPanel> getSubClass() {
		return subClassType;
	}
}
