# LibraryDemos

## 简介

- 内容： 各种开源库、新技术、新想法的验证。
- 结构： 除了base和glide包外，其他分包根据验证内容划分。
- 版本： 在主项目的build.gradle文件中管理，如下
  
  ```
  ext {
        setup = [compileSdk: 25,
                 buildTools: "25.0.2",
                 minSdk    : 16,
                 targetSdk : 25,
                 ]
        versions = [libSupport    : "25.2.0",
                    libButterKnife: "8.5.1",
                    libRxJava     : "2.0.1",
                    libRxBinding  : "2.0.0",
                    libRetrofit   : "2.2.0",
                    libOkhttp     : "3.6.0"]
    }
  ```

## 内容/分包

- ### 图片选择和裁剪 / imagepicker

  TakePhoto: https://github.com/crazycodeboy/TakePhoto
  
  ```
  compile ('com.jph.takephoto:takephoto_library:4.0.3', {
        exclude module: 'rxjava', group: 'io.reactivex'
        exclude module: 'rxandroid', group: 'io.reactivex'
    })
  ```
- ### 图片展示和下载 / glide

  glide: https://github.com/bumptech/glide
  
  ```
  compile 'com.github.bumptech.glide:glide:3.7.0'
  ```
- ### rxAndroid 和 retrofit 结合 / rxretrofit
  
  rx分支较多，不贴了
  retrofit: https://github.com/square/retrofit
  
  ```
  //网络
  compile "com.squareup.retrofit2:retrofit:$rootProject.versions.libRetrofit"
  compile "com.squareup.retrofit2:converter-gson:$rootProject.versions.libRetrofit"
  compile "com.squareup.retrofit2:adapter-rxjava2:$rootProject.versions.libRetrofit"
  compile "com.squareup.okhttp3:okhttp:$rootProject.versions.libOkhttp"
  compile "com.squareup.okhttp3:logging-interceptor:$rootProject.versions.libOkhttp"
  //rx
  compile "io.reactivex.rxjava2:rxjava:$rootProject.versions.libRxJava"
  compile "io.reactivex.rxjava2:rxandroid:$rootProject.versions.libRxJava"
  compile "com.jakewharton.rxbinding2:rxbinding:$rootProject.versions.libRxBinding"
  ```

- ### data-binding / databinding

  Data Binding Library: https://developer.android.com/topic/libraries/data-binding/index.html
  
  ```
  andrdoid{
     dataBinding{
        enabled true
     } 
  }
  ```

- ### 用于转场和View动效的Transition框架 / transition

  The Transitions Framework: https://developer.android.com/training/transitions/overview.html
                             http://blog.csdn.net/sunsteam/article/details/71565999
  
