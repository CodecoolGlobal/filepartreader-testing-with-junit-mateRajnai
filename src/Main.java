import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String filepath = "src/alma.txt";

        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup(filepath, 2, 4);
        String fileContent = filePartReader.read(filepath);
        filePartReader.readLines(filepath, 2, 4);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader, filepath);
        fileWordAnalyzer.getWordsOrderedAlphabetically();
        fileWordAnalyzer.getWordsContainingSubstring("fanyar");
        fileWordAnalyzer.getStringsWhichPalindromes();
    }
}
