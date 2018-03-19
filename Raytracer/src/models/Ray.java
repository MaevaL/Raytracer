package models;

/**
 * Ray object containing all infos 
 * @author Maeva
 *
 */
public class Ray {
	private Vec3 origine = new Vec3(0,0,0);
	private Vec3 direction = new Vec3(0,0,0);
	
	public Ray(Vec3 r1, Vec3 r2){
		origine.setCoordinate(r1.getX(),r1.getY(), r1.getZ());
		direction.setCoordinate(r2.getX(),r2.getY(), r2.getZ());
		direction = direction.normalized();
}
	
	public Vec3 getOrigine() {
		return origine;
	}

	public void setOrigine(Vec3 origine) {
		this.origine = origine;
	}

	public Vec3 getDirection() {
		return direction;
	}

	public void setDirection(Vec3 direction) {
		this.direction = direction;
	}
	
	// return a point at a specific distance on the ray
	public Vec3 position3D(double t) {
		Vec3 r = origine.sum(direction.multiplyByNumber(t));
		return r;
	}

	

}
