import java.util.Scanner;

public class Main {
    public static void main(String[] args){
      Cube cube = new Cube();
      Scanner console = new Scanner(System.in);
      System.out.println("Enter your scramble");
      String scramble = console.nextLine();
      cube.scramble(scramble);
      while(!cube.isSolved()) {
        int pos = cube.findDestination();
        Move[] setUp = cube.setup(pos);
        for (Move move: setUp) {
          move.execute(true);
        }
        cube.cornerSwap();
        Move[] reversedSetUp = cube.reverse(setUp);
        for (Move move: reversedSetUp) {
          move.execute(true);
        }
      }
    }

}
