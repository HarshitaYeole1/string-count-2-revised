import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by harshita on 23/8/16.
 */
public class WordCounter {


    private String filename;
    private int numberOfOccurencesOfWords;
    private Map<String, Integer> m = new HashMap<>();


    public WordCounter(String file, int numberOfOccurencesOfWords) {


        setFilename(file);
        setNumberOfOccurencesOfWords(numberOfOccurencesOfWords);
        //assert filename!=null : "file name is null!!!!!";
    }

    public void setFilename(String filename) {

        if (filename == null) {
            throw new NullPointerException("File name is null!!!!");
        }

        this.filename = filename;

    }

    public void setNumberOfOccurencesOfWords(int numberOfOccurencesOfWords) {
        if (numberOfOccurencesOfWords<1 || numberOfOccurencesOfWords>9)
        {
            throw new NullPointerException("INcorrect number of occurences!!!!!!!!!!!!!!!!!!");
        }
        this.numberOfOccurencesOfWords = numberOfOccurencesOfWords;

    }

    public void findWords(File file)
    {

        try {
            Scanner sc = new Scanner(file);
            if(sc == null){
                throw new NullPointerException("Enter a correct file name");
            }
            else{
                sc.useDelimiter("\\s+|\\.\\s|\\,\\s+|\\;\\s+|\\\\s'+|\\.|\\,|\\:|\\;+");
                while (sc.hasNext()) {
                    String str = sc.next();
                    str = str.toLowerCase();             //to ignore cases

                    if (m.containsKey(str)) {          //if key already exists in map
                        Integer count = m.get(str);    //get its value
                        m.put(str, count + 1);         //increment value and store the key-value
                    } else {
                        m.put(str, 1);                 //if key does not exist add key-value to map
                    }
                }

            }
        }
        catch (FileNotFoundException e) {
            System.out.println("and..............te file is not found");
        }

    }
    public void displayWordFrequency(int numberOfOccurences) throws IOException {

        File file = null;
        try {
            file = new File(filename);
        } catch (NullPointerException ne) {
            System.err.println("The file is null.");
        }

        findWords(file);
        System.out.println("KEY : VALUE");
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            if (entry.getValue() >= numberOfOccurences) {

                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}


