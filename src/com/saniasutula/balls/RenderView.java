package com.saniasutula.balls;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

class RenderView extends View {
	ArrayList<Ball> balls;
	int numberOfBalls = 10;
	Touching touch;
	Canvas canva;
	int width;
	int height;

	public RenderView(Context context) {
		super(context);
	}

	public void initialization(int width, int height) {
		numberOfBalls += 3;
		touch = null;

		if (this.width == 0 && this.height == 0) {
			this.width = width;
			this.height = height;

		}
		balls = new ArrayList<Ball>(numberOfBalls);

		for (int i = 0; i < numberOfBalls; i++)
			balls.add(new Ball(width, height));
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {

		super.onDraw(canvas);

		Paint paint = new Paint();
		paint.setStyle(Style.FILL);

		if (touch != null)
			proccesTouching(canvas, paint);

		drawBalls(canvas, paint);
		invalidate();
	}

	private void proccesTouching(Canvas canvas, Paint paint) {
		if (touch.isActual()) {
			paint.setColor(touch.color);
			canvas.drawCircle(touch.x, touch.y, touch.radius, paint);
		} else {
			initialization(width, height);
			invalidate();
			return;
		}
		verifyIntersections();
	}

	private void verifyIntersections() {
		for (int i = 0; i < balls.size(); i++)
			if (touch != null && balls.get(i).isIntersect(touch)){
				touch.extand();
				balls.remove(i);
			}
	}

	private void drawBalls(Canvas canvas, Paint paint) {
		for (int i = 0; i < balls.size(); i++) {
			paint.setColor(balls.get(i).color);
			canvas.drawCircle(balls.get(i).getX(), balls.get(i).getY(), 10,
					paint);

		}
	}
}