import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        WriteKeysToTxt(GetInitDico());
        try {
            FromMorseToLatin("morse_code.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    static HashMap<String, String> GetInitDico() {
        HashMap<String, String> morseMap = new HashMap<String, String>();

        morseMap.put(".-", "A");
        morseMap.put(".--.-", "À");
        morseMap.put("-...", "B");
        morseMap.put("-.-.", "C");
        morseMap.put("-.-..", "Ç");
        morseMap.put("-..", "D");
        morseMap.put(".", "E");
        morseMap.put("..-.", "F");
        morseMap.put("--.", "G");
        morseMap.put("....", "H");
        morseMap.put("..", "I");
        morseMap.put(".---", "J");
        morseMap.put("-.-", "K");
        morseMap.put(".-..", "L");
        morseMap.put("--", "M");
        morseMap.put("-.", "N");
        morseMap.put("---", "O");
        morseMap.put(".--.", "P");
        morseMap.put("--.-", "Q");
        morseMap.put(".-.", "R");
        morseMap.put("...", "S");
        morseMap.put("-", "T");
        morseMap.put("..-", "U");
        morseMap.put("...-", "V");
        morseMap.put(".--", "W");
        morseMap.put("-..-", "X");
        morseMap.put("-.--", "Y");
        morseMap.put("--..", "Z");
        morseMap.put(".-.-.-", ".");
        morseMap.put("--..--", ",");
        morseMap.put("..--..", "?");
        morseMap.put(".----.", "\'");
        morseMap.put("-.-.--", "!");

        return morseMap;
    }

    static void WriteKeysToTxt(HashMap<String, String> map) {
        try {
            File newFile = new File("morse_alphabet.txt");
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
                System.out.println("Absolute path: " + newFile.getAbsolutePath());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter writer = new FileWriter(newFile);
            for (String key : map.keySet()) {
                writer.write(key + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static String FromMorseToLatin(String fileTxt) throws IOException {
        HashMap<String, String> morseMap = GetInitDico();
        String line;

        BufferedReader reader = new BufferedReader(new FileReader(fileTxt));

        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                String latinWord = "";
                String[] letters = word.split(" ");

                for (String letter : letters) {
                    String latinLetter = morseMap.get(letter);
                    if (latinLetter == null) {
                        System.out.println("Invalid character in input file: " + letter);
                        break;
                    }
                    latinWord += latinLetter;
                }
                System.out.print(latinWord + " ");
            }
            System.out.println();
        }

        reader.close();
        return fileTxt;
    }

}