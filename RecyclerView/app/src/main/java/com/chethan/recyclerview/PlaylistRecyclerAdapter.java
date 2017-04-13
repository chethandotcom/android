package com.chethan.recyclerview;

/**
 * Created by chethanshetty on 20/03/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tony Stark on 18/12/16.
 */

public class PlaylistRecyclerAdapter extends RecyclerView.Adapter<PlaylistRecyclerAdapter.ViewHolder> {

    Context mContext;
    OnItemClickListener mItemClickListener;
    private List<String> playlistModelList;

    // 2
    public PlaylistRecyclerAdapter(Context context, List<String> playlistModelList) {
        this.mContext = context;
        this.playlistModelList = playlistModelList;
    }

    public void dataSetUpdated(List<String> listRestaurants) {
        this.playlistModelList = listRestaurants;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return playlistModelList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.textViewPlaylistTitle.setText(playlistModelList.get(position));
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    // 3
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView textViewPlaylistTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewPlaylistTitle = (TextView) itemView.findViewById(R.id.text_view_playlist_title);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(itemView, getPosition());
            }
        }
    }
}