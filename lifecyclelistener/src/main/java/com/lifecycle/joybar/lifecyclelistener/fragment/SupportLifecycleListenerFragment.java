package com.lifecycle.joybar.lifecyclelistener.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.lifecycle.joybar.lifecyclelistener.FragmentLifecycle;

/**
 * Created by joybar on 2017/6/29.
 */

public class SupportLifecycleListenerFragment extends Fragment {

	private static String TAG = "SupportLifecycleListenerFragment";
	private FragmentLifecycle fragmentLifecycle;


	public SupportLifecycleListenerFragment() {
		this(new FragmentLifecycle());
	}

	public SupportLifecycleListenerFragment(FragmentLifecycle lifecycle) {
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
