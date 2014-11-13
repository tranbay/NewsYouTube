package com.example.news;

import java.io.ObjectOutputStream.PutField;
import java.util.List;

import paperAdapter.NewsAdapter;

import com.example.models.RssItem;
import com.example.variables.Variables;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class NewListActivity extends ListActivity{

	private List<RssItem> items;
	private int category;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
		category  = bundle.getInt(Variables.CATEGORY);
		int paper = bundle.getInt(Variables.PAPER);
		
		setTitle(Variables.CATEGORIES[paper][category]);
		int key = paper*1000 + category;
	     items =Variables.newsMap.get(key);
		NewsAdapter adapter = new NewsAdapter(this, Variables.ICONS[paper], items);
		setListAdapter(adapter);
		
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(NewListActivity.this, NewsActiviy.class);
	    intent.putExtra(Variables.LINK,items.get(position).getLink());
	    
	    startActivity(intent);
	}
}
