package assignment1;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Problem3 {

    public static String tagSentence(String sentence) {
        String modelPath = "models/english-left3words-distsim.tagger";

        try (InputStream model = Problem3.class.getClassLoader().getResourceAsStream(modelPath)) {
            if (model != null) {
                return new MaxentTagger(model).tagString(sentence);
            }

            // just in case, catches error before it can cause failure in the next try block
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to close the POS tagger model", exception);
        }
        // allows model to load from inside the jar first, for offline running
        try (InputStream model = Files.newInputStream(Path.of(modelPath))) {
            return new MaxentTagger(model).tagString(sentence);
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to load POS tagger model: " + modelPath, exception);
        }
    }

    public static void main(String[] args) {
        // Internal path pointing inside the embedded Stanford models jar
        String sample = " I was slowly walking to the park with my over enthusiastic dog when he bit me, and I shouted, Ouch!";
        String tagged = tagSentence(sample);

        System.out.println("\n--- POS TAGGER OUTPUT ---");
        System.out.println(tagged);
        System.out.println("-------------------------\n");
    }
}
