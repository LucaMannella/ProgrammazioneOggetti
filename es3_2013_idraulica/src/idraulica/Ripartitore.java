package idraulica;

public class Ripartitore extends Split { //could extends Elemento{
	
	double proportions[];
	
	public Ripartitore(String nome, int num) {
		super(nome);
		super.outputs = new Elemento[num];
		this.proportions = new double[num];
		
		double p = (double)1/num*100;
		for(int i=0; i<num; i++) {
			this.proportions[i] = p;
		}
	}
	
	public int getNumeroUscite() {
		return super.outputs.length;
	}
	
	public void setProporzioni(double[] proporzioni) {
		int i;
		for(i=0; i<proportions.length && i<proporzioni.length; i++)
			proportions[i] = proporzioni[i];
		
		if(i<proportions.length)
			for(; i<proportions.length; i++)
				proportions[i] = 0;
	}
    
	public void connetti(Elemento elem, int uscita) {
    	if((uscita < 0) || (uscita > super.outputs.length)) {
    		System.err.println("LOG - Invalid input: "+uscita);
    		return;
    	}
    	
        if(uscita == 0) {
        	super.connetti(elem);
        }
        super.outputs[uscita] = elem;
	}
	
	public void simula(String indentation, double portata) {
		System.out.println(indentation+" | ");
		System.out.println(indentation+" element: "+name+" - inflow: "+portata+" cubic meters per second ");
		
		indentation += "---";
		int i=0;
		for(Elemento el : outputs) {
			if(el != null) {
				System.out.println(indentation+" Outflow"+i+": "+portata*proportions[i]/100+" cubic meters per second");
				super.outputs[i].simula(indentation+"---", portata*proportions[i]/100);
			}
			i++;
		}		
	}
	
}
