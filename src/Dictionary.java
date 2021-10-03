import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> my_words = new ArrayList<Word>();

    public void setMyWord(Word new_word) {
        my_words.add(new_word);
    }

    public Word getWord(int i) {
        return my_words.get(i);
    }

    public int getSize() {
        return my_words.size();
    }

    public void sortMyDict() {
        Word temp = new Word();
        for (int i = 0; i < my_words.size(); i++)
        {
            for (int j = i + 1; j < my_words.size(); j++) {
                if (my_words.get(i).getWord_target().compareTo(my_words.get(j).getWord_target()) > 0)
                {
                    temp = my_words.get(i);
                    my_words.set(i, my_words.get(j));
                    my_words.set(j, temp);
                }
            }
        }
    }

    public void removeWord(int i) {
        my_words.remove(i);
    }

}