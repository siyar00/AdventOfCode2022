package Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class sixthDay {

    private static void firstPart() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Day6/input.txt"));
        String input = reader.readLine();
        reader.close();
        for (int i = 0; i < input.length() - 4; i++) {
            String temp = input.substring(i, i + 4);
            Set<Character> test = new HashSet<>() {{
                for (int j = 0; j < temp.length(); j++) add(temp.charAt(j));
            }};
            if (test.size() == 4) {
                System.out.println(i + 4);
                break;
            }
        }
    }

    private static void secondPart() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Day6/input.txt"));
        String input = reader.readLine();
        reader.close();
        for (int i = 0; i < input.length() - 14; i++) {
            String temp = input.substring(i, i + 14);
            Set<Character> test = new HashSet<>() {{
                for (int j = 0; j < temp.length(); j++) add(temp.charAt(j));
            }};
            if (test.size() == 14) {
                System.out.println(i + 14);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        firstPart();
        secondPart();
    }
}
