package util;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RandomUtilTest {

	@Test
	public void testRandomValueInRange() {
		int min = 1;
		int max = 9;
		int randomValue = RandomUtil.getRandomValueInRange(min, max);
		System.out.println(randomValue);
		assertTrue(randomValue >= min);
		assertTrue(randomValue <= max);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRandomValueNegativeBound() {
		int min = 7;
		int max = 2;
		RandomUtil.getRandomValueInRange(min, max);
	}
}