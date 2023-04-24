import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

// conexao http para buscar os filmes IMDB e Imagens NASA 

public class ClienteHttp {

    public String buscaDados(String url) {

        try {

            HttpClient client = HttpClient.newHttpClient(); // classe utilizadada para receber requisições e respostas
                                                            // HTTP
            URI endereco = URI.create(url);// classe que representa endereços da internet em string

            // A classe abaixo é uma instancia de HttpRequest utilizando o metodo
            // newBuilder(). O parametro
            // utilizado para para o metodo é a URI "endereco" (que converte a String ulr
            // para um obeto do tipo URI)
            // em seguida é chamado o metodo GET que é utilizado para definir o tipo de
            // metodo HTTP na requisição.
            // por ultimo o metodo build() para construir a instancia final de HttpRequest.

            HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            String body = response.body();
            return body;

        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);

        }
    }
}