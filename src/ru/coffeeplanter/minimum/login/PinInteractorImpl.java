package ru.coffeeplanter.minimum;

import android.os.Handler;
import android.text.TextUtils;

public class PinInteractorImpl implements PinInteractor {

	@Override
	void login(final String pin, final OnLoginFinishedListener listener) {
		// Mocking login.
		new Handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				boolean error = false;
				if (TextUtils.isEmpty(pin)) {
					listener.onPinError();
					error = true;
					return;
				}
				if (!error) listener.onSuccess();
			}
		}, 2000);
	}

}
