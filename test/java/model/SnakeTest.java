package model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import org.junit.Test;

public class SnakeTest {

	private Snake snake = new Snake();

	@Test
	public void itShouldGetLongerWhenItEats() {
		int theSnakesInitialLength = snake.getLength();
		SnakeFood aUnitOfFood = new SnakeFood();
		snake.eat(aUnitOfFood);
		int theSnakesCurrentLength = snake.getLength();
		assertThat(theSnakesInitialLength, is(lessThan(theSnakesCurrentLength)));
	}

}
