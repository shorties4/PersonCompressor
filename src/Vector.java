public class Vector
{
	private double direction;
	private double magnitude;

	public Vector(double direction, double magnitude)
	{
		this.direction = direction;
		this.magnitude = magnitude;

	}

	public static Vector fromRect(double x, double y)
	{
		double dir;
		double mag;
		if (x >= 0)
		{
			dir = Math.atan(y / x);
		} 
		else
		{
			dir = Math.PI + Math.atan(y / x);
		}
		mag = Math.sqrt(x * x + y * y);
		return new Vector(dir, mag);
	}

	public double getX()
	{
		return magnitude * Math.cos(direction);
	}

	public double getY()
	{
		return magnitude * Math.sin(direction);
	}

	public void add(Vector other)
	{
		double x = getX() + other.getX();
		double y = getY() + other.getY();

		Vector newv = fromRect(x, y);
		magnitude = newv.getMagnitude();
		direction = newv.getDirection();
	}

	public void unit()
	{
		magnitude = 1;
	}

	public void scale(double m)
	{
		magnitude *= m;
	}

	public double getDirection()
	{
		return direction;
	}

	public double getMagnitude()
	{
		return magnitude;
	}

	public void setDirection(double direction)
	{
		this.direction = direction;
	}

	public void setMagnitude(double magnitude)
	{
		this.magnitude = magnitude;
	}

}
