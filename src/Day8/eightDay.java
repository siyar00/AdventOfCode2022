package Day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class eightDay {

    private static ArrayList<ArrayList<Integer>> getInput() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("src/Day8/input.txt"));
        ArrayList<ArrayList<Integer>> trees = new ArrayList<>();
        String input;
        while((input = reader.readLine()) != null){
            String finalInput = input;
            ArrayList<Integer> temp = new ArrayList<>(){{
                for (int i = 0; i < finalInput.length(); i++)
                    add(Integer.parseInt(String.valueOf(finalInput.charAt(i))));
            }};
            trees.add(temp);
        }
        reader.close();
        return trees;
    }

    private static void firstPart() throws IOException {
        var trees = getInput();
        int visibleTree = 2 * (trees.size() - 2 + trees.get(0).size());
        for (int i = 1; i < trees.size()-1; i++) {
            for (int j = 1; j < trees.get(i).size()-1; j++) {
                if(highestTree(trees, i, j))
                    visibleTree++;
            }
        }
        System.out.println(visibleTree);
    }
    private static boolean highestTree(ArrayList<ArrayList<Integer>> trees, int y, int x) {
        boolean up = true, down = true, right = true, left = true;
        for (int i = 1; i <= y; i++) {
            if(trees.get(y-i).get(x) >= trees.get(y).get(x)){
                up = false;
                break;
            }
        }
        for (int i = 1; i < trees.size()-y; i++) {
            if(trees.get(y+i).get(x) >= trees.get(y).get(x)){
                down = false;
                break;
            }
        }
        for (int i = 1; i < trees.get(y).size()-x; i++) {
            if(trees.get(y).get(x+i) >= trees.get(y).get(x)){
                right = false;
                break;
            }
        }
        for (int i = 1; i <= x; i++) {
            if(trees.get(y).get(x-i) >= trees.get(y).get(x)){
                left = false;
                break;
            }
        }
        return up || down || right || left;
    }

    private static void secondPart() throws IOException {
        var trees = getInput();
        ArrayList<Integer> highestTree = new ArrayList<>();
        for (int i = 1; i < trees.size()-1; i++) {
            for (int j = 1; j < trees.get(i).size()-1; j++) {
                highestTree.add(highestIntTree(trees, i, j));
            }
        }
        System.out.println(Collections.max(highestTree));
    }
    private static int highestIntTree(ArrayList<ArrayList<Integer>> trees, int y, int x) {
        int count = 0, result = 0;
        for (int i = 1; i <= y; i++) {
            count++;
            if(trees.get(y-i).get(x) >= trees.get(y).get(x)) break;
        }
        result = count;
        count = 0;
        for (int i = 1; i < trees.size()-y; i++) {
            count++;
            if(trees.get(y+i).get(x) >= trees.get(y).get(x)) break;
        }
        result *= count;
        count = 0;
        for (int i = 1; i < trees.get(y).size()-x; i++) {
            count++;
            if(trees.get(y).get(x+i) >= trees.get(y).get(x)) break;
        }
        result *= count;
        count = 0;
        for (int i = 1; i <= x; i++) {
            count++;
            if(trees.get(y).get(x-i) >= trees.get(y).get(x)) break;
        }
        return result * count;
    }


    public static void main(String[] args) throws IOException {
        firstPart();
        secondPart();
    }
}
