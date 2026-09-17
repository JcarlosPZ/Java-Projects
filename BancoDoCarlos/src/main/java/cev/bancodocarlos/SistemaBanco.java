package cev.bancodocarlos;


import java.util.Scanner;

public class SistemaBanco {

	private Scanner teclado;
	private ContaBanco conta;
        int option;

	/**
	 * construtor:
	 * abre scanner
	 * instancia nova contaBanco
	 */
	public SistemaBanco() {
            this.teclado = new Scanner(System.in);
            this.conta = new ContaBanco();
        }

	/**
	 * 1 - Criar nova conta
	 * 2- Acessar conta Existente
	 * 3- sair
	 */
	public void exibirMenuPrincipal() {
            System.out.println("=====================");
            System.out.println("BEM-VINDO AO BANCO!");
            System.out.println("=====================\n \n");
            System.out.println("Selecione uma opçao:\n");
            do{
                System.out.println("1- Criar nova conta");
                System.out.println("2 - Acessar conta existente");
                System.out.println("3 - Encerrar");
                System.out.println("\n=====================");
                System.out.println("[OPÇÃO]: ");
                option = teclado.nextInt();
                switch(option){
                    case 1 -> solicitarCriarConta();
                    case 2 -> solicitarLoggin();
                    case 3 -> System.out.print("Obrigado\nVolte sempre!");
                    default -> System.out.println("Erro\nEscolha uma opção válida");
                }
            }while (option !=1 && option !=2 && option !=3);
	}

        private void solicitarLoggin(){
            System.out.println("=====================");
            System.out.println("ACESSE SUA CONTA");
            System.out.println("=====================\n \n");
            
            teclado.nextLine();
            
            String nome,numConta;
            boolean autenticado = false;
            do{
                System.out.println("Nome:");
                nome = teclado.nextLine();
                System.out.println("Numero da conta:");
                numConta = teclado.nextLine();
                autenticado = autenticador(nome, numConta);
                if(!autenticado){
                    System.out.println("[ERRO] NOME ou NUMERO DA CONTA  incorretos!\nTente novamente");
                }
            } while(!autenticado);
            System.out.println("[SUCESSO] Bem vindo " + nome.toUpperCase() + "!\n");
            exibirMenuPrincipal();
        }
	/**
	 * se tipo==1 digito 55
	 * se tipo ==2 digito 67
	 */
	private boolean autenticador(String nome, String numConta) {
            return nome.equalsIgnoreCase(this.conta.getDono()) && numConta.equals(this.conta.getNumConta());
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
