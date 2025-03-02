package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import enigma.Enigma;
import plugborad.Plugboard;
import reflector.Reflector;
import roter.Roter;

public class Main {

	public static void main(String[] args) {
		Plugboard plugboard = new Plugboard(randomAlphabetGenerator());
		Roter roter1 = new Roter(randomAlphabetGenerator(),3);
		Roter roter2 = new Roter(randomAlphabetGenerator(),2);
		Roter roter3 = new Roter(randomAlphabetGenerator(),1);
		
        Roter[] roterList = new Roter[3];
        roterList[0] = roter1;
        roterList[1] = roter2;
        roterList[2] = roter3;

        // アルファベット1文字ずつのリストとそのインデックスのリストを作成する
        List<String> strArray = new ArrayList<>();
        List<Integer> indexArray = new ArrayList<>();
		for (int i = 0; i < plugboard.Alphabet.length(); i++) {
		    String str2 = String.valueOf(plugboard.Alphabet.charAt(i));
		    strArray.add(str2);
		    indexArray.add(i);
		}

		//ランダムなアルファベットの対の配列を生成
		Random rnd = new Random();
		for (int i = 0; i < indexArray.size()/2; i++) {
			int randomInt = rnd.nextInt(indexArray.size());
			int x = indexArray.get(randomInt);
			indexArray.remove(randomInt);
			randomInt = rnd.nextInt(indexArray.size());
			int y = indexArray.get(randomInt);
			indexArray.remove(randomInt);
			
			String temp = strArray.get(x); 
			strArray.set(x, strArray.get(y));
			strArray.set(y, temp);
		}

		Reflector reflector = new Reflector(String.join("", strArray));
		
		Enigma enigmaMachine = new Enigma(plugboard, reflector, roterList);
		String s = "ATTACK TOKYO JAPAN";
		String e = enigmaMachine.encrypt(s);
		System.out.println("encrypt:"+e);
		String d = enigmaMachine.decrypt(e);
		System.out.println("decrypt:"+d);
	}

	public static String randomAlphabetGenerator() {
		// アルファベットのリストを作成
        List<Character> alphabet = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabet.add(c);
        }

        // リストをシャッフルしてランダムな順序にする
        Collections.shuffle(alphabet);

        // リストを文字列に変換
        StringBuilder randomAlphabet = new StringBuilder();
        for (char c : alphabet) {
            randomAlphabet.append(c);
        }
        
        return randomAlphabet.toString();
	}
}
