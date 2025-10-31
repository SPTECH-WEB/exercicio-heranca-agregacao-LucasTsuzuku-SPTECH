package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorWeb extends Desenvolvedor {

    //Atributos
    private String backend;
    private String frontend;
    private String sgbd;
    private Integer horasMentoria;
    //Constructor


    public DesenvolvedorWeb(String nome, Integer qtdHoras, Double valorHora, String backend, String frontend, String sgbd, Integer horasMentoria) {
        super(nome, qtdHoras, valorHora);
        this.backend = backend;
        this.frontend = frontend;
        this.sgbd = sgbd;
        this.horasMentoria = horasMentoria;
    }

    public DesenvolvedorWeb() {
    }

    //Métodos

    @Override
    public Double calcularSalario() {
        return (300 * horasMentoria) + (getQtdHoras() * getValorHora());
    }

    public Boolean isFullstack(){
        if(backend != null && frontend != null && sgbd != null){
            return true;
        } else {
            return false;
        }
    }

    //getter setter


    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public String getFrontend() {
        return frontend;
    }

    public void setFrontend(String frontend) {
        this.frontend = frontend;
    }

    public String getSgbd() {
        return sgbd;
    }

    public void setSgbd(String sgbd) {
        this.sgbd = sgbd;
    }

    public Integer getHorasMentoria() {
        return horasMentoria;
    }

    public void setHorasMentoria(Integer horasMentoria) {
        this.horasMentoria = horasMentoria;
    }
}
