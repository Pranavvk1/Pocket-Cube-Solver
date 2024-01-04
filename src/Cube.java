public class Cube {
  private Move U = new Move("U"), UPrime = new Move("UPrime"), R = new Move("R"),
    RPrime = new Move("RPrime"), R2 = new Move("R2"), L = new Move("L"), LPrime = new Move("LPrime"), 
    L2 = new Move("L2"), F = new Move("F"), FPrime = new Move("FPrime"), F2 = new Move("F2"), B = new Move("B"),
    BPrime = new Move("BPrime"), D = new Move("D"), DPrime = new Move("DPrime"), D2 = new Move("D2"); 
  
    private final String[][] solvedCube = {
      {"W", "W", "W", "W"},
      {"O", "O", "O", "O"},
      {"G", "G", "G", "G"},
      {"R", "R", "R", "R"},
      {"B", "B", "B", "B"},
      {"Y", "Y", "Y", "Y"},
    };

    /**
     * @return returns true if Move.pieces is the same as solvedCube
     */
    public boolean isSolved() {
      for (int i = 0; i < solvedCube.length; i++) {
        for (int j = 0; j < solvedCube[i].length; j++) {
          if (!Move.pieces[i][j].equals(solvedCube[i][j])) return false;
        }
      }
      return true;
    }

    /**
     * @return finds an unsolved piece in the Move.pieces 2D array
     */
    public int findUnsolvedPiece(){
      for (int i = 0; i < solvedCube.length; i++) {
        for (int j = 0; j < solvedCube[i].length; j++) {
          int pos = 4 * i + j;
          if (!Move.pieces[i][j].equals(solvedCube[i][j]) && (pos != 1 && pos != 13 && pos != 16)) {
            return pos;
          }
        }
      }
      return 0;
    }

    public void cornerSwap() {
      Move[] moves = {R, U, RPrime, UPrime, RPrime, F, R2, UPrime, RPrime, UPrime, R, U, RPrime, FPrime};
      for (Move move: moves) {
        move.execute(true);
      }
    }

 
    /**
     * @param setup The moves to setup the corner swap
     * @return the inverse of the setup
     */
    public Move[] reverse(Move[] setup) {
      Move[] reversedAlg = new Move[setup.length];
      for (int i = setup.length - 1; i >= 0; i--) {
        String moveID = setup[i].getID();
        String reversedMove;
        if (moveID.length() == 1) {
          reversedMove = moveID + "Prime";
        } else if (moveID.length() == 2) {
          reversedMove = moveID;
        } else {
          reversedMove = moveID.substring(0, 1);
        }
        reversedAlg[reversedAlg.length - i - 1] = new Move(reversedMove);
      }
      return reversedAlg;
    }
    
    /**
     * @param pos the position of the intended pieces
     * @return the moves to setup the corner swap
     */
    public Move[] setup(int pos) { // setup to swap corners 1 and 2
      Move[] setUp0 = {U}, setUp2 = {}, setUp3 = {BPrime, UPrime, B}, setUp4 = {L, F}, setUp5 = {F}, setUp6 = {LPrime, F}, 
      setUp7 = {L2, F}, setUp8 = {FPrime, D, FPrime}, setUp9 = {F2, D, FPrime},setUp10 = {F, D, FPrime}, setUp11 = {D, FPrime},
      setUp12 = {F, DPrime, F2}, setUp14 = {D2, RPrime, D, R}, setUp15 = {FPrime}, setUp17 = {L2, U, LPrime, UPrime}, setUp18 = {L, U}, 
      setUp19 = {DPrime, FPrime}, setUp20 = {F2}, setUp21 = {DPrime, F2}, setUp22 = {D2, F2}, setUp23 = {D, F2}; 

      switch (pos) {
        case 0:
          return setUp0;
        case 2:
          return setUp2;
        case 3:
          return setUp3;
        case 4:
          return setUp4;
        case 5:
          return setUp5;
        case 6:
          return setUp6;
        case 7:
          return setUp7;
        case 8:
          return setUp8;
        case 9:
          return setUp9;
        case 10:
          return setUp10;
        case 11:
          return setUp11;
        case 12:
          return setUp12;
        case 14:
          return setUp14;
        case 15:
          return setUp15;
        case 17:
          return setUp17;
        case 18:
          return setUp18;
        case 19:
          return setUp19;
        case 20:
          return setUp20;
        case 21:
          return setUp21;
        case 22:
          return setUp22;
        case 23:
          return setUp23;
        default:
          int unsolvedPos = findUnsolvedPiece();
          return setup(unsolvedPos); 
      }
    }

    /**
     * @param scramble the moves meant to scramble the cube
     */
    public void scramble(String scramble) {
      int indexOfSpace = scramble.indexOf(" ");
      while (indexOfSpace >= 0) {
        String nextMove = scramble.substring(0, indexOfSpace);
        Move move = new Move(nextMove);
        move.execute(false);
        scramble = scramble.substring(indexOfSpace + 1);
        indexOfSpace = scramble.indexOf(" ");
      }
      Move move = new Move(scramble);
      move.execute(false);
    }
    
    /**
     * @return the solved position of the piece at the position 1
     */
    public int findDestination() {
      int pos = 0;
      String up = Move.pieces[0][1];
      String right = Move.pieces[3][1];
      if (up.equals("W")) {
        if (right.equals("O")) {
          pos = 3;
        } else if (right.equals("G")) {
          pos = 2;
        } else if (right.equals("B")){
          pos = 0;
        } else {
          pos = 1;
        }
      } else if (up.equals("O")) {
        if (right.equals("W")) {
          pos = 4;
        } else if (right.equals("G")) {
          pos = 5;
        } else if (right.equals("Y")){
          pos = 6;
        } else {
          pos = 7;
        }
      } else if(up.equals("G")) {
        if (right.equals("O")) {
          pos = 8;
        } else if (right.equals("R")) {
          pos = 9;
        } else if (right.equals("Y")){
          pos = 10;
        } else {
          pos = 11;
        }
      } else if (up.equals("R")){
        if (right.equals("W")) {
          pos = 12;
        } else if(right.equals("B")) {
          pos = 13;
        } else if (right.equals("Y")){
          pos = 14;
        } else {
          pos = 15;
        }
      } else if (up.equals("B")) {
        if (right.equals("W")) {
          pos = 16;
        } else if (right.equals("O")) {
          pos = 17;
        } else if (right.equals("Y")){
          pos = 18;
        } else {
          pos = 19;
        }
      } else if (up.equals("Y")) {
        if (right.equals("G")) {
          pos = 20;
        } else if (right.equals("R")){
          pos = 21;
        } else if(right.equals("B")){
          pos = 22;
        } else {
          pos = 23;
        }
      }
      return pos;
    }
}
