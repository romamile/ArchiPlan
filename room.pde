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

	void draw() { //Draw Shapes or draw one by one the walls ? 

		beginShape();
		vertex(get(0).a.x, get(0).a.y);
		for(int i=0; i<size(); i++) 
			vertex(get(i).a.x, get(i).a.y);
		vertex(get(size()-1).b.x, get(size()-1).b.y);
		endShape();



	}
}