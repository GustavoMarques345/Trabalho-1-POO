package Classes;

public class UberX extends Veiculo{
	
	private static double tarifaMinima = 5.50;
	private boolean possuiAr; // Indica se possui ar condicionado;
	private boolean confortoBasico;
	
	public UberX(String p, String ch, String c, int n_pass, String m, boolean at, String st,  boolean possui, boolean conf) {
			super(p, ch, c, n_pass, m, at, st); // Ordem: placa, chassi, cor, n_pass, marca, ativado, status
				this.custoPorKm = 2.50;
				this.possuiAr = possui;
				this.confortoBasico = conf;
	}

	public boolean isPossuiAr() {
		return possuiAr;
	}

	public void setPossuiAr(boolean possuiAr) {
		this.possuiAr = possuiAr;
	}
	
	public boolean isConfortoBasico() {
		return confortoBasico;
	}

	public void setConfortoBasico(boolean conforto) {
		this.confortoBasico = conforto;
	}
	
	//Métodos 
	
	@Override
	public  double calcularCusto(double distancia) {
		double valor = custoPorKm * distancia;
			if(possuiAr == true || confortoBasico == true) {
				valor += tarifaMinima;
			}
			
		return valor;
	}

	
	
}