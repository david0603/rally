
/**
 * Accepts an integer and prints the integers from 0 to that input integer in a spiral format.
 */
public class Exercise3{
	//Spiral direction
	private final String LEFT = "left";
	private final String RIGHT = "right";
	private final String UP = "up";
	private final String DOWN = "down";
	public static void main(String[] args) throws Exception{
		Exercise3 exercise3 = new Exercise3();
		//testing
		exercise3.spiralNumbers(84);
	}
	/**
	 * 
	 * @param input The starting number for the spiral
	 * @throws Exception
	 */
	public void spiralNumbers(int input) throws Exception{
		//error checking, I'd probably create a custom error class for an enterprise app
		if(input<0){
			throw new Exception("Input must be greater than zero");
		}
		//used for formatting
		int maxLength = String.valueOf(input).length();
		//add one to account for zero
		int arrayDim = (int) Math.ceil(Math.sqrt(input+1));
		String[][] answer = new String[arrayDim][arrayDim];		
		//find out where zero goes and the spiral starts
		int xcoord=(int) (Math.ceil(arrayDim/2.0)-1);
		int ycoord=(int) (Math.ceil(arrayDim/2.0)-1);
		//going right from zero per the example in the spec
		String direction = RIGHT;
		//setting the start of the spiral
		answer[xcoord][ycoord]="0";
		//used to keep track of directional changes
		int nextTurn = 1;
		for (int x = 1; x<=input; x++){
			if(RIGHT.equals(direction)){
				xcoord++;
				if(x == nextTurn){
					nextTurn = (int) (x + Math.ceil(Math.sqrt(x)));
					direction = DOWN;
				}
			}
			else if(DOWN.equals(direction)){
				ycoord++;
				if(x == nextTurn){
					nextTurn = (int) (x + Math.ceil(Math.sqrt(x)));
					direction = LEFT;
				}
			}	
			else if(LEFT.equals(direction)){
				xcoord--;
				if(x == nextTurn){
					nextTurn = (int) (x + Math.ceil(Math.sqrt(x)));
					direction = UP;
				}
			}	
			else if(UP.equals(direction)){
				ycoord--;
				if(x == nextTurn){
					nextTurn = (int) (x + Math.ceil(Math.sqrt(x)));
					direction = RIGHT;
				}
			}
			answer[xcoord][ycoord]=Integer.toString(x);
		}
		printAnswer(answer, maxLength);
	}
	private void printAnswer(String[][] answer, int maxLength){
		for(int y = 0; y<answer.length; y++){
			for(int x = 0; x<answer.length; x++){
				//replace null entires with empty string
				if(null==(answer[x][y])){
					answer[x][y]="";
				}
				int existingLength = answer[x][y].length();
				//corrects formatting for string of different lengths
				while(existingLength <= maxLength){
					answer[x][y]+=" ";
					existingLength++;
				}
				System.out.print(answer[x][y]);
			}
			System.out.println();
		}
	}
}