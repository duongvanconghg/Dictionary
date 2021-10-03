import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryManagement {
    private  Dictionary my_dictionary = new Dictionary();

    public DictionaryManagement() {

    }

    public void insertFromCommandline() {
        System.out.println("tu moi khong vuot qua 25 ki tu: ");
        Scanner sc = new Scanner(System.in);
        String new_target = sc.nextLine();
        String new_explain = sc.nextLine();
        if (new_target.length() > 25 || new_explain.length() > 25) {
            return;
        }
        Word new_word = new Word();
        new_word.setWord_target(new_target);
        new_word.setWord_explain(new_explain);
        my_dictionary.set_my_word(new_word);
    }

    public void  insertFromFile() throws FileNotFoundException {
        File file = new File("dictionaries.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] data = line.split("\\s");
            String new_target = data[0];
            String new_explain = data[1];
            Word new_word = new Word();
            new_word.setWord_target(new_target);
            new_word.setWord_explain(new_explain);
            my_dictionary.set_my_word(new_word);
        }
        showAllWords();
    }

    public String concatALine(int no, String tg, String ex) {
        String pLine;
        StringBuilder a_line = new StringBuilder();
        StringBuilder noStr = new StringBuilder(String.valueOf(no));
        int noLength = noStr.length();
        while (noLength < 6) {
            noStr.append(" ");
            noLength++;
        }
        pLine = noStr + "|   ";
        a_line.append(pLine);
        StringBuilder tgB = new StringBuilder(tg);
        int tgLength = tg.length();
        while (tgLength < 26) {
            tgB.append(" ");
            tgLength++;
        }
        pLine = tgB + "|   ";
        a_line.append(pLine);
        StringBuilder exB = new StringBuilder(ex);
        int exLength = ex.length();
        while (exLength < 26) {
            exB.append(" ");
            exLength++;
        }
        a_line.append(exB);
        return  a_line.toString();
    }

    public void showAllWords() {
        int size = my_dictionary.getSize();
        System.out.println("No    |   English                   |   Vietnamese");
        for (int i = 0; i < size; i++) {
            //no = "     |  "; tg = "                    |  "; ex = "                    ";
            int num = i + 1;
            Word my_word = my_dictionary.getWord(i);
            String tg = my_word.getWord_target();
            String ex = my_word.getWord_explain();
            String a_line = concatALine(i + 1, tg, ex);
            System.out.println(a_line);
        }
    }

    public void dictionaryBasic() {
        insertFromCommandline();
        showAllWords();
    }

    public void dictionaryLookup() throws FileNotFoundException {
        File file = new File("dictionaries.txt");
        Scanner sc = new Scanner(file);
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap tu ban muon tim kiem: ");
        String s = scanner.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] data = line.split("");
            String el = data[0];
            String vn = data[1];
            if (el.contains(s)) {
                System.out.format("%-25s %-25s\n", el, vn);
            }

        }
    }

}