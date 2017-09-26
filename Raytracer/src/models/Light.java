package models;

public class Light {
	Vec3 position;
	double intensity;

	public Light(Vec3 position, double intensity) {
		this.position = position;
		this.intensity = intensity;
	}

	public Vec3 getPosition() {
		return position;
	}
	public void setPosition(Vec3 position) {
		this.position = position;
	}
	public double getIntensity() {
		return intensity;
	}
	public void setPower(double intensity) {
		this.intensity = intensity;
	}
}
