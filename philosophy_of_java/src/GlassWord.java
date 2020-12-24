import java.util.Scanner;

public class GlassWord {
    public static void main(String[] args) {
        Scanner read=new Scanner(System.in);
        System.out.println("Insert the word:");
      String  word=read.next();
        System.out.println("This word is glass: "+isGlassWord(word));
        isGlassWord2(word);
    }
    static boolean isGlassWord(String word){
        for(int i=0;i<word.length()/2;i++){
            if(word.charAt(i)!=word.charAt(word.length()-1-i)) return false;
        }
        return true;
    }
    static boolean isGlassWord2(String word){
      int value= word.compareTo("q");
      System.out.println("value: "+value);
        return true;
    }
}
