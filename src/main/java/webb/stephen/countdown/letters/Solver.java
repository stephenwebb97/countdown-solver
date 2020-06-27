package webb.stephen.countdown.letters;

import java.util.LinkedList;
import java.util.List;

public class Solver {

    private List<Word> dict;

    public Solver(List<Word> dict){
        setDict(dict);
    }

    public List<Word> getDict() {
        return dict;
    }
    public void setDict(List<Word> dict) {
        this.dict = dict;
    }

    public List<Word> find(Word goal){

        List<Word> found = new LinkedList<>();

        List<Word> dict = this.getDict();

        for ( Word word: dict) {
            if (word.canDerive(goal)){
                found.add(word);
            }
        }

        return found;
    }
}
