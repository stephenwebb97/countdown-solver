package webb.stephen;

import webb.stephen.countdown.letters.Loader;
import webb.stephen.countdown.letters.Word;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<Word> fromText = Loader.loadText("/home/stephen/personal-project/src/main/java/webb/stephen/countdown/letters/words.txt");
            Loader.storeJson("/home/stephen/personal-project/src/main/java/webb/stephen/countdown/letters/words.json",fromText);
            List<Word> jsonCheck = Loader.loadJson("/home/stephen/personal-project/src/main/java/webb/stephen/countdown/letters/words.json");
        }catch (Exception e){
            System.out.println(e.toString());
        }



    }
}
