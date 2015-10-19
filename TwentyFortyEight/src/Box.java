
import processing.core.*;
import java.awt.Color;
import java.awt.Point;
import java.util.*;
public class Box{
	
	int r,g;
	Random rand = new Random();
	Location l = new Location();
	int value;
	/*double red=256-(256/11)*(Math.log(value))/(Math.log(2));
	double blue = (256/11)*(Math.log(value)/Math.log(2));
	
	Color myColor = new Color ((float)red,(float)blue,(float)0);
	 */
	
	
	public Box(int x, int y){
		value=0;
		 l.setX(x);
		 l.setY(y);
	}
	
	public void setX(int a){
		l.setX(a);
	}
	
	public Location getLoc(){
		return l;
	}
	
	public void setY(int a){
		l.setY(a);
	}
	
	public void randValue(){
		if(rand.nextInt(11)==1){
			value = 4;
		}else{
			value = 2;
		}
		
	}
	
	public void setValue(int a){
		value=a;
	}

	
	public int getValue(){
		return value;
	}
	
	
}
