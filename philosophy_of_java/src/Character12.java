import java.util.Formatter;

public class Character12 {
    public static void main(String[] args) {
        int x=12;
        float y=12.5f;
        String f="[%d;%f]\n";
        System.out.printf(f,x,y);
        System.out.format(f,x,y);
        System.out.println(String.format(f,x,y));
        /////////////////////
        class Print{
            Formatter formatter;
            Print(Formatter formatter){
                this.formatter=formatter;
            }
           void print(int x){
                formatter.format("print %d\n",x);
           }
        }
        Print p=new Print(new Formatter(System.out));
        p.print(11);
        //////////////////////
        System.out.printf("%-6.1f:%-15s",112.22,"hi");
    }
}
