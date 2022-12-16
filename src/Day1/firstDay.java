package Day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class firstDay {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Day1/input.txt"));
            int sum = 0;
            String input = null;
            List<Integer> integerList = new ArrayList<>();
            do {
                input = reader.readLine();
                if (input != null && !input.equals(""))
                    sum += Integer.parseInt(input);
                else{
                    integerList.add(sum);
                    sum = 0;
                }
            } while (input != null);
            reader.close();

            Collections.sort(integerList);
            Collections.reverse(integerList);
            int max = 0;
            for (int i = 0; i < 3; i++) {
                max += integerList.get(i);
            }
            System.out.println(max);

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
