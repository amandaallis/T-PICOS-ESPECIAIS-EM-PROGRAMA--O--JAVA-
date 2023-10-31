package modelo;

public class Produto {
    String codigo;
    String descricao;
    Double valor;

    public Produto (String codigo, String descricao, Double valor){
        this.codigo = "codigo";
        this.descricao = "Descrição";
        this.valor = 2.4;
    }

    public String getCodigo() {
        return this.codigo;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public Double getValor() {
        return this.valor;
    }
    public void setCodigo(String cod) {
        this.codigo = cod;
    }
    public void setDescricao(String desc) {
        this.descricao = desc;
    }
    public void setValor(Double val) {
        this.valor = val;
    }

}
