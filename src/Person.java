import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Person
{
	private Vector vector;
	private Position pos;
	private Platform platform;
	
	private double fitness = Constants.FIT_PARAMETER - 0.3 + 0.6*Math.random();
	private double anxiousness = 3 - 0.5 + 1*Math.random();
	private boolean reachedStairs = false;
	
	public Person(Position pos, Platform platform)
	{
		this.pos = pos;
		this.platform = platform;
		this.vector = new Vector(0,0);
	}
	
	public void update()
	{
		double newMagnitude = getMovementSpeed(pos);
		double newDirection = platform.getPreferredDirection(pos);
		
		vector.setMagnitude(newMagnitude);
		vector.setDirection(newDirection);
		
		Vector proximityVector = new Vector(0, 0);
		
		ArrayList<Person> people = platform.getPeople();
		
		for(Person person : people)
		{
			\
		}
		
		pos.move(vector);
		
		if(pos.distance(platform.getStairBase()) <= Constants.AREA_UNIT_RADIUS)
		{
			platform.peopleNumPerTime ++;
			reachedStairs = true;
		}
	}
	
	public double getMovementSpeed(Position pos)
	{
		return anxiousness*Constants.WALKING_SPEED*(1 - Math.pow(Math.E, - fitness*((1/platform.getDensity(pos)) - (1/Constants.MAX_DENSITY))));
	}

	public void draw(Graphics graphics)
	{
		if(!reachedStairs)
		{
			graphics.setColor(Color.RED);
		}
		else
		{
			graphics.setColor(Color.GREEN);
		}
		graphics.fillOval((int)pos.getX(), (int)pos.getY(), 7, 7);
	}
	
	public Vector getVector()
	{
		return vector;
	}

	public Position getPos()
	{
		return pos;
	}

	public Platform getPlatform()
	{
		return platform;
	}

	public void setVector(Vector vector)
	{
		this.vector = vector;
	}

	public void setPos(Position pos)
	{
		this.pos = pos;
	}

	public void setPlatform(Platform platform)
	{
		this.platform = platform;
	}

	public boolean isReachedStairs()
	{
		return reachedStairs;
	}

	public void setReachedStairs(boolean reachedStairs)
	{
		this.reachedStairs = reachedStairs;
	}
}
