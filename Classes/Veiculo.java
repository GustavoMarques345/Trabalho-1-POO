package Classes;

public abstract class Veiculo {
	
	protected double custoPorKm; // Atributos que serão usados nas classes
	private String placa;
	private String chassi;
	private String cor;
	private int nro_passageiros;
	private String marca;
	private boolean ativado; // Indoca se o veículo está ativado ou não
	private String status;
	
	public Veiculo(String p, String ch, String c, int n_pass, String m, boolean at, String st) {
        this.placa = p;
        this.chassi = ch;
        this.cor = c;
        this.nro_passageiros = n_pass;
        this.marca = m;
        this.ativado = at;
        this.status = st;
    }
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPlaca() {
		return placa;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getChassi() {
		return chassi;
	}

	

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getNro_passageiros() {
		return nro_passageiros;
	}

	public void setNro_passageiros(int nro_passageiros) {
		this.nro_passageiros = nro_passageiros;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getMarca() {
		return marca;
	}

	

	public boolean isAtivado() {
		return ativado;
	}

	public void setAtivado(boolean ativado) {
		this.ativado = ativado;
	}
	
	
	public String getStatus() {
	    return status;
	}

	public void setStatus(String status) {
	    this.status = status;
	}

	
	//Métodos
	public void ativar() { // Veículo ativado
		ativado = true;
	}
	
	public void desativar() {
		ativado = false;
	}
	
	public void disponivel() {
	    this.status = "Disponivel";
	}

	public void emViagem() {
	    this.status = "Em viagem";
	}

	public void naoDisponivel() {
	    this.status = "Nao disponivel";
	}

	public void finalizandoViagem() {
	    this.status = "Finalizando viagem";
	}
	
	
	
	public abstract double calcularCusto(double distancia); 

}