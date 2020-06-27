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

    static public List<Word> loadJson(String path) throws IOException {
        BufferedReader reader = getBufferedReader(path);
        Gson gson = new Gson();
        List<Word> ret =  gson.fromJson(reader,new TypeToken<List<Word>>(){}.getType());
        reader.close();
        return ret;
    }

    static public void storeJson(String path,List<Word> wordList) throws IOException {
        Gson gson = new Gson();
        FileWriter fileWriter = new FileWriter(path);
        gson.toJson(wordList, fileWriter);
        fileWriter.close();
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
        reader.close();
        return wordList;
    }
}
