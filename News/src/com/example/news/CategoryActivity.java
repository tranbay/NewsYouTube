package com.example.news;

import java.util.List;

import paperAdapter.CategoryAdapter;

import com.example.variables.*;

import android.app.LauncherActivity.ListItem;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.example.models.RssItem;

public class CategoryActivity  extends ListActivity{

	private int paper;
	private ProgressDialog dialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {


		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
		 paper = bundle.getInt(Variables.PAPER);
		setTitle(Variables.PAPERS[paper]);
		CategoryAdapter adapter = new CategoryAdapter(this,
				Variables.ICONS[paper], Variables.CATEGORIES[paper]);
		setListAdapter(adapter);
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		int key = paper*1000 +position ;
		if(Variables.newsMap.get(key)==null){
		dialog = ProgressDialog.show(CategoryActivity.this, ""," Loading"+" " 
		                          +Variables.CATEGORIES[paper][position] );
		
		new CategoryTask().execute(position);
		}
		else {
			Intent intent = new Intent(CategoryActivity.this, NewListActivity.class );
			intent.putExtra(Variables.CATEGORY, position);
			intent.putExtra(Variables.PAPER, paper);
			
			startActivity(intent);
		}
	}
class CategoryTask extends AsyncTask<Integer , Void, Void>{

	private int position;
	@Override
	protected Void doInBackground(Integer... params) {
		int position = params[0];
		int key = paper*1000 +position ;
        RssParser parser = new RssParser();
		
		List<RssItem> items = 
				parser.getNewsList(Variables.LINKS[paper][position]);
		System.out.println(" items size:" +items.size());
		
		Variables.newsMap.put(key, items);
		
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		
		if(dialog !=null){
			dialog.dismiss();
		}
		Intent intent = new Intent(CategoryActivity.this, NewListActivity.class );
		intent.putExtra(Variables.CATEGORY, position);
		intent.putExtra(Variables.PAPER, paper);
		
		startActivity(intent);
		super.onPostExecute(result);
	}
	
	
}

	
	
	
}
