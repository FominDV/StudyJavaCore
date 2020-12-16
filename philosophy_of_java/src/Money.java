public enum  Money {
    RUB(1), DOLLAR(30.2), ERO(72.1);
    private double cost;
    Money(double cost){
        this.cost=cost;
    }
    public void printCost(){
        System.out.println(ordinal()+name()+": "+cost);
    }
}
