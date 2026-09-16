public class ContaBanco {

	public String numConta;

	/**
	 * 1- cc-Conta corrente
	 * 2- cp-conta polpança
	 */
	protected int tipo;

	private String dono;

	private double saldo;

	private boolean status;

	private SistemaBanco sistemaBanco;

	/**
	 *  
	 */
	public ContaBanco() {

	}

	public void setNumConta(String numConta) {

	}

	public String getNumConta() {
		return null;
	}

	/**
	 * se 1:
	 * 	cc
	 * se 2:
	 * 	cp
	 */
	public void setTipo(int tipo) {

	}

	/**
	 * retorna cc se 1 ou cp se 2
	 */
	public String getTipo() {
		return null;
	}

	public void setDono(String dono) {

	}

	public String getDono() {
		return null;
	}

	public void setSaldo(double saldo) {

	}

	public double getSaldo() {
		return 0;
	}

	public void setStatus(boolean status) {

	}

	public boolean getStatus() {
		return false;
	}

	/**
	 * 1- cc +=50 reais
	 * 2 - cp+=150
	 * 
	 * status = true
	 */
	public void abrirConta(int tipo) {

	}

	/**
	 * só funciona se:
	 * saldo == 0
	 * status == true
	 */
	public void fecharConta() {

	}

	/**
	 * só funciona se:
	 * status == true 
	 * e
	 * saldo >0
	 * e
	 * saldo >= saque
	 */
	public void depositar(double valor) {

	}

	/**
	 * saldo-=valor
	 * se saldo <=0 erro
	 */
	public void sacar(double valor) {

	}

	/**
	 * cc-=12
	 * cp-=20
	 * por mês
	 * só se:
	 * saldo>0
	 */
	public void pagarMensalidade(int meses) {

	}

}
