package search_token;

import java.io.File;

public class Token {

    private File source;
    private int nrOfOccurences = 1;

    public Token(final File source) {
        this.source = source;
    }

    public void addCount() {
        this.nrOfOccurences++;
    }

    public File getSource() {
        return source;
    }

    public int getNrOfOccurences() {
        return nrOfOccurences;
    }
}
