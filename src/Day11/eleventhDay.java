package Day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class eleventhDay {

    private class Monkey {
        ArrayList<Long> starting_items;
        int operation;
        char operator;
        int divisible;
        int ifTrue;
        int ifFalse;
        int inspected;

        public Monkey(ArrayList<Long> starting_items, int operation, char operator, int divisible, int ifTrue, int ifFalse) {
            this.starting_items = starting_items;
            this.operation = operation;
            this.operator = operator;
            this.divisible = divisible;
            this.ifTrue = ifTrue;
            this.ifFalse = ifFalse;
            this.inspected = 0;
        }
    }

    private final ArrayList<Monkey> monkeys = new ArrayList<>();

    private void getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Day11/input.txt"));
        reader.mark(Short.MAX_VALUE);
        String input, operate;
        ArrayList<Long> starting_items = new ArrayList<>();
        int operation = 0, divisible = 0, ifTrue = 0, ifFalse = 0;
        char operator = '+';
        while ((input = reader.readLine()) != null) {
            if (input.contains("Monkey")) continue;
            if (input.contains("Operation:")) {
                operate = input.substring(input.indexOf("= old "));
                operator = operate.charAt(6);
                Pattern pattern = Pattern.compile("[\\d]+");
                Matcher matcher = pattern.matcher(input);
                if (matcher.find()) operation = Integer.parseInt(matcher.group());
                else operation = 0;
            }
            Pattern pattern = Pattern.compile("[\\d]+");
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                if (input.contains("Starting items:"))
                    starting_items.add(Long.parseLong(matcher.group()));
                else if (input.contains("Test: divisible by"))
                    divisible = Integer.parseInt(matcher.group());
                else if (input.contains("If true: throw to monkey"))
                    ifTrue = Integer.parseInt(matcher.group());
                else if (input.contains("If false: throw to monkey"))
                    ifFalse = Integer.parseInt(matcher.group());
            }
            if (input.equals("")) {
                monkeys.add(new Monkey((ArrayList<Long>) starting_items.clone(), operation, operator, divisible, ifTrue, ifFalse));
                starting_items.clear();
            }
        }
        reader.close();
    }

    private void firstPart() {
        for (int j = 0; j < 20; j++) {
            for (Monkey monkey : monkeys) {
                for (int i = monkey.starting_items.size(); i > 0; i--) {
                    Long item = monkey.starting_items.get(0);
                    monkey.inspected++;
                    long temp;
                    switch (monkey.operator) {
                        case '+':
                            if ((temp = ((item + monkey.operation) / 3)) % monkey.divisible == 0)
                                monkeys.get(monkey.ifTrue).starting_items.add(temp);
                            else
                                monkeys.get(monkey.ifFalse).starting_items.add(temp);
                            break;
                        case '*':
                            if (monkey.operation == 0) {
                                if ((temp = ((item * item) / 3)) % monkey.divisible == 0)
                                    monkeys.get(monkey.ifTrue).starting_items.add(temp);
                                else
                                    monkeys.get(monkey.ifFalse).starting_items.add(temp);
                                break;
                            }
                            if ((temp = ((item * monkey.operation) / 3)) % monkey.divisible == 0)
                                monkeys.get(monkey.ifTrue).starting_items.add(temp);
                            else
                                monkeys.get(monkey.ifFalse).starting_items.add(temp);
                            break;
                    }
                    monkey.starting_items.remove(item);
                }
            }
        }
        ArrayList<Integer> maxIns = new ArrayList<>();
        for (Monkey monkey : monkeys) {
            maxIns.add(monkey.inspected);
        }
        int max = Collections.max(maxIns);
        maxIns.remove((Integer) max);
        System.out.println(max*Collections.max(maxIns));
    }

    private void secondPart() {
        long supermodulo = 1;
        for(Monkey monkey : monkeys){
            supermodulo*= monkey.divisible; // Check nicht wieso, hat was mit Modulo Arithmetik zu tun
        }
        for (int j = 0; j < 10000; j++) {
            for (Monkey monkey : monkeys) {
                for (int i = monkey.starting_items.size(); i > 0; i--) {
                    Long item = monkey.starting_items.get(0);
                    monkey.inspected++;
                    long temp;
                    switch (monkey.operator) {
                        case '+':
                            if ((temp = ((item % supermodulo) + (monkey.operation % supermodulo))) % monkey.divisible == 0)
                                monkeys.get(monkey.ifTrue).starting_items.add(temp);
                            else
                                monkeys.get(monkey.ifFalse).starting_items.add(temp);
                            break;
                        case '*':
                            if (monkey.operation == 0) {
                                if ((temp = ((item % supermodulo) * (item % supermodulo))) % monkey.divisible == 0)
                                    monkeys.get(monkey.ifTrue).starting_items.add(temp);
                                else
                                    monkeys.get(monkey.ifFalse).starting_items.add(temp);
                                break;
                            }
                            if ((temp = ((item % supermodulo)* (monkey.operation % supermodulo))) % monkey.divisible == 0)
                                monkeys.get(monkey.ifTrue).starting_items.add(temp);
                            else
                                monkeys.get(monkey.ifFalse).starting_items.add(temp);
                            break;
                    }
                    monkey.starting_items.remove(item);
                }
            }
        }
        ArrayList<Integer> maxIns = new ArrayList<>();
        for (Monkey monkey : monkeys) {
            maxIns.add(monkey.inspected);
        }
        int max = Collections.max(maxIns);
        maxIns.remove((Integer) max);
        System.out.format("%d * %d",max, Collections.max(maxIns));
    }

    public static void main(String[] args) throws IOException {
        eleventhDay adventOfCode = new eleventhDay();
        adventOfCode.getInput();
        adventOfCode.firstPart();
        adventOfCode.monkeys.clear();
        adventOfCode.getInput();
        adventOfCode.secondPart();
    }
}
