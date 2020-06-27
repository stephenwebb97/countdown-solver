package webb.stephen;

import org.apache.commons.cli.*;

import webb.stephen.countdown.letters.Loader;
import webb.stephen.countdown.letters.Solver;
import webb.stephen.countdown.letters.Word;
import webb.stephen.countdown.letters.WordComparator;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Options options = new Options();
        Option letterOption= new Option("l", "Find all possible matching words for the supplied letters");
        letterOption.setArgs(Option.UNLIMITED_VALUES);
        options.addOption(letterOption);
        Option numberOption= new Option("n", "The List of numbers to solve -n n1 n2 n3");
        numberOption.setArgs(Option.UNLIMITED_VALUES);
        options.addOption(numberOption);
        options.addOption("r",true,"Read new line delimiter dictionary and converts it to java objects -r {PATH_TO_TEXT}");
        options.addOption("j","The Path json-java object file -j {PATH_TO_JSON}");
        options.addOption("nt",true,"The Number of threads allocated to the number solver Default:1");
        options.addOption("lt",true,"The Number of threads allocated to the letter solver Default:1");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try{
            cmd = parser.parse( options, args);
        }  catch (Exception e){
            System.out.println(e.toString());
            System.exit(-1);
            return;
        }

        Path currentPath = Paths.get("");
        String DefaultPath = currentPath.toAbsolutePath().toString();

        if (cmd.hasOption("r")){
            try {
                List<Word> fromText = Loader.loadText(cmd.getOptionValue("r",DefaultPath+"/words.txt"));
                Loader.storeJson(cmd.getOptionValue("j",DefaultPath+"/words.json"),fromText);
            }catch (Exception e){
                System.out.println(e.toString());
                System.exit(-1);
                return;
            }
        }

        if (cmd.hasOption("l")){
            List<Word> dic = null;
            try {
                dic = Loader.loadJson(cmd.getOptionValue("j",DefaultPath+"/words.json"));
            }catch (Exception e){
                System.out.println(e.toString());
                System.exit(-1);
                return;
            }
            String[] letters = cmd.getOptionValues("l");
            Word search = null;
            if (letters.length == 1){
                search = new Word(letters[0].toLowerCase());
            }else{
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < letters.length; i++) {
                    builder.append(letters[i]);
                }
                search = new Word(builder.toString().toLowerCase());
            }

            Solver solver = new Solver(dic);

            List<Word> results = solver.find(search);
            results.sort(new WordComparator());
            System.out.println("----- Letter results -----");
            for (Word word: results) {
                System.out.println(word.getWord().toUpperCase());
            }

        }





    }
}
