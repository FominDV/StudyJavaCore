public class Inter {
    Ar ar;
    interface A {
        void f();
    }
    Inter(){
     ar=new Ar();
    }
Ar getAr(){
     return ar;
}
 private class Ar implements A {

        @Override
        public void f() {
            System.out.println("A");
        }
    }
}
