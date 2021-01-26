package com.deepai.paipai.dao;

import android.content.ContentValues;
import com.deepai.paipai.support.bean.SaveShareDataBean;
import java.util.List;
import java.util.Map;

public interface ShareInformDaoInface {
    boolean addCache(SaveShareDataBean saveShareDataBean, String str);

    void clearFeedTable();

    boolean deleteCache(String str, String[] strArr);

    List<Map<String, String>> listCache(String str, String[] strArr);

    boolean updateCache(ContentValues contentValues, String str, String[] strArr);

    Map<String, String> viewCache(String str, String[] strArr);
}
