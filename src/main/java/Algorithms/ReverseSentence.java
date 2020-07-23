package Algorithms;

public class ReverseSentence{
    public static void main (String[]arg){
        final String sentence = "Today is awful weather ";
        reverceSentence(sentence);

    }

    private static void reverceSentence(String sentence){
        var words = sentence.split("");
        var reverse = "";
        for(var i=words.length-1; i>=0; i--){
            reverse+=words[i]+"";
        }
        System.out.println(reverse);
    }
}
