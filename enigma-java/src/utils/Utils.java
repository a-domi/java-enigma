package utils;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {
	
	public String makeAlphabet() {
		String alphabet = IntStream.rangeClosed('A', 'Z')
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

		return alphabet;
	}
}
