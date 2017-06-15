package ru.coffeeplanter.minimum.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import ru.coffeeplanter.minimum.R;
import ru.coffeeplanter.minimum.main.MainActivity;

public class PinActivity extends Activity implements PinView, View.OnClickListener {

	private ProgressBar mProgressBar;
	private EditText mPinEditText;

	private PinPresenter mPresenter;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pin);

		mProgressBar = (ProgressBar) findViewById(R.id.progress);
		mPinEditText = (EditText) findViewById(R.id.pin);
		findViewById(R.id.button).setOnClickListener(this);
		
		mPresenter = new PinPresenterImpl(this);
		
	}

	@Override
	protected void onDestroy() {
		mPresenter.onDestroy();
		super.onDestroy();
	}

	@Override
	public void showProgress() {
		mProgressBar.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideProgress() {
		mProgressBar.setVisibility(View.GONE);
	}

	@Override
	public void setPinEmptyError() {
		mPinEditText.setError(getString(R.string.pin_empty_error));
	}

	@Override
	public void setPinShortError() {
		mPinEditText.setError(getString(R.string.pin_short_error));
	}

	@Override
	public void navigateToMainActivity() {
		startActivity(new Intent(this, MainActivity.class));
		finish();
	}

	@Override
	public void onClick(View view) {
		mPresenter.validatePin(mPinEditText.getText().toString());
	}

}
