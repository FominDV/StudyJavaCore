import java.util.Scanner;

public class Graph {

        static int[] weightsOfVertexes;
        static int countOfVertex,countOfTraces;
        public static void main(String[] args) {
            readData();
    }
    static void readData(){
            Scanner scanner=new Scanner(System.in);
            countOfVertex=scanner.nextInt();
            weightsOfVertexes=new int[countOfTraces];
            int index=0;
            for(String weight: scanner.nextLine().split(" "))
                weightsOfVertexes[index++]=Integer.parseInt(weight);

    }
}
