package br.com.carros.CarAPI;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Carro {
    @Id @GeneratedValue
    private Long id;
    private String modelo;
    private Integer ano;
    private String cor;
    private String placa;

    public Carro(String modelo, Integer ano, String cor, String placa) {
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
    }

    public Carro() {}

    public Long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                ", placa='" + placa + '\'' +
                '}';
    }
}
