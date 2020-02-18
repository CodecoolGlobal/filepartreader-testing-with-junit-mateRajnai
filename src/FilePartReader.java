import java.io.*;

public class FilePartReader {

    public void setup(String filepath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine) throw new IllegalArgumentException("fromLine must be smaller or equal to toLine");
        if (fromLine < 1) throw new IllegalArgumentException("fromLine is smaller than 1");
    }

    public String read(String filepath) throws IOException {
        File file = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
            sb.append('\n');
        }
        return sb.toString();
    }

    public String readLines(String filepath, Integer fromLine, Integer toLine) throws IOException {
        String[] fileContent = read(filepath).split("\n");
        StringBuilder sb = new StringBuilder();
        for (int numberOfLine = 1; numberOfLine <= toLine; numberOfLine++ ) {
            if (fromLine <= numberOfLine) {
                sb.append(fileContent[numberOfLine - 1]);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
