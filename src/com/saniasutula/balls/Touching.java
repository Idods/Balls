package com.saniasutula.balls;

import android.graphics.Color;

public class Touching {
	long tap;
	long delta = 1000000000L;
	float x, y;
	float radius = 20;
	public int color;

	Touching(float x, float y, long tap) {
		color = Color.rgb((int) (Math.random() * (256)),
				(int) (Math.random() * (256)), (int) (Math.random() * (256)));
		this.x = x;
		this.y = y;
		this.tap = tap;
	}

	public boolean isActual() {
		return System.nanoTime() - tap > delta ? false : true;
	}

	public void extand(){
		radius += 5;
		tap = System.nanoTime();
	}
	

}
