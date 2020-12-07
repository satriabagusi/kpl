import static org.junit.Assert.*;

import org.junit.Test;

public class HelloTest {

	@Test
	public void test() {
		Hello hai = new Hello();
		String result = hai.welcome("Satria");
		assertEquals("Welcome, Satria", result);
	}
}
