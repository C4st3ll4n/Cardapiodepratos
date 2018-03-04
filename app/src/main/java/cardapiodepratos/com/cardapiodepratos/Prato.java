package cardapiodepratos.com.cardapiodepratos;

public class Prato {
    private String nome;
    private String descricao;
    private String url_foto;
    private Double preco;

    public Prato(String n, String d, Double p) {
        this.nome = n;
        this.descricao = d;
        this.preco = p;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
