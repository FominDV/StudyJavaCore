import java.util.Random;

public class Test6 {
    public static void main(String[] args) {
        AA[] arrA=new AA[10];
        for(int i=0;i<10;i++) arrA[i]=new AA(i);
        BB bb=new BB();
        for(int i=0;i<arrA.length;i++) bb.setU(arrA[i].getU(),i);
        bb.actionU();
        for(int i=0;i<3;i++){
            bb.removeU(new Random().nextInt(10));
        }
        bb.actionU();
    }
}

interface U {
    void a();

    void b();

    void c();
}

class AA {
    AA(int index){
        count=index;
    }
     int count;
    U getU() {
        return new U() {

            @Override
            public void a() {
                System.out.println("a"+count);
            }

            @Override
            public void b() {
                System.out.println("b"+count);
            }

            @Override
            public void c() {
                System.out.println("c"+count);
            }

        };
    }
}

class BB {
    private U[] arrU = new U[10];

    void setU(U u, int index) {
        arrU[index] = u;
    }

    void removeU(int index) {
       arrU[index]=null;
    }

    void actionU() {
        for (U element : arrU) {
            if(element==null) continue;
            element.a();
            element.b();
            element.c();
        }
    }
}
