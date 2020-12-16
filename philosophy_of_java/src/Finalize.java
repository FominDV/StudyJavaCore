public class Finalize {
    static class Book{
        int i;
        public Book(int i){
            this.i=i;
        }
    public void printI(){
            System.out.println("book: "+i);
    }
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println(i);
        }
    }
    public static void main(String[] args){

Book book1=new Book(1);
new Book(2);
      new Book(3);

book1.printI();
book1=new Book(0);
book1=new Book(-1);
        System.gc();

    }
}
