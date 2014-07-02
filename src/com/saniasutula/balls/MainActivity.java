package com.saniasutula.balls;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

@SuppressLint("DrawAllocation")
public class MainActivity extends Activity {

	RenderView renderView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		renderView = new RenderView(this);
		renderView.initialization(getWindowManager().getDefaultDisplay()
						.getWidth(), getWindowManager().getDefaultDisplay()
						.getHeight());

		setContentView(renderView);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (renderView.touch == null && event.getAction() == MotionEvent.ACTION_UP) {
			renderView.touch = new Touching(event.getX(), event.getY(),
					System.nanoTime());
		}

		return super.onTouchEvent(event);
	}

}

