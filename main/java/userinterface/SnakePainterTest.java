package userinterface;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SnakePainterTest {
	@Test
	public void itHasNotPaintedYet_WhenItsNewlyCreated() {
		SnakePainter snakePainter = new SnakePainter();
		assertThat(snakePainter.paintsRegularly(), is(false));
	}
}
