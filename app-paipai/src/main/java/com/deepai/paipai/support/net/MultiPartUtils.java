package com.deepai.paipai.support.net;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.http.Headers;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.support.annotation.NonNull;
import com.deepai.paipai.app.AppConstant;
import com.deepai.paipai.app.AppConstant.RequestKey;
import com.deepai.paipai.support.utils.AppSP;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

public class MultiPartUtils {

    public interface CallBackResponseContent {
        void getFailContent(String str);

        void getResponseContent(String str);
    }

    public static void upLoadParsonHomepageImage(Context context, File imageFile, String url, CallBackResponseContent backResponseContent) {
        String token = AppSP.getToken(context, "").toString();
        PostMethod fileMethod = new PostMethod(url);
        Part[] parts = new Part[2];
        parts[0] = new StringPart(RequestKey.TOKEN, token, HTTP.UTF_8);
        try {
            parts[1] = new FilePart("picture", imageFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        fileMethod.setRequestEntity(new MultipartRequestEntity(parts, fileMethod.getParams()));
        try {
            if (new HttpClient().executeMethod(fileMethod) == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(fileMethod.getResponseBodyAsStream()));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String str = br.readLine();
                    if (str == null) {
                        break;
                    }
                    stringBuffer.append(str);
                }
                JSONObject jsonObject = new JSONObject(stringBuffer.toString());
                String code = jsonObject.getString(AppConstant.CODE);
                if (AppConstant.SUCCESS.equals(code)) {
                    backResponseContent.getResponseContent(jsonObject.getString(AppConstant.DATA));
                } else {
                    backResponseContent.getFailContent(code);
                }
            }
        } catch (HttpException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        } finally {
            fileMethod.releaseConnection();
        }
    }

    public static void upLoadAddImage(@NonNull File imageFile, @NonNull String token, @NonNull String imageContent, @NonNull String location, @NonNull String hideContent, @NonNull String musicName, @NonNull String url, @NonNull CallBackResponseContent backResponseContent) {
        PostMethod fileMethod = new PostMethod(url);
        Part[] parts = new Part[6];
        Part partToken1 = new StringPart(RequestKey.TOKEN, token, HTTP.UTF_8);
        Part partToken2 = new StringPart("title", imageContent, HTTP.UTF_8);
        Part partToken3 = new StringPart(Headers.LOCATION, location, HTTP.UTF_8);
        Part partToken4 = new StringPart("hideContent", hideContent, HTTP.UTF_8);
        Part partToken5 = new StringPart("songName", musicName, HTTP.UTF_8);
        parts[0] = partToken1;
        parts[1] = partToken2;
        parts[2] = partToken3;
        parts[3] = partToken4;
        parts[4] = partToken5;
        try {
            parts[5] = new FilePart("picture", imageFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        MultipartRequestEntity multipartRequestEntity = new MultipartRequestEntity(parts, fileMethod.getParams());
        fileMethod.setRequestEntity(multipartRequestEntity);
        try {
            if (new HttpClient().executeMethod(fileMethod) == 200) {
                InputStreamReader inputStreamReader = new InputStreamReader(fileMethod.getResponseBodyAsStream());
                BufferedReader br = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String str = br.readLine();
                    if (str == null) {
                        break;
                    }
                    stringBuffer.append(str);
                }
                String result = stringBuffer.toString();
                String code = new JSONObject(result).getString(AppConstant.CODE);
                if (AppConstant.SUCCESS.equals(code)) {
                    backResponseContent.getResponseContent(result);
                } else {
                    backResponseContent.getFailContent(code);
                }
            }
        } catch (HttpException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        } finally {
            fileMethod.releaseConnection();
        }
    }

    public static void upLoadArmFile(@NonNull File[] armFiles, @NonNull String token, @NonNull String url, @NonNull CallBackResponseContent backResponseContent) {
        PostMethod fileMethod = new PostMethod(url);
        Part[] parts = new Part[(armFiles.length + 1)];
        parts[0] = new StringPart(RequestKey.TOKEN, token, HTTP.UTF_8);
        int i = 0;
        while (i < armFiles.length) {
            try {
                parts[i + 1] = new FilePart("armFile", armFiles[i]);
                i++;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        MultipartRequestEntity multipartRequestEntity = new MultipartRequestEntity(parts, fileMethod.getParams());
        fileMethod.setRequestEntity(multipartRequestEntity);
        try {
            if (new HttpClient().executeMethod(fileMethod) == 200) {
                InputStreamReader inputStreamReader = new InputStreamReader(fileMethod.getResponseBodyAsStream());
                BufferedReader br = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String str = br.readLine();
                    if (str == null) {
                        break;
                    }
                    stringBuffer.append(str);
                }
                String result = stringBuffer.toString();
                String code = new JSONObject(result).getString(AppConstant.CODE);
                if (AppConstant.SUCCESS.equals(code)) {
                    backResponseContent.getResponseContent(result);
                } else {
                    backResponseContent.getFailContent(code);
                }
            }
        } catch (HttpException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        } finally {
            fileMethod.releaseConnection();
        }
    }

    @SuppressLint({"NewApi"})
    public static String getPath(Context context, Uri uri) {
        boolean isKitKat;
        if (VERSION.SDK_INT >= 19) {
            isKitKat = true;
        } else {
            isKitKat = false;
        }
        if (!isKitKat || !DocumentsContract.isDocumentUri(context, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                return getDataColumn(context, uri, null, null);
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            } else {
                return null;
            }
        } else if (isExternalStorageDocument(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(split[0])) {
                return Environment.getExternalStorageDirectory() + CookieSpec.PATH_DELIM + split[1];
            }
            return null;
        } else if (isDownloadsDocument(uri)) {
            return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
        } else if (!isMediaDocument(uri)) {
            return null;
        } else {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
            String type = split2[0];
            Uri contentUri = null;
            if ("image".equals(type)) {
                contentUri = Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(type)) {
                contentUri = Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(type)) {
                contentUri = Audio.Media.EXTERNAL_CONTENT_URI;
            }
            String str = "_id=?";
            return getDataColumn(context, contentUri, "_id=?", new String[]{split2[1]});
        }
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    /* JADX INFO: finally extract failed */
    public static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        String str = "_data";
        try {
            Cursor cursor2 = context.getContentResolver().query(uri, new String[]{"_data"}, selection, selectionArgs, null);
            if (cursor2 == null || !cursor2.moveToFirst()) {
                if (cursor2 != null) {
                    cursor2.close();
                }
                return null;
            }
            String string = cursor2.getString(cursor2.getColumnIndexOrThrow("_data"));
            if (cursor2 == null) {
                return string;
            }
            cursor2.close();
            return string;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
