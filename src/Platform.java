import java.awt.Graphics;
import java.util.ArrayList;

public class Platform
{
	private int timeCount = 0;
	
	private double width;
	private double height;
	
	private ArrayList<Person> people;
	private Position stairBase;
	
	public int peopleNumPerTime = 0;
	
	public Platform()
	{
		width = Constants.PLATFORM_WIDTH;
		height = Constants.PLATFORM_HEIGHT;
		
		stairBase = new Position(width/2, height/2);
		people = new ArrayList<Person>();
		
		for(int i = 1; i <= 50; i ++)
		{
			Position thisPos = new Position(10*i, 0);
			people.add(new Person(thisPos, this));
		}
	}
	
	public void draw(Graphics graphics)
	{
		for(Person person : people)
		{
			person.draw(graphics);
		}
	}
	
	public void update()
	{
		timeCount ++;
		if(timeCount % 5 == 2)
		{
			for(int i = 1; i <= 50; i ++)
			{
				Position thisPos = new Position(10*i, 0);
				people.add(new Person(thisPos, this));
			}
		}
		
		for(Person person : people)
		{
			if (!person.isReachedStairs())
			{
				person.update();
			}
		}
		
//		for(int i = 1; i <= 10; i ++)
//		{
//			Position thisPos = new Position(i*50, 10);
//			people.add(new Person(thisPos, this));
//		}
		
		System.out.println(peopleNumPerTime);
		
		peopleNumPerTime = 0;
	}
	
	public double getDensity(Position pos)
	{
		int numberOfPeople = 0;
		
		for(Person person : people)
		{
			if(pos.distance(person.getPos()) <= Constants.AREA_UNIT_RADIUS)
			{
				if (!person.isReachedStairs())
				{
					numberOfPeople ++;
				}
			}
		}
		
		return numberOfPeople;
	}
	
	public double getPreferredDirection(Position pos)
	{
		double theta;
		double deltaX = stairBase.getX() - pos.getX();
		double deltaY = stairBase.getY() - pos.getY();
		
		if (deltaX >= 0) 
		{
			theta = Math.atan(deltaY / deltaX);
		} 
		else 
		{
			theta = Math.PI + Math.atan(deltaY / deltaX);
		}
		
		return theta;
	}

	/**
	 * @return the width
	 */
	public double getWidth()
	{
		return width;
	}

	/**
	 * @return the height
	 */
	public double getHeight()
	{
		return height;
	}

	/**
	 * @return the people
	 */
	public ArrayList<Person> getPeople()
	{
		return people;
	}

	/**
	 * @return the stairBase
	 */
	public Position getStairBase()
	{
		return stairBase;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width)
	{
		this.width = width;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height)
	{
		this.height = height;
	}

	/**
	 * @param people the people to set
	 */
	public void setPeople(ArrayList<Person> people)
	{
		this.people = people;
	}
	
	
}
