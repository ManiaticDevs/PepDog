package net.oikmo.toolbox;

import javax.vecmath.Matrix3f;
import javax.vecmath.Quat4f;

import org.lwjgl.util.vector.Vector3f;

public class Maths {
	
	/**
	 * Converts {@link org.lwjgl.util.vector.Vector3f} to {@link javax.vecmath.Vector3f}
	 * @param vector
	 * @return
	 */
	public static javax.vecmath.Vector3f lwjglToVM(org.lwjgl.util.vector.Vector3f vector) {
		return new javax.vecmath.Vector3f(vector.x,vector.y,vector.z);
	}
	
	/**
	 * Converts Quaternion rotations to Euler Angles
	 * @param q
	 * @return {@link Vector3f}
	 */
	public static Vector3f QuaternionToEulerAngles(Quat4f q) {

		double t0 = +2.0 * (q.w * q.x + q.y * q.z);
		double t1 = +1.0 - 2.0 * (q.x * q.x + q.y * q.y);
		double X = Math.toDegrees(FastMath.atan2((float)t0, (float)t1));

		double t2 = +2.0 * (q.w * q.y - q.z * q.x);
		t2 = t2 > 1.0f ? 1.0f : t2;
		t2 = t2 < -1.0f ? -1.0f : t2;
		double Y = Math.toDegrees(FastMath.asin((float)t2));

		double t3 = +2.0 * (q.w * q.z + q.x * q.y);
		double t4 = +1.0 - 2.0 * (q.y * q.y + q.z * q.z);
		double Z = Math.toDegrees(FastMath.atan2((float)t3, (float)t4));

		return new Vector3f((float)X,(float)Y,(float)Z);
	}

	/**
	 * 
	 * Converts Euler Angles (Vector3f) to Quaternion
	 * 
	 * @param e [Vector3f]
	 * @return Quaternion [Quat4f]
	 */
	@Deprecated
	public static Quat4f ToQuaternion(Vector3f e) {
		float roll = e.x;
		float pitch = e.y;
		float yaw = e.z;
		Quat4f q = new Quat4f();
		float qx = (float) (Math.sin(roll/2) * Math.cos(pitch/2) * Math.cos(yaw/2) - Math.cos(roll/2) * Math.sin(pitch/2) * Math.sin(yaw/2));
		float qy = (float) (Math.cos(roll/2) * Math.sin(pitch/2) * Math.cos(yaw/2) + Math.sin(roll/2) * Math.cos(pitch/2) * Math.sin(yaw/2));
		float qz = (float) (Math.cos(roll/2) * Math.cos(pitch/2) * Math.sin(yaw/2) - Math.sin(roll/2) * Math.sin(pitch/2) * Math.cos(yaw/2));
		float qw = (float) (Math.cos(roll/2) * Math.cos(pitch/2) * Math.cos(yaw/2) + Math.sin(roll/2) * Math.sin(pitch/2) * Math.sin(yaw/2));
		q.x = qx;
		q.y = qy;
		q.z = qz;
		q.w = qw;

		return q;
	}
	
	public static Vector3f test(Quat4f q) {
		Vector3f v = new Vector3f();
		
		Matrix3f m = new Matrix3f();
		m.set(q);
		
		v = Maths.MatrixToEulerEngles(m);
		
		return v;
	}
	
	static double RADTODEG = 180.0 / Math.PI;
	/**
	 * Converts rotational Matrix ({@linkplain javax.vecmath.Matrix3f}) to Euler Angles
	 * @param matrix
	 * @return
	 */
	public static Vector3f MatrixToEulerEngles(Matrix3f matrix) {

		double EPS = 1.0e-6;
		double X, Y, Z;

		Y = FastMath.asin(matrix.m02);                       // Unique angle in [-pi/2,pi/2]

		if (FastMath.abs((float)(FastMath.abs(matrix.m02) - 1.0)) < EPS) { // Yuk! Gimbal lock. Infinite choice of X and Z
			X = FastMath.atan2(matrix.m21, matrix.m11);          // One choice amongst many
			Z = 0.0;
		} else {                                   // Unique solutions in (-pi,pi]
			X = FastMath.atan2(-matrix.m12, matrix.m22);         // atan2 gives correct quadrant and unique solutions
			Z = FastMath.atan2(-matrix.m01, matrix.m00);
		}

		X *= RADTODEG;   
		Y *= RADTODEG;   
		Z *= RADTODEG;

		return new Vector3f((float)X,(float)Y,(float)Z);
	}
}
