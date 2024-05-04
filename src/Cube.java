public class Cube {
  private Move U = new Move("U"), UPrime = new Move("U'"), R = new Move("R"),
    RPrime = new Move("R'"), R2 = new Move("R2"), L = new Move("L"), LPrime = new Move("L'"), 
    L2 = new Move("L2"), F = new Move("F"), FPrime = new Move("F'"), F2 = new Move("F2"), B = new Move("B"),
    BPrime = new Move("B'"), D = new Move("D"), DPrime = new Move("D'"), D2 = new Move("D2"); 
  
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
        if (moveID.substring(moveID.length() - 1).equals("'")) {
          reversedMove = moveID.substring(0, 1);
        } else if (moveID.length() == 2) {
          reversedMove = moveID;
        } else {
          reversedMove = moveID + "'";
        }
        reversedAlg[reversedAlg.length - i - 1] = new Move(reversedMove);
      }
      return reversedAlg;
    }
    
    /**
     * @param pos the position of the intended pieces
     * @return the moves to setup the corner swap
     */
    public Move[] setup(int pos) {
      Move[][] setups = {{U}, {}, {}, {BPrime, UPrime, B}, {L, F}, {F}, {LPrime, F}, 
      {L2, F}, {FPrime, D, FPrime}, {F2, D, FPrime}, {F, D, FPrime}, {D, FPrime},
      {F, DPrime, F2}, {}, {D2, RPrime, D, R}, {FPrime}, {}, {L2, U, LPrime, UPrime}, {L, U}, 
      {DPrime, FPrime}, {F2}, {DPrime, F2}, {D2, F2}, {D, F2}};

      for (int i = 0; i < setups.length; i++) {
        if(pos == i && pos != 1 &&  pos != 13 && pos != 16) {
          return setups[i];
        }
      }
      int unsolvedPos = findUnsolvedPiece();
      return setup(unsolvedPos);
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
