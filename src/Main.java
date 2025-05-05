import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Cube c = new Cube();
        CubeSolver solver = new CubeSolver();

        // c.L();
        // c.printCube();

        Scanner console = new Scanner(System.in);
        System.out.println("Enter your scramble");
        String scramble = console.nextLine();
        c.execAlg(false, scramble);
        solver.solveCube(c);
    }
  }

