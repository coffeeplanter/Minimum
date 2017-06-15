package ru.coffeeplanter.minimum.login;

public interface PinView {

	void showProgress();

	void hideProgress();

	void setPinEmptyError();

	void setPinShortError();

	void navigateToMainActivity();

}
