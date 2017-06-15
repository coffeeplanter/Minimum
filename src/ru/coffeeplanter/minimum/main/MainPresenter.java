package ru.coffeeplanter.minimum.main;

interface MainPresenter {

	void onItemClicked(int position);

	void onResume(boolean isActivityRecreated);

	void onDestroy();

	void onBackPressed();

}
