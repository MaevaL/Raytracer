package utils;

import java.util.ArrayList;
import java.util.List;

import models.Light;
import models.Scene;
import models.Sphere;
import models.Vec3;
import tests.RayTest;
import tests.TracingUtilsTest;
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

		double r1 = 5;
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

		/**
		 * Sphere of the scene.
		 * @param : position of the sphere
		 * @param : color of the sphere
		 * @param : radius of the sphere
		 * @param : is a mirror ?
		 * 
		 * @return : sphere 
		 * 
		 **/
		Sphere s1 = new Sphere(v1, c1, r1, false); // sphere
		Sphere s2 = new Sphere(v2, c2, r2, false); // sol
		Sphere s3 = new Sphere(v3, c3, r3, false); // plafond
		Sphere s4 = new Sphere(v4, c4, r4, true); // mur gauche 
		Sphere s5 = new Sphere(v5, c5, r5, false); // mur droit
		Sphere s6 = new Sphere(v6, c6, r6, false); // mur du fond
		Sphere s7 = new Sphere(new Vec3(0,-20,-60), new Vec3(255,255,255), 5, false);

		
		// Spotlight of the scene
		Light l1 = new Light(new Vec3(0,-20,-80), 100000);
		Light l2 = new Light(new Vec3(30,-30,-30), 100000);
		Light l3 = new Light(new Vec3(20,20,-30), 100000);
		Light l4 = new Light(new Vec3(30, 30, 30),100000);

		Scene scene = new Scene();
		scene.addSphere(s1);
		scene.addSphere(s2);
		scene.addSphere(s3);
		scene.addSphere(s4);
		scene.addSphere(s5);
		scene.addSphere(s6);
		//scene.addSphere(s7);

		scene.addLight(l1);
		scene.addLight(l2);
		scene.addLight(l3);
		scene.addLight(l4);

		return scene;
	}

	public static void main(String[] args) {

		int h = 1024;
		List<Vec3> image = new ArrayList<Vec3>();
		double fov = Math.PI/3;

		Scene scene = createScene(); // exemple scene

		// rayCast
		image = new ArrayList<Vec3>();
		image = TracingUtils.raytracer(h, h, fov, scene);

		// Save image
		Utils.save_img(image, h, h, "testLightShadow");

		System.out.println("Program done");
	}


}
