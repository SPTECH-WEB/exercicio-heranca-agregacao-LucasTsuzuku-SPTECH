package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {

    //Atributos

    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    //Construtor


    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<Desenvolvedor>();
    }

    public Consultoria() {
    }

    // Métodos

    public void contratar(Desenvolvedor desenvolvedor){
        if(vagas <= 0 ) {
        } else{
            desenvolvedores.add(desenvolvedor);
            vagas = vagas - 1;
        }

    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double totalSalarioDesenvolvedores = 0.0;
        for (int i = 0; i < desenvolvedores.size(); i++) {
            totalSalarioDesenvolvedores += desenvolvedores.get(i).calcularSalario();
        }
        return totalSalarioDesenvolvedores;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer totalDesenvolvedoresMobile = 0;
        for (int i = 0; i < desenvolvedores.size(); i++) {
            if(desenvolvedores.get(i) instanceof DesenvolvedorMobile){
                totalDesenvolvedoresMobile += 1;
            }
        }
        return totalDesenvolvedoresMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        if(desenvolvedores.isEmpty()){return null;} else {
            List<Desenvolvedor> desenvolvedoresSalarioMaiorQuePassado = new ArrayList<Desenvolvedor>();
            for (int i = 0; i < desenvolvedores.size(); i++) {
                if(desenvolvedores.get(i).calcularSalario() >= salario){
                    desenvolvedoresSalarioMaiorQuePassado.add(desenvolvedores.get(i));
                }
            }
            return desenvolvedoresSalarioMaiorQuePassado;
        }
    }

    public Desenvolvedor buscarMenorSalario(){
        if(desenvolvedores.isEmpty()){return null;} else {
            Desenvolvedor desenvolvedorMenorSalario = desenvolvedores.get(0);
            for (int i = 0; i < desenvolvedores.size(); i++) {
                if(desenvolvedores.get(i).calcularSalario() < desenvolvedorMenorSalario.calcularSalario()){
                    desenvolvedorMenorSalario = desenvolvedores.get(i);
                }
            }
            return desenvolvedorMenorSalario;
        }
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        if(desenvolvedores.isEmpty()){return null;} else {
            List<Desenvolvedor> desenvolvedoresTecnologia = new ArrayList<Desenvolvedor>();
            for (int i = 0; i < desenvolvedores.size(); i++) {
                if (desenvolvedores.get(i) instanceof DesenvolvedorWeb){
                    if(
                            ((DesenvolvedorWeb) desenvolvedores.get(i)).getFrontend().equalsIgnoreCase(tecnologia) ||
                            ((DesenvolvedorWeb) desenvolvedores.get(i)).getBackend().equalsIgnoreCase(tecnologia) ||
                            ((DesenvolvedorWeb) desenvolvedores.get(i)).getSgbd().equalsIgnoreCase(tecnologia)
                    ){
                        desenvolvedoresTecnologia.add(desenvolvedores.get(i));
                    }
                } else if (desenvolvedores.get(i) instanceof DesenvolvedorMobile) {
                    if(
                            ((DesenvolvedorMobile) desenvolvedores.get(i)).getLinguagem().equalsIgnoreCase(tecnologia) ||
                                    ((DesenvolvedorMobile) desenvolvedores.get(i)).getPlataforma().equalsIgnoreCase(tecnologia)
                    ){
                        desenvolvedoresTecnologia.add(desenvolvedores.get(i));
                    }
                }
            }
            return desenvolvedoresTecnologia;
        }
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        if(desenvolvedores.isEmpty()){return null;} else {
            Double acumuladorSalarioTecnologia = 0.0;
            for (int i = 0; i < desenvolvedores.size(); i++) {
                if (desenvolvedores.get(i) instanceof DesenvolvedorWeb){
                    if(
                            ((DesenvolvedorWeb) desenvolvedores.get(i)).getFrontend().equalsIgnoreCase(tecnologia) ||
                                    ((DesenvolvedorWeb) desenvolvedores.get(i)).getBackend().equalsIgnoreCase(tecnologia) ||
                                    ((DesenvolvedorWeb) desenvolvedores.get(i)).getSgbd().equalsIgnoreCase(tecnologia)
                    ){
                        acumuladorSalarioTecnologia += desenvolvedores.get(i).calcularSalario();
                    }
                } else if (desenvolvedores.get(i) instanceof DesenvolvedorMobile) {
                    if(
                            ((DesenvolvedorMobile) desenvolvedores.get(i)).getLinguagem().equalsIgnoreCase(tecnologia) ||
                                    ((DesenvolvedorMobile) desenvolvedores.get(i)).getPlataforma().equalsIgnoreCase(tecnologia)
                    ){
                        acumuladorSalarioTecnologia += desenvolvedores.get(i).calcularSalario();
                    }
                }
            }
            return acumuladorSalarioTecnologia;
        }
    }

    //Getter Setter


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}