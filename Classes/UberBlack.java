package Classes;

public class UberBlack extends Veiculo {
	
	private static double tarifaMinima = 6.00; 
	

	private boolean interiorPremium;
	private boolean rodasligaleve;
	private int nro_malas; 
	
	public UberBlack(String p, String ch, String c, int n_pass, String m, boolean at, String st, boolean ip, boolean rl, int nro ) {
		super(p, ch, c, n_pass, m, at, st);
		
		this.interiorPremium = ip;
		this.rodasligaleve = rl;
		this.nro_malas = nro;
		this.custoPorKm = 5.37;
		
	}


	public boolean isInteriorPremium() {
		return interiorPremium;
	}

	public void setInteriorPremium(boolean interiorPremium) {
		this.interiorPremium = interiorPremium;
	}

	public boolean isRodasligaleve() {
		return rodasligaleve;
	}

	public void setRodasligaleve(boolean rodasligaleve) {
		this.rodasligaleve = rodasligaleve;
	}

	public int getNro_malas() {
		return nro_malas;
	}

	public void setNro_malas(int nro_malas) {
		this.nro_malas = nro_malas;
	}
	
	//Metodos 
	@Override
	public double calcularCusto(double distancia) {
		double valor = custoPorKm * distancia;
		valor += tarifaMinima * nro_malas;
		return valor;
	}
}