package roter;

import plugborad.Plugboard;
import utils.Utils;

public class Roter extends Plugboard implements RoterInterface{
	public static int Offset;
    private static int Rotations;
    
	public Roter() {
		
	}
    
	public Roter(String mapAlphabet, int offset) {
		super(mapAlphabet);
		Offset = offset;
		Rotations = 0;
		
		Mapping(mapAlphabet);
	}
	
	public int Rotate(int offset) {
		//アルファベットの順をoffsetの数だけローテーションする
		Alphabet = Alphabet.substring(offset) + Alphabet.substring(0, offset);
		Rotations += offset;
		
		return Rotations;
	}
	
	public void reset() {
		Utils utils = new Utils();
		Alphabet = utils.makeAlphabet();
		Rotations = 0;
	}
}