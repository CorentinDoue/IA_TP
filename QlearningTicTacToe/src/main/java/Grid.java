import java.util.*;

/**
 * @author Nicolas and Gauthier
 * The grid, a digital frontier...
 */
public class Grid {

	private ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
	
	/**
	 * Constructeur : initialise la grille
	 */
	public Grid() {
		matrix.add( new ArrayList<String>());
		matrix.get(0).add("1");
		matrix.get(0).add("2");
		matrix.get(0).add("3");
		matrix.add(new ArrayList<String>());
		matrix.get(1).add("4");
		matrix.get(1).add("5");
		matrix.get(1).add("6");
		matrix.add(new ArrayList<String>());
		matrix.get(2).add("7");
		matrix.get(2).add("8");
		matrix.get(2).add("9");
	}
	
	/**
	 * Getter sur le contenu d'une cellule
	 * @param x le numéro de la cellule
	 * @return le contenu
	 */
	public String getCell(int x)
	{
		if(x>=0 && x<=9)
			return matrix.get((x-1)/3).get((x-1)%3);
		return(null);
	}
	
	/**
	 * Retourne une copie de la matrice
	 * @return la copie
	 */
	public ArrayList<ArrayList<String>> getAllCells()
	{
		return new ArrayList<ArrayList<String>>(matrix);
	}
	
	/**
	 * Renvoie vrai si la case ne contient pas de X ou de O
	 * @param x le numéro de la cellule
	 * @return true si elle ne contient ni X ni O, false sinon.
	 */
	public boolean isEmptyCell(int x)
	{
		if(!getCell(x).equals("O") && !getCell(x).equals("X") && x>=1 && x<=9)
			return true;
		return false;
	}
	
	/**
	 * Vérifie si la partie est remportée
	 * @return
	 */
	public boolean isWon()
	{
        if(	getCell(1)==getCell(2) && getCell(2)==getCell(3) ||
                getCell(4)==getCell(5) && getCell(5)==getCell(6) ||
                getCell(7)==getCell(8) && getCell(8)==getCell(9) ||
                getCell(1)==getCell(4) && getCell(4)==getCell(7) ||
                getCell(2)==getCell(5) && getCell(5)==getCell(8) ||
                getCell(3)==getCell(6) && getCell(6)==getCell(9) ||
                getCell(1)==getCell(5) && getCell(5)==getCell(9) ||
                getCell(3)==getCell(5) && getCell(5)==getCell(7)
                ) return true;
        return false;
	}

	/**
	 * Vérifie si il y a égalité
	 * @return
	 */
	public boolean isFull()
	{
        if(	!isEmptyCell(1) &&
                !isEmptyCell(2) &&
                !isEmptyCell(3) &&
                !isEmptyCell(4) &&
               !isEmptyCell(5) &&
                !isEmptyCell(6) &&
               !isEmptyCell(7) &&
                !isEmptyCell(8) &&
                !isEmptyCell(9)) return true;
        return false;
	}
	
	/**
	 * Ajoute une String à l'emplacement indiqué si c'est un chiffre ou une marque
	 * @param x emplacement
	 * @param s nouvelle valeur
	 */
	public void put(int x, String s)
	{
		Collection<String> collection = new ArrayList<String>(Arrays.asList(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "X", "O" }));
		if(collection.contains(s))
			matrix.get((x-1)/3).set((x-1)%3,s);
	}
	
	/**
	 * @return une chaine représentant la grille
	 */
	public String toString()
	{
		return 	  "-------------\n| " + getCell(1) + " | " + getCell(2) + " | " + getCell(3) + " |\n"
				+ "-------------\n| " + getCell(4) + " | " + getCell(5) + " | " + getCell(6) + " |\n"
				+ "-------------\n| " + getCell(7) + " | " + getCell(8) + " | " + getCell(9) + " |\n"
				+ "-------------\n";
	}


	public void reset(){
		matrix.get(0).set(0,"1");
		matrix.get(0).set(1,"2");
		matrix.get(0).set(2,"3");
		matrix.get(1).set(0,"4");
		matrix.get(1).set(1,"5");
		matrix.get(1).set(2,"6");
		matrix.get(2).set(0,"7");
		matrix.get(2).set(1,"8");
		matrix.get(2).set(2,"9");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Grid grid = (Grid) o;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(grid.getMatrix().get(i).get(j)!=matrix.get(i).get(j)){
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public int hashCode() {

		return Objects.hash(matrix);
	}

	public Grid copy(){
		Grid grid = new Grid();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				grid.put((i*3)+1+j,matrix.get(i).get(j));
			}
		}
		return grid;
	}

	public List<Integer> freeMove(){
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (matrix.get(i).get(j)!="X"&&matrix.get(i).get(j)!="O")
				list.add(Integer.parseInt(matrix.get(i).get(j)));
			}
		}
		return list;
	}

	public ArrayList<ArrayList<String>> getMatrix() {
		return matrix;
	}
}
