package ru.coffeeplanter.minimum;

public class PinPresenterImpl implements PinPresenter, PinInteractor.OnLoginFinishedListener {

	PinView pinView;
	PinInteractor pinInteractor;

	public void PinPresenterImpl(PinView pinView) {
		this.pinView = pinView;
		this.pinInteractor = new PinInteractorImpl();
	}

	@Override
	public void validatePin(String pin) {
		if (pinView != null) {
			pinView.showProgress();
		}
		pinInteractor.login(pin, this);
	}

	@Override
	public void onDestroy() {
		pinView = null;
	}

	@Override
	public void onPinError() {
		if (pinView != null) {
			pinView.setPinError();
			pinView.hideProgress();
		}
	}

	@Override
	public void onSuccess() {
		if (pinView != null) {
			pinView.navigateToMainActivity();
		}
	}

}
