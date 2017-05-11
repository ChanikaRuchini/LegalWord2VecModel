import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class UseModel {

    private static Logger log = LoggerFactory.getLogger(UseModel.class);

    public static void main(String[] args) throws Exception {

        log.info("LegalWord2Vec Model loading...");
        Word2Vec word2Vec = WordVectorSerializer.loadFullModel("C:\\Users\\User\\Desktop\\LegalWord2VecModel");
        log.info("LegalWord2Vec Model loading successful");

        while(true){
            System.out.print("Enter word: ");
            String input = System.console().readLine();
            Collection<String> testWord = word2Vec.wordsNearest(input, 10);
            log.info("Closest words to " + input + ": "  + testWord);
        }

    }
}
