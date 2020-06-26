package webb.stephen.countdown.letters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.List;

public class Loader {

    private static String cleanString(String in){
        return in.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    }

    private static BufferedReader getBufferedReader(String path) throws FileNotFoundException {
        File file = new File(path);
        return new BufferedReader(new FileReader(file));
    }

    static public List<Word> loadJson(String path) throws FileNotFoundException {
        BufferedReader reader = getBufferedReader(path);
        Gson gson = new Gson();
        return gson.fromJson(reader,new TypeToken<List<Word>>(){}.getType());
    }

    static public void storeJson(String path,List<Word> wordList) throws IOException {
        Gson gson = new Gson();
        gson.toJson(wordList, new FileWriter(path));
    }



    static public List<Word> loadText(String path) throws IOException {
        List<Word> wordList = new WordList();
        String st;
        BufferedReader reader = getBufferedReader(path);
        while ((st = reader.readLine())!= null){
            st = cleanString(st);
            if (st.length() <= 9){
                wordList.add(new Word(st));
            }
        }
        return wordList;
    }
}
