package search_engine;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import search_token.Token;
import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchEngineImplementation {
    private Multimap<String, Token> mappings = ArrayListMultimap.create();

    public void mapFile(File file,String docId) {
        putIntoMappings(file,docId);
    }

    /**
     * Return the list of documents (filenames) where given term occurs sorted by tf-idf
     *
     * @param query Word to look for in the index structure
     * @return List of files where given query was found (just the filenames)
     */
    public void find(String query) {
        if (null == query || !isAlphanumeric(query)) {
            System.out.println("Query Error empty or non alphanumeric query. ");
        }

        if(findPaths(query).isEmpty()){
            System.out.println("Query Error Token cannot be found");
        }else{
            final List<Token> tokens = findPaths(query);

            tfidSort(tokens);

            System.out.println("Query results: ");
            getFilenames(tokens);
        }

    }

    public void putIntoMappings(File file,String docId) {
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter(" +");
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (mappings.containsKey(word) && fileContainsWord(word, file)) {
                    incrementsCountInMapForWord(word, file);
                } else {
                    mappings.put(word, new Token(file));
                }
            }
            System.out.println("Index ok: "+ docId);
        } catch (FileNotFoundException e) {
            System.out.println("Index Error indexing file: " + e);
        }
    }

    private boolean fileContainsWord(final String word, final File file) {
        return mappings.get(word)
                .stream()
                .anyMatch(token -> token.getSource() == file);
    }

    private void incrementsCountInMapForWord(final String word, final File file) {
        mappings.get(word).stream()
                .filter(it -> it.getSource().equals(file))
                .findFirst()
                .ifPresent(Token::addCount);
    }

    private List<Token> findPaths(String query) {
        return (List<Token>) mappings.get(query);
    }


    private void tfidSort(final List<Token> tokens) {
        tokens.sort(Comparator.comparingInt(Token::getNrOfOccurences).reversed());
    }

    private void getFilenames(final List<Token> paths) {
         System.out.println(paths
                .stream()
                .map(Token::getSource)
                .map(File::getName)
                .collect(Collectors.toList()));
    }

    public boolean isAlphanumeric(String query)
    {
        char[] charArray = query.toCharArray();
        for(char c:charArray)
        {
            if (!Character.isLetterOrDigit(c))
                return false;
        }
        return true;
    }
}
