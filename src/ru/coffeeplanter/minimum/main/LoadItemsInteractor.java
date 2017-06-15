package ru.coffeeplanter.minimum.main;

import java.util.List;

interface LoadItemsInteractor {

	interface OnFinishedListener {

		void onFinished(List<String> items);

	}

	void loadItems(OnFinishedListener listener);

	void loadItemsImmediately(OnFinishedListener listener);

}
