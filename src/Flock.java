import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Flock extends JPanel implements ActionListener
{
	Boid[] b = new Boid[30];

	//Constructor
	public Flock()
	{
		JFrame frame = new JFrame("Flocks");
		frame.setSize(600,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);

		for(int i=0; i<b.length; i++){
			b[i] = new Boid();
		}

		Timer t = new Timer(16,this);
		t.restart();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}


	/**
	 *
	 *@return void 
	 * <p>main algorithm to make a flock</p>
	 * 
	 */
	public void move_all_boids_to_center()
	{
		Vector v1 = new Vector();
		Vector v2 = new Vector();
		Vector v3 = new Vector();

		for(int i=0; i<b.length; i++)
		{
			v1 = rule1(b[i]);
			v2 = rule2(b[i]);
			v3 = rule3(b[i]);

			b[i].velocity_add(v1);
			b[i].velocity_add(v2);
			b[i].velocity_add(v3);

			limit_velocity(b[i]);
		}
	}//move_all_boids_to_center

	public Vector rule1(Boid b1)
	{
		Vector pc = new Vector();
		for(int i=0; i<b.length; i++)
		{
			if(b1 != b[i])
			{
				pc.add(b[i].position);
			}
		}
		pc.div((double)b.length-1);
		pc.sub(b1.position);
		pc.div(100.0);

		return pc;

	}//rule1

	public Vector rule2(Boid b1)
	{
		Vector c = new Vector();
		for(int i=0; i<b.length; i++)
		{
			if(b1 != b[i])
			{
				Vector diff = new Vector(b[i].position);
				diff.sub(b1.position);
				double mag = diff.mag();
				if(mag<10)
				{
					c.sub(diff);

					c.div(c.mag());

				}
			}
		}
		return c;
	}//rule2

	public Vector rule3(Boid b1)
	{
		Vector pv = new Vector();
		for(int i=0; i<b.length; i++)
		{
			if(b1 != b[i])
			{
				pv.add(b[i].velocity);
			}
		}
		pv.div((double)b.length-1);
		pv.sub(b1.velocity);
		pv.div(8.0);
		return pv;		
	}

	public void limit_velocity(Boid b1)
	{
		double lv = 4.0;
		double mag = b1.magnitude_of_velocity();
		if(mag > lv)
		{
			b1.velocity_div(mag);
			b1.velocity_mul(lv);
		}
	}

	//paint
	public void paint(Graphics g)
	{
		super.paintComponent(g);
		/**
		 * this is a boid simulation
		 * All the work is done with the help of paint method 
		 * 
		 * 
		 * */
		move_all_boids_to_center();
		for(int i=0; i<b.length; i++){
			b[i].paint(g);
		}
	}

	public static void main(String args[])
	{
		Flock flock = new Flock();
	}
}