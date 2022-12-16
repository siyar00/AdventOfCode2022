package Day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ninthDay {

    private final Character[] direction = new Character[2000];
    private final Integer[] steps = new Integer[2000];
    private final ArrayList<Position> visitedPlaces = new ArrayList<>();
    private final ArrayList<Position> rope = new ArrayList<>();

    {
        for (int i = 0; i < 10; i++) {
            rope.add(new Position(0,0));
        }
    }

    private void getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/Day9/input.txt"));
        String input;
        for (int i = 0; (input = reader.readLine()) != null; i++) {
            String[] inputs = input.split(" ");
            direction[i] = inputs[0].charAt(0);
            steps[i] = Integer.parseInt(inputs[1]);
        }
        reader.close();
    }

    private void firstPart() {
        int headX = 0, headY = 0, tailX = 0, tailY = 0;
        for (int i = 0; i < direction.length; i++) {
            for (int j = 0; j < steps[i]; j++) {
                switch (direction[i]) {
                    case 'L' -> headX++;
                    case 'R' -> headX--;
                    case 'U' -> headY++;
                    case 'D' -> headY--;
                }
                //tailMovement
                for (int k = 0; k < 2; k++) {
                    if ((tailX + 1 == headX || tailX == headX || tailX - 1 == headX) &&
                            (tailY == headY || tailY + 1 == headY || tailY - 1 == headY)) {
                        Position position = new Position(tailX, tailY);
                        if (!visitedPlaces.contains(position))
                            visitedPlaces.add(position);
                        break;
                    } else {
                        if (tailX + 2 == headX && tailY == headY) {
                            tailX++;
                        } else if (tailX - 2 == headX && tailY == headY) {
                            tailX--;
                        } else if (tailY + 2 == headY && tailX == headX) {
                            tailY++;
                        } else if (tailY - 2 == headY && tailX == headX) {
                            tailY--;
                        } else if (tailY + 2 == headY && tailX + 1 == headX) {
                            tailX++; tailY++;
                        } else if (tailY + 2 == headY && tailX - 1 == headX) {
                            tailX--; tailY++;
                        } else if (tailY - 2 == headY && tailX + 1 == headX) {
                            tailX++; tailY--;
                        } else if (tailY - 2 == headY && tailX - 1 == headX) {
                            tailX--; tailY--;
                        } else if (tailX + 2 == headX && tailY + 1 == headY) {
                            tailX++; tailY++;
                        } else if (tailX + 2 == headX && tailY - 1 == headY) {
                            tailX++; tailY--;
                        } else if (tailX - 2 == headX && tailY + 1 == headY) {
                            tailX--; tailY++;
                        } else if (tailX - 2 == headX && tailY - 1 == headY) {
                            tailX--; tailY--;
                        }
                    }
                }
            }
        }
        System.out.println(visitedPlaces.size());
    }

    private void secondPart() {
        visitedPlaces.clear();
        for (int i = 0; i < direction.length; i++) {
            for (int j = 0; j < steps[i]; j++) {
                switch (direction[i]) {
                    case 'L' -> rope.get(0).X++;
                    case 'R' -> rope.get(0).X--;
                    case 'U' -> rope.get(0).Y++;
                    case 'D' -> rope.get(0).Y--;
                }
                for (int k = 0; k < rope.size()-1; k++) {
                    if (k == rope.size()-2){
                        setRope(rope.get(k), rope.get(k+1), false);
                        continue;
                    }
                    setRope(rope.get(k), rope.get(k+1), true);
                }
            }
        }
        System.out.println(visitedPlaces.size());
    }

    private void setRope(Position head, Position tail, boolean visit){
        for (int k = 0; k < 2; k++){
            if ((tail.X + 1 == head.X || tail.X == head.X || tail.X - 1 == head.X) &&
                    (tail.Y == head.Y || tail.Y + 1 == head.Y || tail.Y - 1 == head.Y)) {
                if (visit) return;
                Position position = new Position(tail.X, tail.Y);
                if (!visitedPlaces.contains(position))
                    visitedPlaces.add(position);
                break;
            } else {
                if (tail.X + 2 == head.X && tail.Y == head.Y) {
                    tail.X++;
                } else if (tail.X - 2 == head.X && tail.Y == head.Y) {
                    tail.X--;
                } else if (tail.Y + 2 == head.Y && tail.X == head.X) {
                    tail.Y++;
                } else if (tail.Y - 2 == head.Y && tail.X == head.X) {
                    tail.Y--;
                } else if (tail.Y + 2 == head.Y && (tail.X + 1 == head.X || tail.X + 2 == head.X)) {
                    tail.X++; tail.Y++;
                } else if (tail.Y + 2 == head.Y && (tail.X - 1 == head.X || tail.X - 2 == head.X)) {
                    tail.X--; tail.Y++;
                } else if (tail.Y - 2 == head.Y && (tail.X + 1 == head.X || tail.X + 2 == head.X)) {
                    tail.X++; tail.Y--;
                } else if (tail.Y - 2 == head.Y && (tail.X - 1 == head.X || tail.X - 2 == head.X)) {
                    tail.X--; tail.Y--;
                } else if (tail.X + 2 == head.X && (tail.Y + 1 == head.Y || tail.Y + 2 == head.Y)) {
                    tail.X++; tail.Y++;
                } else if (tail.X + 2 == head.X && (tail.Y - 1 == head.Y || tail.Y - 2 == head.Y)) {
                    tail.X++; tail.Y--;
                } else if (tail.X - 2 == head.X && (tail.Y + 1 == head.Y || tail.Y + 2 == head.Y)) {
                    tail.X--; tail.Y++;
                } else if (tail.X - 2 == head.X && (tail.Y - 1 == head.Y || tail.Y - 2 == head.Y)) {
                    tail.X--; tail.Y--;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ninthDay execute = new ninthDay();
        execute.getInput();
        execute.firstPart();
        execute.secondPart();
    }

    private static class Position{
        int X;
        int Y;
        Position(int x, int y){
            this.X = x;
            this.Y = y;
        }

        @Override
        public boolean equals (Object object) {
            boolean result = false;
            if (object != null && object.getClass() == getClass()) {
                Position position = (Position) object;
                if (this.X == position.X && this.Y == position.Y) {
                    result = true;
                }
            }
            return result;
        }
    }
}
