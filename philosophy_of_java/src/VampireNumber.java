import java.util.Vector;

public class VampireNumber {
    public static void main(String[] args) {
        Vector<Integer> multiplicationOfVampireNumbers=new Vector<>();
        int multiplication;
        for (int i = 10; i < 99; i++) {
            for (int j = 10; j < 99; j++) {
                multiplication=i*j;
                if ((i % 10 == 0 && j % 10 == 0) || multiplication < 1000) continue;
                if (isVampireNumber(i, j, multiplication)) {
                    if(isNotAlreadyAdded(multiplicationOfVampireNumbers, multiplication)){
                    multiplicationOfVampireNumbers.add(i*j);System.out.println(i + "*" + j + "=" + i * j);}
                }
            }
        }
    }

    private static boolean isNotAlreadyAdded(Vector<Integer> multiplicationOfVampireNumbers, int nowMultiplication) {
        for(int multiplication: multiplicationOfVampireNumbers){
            if(multiplication==nowMultiplication)
                return false;
        }
        return true;
    }

    private static boolean isVampireNumber(int i, int j, int multiplication) {
        int[] numbers = {i / 10, i % 10, j / 10, j % 10};
        int[] numbersOfMultiplication = {multiplication / 1000, multiplication / 100 % 10, multiplication / 10 % 10, multiplication % 10};
        start:
        for (int a = 0; a < numbers.length; a++) {
            for (int b = 0; b < numbers.length; b++) {
                if (numbers[a] == numbersOfMultiplication[b]) {
                    numbersOfMultiplication[b]=-1;
                    continue start;
                }
            }
            return false;
        }
        return true;
    }
}
