import java.util.List;

// classe manipuladora de dados API Imdb e Nasa 

public class ManipulacaoDados {

    String url1 = "https://api.nasa.gov/planetary/apod?api_key=zuTqRBDY7uflpHPrmfybhMJrEuoOhJ9MYgFwnqM9&start_date=2022-12-10&end_date=2022-12-31";
    ExtratorDeConteudo extratorNasa = new ExtratorDeConteudoNasa();

    String url2 = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
    ExtratorDeConteudo extratorImdb = new ExtratorConteudoImdb();
    ClienteHttp http = new ClienteHttp();

    public Object buscaConteudos(String opcao) {
        String jsonNasa = "";
        String jsonImdb = "";
        Object retorno = null;

        // manipular dados da fonte NASA aqui
        if (opcao.trim().equals("n")) {
            jsonNasa = http.buscaDados(url1);
            List<Conteudo> conteudosNasa = extratorNasa.extraiConteudos(jsonNasa);
            retorno = conteudosNasa;

            // manipular dados da fonte IMDB aqui
        } else if (opcao.trim().equals("i")) {
            jsonImdb = http.buscaDados(url2);
            List<Conteudo> conteudosImdb = extratorImdb.extraiConteudos(jsonImdb);
            retorno = conteudosImdb;

        }
        return retorno;
    }

}
