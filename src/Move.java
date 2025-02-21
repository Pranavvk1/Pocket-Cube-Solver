class Cube{
  private String[][] pieces = {
    {"W", "W", "W", "W"},
    {"O", "O", "O", "O"},
    {"G", "G", "G", "G"},
    {"R", "R", "R", "R"},
    {"B", "B", "B", "B"},
    {"Y", "Y", "Y", "Y"},
  };

  // private int[] R = {0, 4, 5, 2};
  // private int[] F = {0, 3, 5, 1};


  public void revolveRight(int face) {
    String temp = pieces[face][3];
    for (int i = 3; i > 0; i--) {
      pieces[face][i] = pieces[face][i-1];
    }
    pieces[face][0] = temp;
  }

  public void revolveTwo(int[] faces) {
    String[] temp = new String[2];
    temp[0] = pieces[faces[9]][faces[10]];
    temp[1] = pieces[faces[9]][faces[11]];
    for(int i = 9; i > 0; i -= 3){
      pieces[faces[i]][faces[i + 1]] = pieces[faces[i - 3]][faces[i + 1]];
      pieces[faces[i]][faces[i + 2]] = pieces[faces[i - 3]][faces[i + 2]];
    }
    pieces[faces[0]][faces[1]] = temp[0];
    pieces[faces[0]][faces[2]] = temp[1];
  }

  public void R() {
    revolveRight(3);
    int[] faces = {0, 1, 2, 4, 3, 0, 5, 1, 2, 2, 1, 2};
    revolveTwo(faces);
  }

  public void L() {
    revolveRight(1);
    int[] faces = {2, 0, 3, 5, 0, 3, 4, 1, 2, 0, 0, 3};
    revolveTwo(faces);
  }

  public void U() {
    revolveRight(0);
    int[] faces = {4, 0, 1, 3, 0, 1, 2, 0, 1, 1, 0, 1};
    revolveTwo(faces);
  }

  public void D() {
    revolveRight(5);
    int[] faces = {1, 0, 1, 2, 0, 1, 3, 0, 1, 4, 0, 1};
    revolveTwo(faces);
  }

  public void F() {
    revolveRight(2);
    int[] faces = {0, 2, 3, 3, 0, 3, 5, 0, 1, 1, 1, 2};
  }

  public void printCube() {
    for(int i = 0; i < 6; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(pieces[i][j] + " ");
      }
      System.out.println();
    }
  }
}
