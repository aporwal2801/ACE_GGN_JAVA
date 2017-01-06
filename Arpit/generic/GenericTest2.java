package generic;

public class GenericTest2 {
	
	public static <T> void method(T a, T b){
		a = b;
		System.out.println(a.toString());
		System.out.println(b.toString());
	}

	public static void main(String[] args) {
		method("dfsdf", 45);
	}


}
