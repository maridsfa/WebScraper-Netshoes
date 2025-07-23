package webscraper;

public class Main {
    public static void main(String[] args) {
        String url = "https://www.netshoes.com.br/p/tenis-asics-gelequation-14-feminino-2FW-2956-997";
        Scraper scraper = new Scraper();

        Produto produto = scraper.extrairProduto(url);

        if (produto != null) {
            produto.imprimirProduto();
        } else {
            System.out.println("Não foi possível obter os dados do produto.");
        }
    }
}