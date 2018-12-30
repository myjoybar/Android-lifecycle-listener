package com.lifecycle.joybar.androidlifecyclelistener.lifetest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lifecycle.joybar.androidlifecyclelistener.LifecycleTestManager;

/**
 * Created by joybar on 2017/6/29.
 */

public class V4FragmentLifecycle extends Fragment {


	public V4FragmentLifecycle() {
		// Requires empty public constructor
	}
	public static V4FragmentLifecycle newInstance() {
		V4FragmentLifecycle fragmentLifecycle = new V4FragmentLifecycle();
		return fragmentLifecycle;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		LifecycleTestManager.newInstance().registerLifecycleListener(getActivity());
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		TextView tv = new TextView(getActivity());
		tv.setTextSize(15);
		tv.setText("android.support.v4.app.Fragment");
		tv.setGravity(Gravity.CENTER);
		return tv;
	}
}
