
public class Position
{
	private double x;
	private double y;
	
	public Position(double x, double y)
	{
		super();
		this.x = x;
		this.y = y;
	}
	
	public double distance(Position other)
	{
		return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
	}
	
	public void move(Vector vector)
	{
		x += vector.getX();
		y += vector.getY();
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public void setY(double y)
	{
		this.y = y;
	}
}
