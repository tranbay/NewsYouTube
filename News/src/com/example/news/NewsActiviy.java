package com.example.news;

import com.example.variables.Variables;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsActiviy extends Activity{

	private WebView webView;
	private String link;
	private ProgressDialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.article);
		Bundle bundle =  getIntent().getExtras();
		setTitle(R.string.app_name);
		 link = bundle.getString(Variables.LINK);
		webView = (WebView)findViewById(R.id.wvNews);
		
		webView.getSettings().setSupportZoom(true);
		webView.setInitialScale(1);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setUseWideViewPort(true);
		webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		webView.setScrollbarFadingEnabled(false);
		webView.setWebViewClient(new WebViewClients());
		dialog = ProgressDialog.show(this, " ", " Loading....");
		new NewsTask().execute();
		
	}
 class NewsTask extends AsyncTask<Void,Void,Void>{

	@Override
	protected Void doInBackground(Void... params) {
		webView.loadUrl(link);
		return null;
	}

	
 }
 class WebViewClients extends WebViewClient{

	@Override
	public void onPageFinished(WebView view, String url) {
		if(dialog != null){
			dialog.dismiss();
		}
		
		super.onPageFinished(view, url);
	}
	 
 }
}
