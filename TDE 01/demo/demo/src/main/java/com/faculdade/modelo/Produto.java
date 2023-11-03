package com.faculdade.modelo;

public class Produto {
    Long codigo;
    String descricao;
    Double valor;

//    public Produto (Long codigo, String descricao, Double valor){
//        this.codigo = codigo;
//        this.descricao = descricao;
//        this.valor = valor;
//    }

    public Produto() {
    }
    public Long getCodigo() {
        return this.codigo;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public Double getValor() {
        return this.valor;
    }
    public void setCodigo(Long cod) {
        this.codigo = cod;
    }
    public void setDescricao(String desc) {
        this.descricao = desc;
    }
    public void setValor(Double val) {
        this.valor = val;
    }

}
