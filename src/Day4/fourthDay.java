package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class fourthDay {

    private static void firstDay() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Day4/input.txt"));

        String input;
        int count = 0;
        while ((input = reader.readLine()) != null) {
            String[] teams = input.split(",");
            String[] first = teams[0].split("-");
            String[] second = teams[1].split("-");
            Set<Integer> setTeam = new HashSet<>();
            if (Integer.parseInt(first[1])-Integer.parseInt(first[0]) > Integer.parseInt(second[1])-Integer.parseInt(second[0])) {
                for (int i = Integer.parseInt(first[0]); i <= Integer.parseInt(first[1]); i++)
                    setTeam.add(i);
                for (int i = Integer.parseInt(second[0]); i <= Integer.parseInt(second[1]); i++)
                    if (setTeam.add(i)) break;
                    else if(!setTeam.add(i) && i == Integer.parseInt(second[1])){
                        count++;
                        break;
                    }
            } else {
                for (int i = Integer.parseInt(second[0]); i <= Integer.parseInt(second[1]); i++)
                    setTeam.add(i);
                for (int i = Integer.parseInt(first[0]); i <= Integer.parseInt(first[1]); i++)
                    if (setTeam.add(i)) break;
                    else if(!setTeam.add(i) && i == Integer.parseInt(first[1])){
                        count++;
                        break;
                    }
            }
        }
        System.out.println("count = " + count);
    }

    private static void secondPart() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Day4/input.txt"));

        String input;
        int count = 0;
        while ((input = reader.readLine()) != null) {
            String[] teams = input.split(",");
            String[] first = teams[0].split("-");
            String[] second = teams[1].split("-");
            Set<Integer> setTeam = new HashSet<>();
            if (Integer.parseInt(first[1])-Integer.parseInt(first[0]) > Integer.parseInt(second[1])-Integer.parseInt(second[0])) {
                for (int i = Integer.parseInt(first[0]); i <= Integer.parseInt(first[1]); i++)
                    setTeam.add(i);
                for (int i = Integer.parseInt(second[0]); i <= Integer.parseInt(second[1]); i++)
                    if(!setTeam.add(i)){
                        count++;
                        break;
                    }
            } else {
                for (int i = Integer.parseInt(second[0]); i <= Integer.parseInt(second[1]); i++)
                    setTeam.add(i);
                for (int i = Integer.parseInt(first[0]); i <= Integer.parseInt(first[1]); i++)
                    if(!setTeam.add(i)){
                        count++;
                        break;
                    }
            }
        }
        System.out.println("count = " + count);
    }

    public static void main(String[] args) throws IOException {
        firstDay();
        secondPart();

    }
}
