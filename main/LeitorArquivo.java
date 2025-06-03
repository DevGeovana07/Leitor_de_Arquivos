import org.apache.commons.io.FileUtils;
import opennlp.tools.tokenize.SimpleTokenizer;
import edu.stanford.nlp.pipeline.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LeitorArquivo {

    public static void main(String[] args) throws IOException {
        File file = new File("texto.txt");