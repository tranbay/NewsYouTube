package paperAdapter;

import java.util.List;

import android.content.Context;
import android.media.Image;
import android.media.ImageReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.models.*;
import com.example.news.R;

public class NewsAdapter extends ArrayAdapter<RssItem>{

	private Context context;
	private List<RssItem> items;
	private int ivIcon;
    
    

	
	public NewsAdapter(Context context, int ivIcon, List<RssItem> items) {
		super(context, ivIcon, items);
		this.context = context;
		this.ivIcon =ivIcon;
		this.items = items;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(
				context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.news, parent,false);
		ImageView iv = (ImageView)rowView.findViewById(R.id.ivIcon);
		TextView tv= (TextView)rowView.findViewById(R.id.tvNesws);
		iv.setImageResource(ivIcon);
		tv.setText(items.get(position).getTitle());
		return rowView;
	}

}
