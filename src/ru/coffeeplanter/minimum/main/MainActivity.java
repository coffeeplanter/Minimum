package ru.coffeeplanter.minimum.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ru.coffeeplanter.minimum.login.PinActivity;
import ru.coffeeplanter.minimum.R;

public class MainActivity extends Activity implements MainView, AdapterView.OnItemClickListener {

	private ListView mListView;
	private ProgressBar mProgressBar;

	private MainPresenter mPresenter;

	private boolean isActivityRecreated = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState != null) {
			isActivityRecreated = true;
		}
		mListView = (ListView) findViewById(R.id.item_list);
		mListView.setOnItemClickListener(this);
		mProgressBar = (ProgressBar) findViewById(R.id.main_progress);
		mPresenter = new MainPresenterImpl(this, new LoadItemsInteractorImpl());
	}

	@Override
	protected void onResume() {
		super.onResume();
		mPresenter.onResume(isActivityRecreated);
	}

	@Override
	protected void onDestroy() {
		mPresenter.onDestroy();
		super.onDestroy();
	}

	@Override
	public void onBackPressed() {
		mPresenter.onBackPressed();
	}

	@Override
	public void showProgress() {
		mProgressBar.setVisibility(View.VISIBLE);
		mListView.setVisibility(View.INVISIBLE);
	}

	@Override
	public void hideProgress() {
		mProgressBar.setVisibility(View.INVISIBLE);
		mListView.setVisibility(View.VISIBLE);
	}

	@Override
	public void setItems(List<String> items) {
		mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
	}

	@Override
	public void showMessage(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		mPresenter.onItemClicked(position);
	}

	@Override
	public void navigateToPinActivity() {
		startActivity(new Intent(this, PinActivity.class)
			.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
			.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
		finish();
	}

}
