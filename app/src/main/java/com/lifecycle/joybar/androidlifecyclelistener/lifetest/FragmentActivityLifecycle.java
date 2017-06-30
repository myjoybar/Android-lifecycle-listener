package com.lifecycle.joybar.androidlifecyclelistener.lifetest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.widget.TextView;

import com.lifecycle.joybar.androidlifecyclelistener.LifecycleTestManager;
import com.lifecycle.joybar.androidlifecyclelistener.R;
import com.lifecycle.joybar.androidlifecyclelistener.util.ActivityUtils;

/**
 * Created by joybar on 2017/6/29.
 */

public class FragmentActivityLifecycle extends FragmentActivity {

	public static void launch(Context context) {
		Intent intent = new Intent();
		intent.setClass(context, FragmentActivityLifecycle.class);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_life);
		TextView tv = (TextView) this.findViewById(R.id.tv);
		tv.setTextSize(15);
		tv.setText("android.support.v4.app.FragmentActivity");
		tv.setGravity(Gravity.CENTER);
		LifecycleTestManager.newInstance().registerLifecycleListener(this,"android.support.v4.app.FragmentActivity");
		initFragment();
	}

	private void initFragment() {
		V4FragmentLifecycle fragment = (V4FragmentLifecycle) getSupportFragmentManager().findFragmentById(R.id.fl_content);
		if (fragment == null) {
			fragment = fragment.newInstance();
			ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.fl_content);
		}
	}
}

