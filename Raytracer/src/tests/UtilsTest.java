package tests;
import utils.Utils;

// Test utils methods : out of an image.
public class UtilsTest {
	
	public static void clampTest() {
		double val1 = -1;
		double val2 = 125;
		double val3 = 256;
		
		double r1 = 0;
		double r2 = 125;
		double r3 = 255;
		
		if(Utils.clamp(val1) != r1) {
			System.out.println("clamp should be returning min");
		}
		if(Utils.clamp(val2) != r2) {
			System.out.println("clamp should be returning current value");
		}
		if(Utils.clamp(val3) != r3) {
			System.out.println("clamp should be returning max");
		}
	}
	
	public void img_savedTest() {}
	
	public static void main(String[] args) {
		UtilsTest.clampTest();
		
	}

}
