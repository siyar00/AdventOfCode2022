package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class thirdDay {
    private static void firstPart() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Day3/input.txt"));
        String input;
        List<Integer> letters = new ArrayList<>();
        while ((input = reader.readLine()) != null) {
            boolean loop = true;
            String first = input.substring(0, input.length() / 2);
            String second = input.substring(input.length() / 2);
            for (char letter : first.toCharArray())
                for (char letter2 : second.toCharArray())
                    if (loop && letter == letter2) {
                        letters.add((int) letter);
                        loop = false;
                    }
        }
        helperMethod(reader, letters);
    }

    private static void secondPart() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Day3/input.txt"));
        ArrayList<String> firstTeam = new ArrayList<>();
        List<Integer> letters = new ArrayList<>();
        String input;
        while ((input = reader.readLine()) != null) {
            boolean loop = true;
            firstTeam.add(input);
            for (int i = 0; i < 2; i++) {
                input = reader.readLine();
                firstTeam.add(input);
            }
            for (int i = 0; i < firstTeam.get(0).length() && loop; i++) {
                char[] first = firstTeam.get(0).toCharArray();
                for (int j = 0; j < firstTeam.get(1).length() && loop; j++) {
                    char[] second = firstTeam.get(1).toCharArray();
                    if (first[i] == second[j]) {
                        for (int k = 0; k < firstTeam.get(2).length() && loop; k++) {
                            char[] third = firstTeam.get(2).toCharArray();
                            if (second[j] == third[k]) {
                                letters.add((int) third[k]);
                                loop = false;
                            }
                        }
                    }
                }
            }
            firstTeam.clear();
        }
        helperMethod(reader, letters);
    }

    private static void helperMethod(BufferedReader reader, List<Integer> letters) throws IOException {
        reader.close();
        int sum = 0;
        for (int letter : letters) {
            if (letter > 64 && letter < 91) {
                sum += (letter - 38);
            } else {
                sum += (letter - 96);
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        firstPart();
        secondPart();
    }
}
