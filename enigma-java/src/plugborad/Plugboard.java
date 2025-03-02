package plugborad;

import java.util.HashMap;
import java.util.Map;

import utils.Utils;

public class Plugboard implements PlugboardInterface {
	public String Alphabet;
	private static Map<String, String> forwardMap;
    private static Map<String, String> backwardMap;
	
	public Plugboard() {

	}
    
	public Plugboard(String mapAlphabet) {
		Utils utils = new Utils();
		Alphabet = utils.makeAlphabet();
		Mapping(mapAlphabet);
	}
	
	public void Mapping(String mapAlphabet) {
        Map<String, String> forward = new HashMap<>();
        Map<String, String> backward = new HashMap<>();
        for(int i = 0; i < mapAlphabet.length(); i++) {
        	forward.put(String.valueOf(Alphabet.charAt(i)), String.valueOf(mapAlphabet.charAt(i)));
        	backward.put(String.valueOf(mapAlphabet.charAt(i)), String.valueOf(Alphabet.charAt(i)));
        }

        forwardMap = forward;
        backwardMap = backward;
	}
	
	public int Forward(int index) {
		String Alphabet_index_char = String.valueOf(Alphabet.charAt(index));
		String forwardMap_index_char = forwardMap.get(Alphabet_index_char);
		return Alphabet.indexOf(forwardMap_index_char);
	}
	
	public int Backward(int index) {
		String Alphabet_index_char = String.valueOf(Alphabet.charAt(index));
		String backwardMap_index_char = backwardMap.get(Alphabet_index_char);
		return Alphabet.indexOf(backwardMap_index_char);
	}
}
