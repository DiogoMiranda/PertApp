package diogo.miranda.pert.Model;

import java.io.Serializable;

public class CalculoPert implements Serializable{

    private Long otimista;
    private Long provavel;
    private Long pessimista;
    private double resultado;
    private double desvioPadrao;
    private double variacia;

    public CalculoPert() {

    }
    public CalculoPert(Long otimista, Long provavel, Long pessimista) {
        this.otimista = otimista;
        this.provavel = provavel;
        this.pessimista = pessimista;

    }
    public Long getOtimista() {
        return otimista;
    }

    public void setOtimista(Long otimista) {
        this.otimista = otimista;
    }

    public Long getProvavel() {
        return provavel;
    }

    public void setProvavel(Long provavel) {
        this.provavel = provavel;
    }

    public Long getPessimista() {
        return pessimista;
    }

    public void setPessimista(Long pessimista) {
        this.pessimista = pessimista;
    }

    public double getResultado() {
        try {
            calcula();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getDesvioPadrao() {
        try {
            calcula();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return desvioPadrao;
    }

    public void setDesvioPadrao(double desvioPadrao) {
        this.desvioPadrao = desvioPadrao;
    }

    public double getVariacia() {
        try {
            calcula();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return variacia;
    }

    public void setVariacia(double variacia) {
        this.variacia = variacia;
    }

    public boolean calcula() throws Exception{
        if (otimista == null || provavel == null || pessimista == null) {
            throw new Exception("Os valores estão vazios ");

        } else {
            Long o = otimista;
            Long m = provavel;
            Long p = pessimista;
            resultado = (o + (4 * m) + p) / 6;
            desvioPadrao = (p - o) / 6;
            variacia = ((p - o) / 6) ^ 2;
            return true;
        }
    }
}
