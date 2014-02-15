package model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import org.junit.Test;

public class SnakeTest {

	private Snake snake = new Snake();

	@Test
	public void itShouldGetLonger_WhenItEats() {
		int snakesInitialLength = snake.getLength();
		snake.eat();
		int snakesCurrentLength = snake.getLength();

		assertThat(snakesInitialLength, is(lessThan(snakesCurrentLength)));
	}

}
