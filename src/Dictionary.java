public class Dictionary {
    private Word[] my_words = new Word[100];
    private int size;

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

}