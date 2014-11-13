package com.example.news;

import paperAdapter.PaperAdapter;

import com.example.variables.Variables;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class PaperActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, 
        	//	Variables.PAPERS);
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //		R.layout.paper,
        	//	R.id.tvPaper, Variables.PAPERS);
        PaperAdapter adapter = new PaperAdapter(this, 
        		R.id.tvPaper,Variables.PAPERS);
        setListAdapter(adapter);
    }

    

    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		super.onListItemClick(l, v, position, id);
		Intent intent =  new Intent("com.example.news");
		intent.putExtra(Variables.PAPER, position);
		
		startActivity(intent);
	}



	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.paper, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
