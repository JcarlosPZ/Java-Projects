package cev.bancodocarlos;

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
        setMensalidade(1);
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
    private void setMensalidade(int mensalidade){
        this.mensalidade = mensalidade;
    }

    private int getMensalidade(){
        return this.mensalidade;
    }

    /**
     * 1- cc +=50 reais
     * 2 - cp+=150
     * 
     * status = true
     */
    public void abrirConta(int tipo) {
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
        if(!getStatus()){
            return 0;
        }
        if(getSaldo()>=valor){
            setSaldo(false, valor);
            return 1;
        }
        else{
            return 2;
        }

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
        double totalCobrar = valorBase * getMensalidade() * meses;

        if (getSaldo() >= totalCobrar) {
            setSaldo(false, totalCobrar);
            setMensalidade(1);
            return 1; // Sucesso
        } else {
            return 2; // Saldo insuficiente
        }
    }

}
