package com.lifecycle.joybar.androidlifecyclelistener.lifetest;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lifecycle.joybar.androidlifecyclelistener.LifecycleTestManager;

/**
 * Created by joybar on 2017/6/29.
 */

public class FragmentLifecycle extends Fragment {


	public FragmentLifecycle() {
		// Requires empty public constructor
	}

	public static FragmentLifecycle newInstance() {
		FragmentLifecycle fragmentLifecycle = new FragmentLifecycle();
		return fragmentLifecycle;
	}


	@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		LifecycleTestManager.newInstance().registerLifecycleListener(getActivity());
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		TextView tv = new TextView(getActivity());
		tv.setTextSize(15);
		tv.setText("android.app.Fragment");
		tv.setGravity(Gravity.CENTER);
		return tv;
	}

}
