package ru.coffeeplanter.minimum.login;

import android.os.Handler;
import android.text.TextUtils;

public class PinInteractorImpl implements PinInteractor {

	@Override
	public void login(final String pin, final OnLoginFinishedListener listener) {
		// Mocking login.
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				boolean error = false;
				if (TextUtils.isEmpty(pin)) {
					listener.onPinEmptyError();
					error = true;
					return;
				}
				if (pin.length() < 4) {
					listener.onPinShortError();
					error = true;
					return;
				}
				if (!error) listener.onSuccess();
			}
		}, 1000);
	}

}
