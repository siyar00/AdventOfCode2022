package Day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class tenthDay {

    private static void firstPart() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Day10/input.txt"));
        String input;
        int x = 1, count = 0, sum = 0;
        boolean loop = true;
        while ((input = reader.readLine()) != null)
            for (int i = 0; i < 2; i++) {
                count++;
                if ((count + 20) % 40 == 0) sum += count * x;
                if (input.equals("noop")) break;
                else {
                    if (loop) {
                        loop = false;
                        continue;
                    }
                    String[] inputs = input.split(" ");
                    int add = Integer.parseInt(inputs[1]);
                    x += add;
                    loop = true;
                }
            }
        reader.close();
        System.out.println(sum);
    }

    private static void secondPart() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Day10/input.txt"));
        String input;
        int x = 1, count = 0;
        boolean loop = true;
        while ((input = reader.readLine()) != null)
            for (int i = 0; i < 2; i++) {
                count++;
                if ((count - 1) % 40 == x || (count - 1) % 40 == x - 1 || (count - 1) % 40 == x + 1)
                    System.out.print("#");
                else
                    System.out.print(".");
                if (count % 40 == 0)
                    System.out.println();

                if (input.equals("noop")) break;
                else {
                    if (loop) {
                        loop = false;
                        continue;
                    }
                    String[] inputs = input.split(" ");
                    int add = Integer.parseInt(inputs[1]);
                    x += add;
                    loop = true;
                }
            }
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        firstPart();
        secondPart();
    }
}
