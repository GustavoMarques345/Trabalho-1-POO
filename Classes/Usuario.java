package Classes;

public class Usuario {
	
	private String nome;
	private String cpf; 
	private String dataNasc;
	protected double somaAvaliacao; // Atributo para a soma de avaliações que o usuário pode receber
	protected int qtdAvaliacoes; // Atributo para a quantidade de avaliações
	protected double media; // Armazena a média das notas
	protected int nroCorrida; // Quantidade de corrida 
	
	public Usuario(String n, String cp, String data) {
	    this.nome = n;
	    this.cpf = cp;
	    this.dataNasc = data;
	    this.somaAvaliacao = 0;
	    this.qtdAvaliacoes = 0;
	    this.media = 0;
	    this.nroCorrida = 0;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	
	public void setDatanasc(String data) {
		this.dataNasc = data;
	}
	
	
	public String getDatanasc() {
		return dataNasc;
	}

	public double getSomaAvaliacao() {
		return somaAvaliacao;
	}

	public void setSomaAvaliacao(double somaAvaliacao) {
		this.somaAvaliacao = somaAvaliacao;
	}

	public int getQtdAvaliacoes() {
		return qtdAvaliacoes;
	}

	public void setQtdAvaliacoes(int qtdAvaliacoes) {
		this.qtdAvaliacoes = qtdAvaliacoes;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public int getNroCorrida() {
		return nroCorrida;
	}

	public void setNroCorrida(int nroCorrida) {
		this.nroCorrida = nroCorrida;
	}
	
	
	
	// Métodos
	
	public void addAvaliacao(double valor) { // Adciona as avaliações e calcula a média
		if(valor >= 0) {
			somaAvaliacao += valor;
			qtdAvaliacoes ++;
			media = somaAvaliacao / qtdAvaliacoes;
		}
	}
	
	
	public void incrementaCorrida() { 
		nroCorrida ++; 
	}
	
	//Algorítmo para validar o CPF - VERSÃO CORRIGIDA
    public static boolean validar(String CPF) {
        CPF = remover(CPF);
        
        // Verifica se tem 11 dígitos
        if (CPF.length() != 11) {
            return false;
        }
        
        // Verifica se todos os dígitos são iguais
        boolean todosIguais = true;
        for (int i = 1; i < CPF.length(); i++) {
            if (CPF.charAt(i) != CPF.charAt(0)) {
                todosIguais = false;
                break;
            }
        }
        if (todosIguais) {
            return false;
        }
        
        // Converte para array de inteiros
        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = Character.getNumericValue(CPF.charAt(i));
        }
        
        // Cálculo do primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += digitos[i] * (10 - i);
        }
        int resto = soma % 11;
        int primeiroDigito = (resto < 2) ? 0 : 11 - resto;
        
        if (primeiroDigito != digitos[9]) {
            return false;
        }
        
        // Cálculo do segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += digitos[i] * (11 - i);
        }
        resto = soma % 11;
        int segundoDigito = (resto < 2) ? 0 : 11 - resto;
        
        return segundoDigito == digitos[10];
    }

    private static String remover(String CPF) {
        if(CPF == null) {
            return "";
        }
        return CPF.replace(".", "").replace("-", "").replace(" ", "");
    }
	
}