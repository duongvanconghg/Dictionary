import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private Word[] my_words = new Word[100];
    private int size;
    /*
    public List<Word> list = new ArrayList<>();
    public void addWord() {
        for (int i = 0;i<size ;i++) {
            list.add(my_words[i]);
        }
    }
*/
    public Dictionary() {
        size = 0;
    }

    public void set_my_word(Word new_word) {
        my_words[size] = new_word;
        size++;
    }

    public Word getWord(int i) {
        return my_words[i];
    }

    public int getSize() {
        return size;
    }

    public void insertFromFile01() {
        try {
            FileWriter fw = new FileWriter("dictionaries.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i=0;i<size ;i++) {
                bw.write(my_words[i].toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
           
            int i = 0;

        }
    }


}