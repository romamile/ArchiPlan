class flat extends ArrayList<room> {
	float x,y;

	flat() {
		x = width/2;
		y = height/2;
		add(new room(4,300, 0, 0, 50, 0));
	}

	void draw() {
		pushMatrix();
		translate(x,y);
		for(int i=0; i<size(); i++) //Rooms
//		for(int j=0; j<get(i).size(); j++) //Walls
//			get(i).get(j).draw();
			get(i).draw();
		popMatrix();

	}
	
}