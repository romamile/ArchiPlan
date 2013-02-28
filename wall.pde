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

	void addDoor() { //DEFAULT : MIDDLE
		myDoors.add(new door(a,b));
	}


	void draw() {
		strokeWeight(3);
		stroke(230);
		line(a.x,a.y,b.x, b.y);
		
		strokeWeight(5);
		stroke(150);
		for(int i=0; i<myDoors.size(); i++)
			myDoors.get(i).draw();
	}
}