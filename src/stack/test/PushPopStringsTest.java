package stack.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import stack.client.PushPopStrings;

public class PushPopStringsTest {

	@Test
	public void test() {
		String[] words = {
			"it", "was", "-", "the", "best",
			"of", "times", "-", "-", "-",
			"it", "was", "-", "the", "-", "-"
		};
		List<String> listWords = Arrays.asList(words);
		
		PushPopStrings evaluator = new PushPopStrings(listWords);
		assertEquals("was times of best was the it ", evaluator.evaluate());
	}

}
