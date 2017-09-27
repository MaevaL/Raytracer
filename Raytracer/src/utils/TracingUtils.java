package utils;

import java.util.ArrayList;
import java.util.List;

import models.Intersection;
import models.Light;
import models.Ray;
import models.Scene;
import models.Sphere;
import models.Vec3;

public class TracingUtils {

	public static Double intersec(Ray ray, Sphere sphere) {
		double b = 2.0 * (ray.getDirection().scalarProduct(ray.getOrigine().substract(sphere.getOrigin())));
		double c = (ray.getOrigine().substract(sphere.getOrigin()).squareNorme()) - (sphere.getRaySphere()*sphere.getRaySphere());
		double delta = (b*b) - (4.0 * c);
		if (delta >= 0) {
			double x1 = -(ray.getDirection().scalarProduct(ray.getOrigine().substract(sphere.getOrigin()))) + (Math.sqrt(delta) / 2.0);
			double x2 = -(ray.getDirection().scalarProduct(ray.getOrigine().substract(sphere.getOrigin()))) - (Math.sqrt(delta) / 2.0);

			if (x1 < 0 && x2 < 0) {
				return null;
			}
			else if (x2 < 0 && x1 > 0) {
				return x1;
			}
			else
			{
				return x2;
			}
		}
		else {
			return null;
		}
	}
	
	public static List<Vec3> raytracer(int height, int width, double fov, Scene scene){
		List<Vec3> pixels = new ArrayList<Vec3>(height * width);
		for (int i = 0; i < height; i++){
			for (int j = 0; j < width; j++) {
				pixels.add(null);
			}
		}
		Vec3 origin = new Vec3(0,0,0);
		Vec3 direction = new Vec3(0,0,0);
		Vec3 color = null;
		for (int i = 0; i < height; i++){
			for (int j = 0; j < width; j++) {
				direction.setX((double)j - ((double)width / 2.0));
				direction.setY((double)i - ((double)height / 2.0));
				direction.setZ(-((double)width / (2.0 * Math.tan(fov / 2.0))));
				
				Ray r = new Ray(origin, direction);
				
				color = castRay(r, scene);
				if(color == null){
					Vec3 pixel = new Vec3(0,0,0);
					pixels.set((i*width) + j, pixel);
				}
				else {
					Vec3 pixel = color;
					pixels.set((i*width) + j, pixel);
				}
			}
		}
		
		return pixels;
	}

	private static Vec3 castRay(Ray r, Scene scene) {
		Intersection inter = intersecScene(scene, r);
		Vec3 color = null;
		if(inter == null) {
			return null;
		}
		
		if(!inter.getSphere().getIs_mirror()) {
			return inter.getSphere().getColor().divide(new Vec3(255,255,255)).multiplyByNumber(illuminationAll(r, inter, scene));
		}
		else {
			Ray reflectedRay = reflection(r, inter);
			color = castRay(reflectedRay, scene);
			if(color == null) {
				return null;
			}
			else {
				return color.multiplyByNumber(0.9);
			}
		}	
	}
	
	public static Ray reflection(Ray r, Intersection inter) {
		
		Vec3 reflectedRayDirection = inter.getNormale().multiplyByNumber(inter.getNormale().scalarProduct(r.getDirection())).multiplyByNumber(-2).sum(r.getDirection());
		
		Ray newRay = new Ray(inter.getIntersecPoint().substract(r.getDirection().multiplyByNumber(0.001)), reflectedRayDirection);
		return newRay;
	}
	
	public static double illuminationAll(Ray r, Intersection inter, Scene scene) {
		double sumlight = 0;
		for (Light light : scene.getLights()) {
			if(!is_in_shadow(inter, light, scene))
				sumlight += illumination(r, inter, light);
		}
		return sumlight;
	}

	private static double illumination(Ray r, Intersection inter, Light light) {
		double intensity = light.getIntensity();
		Vec3 n = inter.getNormale().normalized();
		
		Vec3 dirLight = (light.getPosition().substract(inter.getIntersecPoint())).normalized();
		double distLightInter = light.getPosition().substract(inter.getIntersecPoint()).squareNorme();
		
	
		return (intensity * Math.abs(n.scalarProduct(dirLight))) / (distLightInter);
	}
	
	public static Intersection intersecScene(Scene scene, Ray r){

		Double inter = 0.0;
		Double distanceMin = null;
		Sphere sphs= null;
		
		for (Sphere sphere : scene.getSpheres()) {
			inter = TracingUtils.intersec(r, sphere);
			if(inter != null) {
				if(distanceMin == null) {
					distanceMin = inter;
					sphs = sphere;
				}else if(inter < distanceMin) {
					distanceMin = inter;
					sphs = sphere;
				}
			}
		}
		if(distanceMin != null) {
			
			Vec3 normale =r.position3D(distanceMin).substract(sphs.getOrigin()).normalized(); 
			
			return new Intersection(r.position3D(distanceMin), distanceMin,sphs,normale);
		}
		return null;
	}	
	
	public static Boolean is_in_shadow(Intersection inter, Light light, Scene scene) {
		Vec3 dirInterLight = light.getPosition().substract(inter.getIntersecPoint()).normalized();
		double distInterLight = (light.getPosition().substract(inter.getIntersecPoint())).squareNorme();

		Ray r = new Ray(inter.getIntersecPoint().sum(inter.getNormale().multiplyByNumber(0.0001)),dirInterLight);
		Intersection newInter = intersecScene(scene, r);
		
		if(newInter != null) {
			double distInterInterLight = (inter.getIntersecPoint().substract(newInter.getIntersecPoint())).squareNorme();
		
	
			if(distInterInterLight < distInterLight) {
				return true;
			}	
		}
		return false;
	}
	
}
