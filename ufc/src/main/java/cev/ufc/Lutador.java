package cev.ufc;

public class Lutador {
	private String nome;
	private String nacionalidade;
	private int idade;
	private float altura;
	private float peso;
	private String categoria;
	private int vitorias;
	private int derrotas;
	private int empates;

	/**
	 *  
	 */
	public Lutador(String nome,
                String nacionalidade,
                int idade, float altura,
                float peso, int vitorias, 
                int derrotas, int empates) {
            setNome(nome);
            setNacionalidade(nacionalidade);
            setIdade(idade);
            setAltura(altura);
            setPeso(peso);
            setVitorias(vitorias);
            setDerrotas(derrotas);
            setEmpates(empates);
	}

	public void apresentar() {
           String apresenta = """
                              = = = = = = = AANND NOOOOW!!! = = = = = = = = 
                              
                                      Here comes a new challenger
                              ----------------------------------------------
                              
                                    ============ %s ============
                                      PESO: %.2f
                                      CATEGORIA: %s
                                      NACIONALIDADE: %s
                                      ALTURA: %.2f                              
                              ++++++++++++++++++++++++++++++++++++++++++++++
                              
                              VITORIAS ---------------------------------%d
                              
                              DERROTAS -------------------------------- %d
                              
                              EMPATES --------------------------------- %d
                              
                              
                              """.formatted(this.nome, 
                                      this.peso,
                                      this.categoria,
                                      this.nacionalidade,
                                      this.altura,
                                      this.vitorias, 
                                      this.derrotas, 
                                      this.empates);
           
            System.out.println(apresenta);

	}

	public void status() {

	}

	public void ganharLuta() {
            setVitorias(getVitorias()+1);

	}

	public void perderLuta() {
            setDerrotas(getDerrotas()+1);

	}

	public void empatarLuta() {
            setEmpates(getEmpates()+1);

	}

	public void setNome(String nome) {
            this.nome = nome;

	}

	public String getNome() {
		return this.nome;
	}

	public void setNacionalidade(String nacionalidade) {
            this.nacionalidade = nacionalidade;

	}

	public String getNacionalidade() {
		return this.nacionalidade;
	}

	public void setIdade(int idade) {
            this.idade = idade;

	}

	public int getIdade() {
		return this.idade;
	}

	public void setAltura(float altura) {
            this.altura = altura;

	}

	public float getAltura() {
		return altura;
	}

	public void setPeso(float peso) {
            this.peso = peso;
            setCategoria();

	}

	public float getPeso() {
		return this.peso;
	}

	public void setCategoria() {
            if(getPeso()<52.2){
                this.categoria = "Inválido";
            }else if(getPeso() <=70.3){
                this.categoria = "Leve";
            }else if(getPeso()<=83.9){
                this.categoria = "medio";
            }else if (getPeso()<=120.2){
                this.categoria = "Pesado";
            }else{
                this.categoria = "Pesadíssimo";
            }
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setVitorias(int vitorias) {
            this.vitorias=vitorias;

	}

	public int getVitorias() {
		return vitorias;
	}

	public void setDerrotas(int derrotas) {
            this.derrotas=derrotas;

	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setEmpates(int empates) {
            this.empates = empates;

	}

	public int getEmpates() {
		return empates;
	}

}
