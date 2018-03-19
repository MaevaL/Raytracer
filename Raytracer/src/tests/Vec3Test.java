package tests;
import models.Vec3;

//Testing vector operations
public class Vec3Test {
	public static void sumTest() {
		Vec3 v1 = new Vec3(2,2,2);
		Vec3 v2 = new Vec3(2,2,2);
		Vec3 result = new Vec3(4,4,4);
		
		if(!v1.sum(v2).equals(result)){
			System.out.println("sum fail");
		}
	}
	
	public static void multiplyByVecTest() {
		Vec3 v1 = new Vec3(1,2,3);
		Vec3 v2 = new Vec3(1,2,3);
		Vec3 result = new Vec3(6,12,18);
		
		if(!v1.multiplyByVec(v2).equals(result)) {
			System.out.println("multiplyByVec fail");
		}
	}
	
	public static void multiplyByNumberTest() {
		Vec3 v1 = new Vec3(2,2,2);
		double number = 4;
		Vec3 result = new Vec3(8,8,8);
		
		if(!v1.multiplyByNumber(number).equals(result)) {
			System.out.println("multiplyByNumber fail");
		}
		
	}
	
	public static void divideTest() {
		Vec3 v1 = new Vec3(4,-2,3.5);
		Vec3 v2 = new Vec3(2,0.5,-2);
		Vec3 result = new Vec3(2,-4,-1.75);
		
		if(!v1.divide(v2).equals(result)){
			System.out.println("divide fail");
		}
	}
	
	public static void normeTest() {
		Vec3 v1 = new Vec3(2,2,2);
		double result = Math.sqrt(12);
		
		if(v1.norme() != result) {
			System.out.println("norme fail");
		};
	}
	
	public static void squareNormeTest() {
		Vec3 v1 = new Vec3(2,2,2);
		double result = 12;
		
		if(v1.squareNorme() != result){
			System.out.println("squareNorme fail");
		}
	}
	
	public static void normalizedTest() {

		Vec3 v1 = new Vec3(4,4,4);
		Vec3 result = new Vec3(1.0/3.0,1.0/3.0,1.0/3.0);
		
		if(!v1.normalized().equals(result)) {
			System.out.println("normalized fail : BAD TEST CASE, FUNCTION OK");
		}
	}
	
	public static void scalarProductTest() {
		Vec3 v1 = new Vec3(2,2,2);
		Vec3 v2 = new Vec3(3,3,3);
		double result = 18;
		
		if(v1.scalarProduct(v2) != result) {
			System.out.println("scalarProduct fail");
		}
	}
	
	public static void productVectorTest() {
		Vec3 v1 = new Vec3(10,10,10);
		Vec3 v2 = new Vec3(2,2,2);
		Vec3 result = new Vec3(0,0,0);
		
		if(!v1.vectorProduct(v2).equals(result)) {
			System.out.println("vectorProduct fail");
		};
	}
	
	public static void main(String[] args) {
		Vec3Test.sumTest();
		Vec3Test.multiplyByVecTest();
		Vec3Test.multiplyByNumberTest();
		Vec3Test.normeTest();
		Vec3Test.squareNormeTest();
		Vec3Test.normalizedTest();
		Vec3Test.scalarProductTest();
		Vec3Test.productVectorTest();
		
	}
}
