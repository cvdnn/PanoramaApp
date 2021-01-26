package com.deepai.paipai.ui.activity.photo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import com.deepai.paipai.R;
import com.deepai.paipai.support.adapter.MusicListAdapter;
import com.deepai.paipai.support.bean.MusicBean;
import com.deepai.paipai.ui.activity.basic.BaseActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MusicListActivity extends BaseActivity {
    private MusicListAdapter adapter;
    private List<MusicBean> list = new ArrayList();
    private ListView listView;
    private String[] musics;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_music_list);
        initTitle(1, R.string.text_right, R.string.insert_music);
        init();
    }

    private void init() {
        this.listView = (ListView) findViewById(R.id.lv_music);
        try {
            this.musics = getAssets().list("ogg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String name : this.musics) {
            MusicBean musicBean = new MusicBean();
            musicBean.setName(name);
            musicBean.setAuthor("");
            this.list.add(musicBean);
        }
        this.adapter = new MusicListAdapter(this, this.list);
        this.listView.setAdapter(this.adapter);
    }

    public void onTitleRightClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("musicName", this.adapter.getMusicName());
        setResult(-1, intent);
        onBackPressed();
    }

    private MusicBean getRadioButtonStatus() {
        MusicBean musicBean = new MusicBean();
        int count = this.listView.getCount();
        for (int i = 0; i < this.listView.getCount(); i++) {
            if (((RadioButton) this.listView.getChildAt(i).findViewById(R.id.radio_btn)).isChecked()) {
                return (MusicBean) this.list.get(i);
            }
        }
        return musicBean;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.adapter != null) {
            MediaPlayer mediaPlayer = this.adapter.getMineMediaPlayer();
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        }
        super.onDestroy();
    }
}
