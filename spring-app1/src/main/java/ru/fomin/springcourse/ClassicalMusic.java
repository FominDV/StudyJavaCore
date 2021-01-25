package ru.fomin.springcourse;

public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Simphony";
    }
private void privateInit(){
  //  System.out.println("privateInit");
    
    try {
        System.out.println(getClass().getDeclaredMethod("privateInit",null));
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    }
}
}
