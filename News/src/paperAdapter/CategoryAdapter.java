package paperAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.news.R;
import com.example.variables.Variables;

public class CategoryAdapter extends ArrayAdapter<String>{

	private Context context;
	private String[] categoris;
	private int ivIcon;
	
	public CategoryAdapter (Context context, int ivIcon,
			String[] categoris) {
		super(context, ivIcon, categoris);

this.context = context;
this.ivIcon = ivIcon;
this.categoris = categoris;


	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(
				context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.category, parent,false);
		ImageView iv = (ImageView)rowView.findViewById(R.id.ivIcon);
		TextView tv= (TextView)rowView.findViewById(R.id.tvCategory);
		iv.setImageResource(ivIcon);
		tv.setText(categoris[position]);
		return rowView;
		
	}
}
