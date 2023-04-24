import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class App {
   public static void main(String[] args) throws Exception {

      // interação com o usuário
      Scanner sc = new Scanner(System.in);
      String opcao = "";

      while (true) {
         System.out.println("Deseja consumir a API NASA ou IMDB? (Digite N ou I)");
         opcao = sc.nextLine();
         if (opcao.equals("n") || opcao.equals("i")) {

            break;
         }
      }
      Scanner fraseEntrada = new Scanner(System.in);
      String frase = "";
      System.out.println(" Escreva uma frase para a figurinha");
      frase = fraseEntrada.nextLine();

      ManipulacaoDados retornoConteudo = new ManipulacaoDados();
      Object retorno = retornoConteudo.buscaConteudos(opcao);

      if (retorno instanceof List<?>) {
         List<Conteudo> conteudos = (List<Conteudo>) retorno;

         var geradora = new GeradorDeFigurinhas();

         // Retirar comentarios abaixo caso queira imprimir todas as imagens da API
         // for (Map<String, String> conteudo : listaDeConteudos) {

         for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/ " + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo, frase);

            System.out.println(conteudo.getTitulo());
            System.out.println("");
            System.out.println(conteudo.getComentarios());

         }

      }

   }
}
