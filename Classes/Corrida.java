package Classes;

public class Corrida {
	
	//Requisito Extra - Taxa de cancelamento. Se o cliente cancelar uma corrida que solicitou terá de pagar uma taxa para UberLand
	
	private static double taxa = 2.50;
	
	private static double valorFixoUberland = 0.6;  // UberLand fica com 60%, motorista com 40%
	
	private Cliente cliente;
	private Motorista motorista;
	private Veiculo veiculo;
	
	private String origem;
	private String destino;
	private String DataCorrida;
	private String horaCorrida;
	private String horarioChegada;
	private String horarioFinal;
	private String status;
	private String formaPagamento;
	
	private double distancia;
	private double duracaoViagem;
	private double valorTotal;
	private double valorExtra;
	private double valorUberLand;
	private double valorMotorista;
	
	public Corrida (Cliente cli, Veiculo v, String or, String dest, String data, String hora ) { //Construtor que recebe cliente e veículo
		this.cliente = cli;
		this.veiculo = v;
		this.DataCorrida = data;
		this.horaCorrida = hora;
		this.origem = or;
		this.destino = dest;
		this.status = "SOLICITADA";
	
	
		
	}

	public String getDataCorrida() {
		return DataCorrida;
	}

	public void setDataCorrida(String dataCorrida) {
		DataCorrida = dataCorrida;
	}

	public String getHoraCorrida() {
		return horaCorrida;
	}

	public void setHoraCorrida(String horaCorrida) {
		this.horaCorrida = horaCorrida;
	}

	public String getHorarioChegada() {
		return horarioChegada;
	}

	public void setHorarioChegada(String horarioChegada) {
		this.horarioChegada = horarioChegada;
	}

	public String getHorarioFinal() {
		return horarioFinal;
	}
	
	

	public void setHorarioFinal(String horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		if(distancia > 0) {
		this.distancia = distancia;
		}
		
	}
		

	public double getDuracaoViagem() {
		return duracaoViagem;
	}

	public void setDuracaoViagem(double duracaoViagem) {
		this.duracaoViagem = duracaoViagem;
	}

	public double getValorTotal() {
		return valorTotal;
	}


	public double getValorExtra() {
		return valorExtra;
	}

	public void setValorExtra(double valorExtra) {
		if(valorExtra >= 0) {
		this.valorExtra = valorExtra;
		} else {
		
		this.valorExtra = 0; // Se o valor for inválido o padrão será 0 
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public double getValorUberLand() {
		return valorUberLand;
	}


	public double getValorMotorista() {
		return valorMotorista;
	}
	
	// ADICIONAR:
	public Cliente getCliente() {
	    return cliente;
	}

	public Motorista getMotorista() {
	    return motorista;
	}

	public Veiculo getVeiculo() {
	    return veiculo;
	}

	public String getOrigem() {
	    return origem;
	}

	public String getDestino() {
	    return destino;
	}
	
	//Métodos
	
	public void iniciarCorrida(Motorista mot, String chegada) {
		this.motorista = mot;
		this.horarioChegada = chegada;
		this.status = "EM ANDAMENTO";
	}
	
	public void finalizarCorrida(double dist, double tempoDuracao, String tempoFinal) {
		this.distancia = dist;
		this.duracaoViagem = tempoDuracao;
		this.horarioFinal = tempoFinal;
		this.status = "FINALIZADA";
		
		
	}
	
	
	public void cancelarPorClienteDuranteViagem()  { //Método que implementa o atributo extra
		
		this.status = "CANCELADA DURANTE A VIAGEM";
		this.valorTotal = taxa;
		distribuirPorPorcentagem();
	}
	
	public void distribuirPorPorcentagem() { // Calcula os valores para Uberland e o motorista
        if(valorTotal >= 0) {
            this.valorUberLand = valorTotal * valorFixoUberland;
            this.valorMotorista = valorTotal - valorUberLand;
        } else {
            this.valorUberLand = 0;
            this.valorMotorista = 0;
        }
    }
	
	public void cancelaPorCliente() { //Cliente que Cancela a corrida
		
		this.status = "Corrida Cancelada Pelo Cliente";
		
	}
	
	public void cancelaPorMotorista() { //Motorista cancela a corrida
		
		this.status = "Corrida Cancelada Pelo Motorista";
		
	}
	
	 public void calcularValorTotal() {
	        if(veiculo != null && distancia > 0) {
	            double custo = veiculo.calcularCusto(distancia);
	            this.valorTotal = custo + valorExtra;
	        }
	    }
	
	public void encerrarCorrida(double dist, double duracao, String horarioF) {
	    this.finalizarCorrida(dist, duracao, horarioF);
	    this.calcularValorTotal(); // Já usa this.valorExtra que foi setado antes
	    this.distribuirPorPorcentagem();
	    
	    if(cliente != null) {
	        cliente.incrementaCorrida(); // Incrementa o número de corridas
	    }
	}
	
    public void encerrarCorridaComExtra(double distancia, double duracao, String horarioFinal, double valorExtra) {
        this.setValorExtra(valorExtra);
        this.encerrarCorrida(distancia, duracao, horarioFinal);
    }
	
	public void definirPagamento(String forma) {
		
		this.formaPagamento = forma;
		
	}
	
	
	
	
	
}