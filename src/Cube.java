public class Cube {
  public String threeCycleBottomLayerSide(int interchange, int oddPiece) {
	    String solution = "";
	    
	    String interchangeMove = "";
	    if(interchange == 1) {
	        interchangeMove = "U ";
	    } else {
	        interchangeMove = "U' ";
	    }
	    solution += interchangeMove;
	    
	    String oddPieceSolution = "";
	    int numMoves = ((interchange == 1) ? 1 : 2) - oddPiece / 4;
	    if(numMoves < 0) {
	        for(int i = 0; i > numMoves; i--) {
	            oddPieceSolution += "D' ";
	        }
	    } else if (numMoves > 0){
	        for(int i = 0; i < numMoves; i++) {
	            oddPieceSolution += "D ";
	        }
	    }
	    
	    if(interchange == 1) {
	        oddPieceSolution += "R' D R ";
	    } else {
	        oddPieceSolution += "B' D B ";
	    }
	    solution += oddPieceSolution;
	    
	    solution += reverse(interchangeMove);
	    solution += reverse(oddPieceSolution);
	    
	    return solution;
	} 
	
	public String reverse(String alg) {
	    String reversedAlg = "";
	    
	    while(alg.length() > 0) {
	        String inverseLastMove = "";
	        int removeLength = 0;
	        
	        if(alg.substring(alg.length() - 2).equals("' ")) {
	            inverseLastMove = alg.substring(alg.length() - 3, alg.length() - 2) + " ";
	            removeLength = 3;
	        } else if(alg.substring(alg.length() - 2).equals("2 ")) {
	            inverseLastMove = alg.substring(alg.length() - 2);
	            removeLength = 3;
	        } else {
	            inverseLastMove = alg.substring(alg.length() - 2, alg.length() - 1) + "' ";
	            removeLength = 2;
	        }
	        
	        reversedAlg += inverseLastMove;
	        alg = alg.substring(0, alg.length() - removeLength);
	    }
	    
	    return reversedAlg;
	}
}
