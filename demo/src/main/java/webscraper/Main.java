package webscraper;

public class Main {
    public static void main(String[] args) {
        String url_produto = "tenis-asics-gelequation-14-feminino-2FW-2956-997";
        NetshoesScraper scraper = new NetshoesScraper();

        Produto produto = scraper.extrairProduto(url_produto);

        if (produto != null) {
            produto.imprimirProduto();
        } else {
            System.out.println("Não foi possível obter os dados do produto.");
        }
    }
}