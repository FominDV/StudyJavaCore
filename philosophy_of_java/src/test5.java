public class test5 {
    public static void main(String[] args) {
        test5 test = new test5();
        String str="as";
        str="dd";

        Parent parent = test.getParent(15, str);

        Parent parent2 = test.getParent(12, str);
parent.print();
        parent2.print();
    }
//Тут по идее должно быть объявлено final String j. Информации и книги "Философия Java"
  public   Parent getParent(int i, String j) {

        return new Parent(i) {

            public void print() {
                System.out.println(j);
            }
        };
    }
   static class S{
       static int a=0;
    }
}

abstract class Parent {
  private   int jj;
    Parent() {
    }

    Parent(int i) {
        System.out.println("i=" + i);
    }
  abstract   void print();
}
