package Classes;

public class Cliente extends Usuario{
	
	private String email;
	private String nro_Celular;
	private String genero;
	private String forma_Pagamento;
	
	public Cliente (String n, String cp, String data, String em, String cel, String gen, String fp) {
		super(n, cp, data);
		this.email = em;
		this.nro_Celular = cel;
		this.genero = gen;
		this.forma_Pagamento = fp;
		
	}
	
	public Cliente(String nome, String cpf) { // Construtor com apenas nome e cpf
		super(nome, cpf, null);
	}
	
	public Cliente() {  // Construtor Default
		super(null, null, null);
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	public String getEmail() {
		return email;
	}
	

	public void setNro_Celular(String nro_Celular) {
		this.nro_Celular = nro_Celular;
	}
	
	public String getNro_Celular() {
		return nro_Celular;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	
	public void setForma_Pagamento(String forma_Pagamento) {
		this.forma_Pagamento = forma_Pagamento;
	}
	
	
	public String getForma_Pagamento() {
		return forma_Pagamento;
	}
	
	//Métodos: 
	
	
	//Regra para cliente se tornar Vip
	public ClienteVip promover(int corridas) {
	    if (this.getNroCorrida() >= corridas) {
	        double desconto = calcularDesconto();
	        return new ClienteVip(this, desconto);
	    }
	    return null; // Se não tiver corridas o suficiente retorna null
	}

	//Método para calcular o desconto -> A ideia é, a cada 50 corridas  o desconto aumenta, e tem um limite de até 20%. 
	//Funciona da seguinte forma: 50 corridas = 5% de desconto, 100 corridas = 10% de desconto, 150 corridas = 15 % ... 200 corridas = 20%
	
	public double calcularDesconto(){
		int qtd = this.getNroCorrida();
		
		if(qtd >= 200) {
			return 0.20;
		} else if(qtd >= 150) {
			return 0.15;
		}else if(qtd >= 100) {
			return 0.10;
		}else if(qtd >= 50) {
			return 0.05;
		}
		
		return 0.0;
	}
	

}