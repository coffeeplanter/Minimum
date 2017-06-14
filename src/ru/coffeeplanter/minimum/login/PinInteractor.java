package ru.coffeeplanter.minimum;

public interface PinInteractor {

	interface OnLoginFinishedListener {

		void onPinError();

		void onSuccess();

	}

	void login(String pin, OnLoginFinishedListener listener);

}
