public class Cube {
  public String threeCycleBottomLayerSide(int interchange, int oddPiece) {
	String solution = "";
	    
	    String interchangeMove = (interchange == 1) ? "U " : "U' ";
	    solution += interchangeMove;
	    
	    String oddPieceSolution = "";
	    
	    boolean isLeft = (oddPiece % 4 == 3) ? true : false;
	    int numMoves;
	    
	    if(isLeft) {
	        numMoves = ((interchange == 1) ? 4 : 1) - oddPiece / 4;
	    } else {
	        numMoves = ((interchange == 1) ? 1 : 2) - oddPiece / 4;
	    }
	    
	    
	    switch(numMoves) {
	        case -1:
	            oddPieceSolution += "D' ";
	            break;
	        case -3:
	            oddPieceSolution += "D ";
	            break;
	        case -2: 
	            oddPieceSolution += "D2 ";
	            break;
	        case 1:
	            oddPieceSolution += "D ";
	            break;
	        case 2: 
	            oddPieceSolution += "D2 ";
	            break;
	        case 3:
	            oddPieceSolution += "D' ";
	            break;
	    }
	    
	    if(interchange == 1) {
	        if(isLeft) {
	            oddPieceSolution += "F D' F' ";
	        } else {
	            oddPieceSolution += "R' D R ";
	        }
	    } else {
	        if(isLeft) {
	            oddPieceSolution += "R D' R' ";
	        } else {
	            oddPieceSolution += "B' D B ";
	        }
	    }
	    solution += oddPieceSolution;
	    
	    solution += reverse(interchangeMove);
	    solution += reverse(oddPieceSolution);
	    
	    return solution;
	} 
	
	public String threeCycleBottomLayer(int interchange, int oddPiece) {
	    String solution = "";
	    String interchangeMove = (interchange == 1) ? "U " : "U' ";
	    solution += interchangeMove;
	    
	    String oddPieceSolution = "";
	    
	    int numMoves = ((interchange == 1) ? 1 : 2) - oddPiece % 4;
	    switch(numMoves) {
	        case -1:
	            oddPieceSolution += "D' ";
	            break;
	        case -3:
	            oddPieceSolution += "D ";
	            break;
	        case -2: 
	            oddPieceSolution += "D2 ";
	            break;
	        case 1:
	            oddPieceSolution += "D ";
	            break;
	        case 2: 
	            oddPieceSolution += "D2 ";
	            break;
	        case 3:
	            oddPieceSolution += "D' ";
	            break;
	    }
	    
	    if(interchange == 1) {
	        oddPieceSolution += "R2 D' R2 D R2 ";
	    } else {
	        oddPieceSolution += "R2 D R2 D' R2 ";
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
	            inverseLastMove = alg.substring(alg.length() - 3);
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
