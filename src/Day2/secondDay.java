package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class secondDay {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Day2/input.txt"));
        int sum = 0;
        String input;
        reader.mark(1000000);
        while((input = reader.readLine()) != null){
            switch (input.charAt(2)) {
                case 'X' -> {
                    sum += 1;
                    switch (input.charAt(0)){
                        case 'A' -> sum += 3;
                        case 'C' -> sum += 6;
                    }
                }
                case 'Y' -> {
                    sum += 2;
                    switch (input.charAt(0)){
                        case 'B' -> sum += 3;
                        case 'A' -> sum += 6;
                    }
                }
                case 'Z' -> {
                    sum += 3;
                    switch (input.charAt(0)){
                        case 'C' -> sum += 3;
                        case 'B' -> sum += 6;
                    }
                }
                default -> throw new IllegalArgumentException();
            }
        }
        System.out.println(sum);

        //Second part
        sum = 0;
        reader.reset();
        while((input = reader.readLine()) != null){
            switch (input.charAt(0)) {
                case 'A' -> { //Rock
                    switch (input.charAt(2)){
                        case 'X' -> sum += 3; //lose
                        case 'Y' -> sum += 4; //draw
                        case 'Z' -> sum += 8; //win
                    }
                }
                case 'B' -> { //Paper
                    switch (input.charAt(2)){
                        case 'X' -> sum += 1;
                        case 'Y' -> sum += 5;
                        case 'Z' -> sum += 9;
                    }
                }
                case 'C' -> { //Scissor
                    switch (input.charAt(2)){
                        case 'X' -> sum += 2;
                        case 'Y' -> sum += 6;
                        case 'Z' -> sum += 7;
                    }
                }
                default -> throw new IllegalArgumentException();
            }
        }
        System.out.println(sum);
    }
}
