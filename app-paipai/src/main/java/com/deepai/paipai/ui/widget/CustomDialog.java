package com.deepai.paipai.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.deepai.paipai.R;
import java.lang.reflect.Field;

public class CustomDialog extends Dialog {

    public static class Builder {
        private View contentView;
        private Context context;
        private boolean mCancelable = true;
        private String message;
        /* access modifiers changed from: private */
        public OnClickListener negativeButtonClickListener;
        private String negativeButtonText;
        /* access modifiers changed from: private */
        public OnClickListener neutralbuttonButtonClickListener;
        private String neutralbuttonText;
        /* access modifiers changed from: private */
        public OnClickListener positiveButtonClickListener;
        private String positiveButtonText;
        private String title;

        public Builder(Context context2) {
            this.context = context2;
        }

        public Builder setMessage(String message2) {
            this.message = message2;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.mCancelable = cancelable;
            return this;
        }

        public Builder setMessage(int message2) {
            this.message = (String) this.context.getText(message2);
            return this;
        }

        public Builder setTitle(int title2) {
            this.title = (String) this.context.getText(title2);
            return this;
        }

        public Builder setTitle(String title2) {
            this.title = title2;
            return this;
        }

        public Builder setContentView(View v) {
            this.contentView = v;
            return this;
        }

        public Builder setPositiveButton(int positiveButtonText2, OnClickListener listener) {
            this.positiveButtonText = (String) this.context.getText(positiveButtonText2);
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setPositiveButton(String positiveButtonText2, OnClickListener listener) {
            this.positiveButtonText = positiveButtonText2;
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setNeutralButton(int neutralbuttonText2, OnClickListener listener) {
            this.neutralbuttonText = (String) this.context.getText(neutralbuttonText2);
            this.neutralbuttonButtonClickListener = listener;
            return this;
        }

        public Builder setNeutralButton(String neutralbuttonText2, OnClickListener listener) {
            this.neutralbuttonText = neutralbuttonText2;
            this.neutralbuttonButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(int negativeButtonText2, OnClickListener listener) {
            this.negativeButtonText = (String) this.context.getText(negativeButtonText2);
            this.negativeButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(String negativeButtonText2, OnClickListener listener) {
            this.negativeButtonText = negativeButtonText2;
            this.negativeButtonClickListener = listener;
            return this;
        }

        public void setDialogCanCancel(DialogInterface dialog, boolean isShow) {
            try {
                Field field = dialog.getClass().getSuperclass().getDeclaredField("mShowing");
                field.setAccessible(true);
                field.set(dialog, Boolean.valueOf(isShow));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public CustomDialog create() {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            final CustomDialog dialog = new CustomDialog(this.context, R.style.custom_dialog_style);
            View layout = inflater.inflate(R.layout.custom_dialog_layout, null);
            dialog.addContentView(layout, new LayoutParams(-1, -2));
            ((TextView) layout.findViewById(R.id.dialog_title)).setText(this.title);
            LinearLayout dialog_ll = (LinearLayout) layout.findViewById(R.id.dialog_ll);
            if (this.positiveButtonText != null) {
                ((Button) layout.findViewById(R.id.dialog_positiveButton)).setText(this.positiveButtonText);
                if (this.positiveButtonClickListener != null) {
                    ((Button) layout.findViewById(R.id.dialog_positiveButton)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Builder.this.positiveButtonClickListener.onClick(dialog, -1);
                        }
                    });
                }
                dialog_ll.setVisibility(0);
            } else {
                layout.findViewById(R.id.dialog_positiveButton).setVisibility(8);
            }
            if (this.neutralbuttonText != null) {
                ((Button) layout.findViewById(R.id.dialog_NeutralButton)).setText(this.neutralbuttonText);
                if (this.neutralbuttonButtonClickListener != null) {
                    ((Button) layout.findViewById(R.id.dialog_NeutralButton)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Builder.this.neutralbuttonButtonClickListener.onClick(dialog, -3);
                        }
                    });
                }
                dialog_ll.setVisibility(0);
            } else {
                layout.findViewById(R.id.dialog_NeutralButton).setVisibility(8);
            }
            if (this.negativeButtonText != null) {
                ((Button) layout.findViewById(R.id.dialog_negativeButton)).setText(this.negativeButtonText);
                if (this.negativeButtonClickListener != null) {
                    ((Button) layout.findViewById(R.id.dialog_negativeButton)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Builder.this.negativeButtonClickListener.onClick(dialog, -2);
                        }
                    });
                }
                dialog_ll.setVisibility(0);
            } else {
                layout.findViewById(R.id.dialog_negativeButton).setVisibility(8);
            }
            if (this.message != null) {
                ((TextView) layout.findViewById(R.id.dialog_message)).setText(this.message);
            } else if (this.contentView != null) {
                ((LinearLayout) layout.findViewById(R.id.dialog_content)).removeAllViews();
                ((LinearLayout) layout.findViewById(R.id.dialog_content)).addView(this.contentView, new LayoutParams(-1, -2));
            }
            dialog.setCancelable(this.mCancelable);
            if (this.mCancelable) {
                dialog.setCanceledOnTouchOutside(true);
            }
            dialog.setContentView(layout);
            dialog.setCanceledOnTouchOutside(false);
            return dialog;
        }

        public CustomDialog show() {
            CustomDialog dialog = create();
            dialog.show();
            return dialog;
        }
    }

    public CustomDialog(Context context, int theme) {
        super(context, theme);
    }

    public CustomDialog(Context context) {
        super(context);
    }
}
