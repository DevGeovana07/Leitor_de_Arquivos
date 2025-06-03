import org.apache.commons.io.FileUtils;
import opennlp.tools.tokenize.SimpleTokenizer;
import edu.stanford.nlp.pipeline.*;

public class LeitorArquivo {

    public static void main(String[] args) throws IOException {
        File file = new File("texto.txt");