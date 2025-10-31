package school.sptech;

public class Desenvolvedor {

    //Atributos
    protected String nome;
    protected Integer qtdHoras;
    protected Double valorHora;

    //Construtor

    public Desenvolvedor(String nome, Integer qtdHoras, Double valorHora) {
        this.nome = nome;
        this.qtdHoras = qtdHoras;
        this.valorHora = valorHora;
    }

    public Desenvolvedor() {
    }

    //Métodos

    public Double calcularSalario(){
        return qtdHoras * valorHora;
    };

    //getter e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(Integer qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }


    //To String

}
