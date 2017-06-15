package ru.coffeeplanter.minimum.login;

public interface PinInteractor {

	interface OnLoginFinishedListener {

		void onPinEmptyError();

		void onPinShortError();

		void onSuccess();

	}

	void login(String pin, OnLoginFinishedListener listener);

}
