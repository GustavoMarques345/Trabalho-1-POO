package Classes;

public class UberComfort extends Veiculo {
	
	private static double tarifaMinima = 6.80;
	
	private boolean espaçoExtra;
	private boolean bancoReclinavel;
	private boolean ar_dualzone;
	
	public UberComfort(String p, String ch, String c, int n_pass, String m, boolean at, String st, boolean ex, boolean br, boolean ad) {
		super(p, ch, c, n_pass, m, at, st);
			this.espaçoExtra = ex;
			this.bancoReclinavel = br;
			this.ar_dualzone = ad;
			this.custoPorKm = 3.00;
	}

	public boolean isEspaçoExtra() {
		return espaçoExtra;
	}

	public void setEspaçoExtra(boolean espaçoExtra) {
		this.espaçoExtra = espaçoExtra;
	}

	public boolean isBancoReclinavel() {
		return bancoReclinavel;
	}

	public void setBancoReclinavel(boolean bancoReclinavel) {
		this.bancoReclinavel = bancoReclinavel;
	}

	public boolean isAr_dualzone() {
		return ar_dualzone;
	}

	public void setAr_dualzone(boolean ar_dualzone) {
		this.ar_dualzone = ar_dualzone;
	}
	
	@Override
	public double calcularCusto(double distancia) {
		double valor = custoPorKm * distancia;
			if(ar_dualzone == true || espaçoExtra == true) {
				valor = valor + (2 * tarifaMinima);
			}
			
		return valor;
	}
	
	

}