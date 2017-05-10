package com.yomii.librarydemos.imagepicker;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.yomii.librarydemos.R;

/**
 * 获取图片对话框
 * Created by Yomii on 2017/3/20.
 */

public class PickPhotoDialog extends AppCompatDialog {

    private View btnAlbum;
    private View btnCamera;

    public PickPhotoDialog(Context context) {
        this(context, R.style.PickImageDialog);
    }

    public PickPhotoDialog(Context context, int theme) {
        super(context, theme);
        init();
    }

    private void init() {
        setCanceledOnTouchOutside(true);
        setContentView(R.layout.image_func_dialog);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(Gravity.BOTTOM);
            window.setWindowAnimations(R.style.dialog_bottom);
            WindowManager.LayoutParams windowparams = window.getAttributes();
            windowparams.width = WindowManager.LayoutParams.MATCH_PARENT;
            window.setAttributes(windowparams);
        }
        btnAlbum = findViewById(R.id.btn_source_album);
        btnCamera = findViewById(R.id.btn_source_camera);
        View btnCancel = findViewById(R.id.btn_cancel);
        if (btnCancel != null)
            btnCancel.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    cancel();
                }
            });
    }

    public void setOnAlbumClickListener(View.OnClickListener albumListener){
        if (btnAlbum != null)
            btnAlbum.setOnClickListener(albumListener);
    }

    public void setOnCameraClickListener(View.OnClickListener cameraListener){
        if (btnCamera != null)
            btnCamera.setOnClickListener(cameraListener);
    }
}
