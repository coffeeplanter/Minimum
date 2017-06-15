package ru.coffeeplanter.minimum.main;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

public class LoadItemsInteractorImpl implements LoadItemsInteractor {

	@Override
	public void loadItems(OnFinishedListener listener) {
		new Handler().postDelayed(createRunnable(listener), 1000);
	}

	@Override
	public void loadItemsImmediately(OnFinishedListener listener) {
		new Handler().post(createRunnable(listener));
	}

	private Runnable createRunnable(final OnFinishedListener listener) {
		return new Runnable() {
			@Override
			public void run() {
				listener.onFinished(createList());
			}
		};
	}

	private List<String> createList() {
		List<String> list = new ArrayList();
		for (int i = 0; i < 10; i++) {
			list.add("Item " + (i + 1));
		}
		return list;
	}

}
