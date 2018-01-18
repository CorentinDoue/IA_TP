import jess.Fact;
import jess.JessException;
import jess.RU;
import jess.Rete;
import jess.Value;
import jess.ValueVector;


public class Perturbation {
	
	private int maxValue;
	Rete r;
		
	
	public Perturbation(Rete r, int maxValue) {
		this.r = r;
		this.maxValue = maxValue;
	}

   public void nextPerturbation(){
	  ValueVector v = new ValueVector();
	  try {
		
		
		int i = (int)(Math.random() * 3);
		switch (i){
			case 0 :
				v.add(new Value ("valueChange",RU.SYMBOL));
				v.add(new Value ((int)(Math.random() * maxValue+1),RU.INTEGER));
				break;
			case 1 :
				v.add(new Value ("valueDelete",RU.SYMBOL));
				v.add(new Value ((int)(Math.random() * maxValue+1),RU.INTEGER));
				maxValue--;
				break;
			case 2 :
				v.add(new Value ("newValue",RU.SYMBOL));
				v.add(new Value ((int)(Math.random() * maxValue+1),RU.INTEGER));
				maxValue++;
				break;
		}
		
		Fact f = new Fact("Perturbation",r);
		f.setSlotValue("__data", new Value(v,RU.LIST));
		r.assertFact(f);
	} catch (JessException e) {
		e.printStackTrace();
	}
		  
   }
   
}
