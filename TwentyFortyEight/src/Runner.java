
import java.util.*;
import processing.core.*;
public class Runner extends PApplet{
	
	Random rand = new Random();
	
	boolean [][] active = new boolean [4][4];
	Box [][] gridA = new Box [4][4];	
	
	
	public void setGame(){
		for(int i =0; i<4; i++){
			
			for(int j=0; j<4; j++){
				
				gridA[j][i]= new Box(j,i);
				active[i][j]=false;
			}
		}
		spawnBox();
		spawnBox();
		
	}
	
	public void spawnBox(){
		int num1 = rand.nextInt(4);
		int num2 = rand.nextInt(4);
		if(gridA[num1][num2].getValue()==0){
			gridA[num1][num2].randValue();
		}else{
			spawnBox();
		}
	}
	
	
	public void setup(){
		size(425, 425);
		strokeWeight(2);
		background(255);
		setGame();
		
	}
	
	public void draw(){
		
		for(int i = 0; i < 5; i++){//horizontal lines
			line(i*105, 0, i*105, 425);
		}
		
		for(int j = 0; j < 5; j++){//vertical lines
			line(0, j*105, 425, j*105);
		}
		
		drawGrid();
			
	}
	

	
	
	
	
	public void moveUp(){
		int position;
			for(int j=0; j<4; j++){
				for(int i=1; i<4; i++){
					position=i;
					while( position>0 && gridA[position-1][j].getValue()==0){
						gridA[position-1][j].setValue(gridA[position][j].getValue());
						gridA[position][j].setValue(0);
						position--;
						}

					}
				if(gridA[0][j].getValue()==gridA[1][j].getValue()){
					gridA[0][j].setValue(gridA[1][j].getValue()*2);
					gridA[1][j].setValue(0);
				}else if(gridA[1][j].getValue()==gridA[2][j].getValue()){
					gridA[1][j].setValue(gridA[1][j].getValue()*2);
					gridA[2][j].setValue(0);
				}else if(gridA[2][j].getValue()==gridA[3][j].getValue()){
					gridA[2][j].setValue(gridA[3][j].getValue()*2);
					gridA[3][j].setValue(0);
				}
			
				}
			spawnBox();
	}
	
	public void moveDown(){
		int position;
			for(int j=0; j<4; j++){
				for(int i=2;i>=0; i--){
					position=i;
					while(position<3 && gridA[position+1][j].getValue()==0){			//movement
						gridA[position+1][j].setValue(gridA[position][j].getValue());
						gridA[position][j].setValue(0);
						position++;
						}

					}
				if(gridA[3][j].getValue()==gridA[2][j].getValue()){		//combine
					gridA[3][j].setValue(gridA[2][j].getValue()*2);
					gridA[2][j].setValue(0);
				}else if(gridA[2][j].getValue()==gridA[1][j].getValue()){
					gridA[2][j].setValue(gridA[1][j].getValue()*2);
					gridA[1][j].setValue(0);
				}else if(gridA[1][j].getValue()==gridA[0][j].getValue()){
					gridA[1][j].setValue(gridA[0][j].getValue()*2);
					gridA[0][j].setValue(0);
				}
			
				}
			spawnBox();
	}
	
	public void moveRight(){
		int position;
			for(int j=0; j<4; j++){
				for(int i=2;i>=0; i--){
					position=i;
					while(position<3 && gridA[j][position+1].getValue()==0){			//movement
						gridA[j][position+1].setValue(gridA[j][position].getValue());
						gridA[j][position].setValue(0);
						position++;
						}

					}
				if(gridA[j][3].getValue()==gridA[j][2].getValue()){		//combine
					gridA[j][3].setValue(gridA[j][2].getValue()*2);
					gridA[j][2].setValue(0);
				}else if(gridA[j][2].getValue()==gridA[j][1].getValue()){
					gridA[j][2].setValue(gridA[j][1].getValue()*2);
					gridA[j][1].setValue(0);
				}else if(gridA[j][1].getValue()==gridA[j][0].getValue()){
					gridA[j][1].setValue(gridA[j][0].getValue()*2);
					gridA[j][0].setValue(0);
				}
			
				}
			spawnBox();
	}
	
	public void moveLeft(){
		int position;
			for(int j=0; j<4; j++){
				for(int i=1; i<4; i++){
					position=i;
					while( position>0 && gridA[j][position-1].getValue()==0){
						gridA[j][position-1].setValue(gridA[j][position].getValue());
						gridA[j][position].setValue(0);
						position--;
						}

					}
				if(gridA[j][0].getValue()==gridA[j][1].getValue()){
					gridA[j][0].setValue(gridA[j][1].getValue()*2);
					gridA[j][1].setValue(0);
				}else if(gridA[j][1].getValue()==gridA[j][2].getValue()){
					gridA[j][1].setValue(gridA[j][1].getValue()*2);
					gridA[j][2].setValue(0);
				}else if(gridA[j][2].getValue()==gridA[j][3].getValue()){
					gridA[j][2].setValue(gridA[j][3].getValue()*2);
					gridA[j][3].setValue(0);
				}
			
				}
			spawnBox();
	}
	
		
		
		
		
/*		for(int x=0; x<4; x++){
			for(int y=1; y<4; y++){
				//for(int i=0; i<y; i++){
					if(active[y][x]){
						if(active[y-1][x]){
							if(gridA[y][x].getValue()==gridA[y-1][x].getValue()){
								gridA[y-1][x].setValue(gridA[y][x].getValue()*2);
								gridA[y][x].setValue(0);
								active[y][x]=false;
							}
						}else{
							gridA[y-1][x].setValue(gridA[y][x].getValue());
							active[y-1][x]=true;
							gridA[y][x].setValue(0);
							active[y][x]=false;
						}
				//	}
				}
			}
		}*/
	
	
	public void keyPressed(){
		if(keyCode==UP){
			moveUp();
		}
		if(keyCode==DOWN){
			moveDown();
		}
		if(keyCode==RIGHT){
			moveRight();
		}
		if(keyCode==LEFT){
			moveLeft();
		}
	}
	
	public int convert(int a){
			if(a==0){
				return 0;
			}else if (a==1){
				return 105;
			}else if(a==2){
				return 210;
			}else if(a==3){
				return 315;
			}else
				return 0;
		}
	
	public String toString(int a){
		String s = " "+ a;
		return s;
	}
	
	
	public void drawGrid(){
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){	
				if(gridA[i][j].getValue()==0){
					fill(255);
					rect(j*105,i*105,100,100);
				}else{
					fill((float)(256-(256/11)*(Math.log(gridA[i][j].getValue()))/(Math.log(2))),(float)((256/11)*(Math.log(gridA[i][j].getValue())/Math.log(2))),(float)0.0);
					rect(j*105,i*105,100,100);
					fill(255);
					text(toString(gridA[i][j].getValue()),j*105+50,i*105+50);
				}
			}
		}
	}
}
