import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class ArchiPlan extends PApplet {


int[][] triUp, triDown;
float w, h, r; //maille, pas triangle
int nbrW, nbrH;
int valUp, valDown;

flat myFlat;

public void setup() {

  size(displayWidth, displayHeight);
  frameRate(30);
  smooth();
  
  stroke(255);
  strokeWeight(2);
  noFill();
  background(45,43,35);

  myFlat = new flat();
}


public void draw() {
//  myFlat.addRoom();
  myFlat.draw();
}
class door {
	vec2f a,b;
	boolean side;

	door() { a = new vec2f(); b = new vec2f(); }
	door(vec2f _a, vec2f _b) { a=_a; b=_b; }
	door(float xA, float yA, float xB, float yB) {	a = new vec2f(xA, yA); b=new vec2f(xB, yB); }


	public void draw() {
		line(a.x,a.y,b.x, b.y);
	}

}
class flat extends ArrayList<room> {
	float x,y;

	flat() {
		x = width/2;
		y = height/2;
		add(new room(4,300, 0, 0, 50, 0));
	}

	public void draw() {
		pushMatrix();
		translate(x,y);
		for(int i=0; i<size(); i++) //Rooms
//		for(int j=0; j<get(i).size(); j++) //Walls
//			get(i).get(j).draw();
			get(i).draw();
		popMatrix();

	}
	
}
class room extends ArrayList<wall> {
	
	room() {
		add(new wall( 0, 0, 0,50));
		add(new wall( 0,50,50,50));
		add(new wall(50,50,50, 0));
		add(new wall(50, 0, 0, 0));
	}

	room(int kR, int l, float dx, float dy, float fx, float fy) {

		//PAS UNE FORME QUI PART EN VRILLASSE
		//NE SE SUPPERPOSE PAS A UNE AUTRE ROOM

		if(kR<2)
			return; // CATCH ERROR COMMENT EN JAVA ?


		wall tWall = new wall(dx,dy,fx,fy); 
		tWall.addDoor();
		add(tWall);

		float ax=dx, ay=dy;
		float bx=dx, by=dy;

		for(int k =0; k < kR-1; k++) {
			ax = bx; ay = by;
			bx = random(l);
			by = random(l);
			add(new wall(ax,ay,bx,by));
		} 

		add(new wall(bx,by,fx,fy));


	}

	public void draw() {

		beginShape();
		vertex(get(0).a.x, get(0).a.y);
		for(int i=0; i<size(); i++) 
			vertex(get(i).a.x, get(i).a.y);
		vertex(get(size()-1).b.x, get(size()-1).b.y);
		endShape();



	}
}
class vec2f {
	float x, y;
	vec2f() { x=0; y=0; }
	vec2f(float _x, float _y) { x=_x; y=_y; }
}
class wall {
	vec2f a,b;
	ArrayList<door> myDoors;


	wall() {
		a = new vec2f(); b = new vec2f(); myDoors = new ArrayList<door>(); }
	wall(vec2f _a, vec2f _b) {
		a=_a; b=_b; myDoors = new ArrayList<door>(); }
	wall(float xA, float yA, float xB, float yB) {
		a = new vec2f(xA, yA); b=new vec2f(xB, yB);
		myDoors = new ArrayList<door>(); }

	public void addDoor() { //DEFAULT : MIDDLE
		myDoors.add(new door(a,b));
	}


	public void draw() {
		strokeWeight(3);
		stroke(230);
		line(a.x,a.y,b.x, b.y);
		
		strokeWeight(5);
		stroke(150);
		for(int i=0; i<myDoors.size(); i++)
			myDoors.get(i).draw();
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ArchiPlan" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
