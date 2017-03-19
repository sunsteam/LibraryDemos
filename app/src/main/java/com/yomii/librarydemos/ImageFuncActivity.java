package com.yomii.librarydemos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.model.InvokeParam;
import com.jph.takephoto.model.TContextWrap;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.permission.InvokeListener;
import com.jph.takephoto.permission.PermissionManager;
import com.jph.takephoto.permission.PermissionManager.TPermissionType;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yomii on 2017/3/17.
 */

public class ImageFuncActivity extends BaseActivity implements TakePhoto.TakeResultListener, InvokeListener {


    @BindView(R.id.image_iv)
    ImageView imageIv;
    private AppCompatDialog dialog;

    @Override
    protected void onInitView() {
        setContentView(R.layout.image_func_activity);
        ButterKnife.bind(this);
        initDialog();
    }

    private void initDialog() {
        dialog = new AppCompatDialog(getWindow().getDecorView().getContext(), R.style.PickImageDialog);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.image_func_dialog);
        dialog.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.findViewById(R.id.btn_source_album).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.cancel();
                getTakePhoto().onPickFromGallery();
            }
        });
        Window window = dialog.getWindow();
        if (window != null) {
            window.setGravity(Gravity.BOTTOM);
            window.setWindowAnimations(R.style.dialog_bottom);
            WindowManager.LayoutParams windowparams = window.getAttributes();
            windowparams.width = WindowManager.LayoutParams.MATCH_PARENT;
            window.setAttributes(windowparams);
        }
    }

    @Override
    protected void onInitData() {

    }


    public void openDrawer(View v) {
        dialog.show();
    }


    //----------------------------------TakePhoto related-------------------------------------//

    private TakePhoto takePhoto;
    private InvokeParam invokeParam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTakePhoto().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getTakePhoto().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        TPermissionType type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.handlePermissionsResult(this, type, invokeParam, this);
    }

    /**
     * 获取TakePhoto实例
     *
     * @return
     */
    public TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this, this));
        }
        return takePhoto;
    }

    @Override
    public void takeSuccess(TResult result) {
        Log.i(TAG, "takeSuccess_OriginalPath：" + result.getImage().getOriginalPath());
        Log.i(TAG, "takeSuccess_CompressPath：" + result.getImage().getCompressPath());
        Log.i(TAG, "takeSuccess_isCompress：" + result.getImage().isCompressed());
        Glide.with(this).load(new File(result.getImage().getOriginalPath())).into(imageIv);
    }

    @Override
    public void takeFail(TResult result, String msg) {
        Log.i(TAG, "takeFail:" + msg);
    }

    @Override
    public void takeCancel() {
        Log.i(TAG, getResources().getString(R.string.msg_operation_canceled));
    }

    @Override
    public TPermissionType invoke(InvokeParam invokeParam) {
        TPermissionType type = PermissionManager.checkPermission(TContextWrap.of(this), invokeParam.getMethod());
        if (TPermissionType.WAIT.equals(type)) {
            this.invokeParam = invokeParam;
        }
        return type;
    }
}
