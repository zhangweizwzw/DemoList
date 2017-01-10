package recyclepulltorefresh;

import android.view.View;
import android.widget.TextView;

import com.example.zw.demolist.R;

/**
 * Created by Andy
 * Time on 2016/1/15.
 * Description for recyclerAdapter
 */
public class RecyclerViewHolder extends RefreshViewHolder {

	public TextView text;
	public RecyclerViewHolder(View itemView, int type) {
		super(itemView, type);
		text = (TextView) itemView.findViewById(R.id.text);

	}
}
