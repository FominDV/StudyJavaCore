import java.util.Scanner;

public class GlassWord {
    public static void main(String[] args) {
        Scanner read=new Scanner(System.in);
        System.out.println("Insert the word:");
        System.out.println("This word is glass: "+isGlassWord(read.next()));
    }
    static boolean isGlassWord(String word){
        for(int i=0;i<word.length()/2;i++){
            if(word.charAt(i)!=word.charAt(word.length()-1-i)) return false;
        }
        return true;
    }
    static boolean isGlassWord2(String word){
        int i=0;
        while (i<word.length()/2){
            if(word.charAt(i)!=word.charAt(word.length()-1-i)) return false;
            i++;
        }
        return true;
    }
}
