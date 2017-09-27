package tests;

import models.Intersection;
import models.Light;
import models.Ray;
import models.Scene;
import models.Sphere;
import models.Vec3;
import utils.TracingUtils;

public class TracingUtilsTest {
	
	public static void intersecTest() {
		Vec3 origin = new Vec3(0,0,0);
		Vec3 direction = new Vec3(1,0,0);
		
		Ray r = new Ray(origin, direction);
		
		Vec3 color = new Vec3(0,0,0);
		Sphere s1 = new Sphere(origin, color, 1, false);
		
		Double inter = 0.0;
		inter = TracingUtils.intersec(r, s1);
		double result = 1;
		
		if(inter != result) {
			System.out.println("Bad Itersection");
		}
		
		Vec3 originSphere = new Vec3(-2,0,0);
		Sphere s2 = new Sphere(originSphere, color, 1, false);
		inter = TracingUtils.intersec(r, s2);
		
		if(inter != null) {
			System.out.println("Bad Intersection : must be null");
		}
		
		originSphere.setCoordinate(2, 0, 0);
		Sphere s3 = new Sphere(origin, color, 1, false);
		inter = TracingUtils.intersec(r, s3);
		result = 1;
		
		if(inter != 1) {
			System.out.println("Bad Intersection");
		}		
		
	}
	
	public static void intersecSceneTest() {
		Vec3 vecS1 = new Vec3(2,0,0);
		Vec3 vecS2 = new Vec3(6,0,0);
		Vec3 color = new Vec3(255,0,0);
		
		Sphere sphere1 = new Sphere(vecS1, color, 1, false);
		Sphere sphere2 = new Sphere(vecS2, color, 1, false);
		
		Scene scene = new Scene();
		scene.addSphere(sphere1);
		scene.addSphere(sphere2);
		
		Vec3 origin = new Vec3(0,0,0);
		Vec3 direction = new Vec3(1,0,0);
		
		Ray r = new Ray(origin, direction);
		Intersection inter = null;
		inter = TracingUtils.intersecScene(scene, r);
		
		if(inter.getDistanceT() != 1) {
			System.out.println("Bad distance");
		}
		if(!inter.getIntersecPoint().equals(new Vec3(1,0,0))) {
			System.out.println("Bad position");
		}
		
		Vec3 vecS3 = new Vec3(6,0,0);
		Vec3 vecS4 = new Vec3(-2,0,0);
		
		Sphere sphere3 = new Sphere(vecS3, color, 1, false);
		Sphere sphere4 = new Sphere(vecS4, color, 1, false);
		
		scene = new Scene();
		scene.addSphere(sphere3);
		scene.addSphere(sphere4);
		
		inter = TracingUtils.intersecScene(scene, r);
		
		if(inter.getDistanceT() != 5) {
			System.out.println("Bad distance");
		}
		if(!inter.getIntersecPoint().equals(new Vec3(5,0,0))){
			System.out.println("Bad position");
		}
		
		Vec3 vecS5 = new Vec3(-6,0,0);
		Vec3 vecS6 = new Vec3(-2,0,0);
		
		Sphere sphere5 = new Sphere(vecS5, color, 1, false);
		Sphere sphere6 = new Sphere(vecS6, color, 1, false);
		
		scene = new Scene();
		scene.addSphere(sphere5);
		scene.addSphere(sphere6);
		
		inter = TracingUtils.intersecScene(scene, r);
		
		if(inter != null) {
			System.out.println("Bad distance");
			System.out.println("Bad position");
		}	
	}
	
	public static void is_in_shadowTest() {
		Sphere sphere = new Sphere(new Vec3(6,0,0), new Vec3(0,0,0), 1, false);
		Sphere sphere2 = new Sphere(new Vec3(8,0,0), new Vec3(0,0,0), 1, false);
		Light light = new Light(new Vec3(10,0,0), 10000);
		
		Vec3 direction = new Vec3(1,0,0);
		Ray r = new Ray(new Vec3(0,0,0), direction);
		
		Scene scene = new Scene();
		scene.addSphere(sphere);
		scene.addSphere(sphere2);
		scene.addLight(light);
		
		Intersection inter = TracingUtils.intersecScene(scene, r);
		
		//Boolean b = TracingUtils.is_in_shadow(inter, light, scene);
		//System.out.println(b + "valeur true");
	}
	
	public static void main(String[] args) {
		intersecTest();
		intersecSceneTest();
		//is_in_shadowTest();
		
		
	}
}
