package com.deepai.paipai.support.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.deepai.library.support.adapter.DBaseAdapter;
import com.deepai.paipai.R;
import com.deepai.paipai.support.bean.IndexPhotoBean;
import com.deepai.paipai.support.imageloader.UniversalImageLoadTool;
import com.deepai.paipai.ui.activity.details.ImageDetailsActivity;
import java.util.List;
import org.apache.http.HttpHost;

public class ListViewIndexAdapter extends DBaseAdapter<IndexPhotoBean> {

    private static class ViewHolder {
        ImageView mImageContent;
        ImageView mImageHead;
        TextView mTextCommentNum;
        TextView mTextContent;
        TextView mTextName;
        TextView mTextTime;
        TextView mTextZanNum;

        private ViewHolder() {
        }
    }

    public ListViewIndexAdapter(List<IndexPhotoBean> list, Context context) {
        super(list, context);
    }

    public View createView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        String headUrl;
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.item_layout_listview_mainactivity, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mImageHead = (ImageView) convertView.findViewById(R.id.image_item_main_head);
            viewHolder.mTextName = (TextView) convertView.findViewById(R.id.text_item_main_head);
            viewHolder.mTextTime = (TextView) convertView.findViewById(R.id.text_item_main_head_time);
            viewHolder.mImageContent = (ImageView) convertView.findViewById(R.id.image_item_main_content);
            viewHolder.mTextContent = (TextView) convertView.findViewById(R.id.text_item_main_content);
            viewHolder.mTextCommentNum = (TextView) convertView.findViewById(R.id.text_item_main_comment);
            viewHolder.mTextZanNum = (TextView) convertView.findViewById(R.id.text_item_main_zan);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final IndexPhotoBean indexPhotoBean = (IndexPhotoBean) this.list.get(position);
        String headImag = indexPhotoBean.getHeadimgurl();
        if (!TextUtils.isEmpty(headImag)) {
            if (headImag.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                headUrl = headImag;
            } else {
                headUrl = "http://www.paipai360.cn/paipai360" + headImag;
            }
            UniversalImageLoadTool.disCirclePlay(headUrl, viewHolder.mImageHead, R.drawable.image_moren_fang, this.context);
        } else {
            viewHolder.mImageHead.setImageResource(R.mipmap.logo_default);
        }
        viewHolder.mTextName.setText(indexPhotoBean.getNickname());
        viewHolder.mTextTime.setText(indexPhotoBean.getHowLong());
        String contentImag = indexPhotoBean.getSurl();
        if (!TextUtils.isEmpty(contentImag)) {
            if (!contentImag.contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                contentImag = "http://www.paipai360.cn/paipai360" + contentImag;
            }
            UniversalImageLoadTool.disPlay(contentImag, viewHolder.mImageContent, (int) R.drawable.image_moren_fang, this.context);
        }
        viewHolder.mTextContent.setText(indexPhotoBean.getTitle());
        viewHolder.mTextCommentNum.setText(indexPhotoBean.getCommentnum());
        viewHolder.mTextZanNum.setText(indexPhotoBean.getPraisenum());
        convertView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ListViewIndexAdapter.this.context, ImageDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("detailsData", indexPhotoBean);
                intent.putExtras(bundle);
                ListViewIndexAdapter.this.context.startActivity(intent);
            }
        });
        return convertView;
    }
}
