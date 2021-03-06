package tests;

import models.Ray;
import models.Vec3;

// Test the position returned by position3D()
public class RayTest {

	public static void position3DTest() {
		Vec3 origin = new Vec3(0,0,0);
		Vec3 direction = new Vec3(1,0,0);
		Vec3 result = new Vec3(2,0,0);
		
		Ray r = new Ray(origin, direction);
		if(!r.position3D(2).equals(result)) {
			System.out.println("position3D is wrong !");
		}	
	}
	
	public static void main(String[] args) {
		RayTest.position3DTest();
	}
}
