public class test5 {
    public static void main(String[] args) {
        test5 test = new test5();
        Parent parent = test.getParent(15, "sssss");
parent.print();
    }
//Тут по идее должно быть объявлено final String j. Информации и книги "Философия Java"
  public   Parent getParent(int i,String j) {
        return new Parent(i) {
            private String jj=j;



            public void print() {
                System.out.println(jj);
            }
        };
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
