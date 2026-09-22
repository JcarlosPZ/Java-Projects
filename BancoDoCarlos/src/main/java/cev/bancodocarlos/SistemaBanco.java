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
        String painel = """
                        ===========================================
                        ----------- Bem-Vindo ao Banco ------------
                        ===========================================
                        """;
        System.out.println(painel);
        do{
            String escolha = """
                                  Selecione uma das opções abaixo

                                  [1] -------- Criar uma nova conta
                                  [2] ----- Acessar conta existente
                                  [6] ---------------------Encerrar

                            ===========================================  
                             [OPÇÃO]:                                                      
                              """;
            System.out.print(escolha);
            option = teclado.nextInt();
            teclado.nextLine();
            
            switch(option){
                case 1 -> this.solicitarCriarConta();
                case 2 -> this.solicitarLoggin();
                case 3 -> System.out.print("Obrigado\nVolte sempre!");
                default -> System.out.println("Erro\nEscolha uma opção válida");
            }
        }while (option != 3);
    }

    private void solicitarLoggin(){
        String painel = """
                        ===========================================
                        ------------ Acesse sua conta -------------
                        ===========================================
                        """;
        System.out.println(painel);

        String nome,numConta;
        boolean autenticado = false;
        do{
            System.out.println("Nome:");
            nome = teclado.nextLine();
            System.out.println("Numero da conta:");
            numConta = teclado.nextLine();
            autenticado = autenticador(nome, numConta);
            if(!autenticado){
                String menu = """
                              ===========================================
                           ---[ERRO] NOME ou NUMERO DA CONTA  incorretos!---
                              Tente novamente ou retorne ao menu principal
                              -------------------------------------------
                                    Selecione uma das opções abaixo

                                    [1] -------------Tentar novamente
                                    [2] ---Retornar ao menu principal 
                              ===========================================                                                       
                              """;
            System.out.println(menu);
                
                int escolha = teclado.nextInt();
                teclado.nextLine();
                
                switch (escolha){
                    case 1 -> System.out.println("ATENÇÃO");
                    
                    case 2 -> {
                        return;
                    }
                    
                    default -> System.out.println("Tente Novamente");
                }
            }
        } while(!autenticado);
        System.out.println("[SUCESSO] Bem vindo " + nome.toUpperCase() + "!\n");
        this.exibirMenuContaExistente();
    }
    /**
     * se tipo==1 digito 55
     * se tipo ==2 digito 67
     */
    private boolean autenticador(String nome, String numConta) {
        return nome.equalsIgnoreCase(this.conta.getDono()) && numConta.equals(this.conta.getNumConta());
    }

    /**
     * 1-ver saldo
     * 2-realizar deposito
     * 2-realizar saque
     * 3- pagar mensalidade
     * 4- fechar conta
     * 5- voltar
     */
    public void exibirMenuContaExistente() {
        do{
            String escolha = """
                              ===========================================
                                      ---Olá, %s!---

                                    Selecione uma das opções abaixo

                                    [1] --------------------Ver Saldo
                                    [2] ------------Realizar depósito 
                                    [3] ---------------Realizar saque
                                    [4] ------------Pagar mensalidade 
                                    [5] ---------------Encerrar conta
                                    [6] -----------------------Voltar

                              ===========================================                                                       
                              """.formatted(this.conta.getDono());
            System.out.println(escolha);
            option = teclado.nextInt();
            teclado.nextLine();
            switch (option){
                case 1 -> this.solicitarSaldo();
                case 2 -> this.solicitarDeposito();
                case 3 -> this.solicitarSaque();
                case 4 -> this.solicitarPagamentoDeMensalidade();
                case 5 -> {
                    this.solicitarFechamentoDeConta();
                    return;
                }
                case 6 -> {
                    System.out.println("Deslogando e voltando ao menu principal...");
                    return;
                }
                default -> System.out.println("[ERRO] --- escolha uma opção válida");
            }
        }while(option != 6);
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

        String nome;
        
        String painel = """
                        ===========================================
                        ----------- CRIE AQUI SUA CONTA -----------
                        ===========================================
                        """;
        System.out.println(painel);

        do{
            System.out.println("Informe seu primeiro e último nome, sem espaços extras, para cadastro\n ou digite [0] para cancelar:\n");
            nome = teclado.nextLine();

            if(nome.equals("0")){
                System.out.println("=========== OPERAÇÃO CANCELADA ============");
                return;
            }
            
            String regexNome = "[A-Z][a-zA-Z][A-Z]?[a-z]*\\s[A-Z][a-zA-Z][A-Z]?[a-z]*";

                if (nome.matches(regexNome)) {
                    System.out.println("Cadastro realizado com sucesso!");
                    break; // Sai do do-while pois o nome é válido
                } else {
                    System.out.println("Nome Inválido, tente novamente\n");
                }

            } while (true);

        do{
            String escolha = """
                              ===========================================
                                    Selecione uma das opções abaixo

                                    [1] -------------- Conta Corrente
                                    [2] -------------- Conta Polpança 
                                    [3] -------------------- CANCELAR
                              ===========================================
                              """;
            System.out.println(escolha);

            option = teclado.nextInt();
            teclado.nextLine();
            
            
            if(option == 3){
                System.out.println("============ OPERAÇÃO CANCELADA ===========");
                return;
                
            }
            if(option<1 || option > 3){
                System.out.println("===== [ERRO] Escolha uma opção válida =====");
            }
        }while(option<1 || option>3);
        this.conta.setDono(nome);
        this.conta.abrirConta(option);
        this.conta.gerarNumConta(this.conta.getTipo());
        

        String relatorio = """
                           ===========================================
                           -------------Nova conta criada-------------
                           ===========================================
                                 Títular da conta---%s

                                 Típo da Conta ---------------%s

                                 Numero da Conta -------------%s

                                 valor das mensalidades ----R$%.2f


                             +++++++++++++++++++++++++++++++++++++++
                                 Saldo -------------------R$%.2f
                             +++++++++++++++++++++++++++++++++++++++
                           """.formatted(this.conta.getDono(), 
                                   this.conta.tipoString(),
                                   this.conta.getNumConta(), 
                                   this.conta.valorTotalMensalidade(this.conta.getTipo(),this.conta.getMensalidade()),
                                   this.conta.getSaldo()
                            );
        System.out.println(relatorio);
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
        String relatorio = """
                           ===========================================
                           --------------Status da conta--------------
                           ===========================================
                                 Títular da conta---%s

                                 Típo da Conta ---------------%s

                                 Numero da Conta -------------%s

                                 valor das mensalidades ---R$%.2f


                             +++++++++++++++++++++++++++++++++++++++
                                 Saldo -------------------R$%.2f
                             +++++++++++++++++++++++++++++++++++++++
                           """.formatted(this.conta.getDono(), 
                                   this.conta.tipoString(),
                                   this.conta.getNumConta(), 
                                   this.conta.valorTotalMensalidade(this.conta.getTipo(),this.conta.getMensalidade()),
                                   this.conta.getSaldo()
                            );
        System.out.println(relatorio);
        do{
            String escolha = """
                              ===========================================

                                    Selecione uma das opções abaixo

                                    [1] ---------------Encerrar conta
                                    [2] ------------CANCELAR OPERAÇÃO 

                              ===========================================                                                       
                              """;
            System.out.println(escolha);
            option = teclado.nextInt();
            teclado.nextLine();
            switch (option){
                case 1 -> {
                    int resultado = this.conta.fecharConta();

                    switch (resultado) {
                        case 1 -> {
                            System.out.println("[SUCESSO] Conta encerrada.");
                            return;
                        }
                        case 2 -> System.out.println("[ERRO] A conta já está fechada.");
                        case 3 -> System.out.println("[ERRO] Não é possível encerrar: há saldo na conta.");
                        case 4 -> System.out.println("[ERRO] Não é possível encerrar: há saldo negativo.");
                        case 5 -> System.out.println("[ERRO] Não é possível encerrar: há mensalidades em atraso.");
                    }
                }
                case 2 -> System.out.println("Retornando...");
                default -> System.out.println("[ERRO] --- escolha uma opção válida");
            }

        }while(option<1 || option>2);
        
        

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
        int result;
        String saldoEmConta = """
                              ===========================================
                              ----------------SALDO ATUAL----------------
                              ===========================================
                                                ---%s----


                                    Conta -----------------------%s

                                    Numero da Conta -------------%s


                                +++++++++++++++++++++++++++++++++++++++
                                    Saldo ------------------R$%.2f
                                +++++++++++++++++++++++++++++++++++++++
                            """.formatted(conta.getDono(), 
                                    this.conta.tipoString(), 
                                    conta.getNumConta(), 
                                    conta.getSaldo());
        System.out.println(saldoEmConta);
        do{
            String escolha = """
                              ===========================================

                                   Informe o valor que deseja depositar
                                     Ou digite [0] para retornar
 
                              ===========================================                                                       
                              """;
            System.out.println(escolha);
            double valor = teclado.nextDouble();
            teclado.nextLine();
            
            if (valor == 0){
                return;
            }
            if (!Double.isFinite(valor) || valor < 0) {
               System.out.println("[ERRO] Informe um valor positivo.");
             }
            
            result = this.conta.depositar(valor);
            
            if (result == 0){
                System.out.println("ERRO saldo insuficiente");
                System.out.println("Tente novamente");
            }
            else if (result == 1){
                String sucesso = """
                              ===========================================
                              ------------ Deposito realizado -----------
                              ===========================================
                                                ---%s----


                                    Saldo anterior -------------%.2f

                                    Valor depositado ----------+%.2f


                                +++++++++++++++++++++++++++++++++++++++
                                    Saldo ------------------R$%.2f
                                +++++++++++++++++++++++++++++++++++++++
                            """.formatted(this.conta.getDono(), 
                                    (this.conta.getSaldo()-valor), 
                                    valor, 
                                    conta.getSaldo());
                System.out.println(sucesso);
            }
            
        }while(result!=0);   
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
        int result;
        String saldoEmConta = """
                              ===========================================
                              ----------------SALDO ATUAL----------------
                              ===========================================
                                                ---%s----


                                    Conta -----------------------%s

                                    Numero da Conta -------------%s


                                +++++++++++++++++++++++++++++++++++++++
                                    Saldo -------------------R$%.2f
                                +++++++++++++++++++++++++++++++++++++++
                            """.formatted(conta.getDono(), this.conta.tipoString(), conta.getNumConta(), conta.getSaldo());
        System.out.println(saldoEmConta);
        do{
            String escolha = """
                              ===========================================

                                   Informe o valor que deseja sacar
                                     Ou digite [0] para retornar
 
                              ===========================================                                                       
                              """;
            System.out.println(escolha);
            double valor = teclado.nextDouble();
            teclado.nextLine();
            
            if (valor == 0){
                return;
            }
            
            result = this.conta.sacar(valor);
            
            if (result == 2){
                System.out.println("SALDO INSUFICIENTE");
            }else if (result == 1){
                String sucesso = """
                              ===========================================
                              -------------- Saque realizado ------------
                              ===========================================
                                                ---%s----


                                    Saldo anterior -------------%.2f

                                    Valor de saque ----------- -%.2f


                                +++++++++++++++++++++++++++++++++++++++
                                    Saldo ------------------R$%.2f
                                +++++++++++++++++++++++++++++++++++++++
                            """.formatted(this.conta.getDono(), 
                                    (this.conta.getSaldo()+valor), 
                                    valor, 
                                    conta.getSaldo());
                System.out.println(sucesso);
            }
            
        }while(result!=2);   
    }

    /**
     * mostra valor disponível
     * mostra quantos em atraso e valor total
     * se >0
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
        String mensalidade = """
                              ===========================================
                              ----------PAGAMENTO DE MENSALIDADE---------
                              ===========================================
                                                ---%s----


                                    Saldo  -----------------------%s

                                    Mensalidades a pagar----------%d

                                    Valor da mensalidade
                                    para %s ------------------R$%.2f

                              """.formatted(this.conta.getDono(),this.conta.getSaldo(),
                                      this.conta.getMensalidade(),this.conta.tipoString(),
                                      this.conta.valorTotalMensalidade(this.conta.getTipo(), this.conta.getMensalidade()));
        System.out.println(mensalidade);

        do{
            String escolha = """
                              ===========================================

                                    Selecione uma das opções abaixo

                                    [1] ------------Pagar Mensalidade
                                    [2] -----------Não Pagar esse mês
                                    [3] --------[SAIR] Menu Principal    

                              ===========================================                                                       
                              """;
            System.out.println(escolha);
            option = teclado.nextInt();
            teclado.nextLine();


            switch (option){

                case 1 -> {
                    int resultado = this.conta.pagarMensalidade(this.conta.getMensalidade());

                    if(resultado==0){
                        System.out.println("Conta inexistente");
                    }
                    if(resultado == 1){
                        System.out.println("PAGO");
                    }
                    if(resultado == 2){
                        System.out.println("Saldo Insuficiente");
                        return;
                    }
                }

                case 2 -> {
                    this.conta.setMensalidade(true, 1);
                    System.out.println("Pagamento em atraso\n+1 mês");
                    return;
                }
                case 3 -> System.out.println("Retornando...");
                default -> System.out.println("[ERRO] --- escolha uma opção válida");
            }

        }while(option<1 || option>3);
    }

    /**
     * mostra o saldo
     * 1-voltar
     * 2-fazer depósito
     * 3-fazer saque
     */
    public void solicitarSaldo() {
        String saldoEmConta = """
                              ===========================================
                              ----------------SALDO ATUAL----------------
                              ===========================================
                                                ---%s----


                                    Conta -----------------------%s

                                    Numero da Conta -------------%s


                                +++++++++++++++++++++++++++++++++++++++
                                    Saldo -------------------R$%.2f
                                +++++++++++++++++++++++++++++++++++++++
                            """.formatted(this.conta.getDono(), 
                                    this.conta.tipoString(), 
                                    this.conta.getNumConta(), 
                                    this.conta.getSaldo()
                            );
        System.out.println(saldoEmConta);
        do{
            String escolha = """
                              ===========================================

                                    Selecione uma das opções abaixo

                                    [1] ---------------Realizar saque
                                    [2] ------------Realizar depósito 
                                    [3] --------[SAIR] Menu Principal    

                              ===========================================                                                       
                              """;
            System.out.println(escolha);
            option = teclado.nextInt();
            teclado.nextLine();
            switch (option){
                case 1 -> this.solicitarSaque();
                case 2 -> this.solicitarDeposito();
                case 3 -> System.out.println("Retornando...");
                default -> System.out.println("[ERRO] --- escolha uma opção válida");
            }

        }while(option<1 || option>3);


    }

}
