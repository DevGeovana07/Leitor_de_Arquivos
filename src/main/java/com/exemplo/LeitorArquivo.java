import org.apache.commons.io.FileUtils;
import opennlp.tools.tokenize.SimpleTokenizer;
import edu.stanford.nlp.pipeline.*;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class LeitorArquivo {

    public static void main(String[] args) throws IOException {
        File file = new File("texto.txt");

        // 1. Leitura do arquivo
        String conteudo = FileUtils.readFileToString(file, "UTF-8");
        System.out.println("Conteúdo do arquivo:\n" + conteudo);

        // 2. Contar palavras e linhas
        int linhas = conteudo.split("\r\n|\r|\n").length;
        String[] palavras = SimpleTokenizer.INSTANCE.tokenize(conteudo);
        System.out.println("\nNúmero de linhas: " + linhas);
        System.out.println("Número de palavras: " + palavras.length);

        // 3. Análise de sentimentos usando Stanford CoreNLP
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,parse,sentiment");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        CoreDocument doc = new CoreDocument(conteudo);
        pipeline.annotate(doc);

        System.out.println("\nAnálise de Sentimentos:");
        for (CoreSentence sentence : doc.sentences()) {
            String sent = sentence.text();
            String sentiment = sentence.sentiment();
            System.out.println("[" + sentiment + "] " + sent);
        }
    }
}
