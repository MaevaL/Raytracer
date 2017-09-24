package tests;
import models.Ray;
import models.Vec3;
import utils.Utils;

public class UtilsTest {
	
	public void clampTest() {
		Utils utils = new Utils();
		double val1 = -1;
		double val2 = 125;
		double val3 = 256;
		
		double r1 = 0;
		double r2 = 125;
		double r3 = 255;
		
		if(utils.clamp(val1) != 0) {
			System.out.println("clamp doit renvoyer la valeur min");
		}
		if(utils.clamp(val2) != r2) {
			System.out.println("clamp doit renvoyer la valeur");
		}
		if(utils.clamp(val3) != r3) {
			System.out.println("clamp doit renvoyer le max");
		}
	}
	
	public void img_savedTest() {}
	

}
