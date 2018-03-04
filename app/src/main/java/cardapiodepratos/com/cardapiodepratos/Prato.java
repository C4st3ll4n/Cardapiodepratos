package cardapiodepratos.com.cardapiodepratos;

/**
 * Criado por Henrique em 04/03/2018.
 */

public class Prato {
    private String nome;
    private String drescicao;
    private String url_foto;
    private Double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDrescicao() {
        return drescicao;
    }

    public void setDrescicao(String drescicao) {
        this.drescicao = drescicao;
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
}
