package ru.coffeeplanter.minimum.main;

import java.util.List;

public class MainPresenterImpl implements MainPresenter, LoadItemsInteractor.OnFinishedListener {

	private MainView mMainView;
	private LoadItemsInteractor mLoadItemsInteractor;

	public MainPresenterImpl(MainView mainView, LoadItemsInteractor loadItemsInteractor) {
		this.mMainView = mainView;
		this.mLoadItemsInteractor = loadItemsInteractor;
	}

	@Override
	public void onResume(boolean isActivityRecreated) {
		if (mMainView != null) {
			mMainView.showProgress();
		}
		if (isActivityRecreated) {
			mLoadItemsInteractor.loadItemsImmediately(this);
		} else {
			mLoadItemsInteractor.loadItems(this);
		}
	}

	@Override
	public void onDestroy() {
		mMainView = null;
	}

	@Override
	public void onBackPressed() {
		if (mMainView != null) {
			mMainView.navigateToPinActivity();
		}
	}

	@Override
	public void onItemClicked(int position) {
		if (mMainView != null) {
			mMainView.showMessage("Item " + (position + 1) + " clicked");
		}
	}

	@Override
	public void onFinished(List<String> items) {
		if (mMainView != null) {
			mMainView.setItems(items);
			mMainView.hideProgress();
		}
	}

}
