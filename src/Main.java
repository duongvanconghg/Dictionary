import java.io.FileNotFoundException;

public class Main {
    public static void main (String[] args) throws FileNotFoundException {
        DictionaryManagement my_dictionaryManagement = new DictionaryManagement();
        my_dictionaryManagement.insertFromFile();
        my_dictionaryManagement.fixWord();
        my_dictionaryManagement.showAllWords();
        my_dictionaryManagement.exportToFile();
    }
}
