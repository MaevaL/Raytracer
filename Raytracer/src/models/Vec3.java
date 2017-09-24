package models;

public class Vec3 {  
	private double x;
	private double y;
	private double z;
	
	public Vec3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	public void setCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vec3 sum(Vec3 vec) {
		Vec3 vecSum = new Vec3(x+vec.x, y+vec.y, z+vec.z);
		return vecSum;
		
	}
	
	public Vec3 substract(Vec3 vec) {
		Vec3 vecSubstract = new Vec3(x-vec.x, y-vec.y, z-vec.z );
		return vecSubstract;

	}
	public Vec3 multiplyByVec(Vec3 vec) {
		Vec3 multipliedVec = new Vec3(0,0,0);
		multipliedVec.x = x * vec.x + x * vec.y + x * vec.z;
		multipliedVec.y = y * vec.x + y * vec.y + y * vec.z;
		multipliedVec.z = z * vec.x + z * vec.y + z * vec.z;
		return multipliedVec;

	}
	
	public Vec3 multiplyByNumber(double number) {
		Vec3 multipliedVec = new Vec3(x*number,y*number,z*number);
		return multipliedVec;

	}
	public Vec3 divide(Vec3 vec) {
		Vec3 dividedVec = new Vec3(0,0,0);
		dividedVec.x = x / vec.x + x / vec.y + x / vec.z;
		dividedVec.y = y / vec.x + y / vec.y + y / vec.z;
		dividedVec.z = z / vec.x + z / vec.y + z / vec.z;
		return dividedVec;

	}
	
	public double norme() {
		return Math.sqrt(x*x + y*y + z*z);

	}
	
	public double squareNorme(){
		double square = x*x + y*y + z*z;
		return square;
	}
	
	public Vec3 normalized() {
		Vec3 normalizedVect = new Vec3(x/norme(), y/norme(), z/norme());
		return normalizedVect;

	}
	
	public double scalarProduct(Vec3 vec) {
		return x*vec.x + y*vec.y + z*vec.z;
	}
	
	public Vec3 vectorProduct(Vec3 vec) {
		Vec3 vectorProduct = new Vec3(0,0,0) ;
		vec.x = (y*vec.z) - (z*vec.y);
		vec.y = (z*vec.x) - (x*vec.z);
		vec.z = (x*vec.y) - (y*vec.x);
		return vectorProduct;

	}

	@Override
	public boolean equals(Object vec) {
		Vec3 vec3 = (Vec3) vec;
		if(x != vec3.x || y != vec3.y || z != vec3.z) {
			return false;
		}
		return true;
	}
	public void showVec() {
		System.out.println("<" + x + "," + y + "," + z + ">");
	}

}
