package cev.bancodocarlos;

import java.security.SecureRandom;

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
    private int mensalidade;


    public ContaBanco() {
        setStatus(false);
        setSaldo(true,0);
        setMensalidade(true,1);
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public String getNumConta() {
        return this.numConta;
    }

    /**

     */
    public void setTipo(int tipo) {
        this.tipo=tipo;
    }

    /**
     * @return cc se 1 ou cp se 2
     * se 1:
     * 	cc
     * se 2:
     * 	cp
     */
    public int getTipo() {
        return this.tipo;
    }

    public void setDono(String dono) {
        this.dono = dono;

    }

    public String getDono() {
            return this.dono;
    }

    public void setSaldo(boolean operador, double saldo) {
        if(operador){
            this.saldo+=saldo;
        }else{    
            this.saldo-=saldo;
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setStatus(boolean status) {
        this.status=status;
    }

    public boolean getStatus() {
        return status;
    }


    /**
     * acumulo de atrasos na mensalidade
     * default 1
     */
    public void setMensalidade(boolean operador, int mensalidade){
        if (operador){
            this.mensalidade += mensalidade;
        }
        else{
            this.mensalidade -= mensalidade;

        }
        
    }

    public int getMensalidade(){
        return this.mensalidade;
    }

    /**
     * 1- cc +=50 reais
     * 2 - cp+=150
     * 
     * status = true
     */
    public void abrirConta(int tipo) {
        if(this.getStatus()==true){
            System.out.println("OPÇÃO INVÁLIDA \n a conta já existe!!");
            return;
        }
        if (tipo == 1 || tipo == 2) {
            setStatus(true);
            setTipo(tipo);
            switch (tipo) {
                case 1 -> setSaldo(true, 50);
                case 2 -> setSaldo(true, 150);
            }
        } else {
            System.out.println("OPÇÃO INVÁLIDA \n ERRO!!");
        }
    }

    /**
     * só funciona se:
     * saldo == 0
     * status == true
     */
    public int fecharConta() {
        if(!getStatus()){
            return 2;
        }
        if(getSaldo()>0){
            return 3;
        }
        if(getSaldo()<0){
            return 4;
        }
        if(this.getMensalidade()!=0){
            return 5;
        }

        setStatus(false);
        return 1;
    }


    public int depositar(double valor) {
        if(getStatus()==true){
            setSaldo(true, valor);
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * só funciona se:
     * status == true 
     * e
     * saldo >0
     * e
     * saldo >= saque
     * 
     * 
     * saldo-=valor
     * se saldo <=0 erro
     */
    public int sacar(double valor) {
        if(getSaldo()>=valor){
            setSaldo(false, valor);
            return 1;
        }
        else{
            return 2;
        }

    }
    
    public double valorTotalMensalidade(int tipo, int quantidade){
        double total;
        switch (tipo){
            case 1 -> total = 12*quantidade;
            case 2 -> total = 20*quantidade;
            default -> total = -20;
        }
        
        return total;
    }

    /**
     * cc-=12
     * cp-=20
     * por mês
     * só se:
     * saldo>0
     */
    public int pagarMensalidade(int meses) {
        if (!getStatus()) {
            return 0; // Conta fechada
        }

        double valorBase = (getTipo() == 1) ? 12 : (getTipo() == 2) ? 20 : 0;
        double totalCobrar = valorBase * meses;

        if (getSaldo() >= totalCobrar) {
            setSaldo(false, totalCobrar);
            setMensalidade(false, this.getMensalidade());
            return 1; // Sucesso
        } else {
            return 2; // Saldo insuficiente
        }
    }
    
    /**
	 * se tipo==1 digito 55
	 * se tipo ==2 digito 67
	 */
	public void gerarNumConta(int tipo) {
            
            SecureRandom secureRandom = new SecureRandom();
            
            int random = secureRandom.nextInt(100000);
            
            String num;
            
            switch(tipo){
                case 1 -> num = Integer.toString(random) + " - 55";
                
                case 2 -> num = Integer.toString(random) + " - 67";
                
                default -> num = "erro";
            }
            
            this.setNumConta(num);
	}
        
        public String tipoString() {
            int tipo = this.getTipo();
            String resposta = (tipo == 1) ? "CC" : "CP"; 
            return resposta;
        }

}
