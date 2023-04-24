
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

    void cria(InputStream inputStream, String nomeArquivo, String frase) throws Exception {

        BufferedImage imagemOririginal = ImageIO.read(inputStream);

        // nova imagem em memoria com transparencia e novo tamanho
        int largura = imagemOririginal.getWidth();
        int altura = imagemOririginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar imagem original para nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOririginal, 0, 0, null);

        // configurar a fonte

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 40);
        graphics.setColor(Color.RED);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString(frase, 175, novaAltura - 100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

}
