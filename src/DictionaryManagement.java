import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryManagement {
    private  Dictionary my_dictionary = new Dictionary();

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
        my_dictionary.setMyWord(new_word);
        my_dictionary.sortMyDict();
    }

    public void insertFromFile() throws FileNotFoundException {
        try {
            FileReader fr = new FileReader("dictionaries.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] data = line.split("\t", 2);
                String new_target = data[0];
                String new_explain = data[1];
                Word new_word = new Word();
                new_word.setWord_target(new_target);
                new_word.setWord_explain(new_explain);
                my_dictionary.setMyWord(new_word);
            }
            my_dictionary.sortMyDict();
            br.close();
            fr.close();
        } catch (Exception e) {

        }
    }

    public void exportToFile() {
        try {
            FileWriter fw = new FileWriter("dictionaries.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < my_dictionary.getSize(); i++) {
                bw.write(my_dictionary.getWord(i).getWord_target() + "\t"
                + my_dictionary.getWord(i).getWord_explain());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {

        }
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

    public void showWords(int i, String tg, String ex) {
        String a_line = concatALine(i, tg, ex);
        System.out.println(a_line);
    }

    public void showAllWords() {
        int size = my_dictionary.getSize();
        System.out.println("No    |   English                   |   Vietnamese");
        for (int i = 0; i < size; i++) {
            int num = i + 1;
            Word my_word = my_dictionary.getWord(i);
            String tg = my_word.getWord_target();
            String ex = my_word.getWord_explain();
            showWords(i + 1, tg, ex);
        }
    }

    public void dictionaryLookup() throws FileNotFoundException {
            System.out.print("nhap tu ban muon tim kiem: ");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine().toLowerCase();
            boolean isContain = false;
            int count = 0;
            int i = 1;
            while (count < my_dictionary.getSize()) {
                if (my_dictionary.getWord(count).getWord_target().toLowerCase().contains(s)) {
                    if (!isContain) {
                        System.out.println("No    |   English                   |   Vietnamese");
                    }
                    isContain = true;
                    showWords(i, my_dictionary.getWord(count).getWord_target(),
                            my_dictionary.getWord(count).getWord_explain());
                    i++;
                }
                count++;
            }
            if (!isContain) {
                System.out.println("Tu moi chua duoc cap nhat.");
            }
    }

    public void fixWord() {
        System.out.print("nhap tu ban muon sua: ");
        Scanner sc = new Scanner(System.in);
        String tg = sc.nextLine().toLowerCase();
        System.out.print("nghia moi: ");
        String newEx = sc.nextLine();
        boolean isExist = false;
        int count = 0;
        while (count < my_dictionary.getSize()) {
            if (my_dictionary.getWord(count).getWord_target().toLowerCase().equals(tg)) {
                isExist = true;
                my_dictionary.getWord(count).setWord_explain(newEx);
            }
            count++;
        }
        if (isExist) {
            System.out.println("Da sua!");
        } else {
            System.out.println("Khong co tu nay trong tu dien!");
        }
    }

    public void removeWord() {
        System.out.print("nhap tu ban muon xoa: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        boolean isExist = false;
        int count = 0;
        while (count < my_dictionary.getSize()) {
            if (my_dictionary.getWord(count).getWord_target().toLowerCase().equals(s)) {
                isExist = true;
                my_dictionary.removeWord(count);
                count--;
            }
            count++;
        }
        if (isExist) {
            System.out.println("Da xoa!");
        } else {
            System.out.println("Khong co tu nay trong tu dien!");
        }
    }

}