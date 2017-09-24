package utils;

import java.util.ArrayList;
import java.util.List;

import models.Scene;
import models.Sphere;
import models.Vec3;
import tests.RayTest;
import tests.UtilsTest;
import tests.Vec3Test;

public class Main {

	private static Scene createScene() {
		double cadre = 2000;
		Vec3 v1 = new Vec3(0, 0, -80);
		Vec3 v2 = new Vec3(0, -cadre - 20, 0);
		Vec3 v3 = new Vec3(0, cadre + 20, 0);
		Vec3 v4 = new Vec3(-cadre - 20, 0, 0);
		Vec3 v5 = new Vec3(cadre +20, 0, 0); 
		Vec3 v6 = new Vec3(0, 0, -cadre - 100);

		double r1 = 15;
		double r3 = 2000;
		double r4 = 2000;
		double r5 = 2000;
		double r6 = 2000;
		double r2 = 2000;

		Vec3 c1 = new Vec3(255, 0, 0);   // rouge
		Vec3 c2 = new Vec3(0, 154, 255); // bleu
		Vec3 c3 = new Vec3(0, 255, 51);  // vert
		Vec3 c4 = new Vec3(255, 260, 0); // jaune
		Vec3 c5 = new Vec3(255, 85, 0);  // orange
		Vec3 c6 = new Vec3(128, 119, 115); // gris 

		Sphere s1 = new Sphere(v1, c1, r1, false); // sphere
		Sphere s2 = new Sphere(v2, c2, r2, false); // sol
		Sphere s3 = new Sphere(v3, c3, r3, false); // plafond
		Sphere s4 = new Sphere(v4, c4, r4, false); // mur gauche 
		Sphere s5 = new Sphere(v5, c5, r5, true); // mur droit
		Sphere s6 = new Sphere(v6, c6, r6, true); // mur du fond
		

		Scene scene = new Scene();
		scene.addSphere(s1);
		scene.addSphere(s2);
		scene.addSphere(s3);
		scene.addSphere(s4);
		scene.addSphere(s5);
		scene.addSphere(s6);
		return scene;
	}

	public static void main(String[] args) {
		//TEST
		Vec3Test vec = new Vec3Test();
		vec.sumTest();
		vec.multiplyByVecTest();
		vec.multiplyByNumberTest();
		vec.normeTest();
		vec.squareNormeTest();
		vec.normalizedTest();
		vec.scalarProductTest();
		vec.productVectorTest();
		
		UtilsTest utils = new UtilsTest();
		utils.clampTest();
		
		RayTest ray = new RayTest();
		ray.position3DTest();
		
		//TracingUtilsTest.intersecTest();
		System.out.println("test done");
		//TEST
		
		//CAS EXEMPLE
		int h = 1024;
		List<Vec3> image = new ArrayList<Vec3>();
		double fov = Math.PI/3;
		
		//image.addAll(TracingUtils.raytracer(h, h, fov, sphere)); deprecated
		
		Scene scene = createScene();
		
		image = new ArrayList<Vec3>();
		
		image = TracingUtils.raytracer(h, h, fov, scene);
		Utils.save_img(image, h, h, "testExemple2");
		
		System.out.println("done");
		
		
		//CAS EXEMPLE
		

	}

	
}
