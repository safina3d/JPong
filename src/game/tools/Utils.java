package game.tools;

public class Utils {

	public static int clamp(int val, int min, int max){
		if(val < min) return min;
		if(val > max) return max;
		return val;
	}
	
	
	
	public static boolean memeSigne(int v1, int v2){
		return (v1 >> 31 == v2 >> 31);
	}
	
	
}
