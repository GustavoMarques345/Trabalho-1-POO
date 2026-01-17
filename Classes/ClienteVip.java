package Classes;

public class ClienteVip extends Cliente {
	
	private double desconto; // Atributo que recebe o ddesconto do cliente Vip.
	
	public ClienteVip(Cliente cli, double desc) {
		super(cli.getNome(), cli.getCpf());
		this.desconto = desc;
	}


	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	public double getDesconto() {
		return desconto;
	}
	

}
