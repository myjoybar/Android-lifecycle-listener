package com.lifecycle.joybar.androidlifecyclelistener.lifetest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.lifecycle.joybar.androidlifecyclelistener.LifecycleTestManager;
import com.lifecycle.joybar.androidlifecyclelistener.R;
import com.lifecycle.joybar.androidlifecyclelistener.util.ActivityUtils;

/**
 * Created by joybar on 2017/6/29.
 */

public class ActivityLifecycle extends Activity {

	public static void launch(Context context) {
		Intent intent = new Intent();
		intent.setClass(context, ActivityLifecycle.class);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_life);
		TextView tv = (TextView) this.findViewById(R.id.tv);
		tv.setTextSize(15);
		tv.setText("android.app.Activity");
		LifecycleTestManager.newInstance().registerLifecycleListener(this,"android.app.Activity");
		initFragment();

	}

	private void initFragment() {
		FragmentLifecycle fragment = (FragmentLifecycle) getFragmentManager().findFragmentById(R.id.fl_content);
		if (fragment == null) {
			fragment = fragment.newInstance();
			ActivityUtils.addFragmentToActivity(getFragmentManager(), fragment, R.id.fl_content);
		}
	}

}
