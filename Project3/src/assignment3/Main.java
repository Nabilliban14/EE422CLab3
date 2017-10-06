/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * Nabil Khan
 * nk7742
 * Unique No. 16275
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL:
 * Fall 2017
 */


package assignment3;
import java.util.*;
import java.io.*;

public class Main {

    // static variables and constants only here.

    public static void main(String[] args) throws Exception {

        Scanner kb = new Scanner(System.in);	// input Scanner for commands
        //PrintStream ps;	// output file, for student testing and grading only
        // If arguments are specified, read/write from/to files instead of Std IO.
        /*if (args.length != 0) {
            kb = new Scanner(new File(args[0]));
            ps = new PrintStream(new File(args[1]));
            System.setOut(ps);			// redirect output to ps
        } else {
            kb = new Scanner(System.in);// default input from Stdin
            ps = System.out;			// default output to Stdout
        }*/
        while(true) {
        ArrayList<String> input = parse(kb);

        ArrayList<String> output = getWordLadderBFS(input.get(0),input.get(1));

        printLadder(output);
        }

        
        
        
        

        // TODO methods to read in words, output ladder
    //kb.close();
    }

    public static void initialize() {
        // initialize your static variables or constants here.
        // We will call this method before running our JUNIT tests.  So call it
        // only once at the start of main.
    }

    /**
     * @param keyboard Scanner connected to System.in
     * @return ArrayList of Strings containing start word and end word.
     * If command is /quit, return empty ArrayList.
     */
    public static ArrayList<String> parse(Scanner keyboard) {
        ArrayList<String> result = new ArrayList<String>();
        String input = keyboard.nextLine();
        if(input.contentEquals("quit")) {
        
        }
        else{
        String[] arr = input.split("[^a-zA-Z]+");
        result.add(arr[0]);
        result.add(arr[1]);
    }



        return result;
    }

    public static ArrayList<String> getWordLadderDFS(String start, String end) {

        // Returned list should be ordered start to end.  Include start and end.
        // If ladder is empty, return list with just start and end.
        // TODO some code
        Set<String> dict = makeDictionary();
        // TODO more code

        return null; // replace this line later with real return
    }

    public static ArrayList<String> getWordLadderBFS(String start, String end) {

        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> isVisited = new ArrayList<String>();
        
        Queue<word> list =  new LinkedList<word>();
        Set<String> dict = makeDictionary();
        dict.add(end);
        word current_word_obj = new word(start.toLowerCase());
        isVisited.add(current_word_obj.getValue().toLowerCase());
        list.add(current_word_obj);
        while(!list.isEmpty()){
            current_word_obj = list.poll();
            
            if((current_word_obj.getValue()).contentEquals(end.toLowerCase())){ // compares and breaks the loop if result is found
               break; 
            }
            else{
            // generate new words
            for(int i =0; i< (current_word_obj.getValue()).length();i++){
            char [] temp_word = (current_word_obj.getValue()).toCharArray();
            for(char t = 'a'; t <= 'z'; t++){

                temp_word[i] = t;
                String new_word = new String(temp_word);
                // check if the word created is already visited and is in dictionary
                if((!(isVisited.contains(new_word.toLowerCase())))&&(dict.contains(new_word.toUpperCase()))){
               // create new word object, add it to is visited list and set its parent     
                	isVisited.add(new_word.toLowerCase());
                    word new_word_obj = new word(new_word);	
                    new_word_obj.setParent(current_word_obj);
                    list.add(new_word_obj);                   
                    }
                }
            }
        }
    }
        if(!list.isEmpty()){
            while(current_word_obj.getParent()!= null){
                result.add(0,current_word_obj.getValue());
                current_word_obj = current_word_obj.getParent();
            }
            result.add(0,current_word_obj.getValue());
        }
        else
        {
            result.add("no word ladder can be found between ");
            result.add(start);
            result.add(" and ");
            result.add(end);
            result.add(".");
            
        }
        return result; // replace this line later with real return
    }


    public static void printLadder(ArrayList<String> ladder) {

        for(int i=0; i< ladder.size();i++){
            System.out.println(ladder.get(i));
        }

    }
    // TODO
    // Other private static methods here


    /* Do not modify makeDictionary */
    public static Set<String>  makeDictionary () {
        Set<String> words = new HashSet<String>();
        Scanner infile = null;
        try {
            infile = new Scanner (new File("five_letter_words.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Dictionary File not Found!");
            e.printStackTrace();
            System.exit(1);
        }
        while (infile.hasNext()) {
            words.add(infile.next().toUpperCase());
        }
        return words;
    }
}
