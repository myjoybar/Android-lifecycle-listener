package com.lifecycle.joybar.lifecyclelistener.interfaces;

/**
 * Created by joybar on 2017/6/29.
 */

public interface LifecycleListener {

	void onStart();

	void onResume();

	void onPause();

	void onStop();

	void onDestroy();
}
