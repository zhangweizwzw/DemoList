package com.example.zw.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zw.bean.CoinBean;
import com.example.zw.demolist.R;

import java.util.ArrayList;
import java.util.List;

import recyclepulltorefresh.RecyclerViewHolder;

/**
 * Created by Administrator
 * Time on 2016/1/15.
 * Description
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

	private Context mContext;
	private LayoutInflater mLayoutInflater;
	private List<CoinBean.InfoBean> mDataSource;
	public RecyclerAdapter(Context context, List<CoinBean.InfoBean> list) {
		mContext = context;
		mLayoutInflater = LayoutInflater.from(context);
		mDataSource = new ArrayList<CoinBean.InfoBean>();
        mDataSource=list;
	}

	@Override
	public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = mLayoutInflater.inflate(R.layout.activity_recycle_refresh_item, parent, false);
		return new RecyclerViewHolder(view, viewType);
	}

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


	@Override
	public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
		holder.text.setText(mDataSource.get(position).getRemark());
		if (onItemClickListener != null) {
			holder.text.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
//					int position = holder.getLayoutPosition();
					onItemClickListener.onItemClick(holder.itemView, position);
				}
			});

			holder.text.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View v) {
//					int position = holder.getLayoutPosition();
					onItemClickListener.onItemLongClick(holder.itemView, position);
					return false;
				}
			});
		}
	}

	@Override
	public int getItemCount() {
		return mDataSource.size();
	}

//	public void resetList(List<CoinBean.InfoBean> list) {
//		mDataSource.clear();
//		mDataSource.addAll(list);
//		notifyDataSetChanged();
//	}
//
//	public void addList(List<CoinBean.InfoBean> list) {
//		mDataSource.addAll(list);
//		notifyDataSetChanged();
//	}
}
