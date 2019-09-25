package tests;

public class pi {
	public static void main(String[] args) {
		double sum = 0;
			int predznak = 1;
			for(int n=0;;n++) {
			 sum += predznak * 4.0 / (2*n+1);
					 System.out.println(sum);
					 predznak*=-1;
			}
	}		
}