package cev.bancodocarlos;


import java.util.Scanner;

public class SistemaBanco {

	private Scanner teclado;
	private ContaBanco conta;

	/**
	 * construtor:
	 * abre scanner
	 * instancia nova contaBanco
	 */
	public SistemaBanco() {
            
        }

	/**
	 * 1 - Criar nova conta
	 * 2- Acessar conta Existente
	 * 3- sair
	 */
	public void exibirMenuPrincipal() {

	}

	/**
	 * se tipo==1 digito 55
	 * se tipo ==2 digito 67
	 */
	private boolean autenticador(String dono, String numConta) {
		return false;
	}

	/**
	 * verificador 
	 * ->
	 * true
	 * 1-ver saldo
	 * 2-realizar deposito
	 * 2-realizar saque
	 * 3- pagar mensalidade
	 * 4- fechar conta
	 * 5- voltar
	 * ->
	 * false
	 * ERRO
	 * 1-NOVA CONTA
	 */
	public void exibirMenuContaExistente() {

	}

	/**
	 * 1-nome
	 * 2- tipo da conta(
	 * 	1-cc
	 * 	2-cp
	 * )
	 * 
	 * envia informação para abrirConta(), setDono(), setTipo(), setNumConta().
	 */
	public void solicitarCriarConta() {

	}

	/**
	 * se tipo==1 digito 55
	 * se tipo ==2 digito 67
	 */
	private String gerarNumConta(int tipo) {
		return null;
	}

	/**
	 * 1- confirma
	 * 2- cancela
         * /////////// recebe um verificador da função fecharConta()
         * se 1 - conta excluida
         * se 2 - inexistente
         * se 3 - saldo em conta
         * se 4 - saldo negativo
	 */
	public void solicitarFechamentoDeConta() {

	}

	/**
	 * 1-valor
	 * 2-cancela
         * 
         * 
         * recebe 0 do deposito() se não tiver conta existente
         * e 1 se for um sucesso
	 */
	public void solicitarDeposito() {

	}

	/**
	 * mostra valor disponível
	 * se >0
	 * pede o valor que deseja sacar
	 * se retorno == 0
	 * mostra erro
         * se retorno ==  1
         * sucesso
         * se retorno == 2
         * saldo insuficiente
	 */
	public void solicitarSaque() {

	}

	/**
	 * mostra valor disponível
	 * mostra quantos em atraso e valor total
	 * se >0
	 * pede o valor que deseja sacar
	 * se <=0
	 * +1 atraso
	 * 
         * recebe 0 se n tem conta
         * recebe 1 se sucesso
         * recebe 2 se não tem saldo
         * 
	 * 1-pagar
	 * 2-dever esse mÊs
	 * 3-voltar
	 */
	public void solicitarPagamentoDeMensalidade() {

	}

	/**
	 * mostra o saldo
	 * 1-voltar
	 * 2-fazer depósito
	 * 3-fazer saque
	 */
	public void solicitarSaldo() {

	}

}
