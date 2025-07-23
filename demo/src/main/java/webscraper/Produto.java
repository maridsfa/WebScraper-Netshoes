package webscraper;

import java.util.List;

public class Produto {

    //ATRIBUTOS
    private String titulo;
    private String preco;
    private String imagem;
    private List<String> descricao;
    
    //CONSTRUTOR -> PEGA OS PARAMETROS DA CLASSE E INICIALIZA NOS ATRIBUTOS
    public Produto(String titulo, String preco, String imagem, List<String> descricao) {
        this.titulo = titulo;
        this.preco = preco;
        this.imagem = imagem;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPreco() {
        return preco;
    }

    public String getImagem() {
        return imagem;
    }

    public List<String> getDescricao() {
        return descricao;
    }

    public void imprimirProduto() {
        System.out.println("Nome do produto: " + titulo);
        System.out.println("Preço do produto: " + preco);
        System.out.println("URL da imagem do produto: " + imagem);
        System.out.println("Descrição do produto:");
        for (String atributo : descricao) {
            System.out.println("- " + atributo);
        }
    }

}
