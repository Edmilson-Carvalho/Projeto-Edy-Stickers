import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoImdb implements ExtratorDeConteudo {

        public List<Conteudo> extraiConteudos(String json) {

                // pegar os dados que interessam (titulo, imagem, avaliaçao)

                JsonParser parser = new JsonParser();
                List<Map<String, String>> listaDeAtributos = parser.parse(json);

                List<Conteudo> conteudos = new ArrayList<>();

                // popular a lista de conteudos
                for (Map<String, String> atributos : listaDeAtributos) {
                        String titulo = atributos.get("title");
                        String urlImagem = atributos.get("image");
                        String comentarios = "";
                        var conteudo = new Conteudo(titulo, urlImagem, comentarios);

                        conteudos.add(conteudo);
                }

                return conteudos;

        }
}
