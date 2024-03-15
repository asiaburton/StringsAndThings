package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input) {
        // make input lowercase so it is not case-sensitive
        input.toLowerCase();
        String[] words = input.split(" ");
        int counter = 0;
        for(String word : words) {
            if(word.endsWith("y") || word.endsWith("z")) {
                counter++;
            }
        }

        return counter;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){

        return base.replace(remove,"");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        // make input word lowercase so it is not case-sensitive
        input.toLowerCase();
        // initialize counters and condition
        int is = 0;
        int not = 0;

        // split input into an array of Strings
        String[] words = input.split("");
        // check if the string "is" or "not" appears anywhere in the input string
        // iterate through words array check if index equals is or not - if so count 1
        for(int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (letter == 'i') {
                if (foundIsAtPoint(i, input)) {
                    is++;
                }
            }
            if (letter == 'n') {
                if (foundNotAtPoint(i, input)) {
                    not++;
                }
            }
        }
        return (is == not);
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        boolean answer = false;
        for(int i = 0; i < input.length(); i++) {
            answer = input.contains("gg");
        }

        return answer;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int counter = 0;
        for(int i = 0; i < input.length()-1; i++) {
            if(input.charAt(i) == input.charAt(i+1) && input.charAt(i) == input.charAt(i+2) ){
                counter++;
            }

        }
        return counter;
    }

    public boolean foundIsAtPoint(int i, String word) {
        if(word.length()-i < 2) {
            return false;
        }
        return word.substring(i,i+2).contains("is");
    }

    public boolean foundNotAtPoint(int i, String word) {
        if(word.length()-i < 3) {
            return false;
        }
        return word.substring(i,i+3).contains("not");
    }
}
