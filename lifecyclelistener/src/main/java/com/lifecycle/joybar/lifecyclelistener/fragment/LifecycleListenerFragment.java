package com.lifecycle.joybar.lifecyclelistener.fragment;

import android.app.Fragment;
import android.os.Bundle;

import com.lifecycle.joybar.lifecyclelistener.FragmentLifecycle;

/**
 * Created by joybar on 2017/6/29.
 */

public class LifecycleListenerFragment extends Fragment {

	private static String TAG = "SupportLifecycleListenerFragment";
	private FragmentLifecycle fragmentLifecycle;


	public LifecycleListenerFragment() {
		this(new FragmentLifecycle());
	}

	public LifecycleListenerFragment(FragmentLifecycle lifecycle) {
		this.fragmentLifecycle = lifecycle;
	}


	public FragmentLifecycle getLifecycle() {
		return fragmentLifecycle;
	}


	public void setLifecycle(FragmentLifecycle lifecycle) {
		this.fragmentLifecycle = lifecycle;
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		fragmentLifecycle.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		super.onStart();
		fragmentLifecycle.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
		fragmentLifecycle.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
		fragmentLifecycle.onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
		fragmentLifecycle.onStop();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		fragmentLifecycle.onDestroy();
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();

	}

}
