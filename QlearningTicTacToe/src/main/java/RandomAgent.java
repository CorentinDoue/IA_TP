import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Nicolas and Gauthier
 *
 */
public class RandomAgent extends Agent {

	/**
	 * Constructeur
	 * @param grid
	 * @param name
	 */
	public RandomAgent(Grid grid, String name, String symbol) {
		super(grid, name, symbol);
	}

	/**
	 * @see Agent#play()
	 */
	@Override
	boolean play() {
		List<Integer> list = grid.freeMove();
		Random rd = new Random();
		int i = rd.nextInt(list.size());
		grid.put(list.get(i), symbol);
		return true;
	}

}
