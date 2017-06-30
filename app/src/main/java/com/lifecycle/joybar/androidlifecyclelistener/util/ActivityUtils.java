package com.lifecycle.joybar.androidlifecyclelistener.util;

import android.support.annotation.NonNull;

/**
 * Created by joybar on 2017/6/9.
 */

public class ActivityUtils {

	public static void addFragmentToActivity(@NonNull android.support.v4.app.FragmentManager fragmentManager, @NonNull android.support.v4.app.Fragment fragment, int frameId) {
		fragmentManager = CheckUtils.checkNotNull(fragmentManager);
		fragment = CheckUtils.checkNotNull(fragment);
		android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.add(frameId, fragment);
		transaction.commit();
	}

	public static void addFragmentToActivity(@NonNull android.app.FragmentManager fragmentManager, @NonNull android.app.Fragment fragment, int frameId) {
		fragmentManager = CheckUtils.checkNotNull(fragmentManager);
		fragment = CheckUtils.checkNotNull(fragment);
		android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.add(frameId, fragment);
		transaction.commit();
	}

}
