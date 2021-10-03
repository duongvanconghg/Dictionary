import java.io.FileNotFoundException;

public class Main {
    public static void main (String[] args) throws FileNotFoundException {
        DictionaryManagement my_dictionaryManagement = new DictionaryManagement();
        //my_dictionaryManagement.insertFromFile();
        //my_dictionaryManagement.dictionaryLookup();
        for (int i =0;i<2;i++) {
            my_dictionaryManagement.insertFromCommandline();
        }
        my_dictionaryManagement.insertF();
        my_dictionaryManagement.insertFromFile();
    }
}
