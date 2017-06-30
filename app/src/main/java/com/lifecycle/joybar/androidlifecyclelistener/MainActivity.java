package com.lifecycle.joybar.androidlifecyclelistener;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lifecycle.joybar.androidlifecyclelistener.lifetest.ActivityLifecycle;
import com.lifecycle.joybar.androidlifecyclelistener.lifetest.FragmentActivityLifecycle;


public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
			case R.id.button1:
				ActivityLifecycle.launch(MainActivity.this);
				break;
			case R.id.button2:
				FragmentActivityLifecycle.launch(MainActivity.this);
				break;

			default:
				break;
		}
	}
}
