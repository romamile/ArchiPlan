class door {
	vec2f a,b;
	boolean side;

	door() { a = new vec2f(); b = new vec2f(); }
	door(vec2f _a, vec2f _b) { a=_a; b=_b; }
	door(float xA, float yA, float xB, float yB) {	a = new vec2f(xA, yA); b=new vec2f(xB, yB); }


	void draw() {
		line(a.x,a.y,b.x, b.y);
	}

}