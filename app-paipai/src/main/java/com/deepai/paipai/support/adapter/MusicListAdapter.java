package com.deepai.paipai.support.adapter;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.deepai.paipai.R;
import com.deepai.paipai.support.bean.MusicBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MusicListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    /* access modifiers changed from: private */
    public boolean isPlaying = false;
    private Context mContext;
    /* access modifiers changed from: private */
    public List<MusicBean> mList;
    /* access modifiers changed from: private */
    public List<ImageView> mPlayList = new ArrayList();
    private MediaPlayer mPlayer = new MediaPlayer();
    HashMap<String, Boolean> playStatus = new HashMap<>();
    HashMap<String, Boolean> states = new HashMap<>();

    class ViewHolder {
        TextView authorTV;
        TextView nameTV;
        ImageView playButton;
        RadioButton radioButton;

        ViewHolder() {
        }
    }

    public MusicListAdapter(Context context, List<MusicBean> beans) {
        this.mContext = context;
        this.mList = beans;
        this.inflater = LayoutInflater.from(this.mContext);
    }

    public MediaPlayer getMineMediaPlayer() {
        return this.mPlayer;
    }

    public int getCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    public Object getItem(int position) {
        return this.mList.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        boolean res;
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.item_music_layout, null);
            holder = new ViewHolder();
            holder.nameTV = (TextView) convertView.findViewById(R.id.tv_music_name);
            holder.authorTV = (TextView) convertView.findViewById(R.id.tv_author);
            holder.playButton = (ImageView) convertView.findViewById(R.id.iv_play);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final RadioButton radio = (RadioButton) convertView.findViewById(R.id.radio_btn);
        holder.radioButton = radio;
        holder.radioButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                for (String key : MusicListAdapter.this.states.keySet()) {
                    MusicListAdapter.this.states.put(key, Boolean.valueOf(false));
                }
                MusicListAdapter.this.states.put(String.valueOf(position), Boolean.valueOf(radio.isChecked()));
                MusicListAdapter.this.notifyDataSetChanged();
            }
        });
        if (this.states.get(String.valueOf(position)) == null || !((Boolean) this.states.get(String.valueOf(position))).booleanValue()) {
            res = false;
            this.states.put(String.valueOf(position), Boolean.valueOf(false));
        } else {
            res = true;
        }
        holder.radioButton.setChecked(res);
        holder.nameTV.setText(((MusicBean) this.mList.get(position)).getName());
        holder.authorTV.setText(((MusicBean) this.mList.get(position)).getAuthor());
        final ViewHolder finalHolder = holder;
        holder.playButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                MusicListAdapter.this.mPlayList.add((ImageView) v);
                if (MusicListAdapter.this.mPlayList.size() > 0) {
                    for (int i = 0; i < MusicListAdapter.this.mPlayList.size(); i++) {
                        ((ImageView) MusicListAdapter.this.mPlayList.get(i)).setImageResource(R.mipmap.music_play);
                    }
                }
                for (String key : MusicListAdapter.this.playStatus.keySet()) {
                    MusicListAdapter.this.playStatus.put(key, Boolean.valueOf(false));
                }
                MusicListAdapter.this.playStatus.put(String.valueOf(position), Boolean.valueOf(MusicListAdapter.this.isPlaying));
                if (MusicListAdapter.this.isPlaying) {
                    MusicListAdapter.this.stopMusic();
                    finalHolder.playButton.setImageResource(R.mipmap.music_play);
                    MusicListAdapter.this.isPlaying = false;
                } else {
                    MusicListAdapter.this.playMusic(((MusicBean) MusicListAdapter.this.mList.get(position)).getName());
                    finalHolder.playButton.setImageResource(R.mipmap.music_stop);
                    MusicListAdapter.this.isPlaying = true;
                }
                MusicListAdapter.this.notifyDataSetChanged();
            }
        });
        return convertView;
    }

    /* access modifiers changed from: private */
    public void playMusic(String name) {
        try {
            AssetFileDescriptor afd = this.mContext.getAssets().openFd("ogg/" + name);
            this.mPlayer.reset();
            this.mPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            this.mPlayer.prepare();
            this.mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void stopMusic() {
        this.mPlayer.pause();
    }

    public String getMusicName() {
        for (int i = 0; i < this.states.size(); i++) {
            if (((Boolean) this.states.get(String.valueOf(i))).booleanValue()) {
                return ((MusicBean) this.mList.get(i)).getName();
            }
        }
        return "";
    }
}
