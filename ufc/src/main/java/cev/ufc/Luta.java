package cev.ufc;

import java.util.Random;

public class Luta {

	private Lutador desafiado;

	private Lutador desafiante;

	private int rounds;

	private boolean aprovada;

	

	public void marcarLuta(Lutador l1, Lutador l2) {
            if ((l1.getCategoria() == l2.getCategoria()) && (l1 != l2)){
                setAprovada(true);
                setDesafiante(l1);
                setDesafiado(l2);
            }
            else{
                setAprovada(false);
                setDesafiante(null);
                setDesafiado(null);
            }
            
	}

	public void lutar() {
            if(this.aprovada){
                System.out.println("++++++++++DESAFIANTE++++++++++");
                this.desafiante.apresentar();
                System.out.println("++++++++++DESAFIADO++++++++++");
                this.desafiado.apresentar();
                
                Random aleatorio = new Random();
                int vencedor = aleatorio.nextInt(3);
                switch(vencedor){
                    case 0 -> {
                        System.out.println("Empatou!");
                        this.desafiado.empatarLuta();
                        this.desafiante.empatarLuta();
                    }
                    case 1->{
                        System.out.println("Vitória de "+this.desafiado);
                        this.desafiado.ganharLuta();
                        this.desafiante.perderLuta();
                    }
                    case 2->{
                        System.out.println("Vitória de "+this.desafiante);
                        this.desafiante.ganharLuta();
                        this.desafiado.perderLuta();
                    }
                }
                this.desafiado.apresentar();
                this.desafiante.apresentar();
            }
	}

	public void setDesafiado(Lutador desafiado) {
            this.desafiado = desafiado;
        }

	public Lutador getDesafiado() {
		return this.desafiado;
	}

	public void setDesafiante(Lutador desafiante) {
            this.desafiante = desafiante;
	}

	public Lutador getDesafiante() {
		return this.desafiado;
	}

	public void setRounds(int rounds) {
            this.rounds = rounds;
	}

	public int getRounds() {
		return rounds;
	}

	public void setAprovada(boolean aprovada) {
            this.aprovada = aprovada;
	}

	public boolean isAprovada() {
		return aprovada;
	}

}
