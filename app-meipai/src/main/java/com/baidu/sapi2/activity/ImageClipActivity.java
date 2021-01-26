package com.baidu.sapi2.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.views.ClipBoxView;
import com.baidu.sapi2.views.ZoomImageView;
import com.baidubce.BceConfig;
import e.c.c.a.a;
import e.c.c.a.e;
import e.c.c.a.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageClipActivity extends Activity {
    public static final int BUSSINESS_FROM_INVOICE_BUILD = 1;
    public static final int BUSSINESS_SET_PORTRAIT = 0;
    public static final int DEFAULT_CLIP_IMAGE_MAX_SIDE_LENGTH = 1000;
    public static final int DEFAULT_UPLOAD_IMAGE_MAX_SIZE = 512;
    public static String EXTRA_IMAGE = "extra_image";
    public static final String EXTRA_PARAM_FROM_BUSINESS = "extra_business_from";
    public static final String EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE = "extra_upload_image_max_size";
    public static final int INVALID_ANIM = 0;
    public static final int UPLOAD_IMAGE_HEIGHT = 160;
    public static final int UPLOAD_IMAGE_WIDTH = 160;

    /* renamed from: a reason: collision with root package name */
    public static final String f2614a = "ImageClipActivity";

    /* renamed from: b reason: collision with root package name */
    public static final String f2615b = "com.android.providers.media.documents";

    /* renamed from: c reason: collision with root package name */
    public static final String f2616c = "com.android.providers.downloads.documents";

    /* renamed from: d reason: collision with root package name */
    public static final String f2617d = "com.android.externalstorage.documents";

    /* renamed from: e reason: collision with root package name */
    public static final String f2618e = "content://downloads/public_downloads";

    /* renamed from: f reason: collision with root package name */
    public int f2619f = 0;

    /* renamed from: g reason: collision with root package name */
    public int f2620g = 0;

    /* renamed from: h reason: collision with root package name */
    public int f2621h = 0;

    /* renamed from: i reason: collision with root package name */
    public int f2622i = 0;

    /* renamed from: j reason: collision with root package name */
    public int f2623j;
    public int k;
    public String l;
    public ClipBoxView m;
    public ZoomImageView n;

    private void d() {
        if (this.f2621h != 0 || this.f2622i != 0) {
            overridePendingTransition(this.f2621h, this.f2622i);
            this.f2621h = 0;
            this.f2622i = 0;
        }
    }

    public void finish() {
        super.finish();
        d();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
    }

    public void onDestroy() {
        super.onDestroy();
        ClipBoxView.a();
        ZoomImageView.a();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        c();
    }

    public Bitmap operateBitmap(String str) {
        float f2;
        Bitmap a2 = a(str);
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                f2 = 180.0f;
            } else if (attributeInt != 6) {
                if (attributeInt == 8) {
                    f2 = 270.0f;
                }
                f2 = 0.0f;
            } else {
                f2 = 90.0f;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(f2, (float) (a2.getWidth() / 2), (float) (a2.getHeight() / 2));
        return Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
    }

    public void setPendingTransition(int i2, int i3, int i4, int i5) {
        this.f2619f = i2;
        this.f2620g = i3;
        this.f2621h = i4;
        this.f2622i = i5;
    }

    /* access modifiers changed from: private */
    @TargetApi(3)
    public void a() {
        Bitmap b2 = ZoomImageView.getInstance() == null ? null : ZoomImageView.getInstance().b();
        if (b2 != null && !b2.isRecycled()) {
            new AsyncTask<Bitmap, Void, byte[]>() {
                public byte[] doInBackground(Bitmap... bitmapArr) {
                    int i2;
                    if (bitmapArr[0] == null || bitmapArr[0].isRecycled()) {
                        return null;
                    }
                    int i3 = 160;
                    if (ImageClipActivity.this.f2623j != 0) {
                        i3 = bitmapArr[0].getWidth();
                        i2 = bitmapArr[0].getHeight();
                    } else {
                        i2 = 160;
                    }
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmapArr[0], i3, i2, true);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int i4 = 100;
                    createScaledBitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                    while (byteArrayOutputStream.toByteArray().length > ImageClipActivity.this.k && i4 > 0) {
                        i4 -= 5;
                        if (i4 <= 0) {
                            break;
                        }
                        byteArrayOutputStream.reset();
                        createScaledBitmap.compress(CompressFormat.JPEG, i4, byteArrayOutputStream);
                    }
                    if (createScaledBitmap != bitmapArr[0]) {
                        createScaledBitmap.recycle();
                    }
                    bitmapArr[0].recycle();
                    return byteArrayOutputStream.toByteArray();
                }

                public void onPostExecute(byte[] bArr) {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putByteArray(ImageClipActivity.EXTRA_IMAGE, bArr);
                    intent.putExtras(bundle);
                    ImageClipActivity.this.setResult(-1, intent);
                    ImageClipActivity.this.finish();
                }
            }.execute(new Bitmap[]{b2});
        }
    }

    private void b() {
        setContentView(f.layout_sapi_sdk_image_clip);
        this.f2623j = getIntent().getIntExtra(EXTRA_PARAM_FROM_BUSINESS, 0);
        int intExtra = getIntent().getIntExtra(EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE, 512);
        this.k = intExtra;
        if (intExtra <= 0) {
            this.k = 512;
        }
        this.k *= 1024;
        this.m = (ClipBoxView) findViewById(e.sapi_clip_box);
        this.n = (ZoomImageView) findViewById(e.sapi_background_picture);
        if (this.f2623j == 1) {
            ClipBoxView clipBoxView = this.m;
            clipBoxView.aa = ClipBoxView.f3133a;
            clipBoxView.ba = false;
        }
        setPendingTransition(a.sapi_sdk_slide_right_in, a.sapi_sdk_slide_left_out, a.sapi_sdk_slide_left_in, a.sapi_sdk_slide_right_out);
        Button button = (Button) findViewById(e.sure_clip_btn);
        Button button2 = (Button) findViewById(e.cancel_clip_btn);
        b(getIntent());
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ImageClipActivity.this.setResult(0);
                ImageClipActivity.this.finish();
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ImageClipActivity.this.a();
            }
        });
    }

    private void c() {
        if (this.f2619f != 0 || this.f2620g != 0) {
            overridePendingTransition(this.f2619f, this.f2620g);
            this.f2619f = 0;
            this.f2620g = 0;
        }
    }

    private void a(Intent intent) {
        b(a(intent.getData(), (String) null));
    }

    private String a(Uri uri, String str) {
        String str2;
        Cursor query = getContentResolver().query(uri, null, str, null, null);
        String str3 = null;
        if (query != null) {
            if (query.moveToFirst()) {
                String str4 = "_data";
                if (query.getColumnIndex(str4) > -1) {
                    str2 = query.getString(query.getColumnIndex(str4));
                } else {
                    str2 = a(getBaseContext(), uri);
                    this.l = str2;
                }
                str3 = str2;
            }
            query.close();
        }
        return str3;
    }

    @TargetApi(12)
    private Bitmap a(String str) {
        if (str == null) {
            return null;
        }
        Options options = new Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i4 > i3) {
            i3 = i4;
        }
        while (i3 / i2 > 1000) {
            i2++;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i2;
        options.inPreferredConfig = Config.RGB_565;
        return BitmapFactory.decodeFile(str, options);
    }

    @TargetApi(19)
    private void b(Intent intent) {
        Uri data = intent.getData();
        String str = null;
        if (DocumentsContract.isDocumentUri(this, data)) {
            String documentId = DocumentsContract.getDocumentId(data);
            boolean equals = f2615b.equals(data.getAuthority());
            String str2 = com.baidu.mobstat.Config.TRACE_TODAY_VISIT_SPLIT;
            if (equals) {
                str = a(Media.EXTERNAL_CONTENT_URI, e.a.a.a.a.a("_id=", documentId.split(str2)[1]));
            } else {
                if (f2616c.equals(data.getAuthority())) {
                    str = a(ContentUris.withAppendedId(Uri.parse(f2618e), Long.valueOf(documentId).longValue()), (String) null);
                } else {
                    if (f2617d.equals(data.getAuthority())) {
                        String[] split = documentId.split(str2);
                        if ("primary".equalsIgnoreCase(split[0])) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(Environment.getExternalStorageDirectory());
                            sb.append(BceConfig.BOS_DELIMITER);
                            sb.append(split[1]);
                            str = sb.toString();
                        }
                    }
                }
            }
        } else {
            if (com.baidu.mobstat.Config.LAUNCH_CONTENT.equalsIgnoreCase(data.getScheme())) {
                str = a(data, (String) null);
            } else {
                if (SdkConfigOptions.KEY_SO_FILE.equalsIgnoreCase(data.getScheme())) {
                    str = data.getPath();
                }
            }
        }
        b(str);
    }

    private String a(Context context, Uri uri) {
        String a2 = a(uri);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getPath());
        sb.append(File.separator);
        sb.append("pass_temp_");
        sb.append(a2);
        File file = new File(sb.toString());
        a(context, uri, file);
        return file.getAbsolutePath();
    }

    private String a(Uri uri) {
        String str = null;
        if (uri == null) {
            return null;
        }
        String path = uri.getPath();
        int lastIndexOf = path.lastIndexOf(47);
        if (lastIndexOf != -1) {
            str = path.substring(lastIndexOf + 1);
        }
        return str;
    }

    private void a(Context context, Uri uri, File file) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                com.baidu.sapi2.utils.a.a(openInputStream, fileOutputStream);
                openInputStream.close();
                fileOutputStream.close();
            }
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    private void b(String str) {
        Bitmap operateBitmap = operateBitmap(str);
        if (operateBitmap != null) {
            this.n.setImageBitmap(operateBitmap);
            if (!TextUtils.isEmpty(this.l)) {
                com.baidu.sapi2.utils.a.a(new File(this.l));
                return;
            }
            return;
        }
        Toast.makeText(this, "加载图片失败", 0).show();
    }
}
