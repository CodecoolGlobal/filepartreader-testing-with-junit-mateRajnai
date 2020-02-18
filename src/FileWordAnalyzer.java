import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWordAnalyzer {

    private FilePartReader filePartReader;
    private String filepath;


    public FileWordAnalyzer(FilePartReader filePartReader, String filepath) {
        this.filePartReader = filePartReader;
        this.filepath = filepath;
    }


    public List<String> getWordsOrderedAlphabetically() throws IOException {
        List<String> words = splitStrings();
        words.sort(String.CASE_INSENSITIVE_ORDER);
        return words;
    }


    public List<String> getWordsContainingSubstring (String subString) throws IOException {
        List<String> words = splitStrings();
        Stream<String> wordsContainingSubstring = words.stream().filter(word -> word.contains(subString));
        return wordsContainingSubstring.collect(Collectors.toList());
    }


    public List<String> getStringsWhichPalindromes () throws IOException {
        List<String> words = splitStrings();
        Stream<String> wordsWhichArePalindromes = words.stream().filter(word -> word.equals(reverseString(word)));
        return wordsWhichArePalindromes.collect(Collectors.toList());
    }


    private List<String> splitStrings() throws IOException {
        String text = filePartReader.readLines(filepath, 2, 4);
        return Arrays.asList(text
                .replace("."," ")
                .replace(",", " ")
                .split("\\s+"));
    }


    private String reverseString(String string) {
        StringBuilder sb = new StringBuilder();
        for (int index = string.length() - 1; index >= 0; index--) {
            sb.append(string.charAt(index));
        }
        return sb.toString();
    }

}
