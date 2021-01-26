package com.deepai.paipai.support.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.deepai.library.support.adapter.DBaseAdapter;
import com.deepai.paipai.R;
import com.deepai.paipai.support.bean.CommentShowBean;
import java.util.List;

public class ListViewCommentShowAdapter extends DBaseAdapter<CommentShowBean> {

    private static class ViewHolder {
        TextView mTextContent;
        TextView mTextName;

        private ViewHolder() {
        }
    }

    public ListViewCommentShowAdapter(List<CommentShowBean> list, Context context) {
        super(list, context);
    }

    public View createView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.item_list_comment_show, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mTextName = (TextView) convertView.findViewById(R.id.text_comment_name);
            viewHolder.mTextContent = (TextView) convertView.findViewById(R.id.text_comment_content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        CommentShowBean commentShowBean = (CommentShowBean) this.list.get(position);
        String name = commentShowBean.getNickname();
        if (!TextUtils.isEmpty(name)) {
            viewHolder.mTextName.setText(name + "：");
        }
        viewHolder.mTextContent.setText(commentShowBean.getContent());
        return convertView;
    }
}
