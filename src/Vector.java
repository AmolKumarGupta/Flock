/**
 * @author amol kumar gupta
 * <p>this Class is used to make vector entity 
 * like velocity, position etc</p>
 */
class Vector
{
	private double x,y;

	//Constructor
	public Vector()
	{
		setx(0.0);
		sety(0.0);
	}

	public Vector(double x, double y)
	{
		setx(x);
		sety(y);
	}

	public Vector(double xy)
	{
		setxy(xy);
	}
	public Vector(Vector v)
	{
		setx(v.getx());
		sety(v.gety());
	}

	//Setter
	public void setx(double x)
	{
		this.x = x;
	}
	public void sety(double y)
	{
		this.y = y;
	}
	public void setxy(double xy)
	{
		this.x = xy;
		this.y = xy;
	}

	//Getter
	public double getx(){
		return this.x;
	}
	public double gety(){
		return this.y;
	}

	//Addition Subtraction and Others
	public void add(Vector v)
	{
		this.x += v.x;
		this.y += v.y;
	}
	public void addx(double d){
		this.x += d;
	}
	public void addy(double d){
		this.y += d;
	}

	public void sub(Vector v)
	{
		this.x -= v.x;
		this.y -= v.y;
	}

	//Multiply
	public void mul(double d)
	{
		this.x*= d;
		this.y*= d;
	}
	public void mulx(double d)
	{
		this.x *= d;
	}
	public void muly(double d)
	{
		this.y *= d;
	}

	//division
	public void div(double d)
	{
		this.x /= d;
		this.y /= d;
	}

	public double mag()
	{
		double mag = Math.sqrt( (getx()*getx()) + (gety()*gety()) );
		return mag;
	}
}