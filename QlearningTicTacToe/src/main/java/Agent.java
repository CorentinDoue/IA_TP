/**
 * 
 */

/**
 * @author Nicolas
 *
 */
public abstract class Agent {

	Grid grid;
	String name;
	String symbol;
	/**
	 * 
	 */
	public Agent(Grid grid, String name, String symbol) {
		this.grid= grid;
		this.name=name;
		this.symbol=symbol;
	}
	
	/**
	 * Méthode appelée lorsque c'est au tour de l'agent de jouer.
	 */
	abstract boolean play();

}
