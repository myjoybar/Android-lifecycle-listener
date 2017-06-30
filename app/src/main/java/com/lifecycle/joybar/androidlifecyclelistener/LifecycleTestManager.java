package com.lifecycle.joybar.androidlifecyclelistener;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.lifecycle.joybar.lifecyclelistener.LifecycleManager;
import com.lifecycle.joybar.lifecyclelistener.interfaces.LifecycleListener;

/**
 * Created by joybar on 2017/6/30.
 */

public class LifecycleTestManager {

	private static final String TAG = "LifecycleTestManager";

	private LifecycleTestManager() {
	}

	public static LifecycleTestManager newInstance() {
		LifecycleTestManager lifecycleManager = new LifecycleTestManager();
		return lifecycleManager;
	}

	public void registerLifecycleListener(Context context, final String fragmentTagName) {

		LifecycleManager lifecycleManager = new LifecycleManager(fragmentTagName);

		lifecycleManager.registerLifecycleListener(context, new LifecycleListener() {
			@Override
			public void onStart() {
				Log.d(TAG, fragmentTagName+"_"+"onStart");
			}

			@Override
			public void onResume() {
				Log.d(TAG, fragmentTagName+"_"+"onResume");
			}

			@Override
			public void onPause() {
				Log.d(TAG, fragmentTagName+"_"+"onPause");
			}

			@Override
			public void onStop() {
				Log.d(TAG, fragmentTagName+"_"+"onStop");
			}

			@Override
			public void onDestroy() {
				Log.d(TAG, fragmentTagName+"_"+"onDestroy");
			}
		});
	}

	@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
	public void registerLifecycleListener(android.app.Fragment fragment, final String fragmentTagName) {

		LifecycleManager lifecycleManager = new LifecycleManager(fragmentTagName);

		lifecycleManager.registerLifecycleListener(fragment, new LifecycleListener() {
			@Override
			public void onStart() {
				Log.d(TAG, fragmentTagName+"_"+"onStart");
			}

			@Override
			public void onResume() {
				Log.d(TAG, fragmentTagName+"_"+"onResume");
			}

			@Override
			public void onPause() {
				Log.d(TAG, fragmentTagName+"_"+"onPause");
			}

			@Override
			public void onStop() {
				Log.d(TAG, fragmentTagName+"_"+"onStop");
			}

			@Override
			public void onDestroy() {
				Log.d(TAG, fragmentTagName+"_"+"onDestroy");
			}
		});
	}

	public void registerLifecycleListener(android.support.v4.app.Fragment fragment, final String fragmentTagName) {

		LifecycleManager lifecycleManager = new LifecycleManager(fragmentTagName);

		lifecycleManager.registerLifecycleListener(fragment, new LifecycleListener() {
			@Override
			public void onStart() {
				Log.d(TAG, fragmentTagName+"_"+"onStart");
			}

			@Override
			public void onResume() {
				Log.d(TAG, fragmentTagName+"_"+"onResume");
			}

			@Override
			public void onPause() {
				Log.d(TAG, fragmentTagName+"_"+"onPause");
			}

			@Override
			public void onStop() {
				Log.d(TAG, fragmentTagName+"_"+"onStop");
			}

			@Override
			public void onDestroy() {
				Log.d(TAG, fragmentTagName+"_"+"onDestroy");
			}
		});
	}
}
