package com.yomii.librarydemos.imagepicker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.InvokeParam;
import com.jph.takephoto.model.TContextWrap;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.permission.InvokeListener;
import com.jph.takephoto.permission.PermissionManager;
import com.jph.takephoto.permission.PermissionManager.TPermissionType;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;
import com.yomii.librarydemos.R;
import com.yomii.librarydemos.base.BaseActivity;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yomii on 2017/3/17.
 */

public class ImageFuncActivity extends BaseActivity implements TakePhoto.TakeResultListener, InvokeListener {


    @BindView(R.id.image_iv)
    ImageView imageIv;
    private PickPhotoDialog dialog;

    @Override
    protected void onInitView() {
        setContentView(R.layout.image_func_activity);
        ButterKnife.bind(this);
        initDialog();
    }

    private void initDialog() {
        final CropOptions cropOptions = new CropOptions.Builder()
                .setAspectX(1).setAspectY(1).setWithOwnCrop(true).create();
        dialog = new PickPhotoDialog(getWindow().getDecorView().getContext());
        dialog.setOnAlbumClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.cancel();
                File temp = new File(getExternalCacheDir(), "temp.jpg");
                getTakePhoto().onPickFromGalleryWithCrop(Uri.fromFile(temp), cropOptions);
            }
        });
        dialog.setOnCameraClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.cancel();
                File temp = new File(getExternalCacheDir(), "temp.jpg");
                getTakePhoto().onPickFromCaptureWithCrop(Uri.fromFile(temp), cropOptions);
            }
        });
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
        getTakePhoto().onEnableCompress(CompressConfig.ofDefaultConfig(), true);
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
        TImage image = result.getImage();
        Log.i(TAG, "takeSuccess_OriginalPath：" + image.getOriginalPath());
        Log.i(TAG, "takeSuccess_CompressPath：" + image.getCompressPath());
        Log.i(TAG, "takeSuccess_isCompress：" + image.isCompressed());
        String path = image.isCompressed() ? image.getCompressPath() : image.getOriginalPath();
        Glide.with(this).load(new File(path))
                .diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true)
                .into(imageIv);
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
