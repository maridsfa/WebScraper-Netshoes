package webscraper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Informe a URL que deseja extrair:");
        Scanner scanner = new Scanner(System.in);
        String url_search = scanner.nextLine();

        NetshoesScraper scraper = new NetshoesScraper();

        Produto produto = scraper.extrairProduto(url_search);

        if (produto != null) {
            produto.imprimirProduto();
        } else {
            System.out.println("Não foi possível obter os dados do produto.");
        }
        
    }
}