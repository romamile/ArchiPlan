
int[][] triUp, triDown;
float w, h, r; //maille, pas triangle
int nbrW, nbrH;
int valUp, valDown;

flat myFlat;

void setup() {

  size(displayWidth, displayHeight);
  frameRate(30);
  smooth();
  
  stroke(255);
  strokeWeight(2);
  noFill();
  background(45,43,35);

  myFlat = new flat();
}


void draw() {
//  myFlat.addRoom();
  myFlat.draw();
}