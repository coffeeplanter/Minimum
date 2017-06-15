package ru.coffeeplanter.minimum.main;

import java.util.List;

interface MainView {

	void showProgress();

	void hideProgress();

	void setItems(List<String> items);

	void showMessage(String message);

	void navigateToPinActivity();

}
