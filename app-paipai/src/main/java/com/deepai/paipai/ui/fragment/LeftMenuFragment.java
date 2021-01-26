package com.deepai.paipai.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.deepai.paipai.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeftMenuFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private OnFragmentInteractionListener mListener;
    private String mParam1;
    private String mParam2;

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public static LeftMenuFragment newInstance(String param1, String param2) {
        LeftMenuFragment fragment = new LeftMenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString(ARG_PARAM1);
            this.mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_menu, container, false);
        initListView(view);
        return view;
    }

    private void initListView(View view) {
        String[] textArray = getResources().getStringArray(R.array.array_left_menu_text);
        int[] iconArray = getResources().getIntArray(R.array.array_left_menu_icon);
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < textArray.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("icon", Integer.valueOf(iconArray[i]));
            map.put("text", textArray[i]);
            data.add(map);
        }
        ListView lv = (ListView) view.findViewById(R.id.lv_left_menu);
        lv.setAdapter(new SimpleAdapter(this.activity, data, R.layout.item_left_menu, new String[]{"icon", "text"}, new int[]{R.id.iv_left_menu_icon, R.id.tv_left_menu_text}));
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            }
        });
    }

    public void onButtonPressed(Uri uri) {
        if (this.mListener != null) {
            this.mListener.onFragmentInteraction(uri);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            this.mListener = (OnFragmentInteractionListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = null;
    }
}
