public class ConsolTest{
	public static void main(String[] args){
		StringBuilder builder=new StringBuilder("[");
		for(int i=0; i<10;i++){
			 builder.append(i);
			builder.append(", ");
		}
		builder.delete(builder.length()-2,2);
		System.out.println(builder);
	}
}