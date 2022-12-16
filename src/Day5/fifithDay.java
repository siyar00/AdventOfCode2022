package Day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class fifithDay {

    private static void firstPart() throws IOException{
        ArrayList<List<Character>> towers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/Day5/input.txt"));
        String input;
        for (int i = 0; i < 9; i++) towers.add(new ArrayList<>());
        while ((input = reader.readLine()).charAt(1) != '1'){
            for (int i = 1, j = 0; i < input.length(); i+=4, j++){
                if(input.charAt(i) != ' '){
                    towers.get(j).add(input.charAt(i));
                }
            }
        }
        for (List<Character> tower : towers){
            Collections.reverse(tower);
        }
        reader.readLine();
        while((input = reader.readLine())!= null){
            String[] inputs = input.split(" ");
            for (int i = 0; i < Integer.parseInt(inputs[1]); i++) {
                List<Character> tower = towers.get(Integer.parseInt(inputs[3])-1);
                towers.get(Integer.parseInt(inputs[5])-1).add(tower.get(tower.size() -1));
                tower.remove(tower.size()-1);
            }
        }
        reader.close();
        for (List<Character> tower : towers){
            System.out.print(tower.get(tower.size()-1));
        }
    }

    private static void secondPart() throws IOException{
        ArrayList<List<Character>> towers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/Day5/input.txt"));
        String input;
        for (int i = 0; i < 9; i++) towers.add(new ArrayList<>());
        while ((input = reader.readLine()).charAt(1) != '1'){
            for (int i = 1, j = 0; i < input.length(); i+=4, j++){
                if(input.charAt(i) != ' '){
                    towers.get(j).add(input.charAt(i));
                }
            }
        }
        for (List<Character> tower : towers){
            Collections.reverse(tower);
        }
        reader.readLine();
        while((input = reader.readLine())!= null){
            List<Character> temp = new ArrayList<>();
            String[] inputs = input.split(" ");
            List<Character> tower = towers.get(Integer.parseInt(inputs[3])-1);
            for (int i = 0; i < Integer.parseInt(inputs[1]); i++) {
                temp.add(tower.get(tower.size() -1));
                tower.remove(tower.size()-1);
            }
            Collections.reverse(temp);
            towers.get(Integer.parseInt(inputs[5])-1).addAll(temp);
        }
        reader.close();
        for (List<Character> tower : towers){
            System.out.print(tower.get(tower.size()-1));
        }
    }
    public static void main(String[] args) throws IOException {
        firstPart();
        System.out.println();
        secondPart();
    }
}
