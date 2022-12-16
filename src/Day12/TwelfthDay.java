package Day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TwelfthDay {
    private static class Position{
        int x;
        int y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static ArrayList<ArrayList<Character>> field = new ArrayList<>();
    private static Position position;

    private static void getInput() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("src/Day12/input.txt"));
        String input; int count = 0;
        while((input = reader.readLine()) != null){
            field.add(new ArrayList<>());
            for (int i = 0; i < input.length(); i++) {
                field.get(count).add(input.charAt(i));
                if(input.charAt(i) == 'S')
                    position = new Position(i, count);
            }
            count++;
        }
        reader.close();
    }

    private static void firstPart() throws IOException {

    }

    private static void secondPart() throws IOException {

    }

    public static void main(String[] args) throws IOException {
        getInput();
        firstPart();
        secondPart();
    }
}
