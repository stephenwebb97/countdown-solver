package webb.stephen.countdown.letters;

import java.util.HashMap;

public class Word {

    private String word;

    private Integer differentLetter;

    private HashMap<Character,Integer> matching;

    private Integer matchLetter;

    Word(String word){
        this.setDifferentLetter(0) ;
        this.setMatching(new HashMap<>());
        this.setMatchLetter(0);
        this.setWord(word);
    }


    public Integer length(){
        return this.getWord().length();
    }

    public boolean found(){
        return this.getDifferentLetter() <= this.getMatchLetter();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
        this.parse(word);
    }


    public boolean checkAndIncrement(Character letter,Integer occurrenceCount){
        HashMap<Character,Integer> match = getMatching();
        if (match.containsKey(letter)){
            if (match.get(letter) >= occurrenceCount){
                this.incrementMatchLetter();
                return true;
            }
        }
        return false;
    }

    private boolean parseCharater(Character letter){
        HashMap<Character,Integer> match = getMatching();
        if (match.containsKey(letter)){
            match.put(letter,match.get(letter) + 1);
        }else{
            match.put(letter,1);
            this.incrementDifferentLetter();
        }

        return true;
    }

    private void parse(String word){
        for (Character letter: word.toCharArray()){
            this.parseCharater(letter);
        }
    }

    private void incrementDifferentLetter(){
        this.setDifferentLetter(this.getDifferentLetter() + 1);
    }

    private Integer getMatchLetter() {
        return matchLetter;
    }

    private void setMatchLetter(Integer matchLetter) {
        this.matchLetter = matchLetter;
    }

    private void incrementMatchLetter(){
        this.setMatchLetter(this.getMatchLetter()+1);
    }

    private Integer getDifferentLetter() {
        return differentLetter;
    }

    private void setDifferentLetter(Integer differentLetter) {
        this.differentLetter = differentLetter;
    }

    private HashMap<Character, Integer> getMatching() {
        return matching;
    }

    private void setMatching(HashMap<Character, Integer> matching) {
        this.matching = matching;
    }




}
