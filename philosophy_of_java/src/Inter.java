public class Inter {
 private    Ar ar;
    interface A {
        void f(int i);
    }
    Inter(){
     ar=new Ar(0);
    }
Ar getAr(){
     return ar;
}
static class Ar implements A {

      static   int i;
        Ar(int i){
            this.i=i;
        }
        @Override
        public void f(int i){

        }
        public static void f1() {
            System.out.println("A"+i);
        }
    }
 private  void print(){
        System.out.println("sssss");
    }
    class B{
    void   action(){
        print();
    }
    }
}
