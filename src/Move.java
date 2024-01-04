public class Move{
  public static String[][] pieces = {
    {"W", "W", "W", "W"},
    {"O", "O", "O", "O"},
    {"G", "G", "G", "G"},
    {"R", "R", "R", "R"},
    {"B", "B", "B", "B"},
    {"Y", "Y", "Y", "Y"},
  };

    private String id;

    public Move(String initId) {
        id = initId;
    }

    public String getID() {
        return id;
    }

    public void execute(boolean shouldPrint) {
        switch (id) {
            case "U":
                U();
                break;
            case "UPrime":
                UPrime();
                break;
            case "U2":
                U2();
                break;
            case "R":
                R();
                break;
            case "RPrime":
                RPrime();
                break;
            case "R2":
                R2();
                break;
            case "L":
                L();
                break;
            case "LPrime":
                LPrime();
                break;
            case "L2":
                L2();
                break;
            case "F":
                F();
                break;
            case "FPrime":
                FPrime();
                break;
            case "F2":
                F2();
                break;
            case "B":
                B();
                break;
            case "BPrime":
                BPrime();
                break;
            case "B2":
                B2();
                break;
            case "D":
                D();
                break;
            case "DPrime":
                DPrime();
                break;
            case "D2":
                D2();
                break;
        }
        if (shouldPrint) System.out.print(id + " ");
    }

    public void U() {
        String pieceAt1 = pieces[0][0], pieceAt2 = pieces[0][1], pieceAt3 = pieces[0][2], pieceAt4 = pieces[0][3], pieceAt5 = pieces[1][0], pieceAt6 = pieces[1][1], pieceAt9 = pieces[2][0], pieceAt10 = pieces[2][1], pieceAt13 = pieces[3][0], pieceAt14 = pieces[3][1], pieceAt17 = pieces[4][0], pieceAt18 = pieces[4][1];
        pieces[0][0] = pieceAt4;
        pieces[0][1] = pieceAt1;
        pieces[0][2] = pieceAt2;
        pieces[0][3] = pieceAt3;
        pieces[1][0] = pieceAt9;
        pieces[1][1] = pieceAt10;
        pieces[2][0] = pieceAt13;
        pieces[2][1] = pieceAt14;
        pieces[3][0] = pieceAt17;
        pieces[3][1] = pieceAt18;
        pieces[4][0] = pieceAt5;
        pieces[4][1] = pieceAt6;
      }
    
      public void UPrime() {
        U();
        U();
        U();
      }
    
      public void U2() {
        U();
        U();
      }
    
      public void R() {
        String topUp = pieces[0][1], topDown = pieces[0][2], backUp = pieces[4][0], backDown = pieces[4][3],bottomUp = pieces[5][1], bottomDown = pieces[5][2],frontUp = pieces[2][1], frontDown = pieces[2][2], right0 = pieces[3][0], right1 = pieces[3][1], right2 = pieces[3][2], right3 = pieces[3][3];
        pieces[3][0] = right3;
        pieces[3][1] = right0;
        pieces[3][2] = right1;
        pieces[3][3] = right2;
        pieces[0][1] = frontUp;
        pieces[0][2] = frontDown;
        pieces[4][0] = topDown;
        pieces[4][3] = topUp;
        pieces[5][1] = backDown;
        pieces[5][2] = backUp;
        pieces[2][1] = bottomUp;
        pieces[2][2] = bottomDown;
      }
    
      public void RPrime() {
        R();
        R();
        R();
      }
    
      public void R2() {
        R();
        R();
      }
    
      public void F(){
        String front0 = pieces[2][0], front1 = pieces[2][1], front2 = pieces[2][2], front3 = pieces[2][3], topLeft = pieces[0][3], topRight = pieces[0][2], rightTop = pieces[3][0], rightBottom = pieces[3][3], bottomLeft = pieces[5][0], bottomRight = pieces[5][1], leftTop = pieces[1][1], leftBottom = pieces[1][2];
        pieces[2][0] = front3;
        pieces[2][1] = front0;
        pieces[2][2] = front1;
        pieces[2][3] = front2;
        pieces[0][3] = leftBottom;
        pieces[0][2] = leftTop;
        pieces[3][0] = topLeft;
        pieces[3][3] = topRight;
        pieces[5][0] = rightBottom;
        pieces[5][1] = rightTop;
        pieces[1][1] = bottomLeft;
        pieces[1][2] = bottomRight;
      }
    
      public void FPrime() {
        F();
        F();
        F();
      }
    
      public void F2() {
        F();
        F();
      }
    
      public void D() {
        String frontLeft = pieces[2][3], frontRight = pieces[2][2], rightFront = pieces[3][3], rightBack = pieces[3][2], backLeft = pieces[4][2], backRight = pieces[4][3], leftFront = pieces[1][2], leftBack = pieces[1][3], bottom0 = pieces[5][0], bottom1 = pieces[5][1], bottom2 = pieces[5][2], bottom3 = pieces[5][3];
        pieces[5][0] = bottom3;
        pieces[5][1] = bottom0;
        pieces[5][2] = bottom1;
        pieces[5][3] = bottom2;
        pieces[2][3] = leftBack;
        pieces[2][2] = leftFront;
        pieces[3][3] = frontLeft;
        pieces[3][2] = frontRight;
        pieces[4][2] = rightBack;
        pieces[4][3] = rightFront;
        pieces[1][3] = backRight;
        pieces[1][2] = backLeft;
      }
    
      public void DPrime() {
        D();
        D();
        D();
      }
    
      public void D2() {
        D();
        D();
      }
    
      public void L() {
        String frontTop = pieces[2][0], frontBottom = pieces[2][3], topFront = pieces[0][3], topBack = pieces[0][0], backTop = pieces[4][1], backBottom = pieces[4][2], bottomFront = pieces[5][0], bottomBack = pieces[5][3], left0 = pieces[1][0], left1 = pieces[1][1], left2 = pieces[1][2], left3 = pieces[1][3];
        pieces[1][0] = left3;
        pieces[1][1] = left0;
        pieces[1][2] = left1;
        pieces[1][3] = left2;
        pieces[0][0] = backBottom;
        pieces[0][3] = backTop;
        pieces[2][0] = topBack;
        pieces[2][3] = topFront;
        pieces[5][0] = frontTop;
        pieces[5][3] = frontBottom;
        pieces[4][1] = bottomBack;
        pieces[4][2] = bottomFront; 
      }
    
      public void LPrime() {
        L();
        L();
        L();
      }
    
      public void L2() {
        L();
        L();
      }
    
      public void B() {
        String rightTop = pieces[3][1], rightBottom = pieces[3][2], bottomRight = pieces[5][2], bottomLeft = pieces[5][3], 
        leftBottom = pieces[1][3], leftTop = pieces[1][0], topRight = pieces[0][1], topLeft = pieces[0][0], back0 = pieces[4][0], 
        back1 = pieces[4][1], back2 = pieces[4][2], back3 = pieces[4][3];
        pieces[4][0] = back3;
        pieces[4][1] = back0;
        pieces[4][2] = back1;
        pieces[4][3] = back2;
        pieces[0][0] = rightTop;
        pieces[0][1] = rightBottom;
        pieces[1][0] = topRight;
        pieces[1][3] = topLeft;
        pieces[5][3] = leftTop;
        pieces[5][2] = leftBottom;
        pieces[3][1] = bottomRight;
        pieces[3][2] = bottomLeft;
      }
    
      public void BPrime() {
        B();
        B();
        B();
      }
    
      public void B2() {
        B();
        B();
      }

      public static void printPieces() {
        for (int i = 0; i < pieces.length; i++) {
          for (int j = 0; j < pieces[i].length; j++) {
            System.out.print(pieces[i][j] + ", ");
          }
          System.out.println();
        }
      }
}
