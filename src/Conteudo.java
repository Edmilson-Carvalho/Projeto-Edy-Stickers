public class Conteudo {

    private String titulo;
    private final String urlImagem;
    private String comentarios;

    public Conteudo(String titulo, String urlImagem, String comentarios) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
        this.comentarios = comentarios;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public String getComentarios() {
        return comentarios;
    }

}
