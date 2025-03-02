package reflector;

import java.util.HashMap;
import java.util.Map;

import utils.Utils;

public class Reflector implements ReflectorInterface {
	public String Alphabet;
	private static Map<String, String> reflectorMap;
	
	public Reflector() {
		
	}
	
	public Reflector(String mapAlphabet) {
		Utils utils = new Utils();
		Alphabet = utils.makeAlphabet();
        
		Map<String, String> zipped = new HashMap<>();

		int length = Math.min(Alphabet.length(), mapAlphabet.length());
        for (int i = 0; i < length; i++) {
            // ALPHABETのi番目の文字とmapAlphabetのi番目の文字をマッピング
            String charInAlphabet = String.valueOf(Alphabet.charAt(i));
            String charInMapAlphabet = String.valueOf(mapAlphabet.charAt(i));
            zipped.put(charInAlphabet, charInMapAlphabet);
        }
        reflectorMap = zipped;
	}
	
	public int Reflect(int index_num) {
		String reflected_char = reflectorMap.get(String.valueOf(Alphabet.charAt(index_num)));
		for (int i = 0; i < Alphabet.length(); i++) {
            if (String.valueOf(Alphabet.charAt(i)).equals(reflected_char)) {
                return i;
            }
        }
        return -1;
	}
}
