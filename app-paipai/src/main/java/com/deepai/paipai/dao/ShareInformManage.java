package com.deepai.paipai.dao;

import android.database.SQLException;
import com.deepai.paipai.db.SQLHelper;
import com.deepai.paipai.support.bean.SaveShareDataBean;
import java.util.Map;

public class ShareInformManage {
    public static ShareInformManage newsManage;
    private ShareInformDao newsDao;

    private ShareInformManage(SQLHelper paramDBHelper) throws SQLException {
        if (this.newsDao == null) {
            this.newsDao = new ShareInformDao(paramDBHelper.getContext());
        }
    }

    public static ShareInformManage getManage(SQLHelper dbHelper) throws SQLException {
        if (newsManage == null) {
            newsManage = new ShareInformManage(dbHelper);
        }
        return newsManage;
    }

    public boolean deleteTableData(String type) {
        return this.newsDao.deleteCache("save_type= ?", new String[]{type});
    }

    public SaveShareDataBean getSaveDataFromDB(String type) {
        Map cacheList = this.newsDao.viewCache("save_type= ?", new String[]{type});
        if (cacheList == null || cacheList.isEmpty()) {
            return null;
        }
        Map<String, String> mapData = cacheList;
        SaveShareDataBean newBean = new SaveShareDataBean();
        newBean.setPhotoImagPath((String) mapData.get(SQLHelper.PHOTOIMAGPATH));
        newBean.setMusicName((String) mapData.get(SQLHelper.MUSICNAME));
        newBean.setHideInform((String) mapData.get(SQLHelper.HIDEINFORM));
        return newBean;
    }

    public void clearAllData() {
        this.newsDao.clearFeedTable();
    }

    public void clearLikeData() {
        this.newsDao.deleteLikeData(SQLHelper.SAVETYPE, "%myCountPage%");
    }

    public void saveNewsToDB(SaveShareDataBean dataBean, String type) {
        this.newsDao.addCache(dataBean, type);
    }
}
