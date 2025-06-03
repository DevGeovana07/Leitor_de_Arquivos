import org.apache.commons.io.FileUtils;
import opennlp.tools.tokenize.SimpleTokenizer;
import edu.stanford.nlp.pipeline.*;

import java.io.File;
import java.io.IOException;


 public class leitorArquivo {

    public static void main(String[] args) throws IOException {
        File file = new File("texto.txt");

        // 1. Leitura do arquivo
        String conteudo = FileUtils.readFileToString(file, "UTF-8");
        System.out.println("Conteúdo do arquivo:\n" + conteudo);