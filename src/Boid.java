import java.awt.*; class Boid
{ 
	Vector position;
	Vector velocity;

	//Constructor
	public Boid()
	{
		double x = (double) (Math.random()*200);
		double y = (double) (Math.random()*200);
		position = new Vector(x,y);
		double vx = (double)((Math.random()*8)-4);
		double vy = (double)((Math.random()*8)-4);
		velocity = new Vector(vx,vy);
	}

	/////paint/////
	public void paint(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillOval((int)position.getx(),(int)position.gety(),5,5);

		//moveing obj by adding velocity
		position.add(velocity);
		//collision checking 
		if(position.getx()<0 || position.getx()>570)
		{
			velocity.mulx(-3.0);
		} 
		if(position.gety()<0 || position.gety()>550)
		{
			velocity.muly(-3.0);
		}
	}//paint 

	/**
	 * name velocity_add
	 * 
	 */
	public void velocity_add(Vector v)
	{
		velocity.add(v);
	}

	public void velocity_div(double mag)
	{
		velocity.div(mag);
	}
	public void velocity_mul(double d)
	{
		velocity.mul(d);
	}

	/**
	 * @param null
	 * @return double <p>the magnitude of velocity og boid</p>
	 * 
	 */
	public double magnitude_of_velocity()
	{
		double mag;
		mag  = Math.sqrt( (velocity.getx()*velocity.getx()) + (velocity.gety()*velocity.gety()) );
		return mag;
	}
}