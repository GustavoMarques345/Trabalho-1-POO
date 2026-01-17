package Classes;

public class Motorista extends Usuario {
	
	private String endereco;
	private String cnh;
	private String nome_Social;
	private Veiculo veiculo; // Cada motorista possui um veiculo cadastrado
	private boolean ativo; //Método para ativar um motorista
	private String status; 

	public Motorista (String n, String cp, String data, String end, String c, String social, String st) {
		super(n, cp, data);
		this.endereco = end;
		this.cnh = c;
		this.nome_Social = social;
		this.status = st;
	}

	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}	
	
	public String getEndereco() {
		return endereco;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getCnh() {
		return cnh;
	}

	public void setNome_Social(String nome_Social) {
		this.nome_Social = nome_Social;
	}


	public String getNome_Social() {
		return nome_Social;
	}
	
	
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	//Métodos
	
	public void ativarMotorista() {
		this.ativo = true;
	}
	
	public void desativarMotorista() {
		this.ativo = false;
			if(veiculo != null) {
				veiculo.desativar();  // Desativa o veículo
			}
	}
	
	public void setStatus() {
	    this.status = "Disponivel";
	    	if(veiculo != null) {
	    		veiculo.disponivel();
	    }
	}	
	
	public void emViagem() {
	    this.status = "Em viagem";
	    	if(veiculo != null) {
	    		veiculo.emViagem();
	    }
	}
	
	public void naoDisp() {
	    this.status = "Nao disponivel";
	    	if(veiculo != null) {
	    		veiculo.naoDisponivel();
	    }
	}
	
	public void finalizando() {
	    this.status = "Finalizando viagem";
	    	if(veiculo != null) {
	    		veiculo.finalizandoViagem();
	    }
	}
	
	

}