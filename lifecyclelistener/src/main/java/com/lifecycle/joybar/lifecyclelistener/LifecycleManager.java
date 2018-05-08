package com.lifecycle.joybar.lifecyclelistener;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.lifecycle.joybar.lifecyclelistener.fragment.LifecycleListenerFragment;
import com.lifecycle.joybar.lifecyclelistener.fragment.SupportLifecycleListenerFragment;
import com.lifecycle.joybar.lifecyclelistener.interfaces.LifecycleListener;
import com.lifecycle.joybar.lifecyclelistener.util.CheckUtils;

/**
 * Created by joybar on 2017/6/29.
 */

public class LifecycleManager {

	private static final String FRAGMENT_TAG = "ActivityFragmentLifecycle";
	private static final String TAG = "LifecycleManager";
	private String fragmentTagName;

	private static volatile LifecycleManager mInstance;

	public LifecycleManager(String fragmentTagName) {
		this.fragmentTagName = fragmentTagName;
	}

	private String getFragmentTag() {
		return fragmentTagName;
	}

	public void registerLifecycleListener(Context context, LifecycleListener lifecycleListener) {
		if (context == null) {
			throw new IllegalArgumentException("You cannot start a load on a null Context");
		} else if (CheckUtils.isOnMainThread() && !(context instanceof Application)) {
			if (context instanceof FragmentActivity) {
				handleObserveLifecycle((FragmentActivity) context, lifecycleListener);
			} else if (context instanceof Activity) {
				handleObserveLifecycle((Activity) context, lifecycleListener);
			} else if (context instanceof ContextWrapper) {
				handleObserveLifecycle(((ContextWrapper) context).getBaseContext(), lifecycleListener);
			}
		}
	}


	public void registerLifecycleListener(android.support.v4.app.Fragment fragment, LifecycleListener lifecycleListener) {
		if (fragment.getActivity() == null) {
			throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
		}
		android.support.v4.app.FragmentManager fm = fragment.getChildFragmentManager();
		SupportLifecycleListenerFragment supportLifecycleListenerFragment = getSupportRequestManagerFragment(fm);
		FragmentLifecycle fragmentLifecycle = getActivitySupportFragmentLifecycle(supportLifecycleListenerFragment);
		fragmentLifecycle.addListener(lifecycleListener);

	}

	@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
	public void registerLifecycleListener(android.app.Fragment fragment, LifecycleListener lifecycleListener) {
		if (fragment.getActivity() == null) {
			throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
		}
		android.app.FragmentManager fm = fragment.getChildFragmentManager();
		LifecycleListenerFragment lifecycleListenerFragment = getSupportRequestManagerFragment(fm);
		FragmentLifecycle fragmentLifecycle = getActivityFragmentLifecycle(lifecycleListenerFragment);
		fragmentLifecycle.addListener(lifecycleListener);

	}


	public void handleObserveLifecycle(FragmentActivity activity, LifecycleListener lifecycleListener) {
		Log.d(TAG, "this context type  is FragmentActivity");
		assertNotDestroyed(activity);
		android.support.v4.app.FragmentManager fm = activity.getSupportFragmentManager();
		SupportLifecycleListenerFragment fragment = getSupportRequestManagerFragment(fm);
		FragmentLifecycle fragmentLifecycle = getActivitySupportFragmentLifecycle(fragment);
		fragmentLifecycle.addListener(lifecycleListener);
	}

	private void handleObserveLifecycle(Activity activity, LifecycleListener lifecycleListener) {
		Log.d(TAG, "this context type  is Activity");
		assertNotDestroyed(activity);
		android.app.FragmentManager fm = activity.getFragmentManager();
		LifecycleListenerFragment fragment = getSupportRequestManagerFragment(fm);
		FragmentLifecycle activityFragmentLifecycle = getActivityFragmentLifecycle(fragment);
		activityFragmentLifecycle.addListener(lifecycleListener);
	}

	private void handleObserveLifecycle(Context context, LifecycleListener lifecycleListener) {
		Log.d(TAG, "this context type is Context");
	}

	private LifecycleListenerFragment getSupportRequestManagerFragment(final android.app.FragmentManager fm) {
		LifecycleListenerFragment current = (LifecycleListenerFragment) fm.findFragmentByTag(getFragmentTag());
		if (current == null) {
			current = new LifecycleListenerFragment();
			fm.beginTransaction().add(current, getFragmentTag()).commitAllowingStateLoss();
		}
		return current;
	}


	private SupportLifecycleListenerFragment getSupportRequestManagerFragment(android.support.v4.app.FragmentManager fm) {
		SupportLifecycleListenerFragment current = (SupportLifecycleListenerFragment) fm.findFragmentByTag(getFragmentTag());
		if (current == null) {
			current = new SupportLifecycleListenerFragment();
			fm.beginTransaction().add(current, getFragmentTag()).commitAllowingStateLoss();
		}
		return current;
	}

	private FragmentLifecycle getActivitySupportFragmentLifecycle(SupportLifecycleListenerFragment fragment) {
		FragmentLifecycle lifecycleListener = fragment.getLifecycle();
		if (null == lifecycleListener) {
			lifecycleListener = new FragmentLifecycle();
		}
		fragment.setLifecycle(lifecycleListener);
		return lifecycleListener;
	}


	private FragmentLifecycle getActivityFragmentLifecycle(LifecycleListenerFragment fragment) {
		FragmentLifecycle lifecycleListener = fragment.getLifecycle();
		if (null == lifecycleListener) {
			lifecycleListener = new FragmentLifecycle();
		}
		fragment.setLifecycle(lifecycleListener);
		return lifecycleListener;
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	private static void assertNotDestroyed(Activity activity) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && activity.isDestroyed()) {
			//throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
		}
	}

}
