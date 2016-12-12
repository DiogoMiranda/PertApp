package diogo.miranda.pert.Model;

/**
 * Created by Diogo Miranda on 17/09/2016.
 */
public class Atividade {

    private Integer id;
    private String titler;
    private String responsible;
    private String description;
    private Double qtd;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitler() {
        return titler;
    }

    public void setTitler(String titler) {
        this.titler = titler;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getQtd() {
        return qtd;
    }

    public void setQtd(Double qtd) {
        this.qtd = qtd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        Atividade atividade = (Atividade) o;

        if(atividade.getId().equals(this.getId())){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public String toString() {
        return "Titler: " + this.titler + " - Description: " + this.description;
    }
}
