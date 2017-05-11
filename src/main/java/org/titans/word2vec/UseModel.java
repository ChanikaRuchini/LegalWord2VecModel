package org.titans.word2vec;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Collection;

/**
 * Created by Buddhi on 5/11/2017.
 */
public class UseModel {

    private static Logger log = LoggerFactory.getLogger(UseModel.class);
    private static final String modelName = "LegalWord2VecModel";

    public static void main(String[] args) throws Exception {

        log.info(modelName + " loading...");
        Word2Vec word2Vec = WordVectorSerializer.loadFullModel(System.getProperty("user.dir") + File.separator + modelName);
        log.info(modelName + " loading successful");

        while (true) {
            System.out.print("Enter word: ");
            String input = System.console().readLine();
            Collection<String> testWord = word2Vec.wordsNearest(input, 10);
            log.info("Closest words to " + input + ": " + testWord);
        }
    }

}
