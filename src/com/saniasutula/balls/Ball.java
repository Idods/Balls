package com.saniasutula.balls;

import android.graphics.Color;

public class Ball {
	
	AxeBehavior x, y;
	float radius = 10;
	int color;

	Ball(int width, int height) {

		x = new AxeBehavior(width);
		y = new AxeBehavior(height);
		
		color = Color.rgb((int) (Math.random() * (256)),
				(int) (Math.random() * (256)), (int) (Math.random() * (256)));
	}

	
	public float getY() {
		return y.getValue();
	}

	public float getX() {
		return x.getValue();
	}
	
	public boolean isIntersect(Touching touch){
		return Math.sqrt(Math.pow(touch.x - x.value, 2) + Math.pow(touch.y - y.value, 2)) <= radius
				+ touch.radius;
	}

	class AxeBehavior{
		private int max;
		private float velocity = 7;
		private float value;
		
		AxeBehavior(int max){
			this.max = max;
			velocity *= ((int) (Math.random() * (2)) == 0 ? -1 : 1);
			value = (float) (11 + Math.random() * (max - radius));
		}
		
		public float getValue(){
			if(isNeedToReflect())
				velocity *= -1;
				
			return value += velocity;
		}
		
		private boolean isNeedToReflect(){
			return (value + velocity > max - radius) || (value + velocity < 0);
		}
	}
}
