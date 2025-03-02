package enigma;

import java.util.ArrayList;
import java.util.List;

import plugborad.Plugboard;
import reflector.Reflector;
import roter.Roter;

public class Enigma implements EnigmaInterface {

	private static Plugboard plugboard;
	private static Reflector reflector;
	private static Roter[] roters;
	
	public Enigma(Plugboard plugboard_instance, Reflector reflector_instance, Roter[] roters_instance) {
		plugboard = plugboard_instance;
		reflector = reflector_instance;
		roters = roters_instance;
	}

	public String encrypt(String letters)  {
		String[] letterArr = letters.split("");
		List<String> list = new ArrayList<String>();
		for (String letter : letterArr) {
		    list.add(GoThrough(letter));
		}
		return String.join("", list);
	}
	
	public String decrypt(String letters)  {
		for (Roter roter : roters) {
			roter.reset();
		}
		String[] letterArr = letters.split("");
		List<String> list = new ArrayList<String>();
		for (String letter : letterArr) {
		    list.add(GoThrough(letter));
		}
		return String.join("", list);
	}

	public String GoThrough(String letter) {
		String upperString = letter.toUpperCase();
		// アルファベット以外の文字列はそのまま返す
		if (!plugboard.Alphabet.contains(upperString)){
            return letter;
        }
		int indexNum = plugboard.Alphabet.indexOf(upperString);
		indexNum = plugboard.Forward(indexNum);

		for (Roter roter : roters) {
			indexNum = roter.Forward(indexNum);
		}
		indexNum = reflector.Reflect(indexNum);
		// roterを逆順でループ
		for (int i = roters.length - 1; i >= 0; i--) {
			indexNum = roters[i].Backward(indexNum);
		}
		indexNum = plugboard.Backward(indexNum);
		letter = String.valueOf(plugboard.Alphabet.charAt(indexNum));
		
		// roterを逆順でループ
		for (int i = roters.length - 1; i >= 0; i--) {
			if(roters[i].Rotate(Roter.Offset) % plugboard.Alphabet.length() != 0) {
				break;
			}
		}
		
		return letter;
	}
}
