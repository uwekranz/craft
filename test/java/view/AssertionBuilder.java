package view;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import model.Direction;

import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import controller.Controller;

public class AssertionBuilder {

	private Controller controllerMock;

	@Captor
	ArgumentCaptor<Direction> directionCaptor = ArgumentCaptor.forClass(Direction.class);

	public AssertionBuilder(Controller controllerMock) {
		this.controllerMock = controllerMock;
	}

	public void thenTheSnakesDirectionGetsSetTo(Direction right) {
		assertThat(theNewDirectionOfSnakeMovement(), is(right));
	}

	private Direction theNewDirectionOfSnakeMovement() {
		verify(controllerMock).setDirectionOfSnakeMovement(directionCaptor.capture());
		Direction directionOfSnakeMovement = directionCaptor.getValue();

		return directionOfSnakeMovement;
	}

	public void pressKeyWithCode(int keyCode) {
		KeyPresser.pressKeyWithCode(keyCode);
	}

}
