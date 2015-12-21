package com.andyiac.zcommon;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by andyiac on 12/21/15.
 *
 * @web www.andyiac.com
 */
public class ListAdapterHolder extends RecyclerView.Adapter<ListAdapterHolder.ViewHolder> {

    private List<String> mData;

    public ListAdapterHolder(List<String> data) {
        this.mData = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View sView = mInflater.inflate(R.layout.main_activity_list_item, parent, false);
        return new ViewHolder(sView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.e("TAG", "position=====>>" + position);
        holder.tvContent.setText(mData.get(position));
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvContent;

        public ViewHolder(View itemView) {
            super(itemView);
            tvContent = (TextView) itemView.findViewById(R.id.tv_main_activity_list_item_content);
        }

        @Override
        public void onClick(View v) {

        }
    }


}
