package models;

/**
 * Sphere object containing informations about origin, color, material
 * @author Maeva
 *
 */
public class Sphere {
	private Vec3 origin = new Vec3(0,0,0);
	private Vec3 color = new Vec3(0,0,0);
	private double raySphere = 0;
	private Boolean is_mirror = false;
	
	/**
	 * 
	 * @param origin position of the sphere
	 * @param color color of the sphere
	 * @param raySphere radius of the sphere
	 * @param is_mirror
	 * 
	 **/
	public Sphere(Vec3 origin, Vec3 color, double raySphere, Boolean is_mirror) {
		this.origin = origin;
		this.color = color;
		this.raySphere = raySphere;
		this.is_mirror = is_mirror;
	}
	
	public Vec3 getColor() {
		return color;
	}

	public void setColor(Vec3 color) {
		this.color = color;
	}

	public Boolean getIs_mirror() {
		return is_mirror;
	}

	public void setIs_mirror(Boolean is_mirror) {
		this.is_mirror = is_mirror;
	}


	public Vec3 getOrigin() {
		return origin;
	}

	public void setOrigin(Vec3 origin) {
		this.origin = origin;
	}

	public double getRaySphere() {
		return raySphere;
	}

	public void setRaySphere(double raySphere) {
		this.raySphere = raySphere;
	}
	

	
	
	

}
