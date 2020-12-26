import java.util.SortedSet;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

class testThread {
    public static void main(String[] args) {

        ExecutorService executorService= Executors.newCachedThreadPool();
        Future future1=executorService.submit(runnable1);

        Future future2=executorService.submit(runnable2);
        executorService.shutdown();
        try {
            System.out.printf("%s %s%n", future1.get(), future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
  static Callable runnable1= () -> {
       int sum=1;
        for(int i=1;i<10;i++) {System.out.print(i+" ");sum*=i;
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

      System.out.println("\n");
      return sum;
  };
    static  Runnable runnable2= () -> {
        for(int i=0;i<10;i++) System.out.print(-i+" ");
        System.out.println("\n");
    };
}
