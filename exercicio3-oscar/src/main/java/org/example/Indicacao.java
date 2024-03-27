package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Indicacao {
    private Indicavel indicavel;
    private String categoria;

    public Indicacao(Indicavel indicavel, String categoria) {
        this.indicavel = indicavel;
        this.categoria = categoria;
    }

    public Indicavel getIndicavel() {
        return indicavel;
    }
    public String getCategoria() {
        return categoria;
    }

}