import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    void setup() {
        FilePartReader filePartReader = new FilePartReader();

    }

    @Test
    public void testFileNotBeFound() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(FileNotFoundException.class, ()-> {
            filePartReader.read("src/kecske.txt");
        });
    }

    @Test
    void readLines() {
    }
}