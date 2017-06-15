package ru.coffeeplanter.minimum.login;

public class PinPresenterImpl implements PinPresenter, PinInteractor.OnLoginFinishedListener {

	PinView mPinView;
	PinInteractor mPinInteractor;

	public PinPresenterImpl(PinView pinView) {
		this.mPinView = pinView;
		this.mPinInteractor = new PinInteractorImpl();
	}

	@Override
	public void validatePin(String pin) {
		if (mPinView != null) {
			mPinView.showProgress();
		}
		mPinInteractor.login(pin, this);
	}

	@Override
	public void onDestroy() {
		mPinView = null;
	}

	@Override
	public void onPinEmptyError() {
		if (mPinView != null) {
			mPinView.setPinEmptyError();
			mPinView.hideProgress();
		}
	}

	@Override
	public void onPinShortError() {
		if (mPinView != null) {
			mPinView.setPinShortError();
			mPinView.hideProgress();
		}
	}

	@Override
	public void onSuccess() {
		if (mPinView != null) {
			mPinView.navigateToMainActivity();
		}
	}

}
