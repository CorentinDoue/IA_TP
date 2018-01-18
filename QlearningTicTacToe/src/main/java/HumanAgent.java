import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Nicolas and Gauthier
 *
 */
public class HumanAgent extends Agent {

	/**
	 * Constructeur
	 * @param grid
	 * @param name
	 */
	public HumanAgent(Grid grid, String name, String symbol) {
		super(grid, name, symbol);
	}

	/**
	 * @see Agent#play()
	 */

	boolean play() {
		boolean continu =true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Agent "+ name + ", you play. Which cell do you choose?");
		String result = sc.nextLine();
		int x=0;
		while(x==0 || !grid.isEmptyCell(x))
		{
			try{
				x=Integer.parseInt(result);
				if (x==-1){
					return false;
				}
			}catch(NumberFormatException e){
				System.out.println("Agent "+ name + ", please enter a valid cell number:");
				result = sc.nextLine();
			}
		}
		grid.put(x, symbol);
		return continu;
	}

}
