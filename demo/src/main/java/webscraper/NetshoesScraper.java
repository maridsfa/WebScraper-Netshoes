package webscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class NetshoesScraper {

    private String urlBase = "https://www.netshoes.com.br/p/";

    public Produto extrairProduto(String url_produto) {

        try {

            String search_url = urlBase + url_produto;

            Document document = Jsoup.connect(search_url).get();

            // Nome do produto
            Element nomeElement = document.selectFirst("h1.product-name");
            String nome;
            // Verifica se o elemento de nome foi encontrado
            if (nomeElement != null) {
                nome = nomeElement.text();
            } else {
                nome = "Nome do produto não encontrado";
            }

            // Preço
            Element precoElement = document.selectFirst("span.saleInCents-value");
            String preco;
            // Verifica se o elemento de preço foi encontrado
            if (precoElement != null) {
                preco = precoElement.text();
            } else {
                preco = "Preço não encontrado";
            }

            // Imagem
            Element imagemElement = document.selectFirst("img.carousel-item-figure__image");
            String imagem;
            // Verifica se o elemento de imagem foi encontrado
            if (imagemElement != null) {
                imagem = imagemElement.attr("src");
            } else {
                imagem = "Imagem não encontrada";
            }

            // Descrição
            Elements descricoes = document.select("div.showcase-details ul.attributes li");
            List<String> descricaoList = new ArrayList<>();
            for (Element atributo : descricoes) {
                descricaoList.add(atributo.text());
            }

            // Verifica se a lista de descrições está vazia
            if (descricaoList.isEmpty()) {
                    descricaoList.add("Descrição não encontrada");
            }

            return new Produto(nome, preco, imagem, descricaoList);

        } catch (Exception e) {
            System.out.println("Erro ao extrair dados: " + e.getMessage());
            return null;
        }
    }
}