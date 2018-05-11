package tg;

public class TestgenE {
	
	
	public boolean getBool(int a, int b, int c, int d, int e, int f, int g, int h) {
		int k = 0;
		
		if(a == 1) {
				if(b == 2) {
						if(c == 3) {
							k = 1;
						}
						else k = 0;
				}
				else k = 0;
		}
		else k = 0;
		
		int[] array = new int[] {d, e, f, g, h};
		
		for(int i = 0; i < array.length; i++){
			if(array[i] < 0)
				k = 0;
		}
		
		
		if(k == 1) return true;
		else	   return false;
						
			
	}
}
