## [MyTitle](https://github.com/flyingsnowtiger/MyToolBarTitle) 简介


`MyTitle`是一款用于在Android设备5.0及以上系统版本沉浸式的标题栏和状态栏的背景颜色的设置,以及标题栏的左 中 右的文字,图标的设置和显示隐藏.

**V1.0**

- 支持左侧图片修改,显示,隐藏,点击事件设置
- 支持中间文字的设置,文字颜色设置,文字的显示和隐藏
- 支持支持右侧文字的设置,文字的颜色,文字的显示和隐藏
- 支持右侧图标菜单的修改,显示和隐藏,点击事件的设置
- 支持标题栏背景色设置
- 支持状态栏背景色的设置(注意: 纯白色或者纯黑色的状态栏颜色有可能与状态栏中的字体一致而显示不出来)

GitHub地址： [https://github.com/flyingsnowtiger/MyToolBarTitle]

```groovy
compile 'com.github.flyingsnowtiger:MyToolBarTitle:weichao1.0toolbar'
```

**Maven:**  



## 演示 

运行效果图：    
![预览图无右侧标题](https://github.com/flyingsnowtiger/MyToolBarTitle/blob/master/img/no_right.png)
![预览图右侧文字标题](https://github.com/flyingsnowtiger/MyToolBarTitle/blob/master/img/tv_right.png)
![预览图右侧图片标题](https://github.com/flyingsnowtiger/MyToolBarTitle/blob/master/img/iv_right.png)


## 使用说明   
1 将依赖拷入你的APP build文件中
2 project build中集成 maven { url 'https://jitpack.io' }
[![](https://jitpack.io/v/flyingsnowtiger/MyToolBarTitle.svg)](https://jitpack.io/#flyingsnowtiger/MyToolBarTitle)
3 在你要增加的标题栏的位置写入我的自定义控件的名字如:<br>
     <wbkj.mydefineview.MyTitileView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/my_tv_title"
            ></wbkj.mydefineview.MyTitileView>

4 在使用的activity中找到该控件并对其进行相应的设置如:<br>
 my_tv_title = (MyTitileView) findViewById(R.id.my_tv_title);

        //设置左侧返回图标 不设置默认为白色箭头
        my_tv_title.setLeftMenuImgResource(R.mipmap.back_white);
        //返回按钮点击事件
        my_tv_title.setOnLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击返回",Toast.LENGTH_LONG).show();
            }
        });

        //中部标题设置文字内容
        my_tv_title.setMiddleTvTitleText("自定义标题");
        //给中部标题设置文字颜色
        my_tv_title.setMiddleTvTitleColor(R.color.white);

        //设置标题栏的背景色
        my_tv_title.setBGColor(R.color.black);
        //设置状态栏颜色
        my_tv_title.setIsFullScreen(true,R.color.black);


      /* //显示右侧文字标题
        my_tv_title.setRightTitleVisiable(true);
        //设置右标题文字
        my_tv_title.setRightTitileText("右标题");
        //设置右文字标题的点击事件
        my_tv_title.setOnRightTitleOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击右侧标题",Toast.LENGTH_LONG).show();

            }
        });*/

       //设置右侧图标菜单显示
        my_tv_title.setRightMenuVisiable(true);
        //设置右侧图标
        my_tv_title.setRightMenuImgResource(R.mipmap.fbu_white);
        //设置右侧图标的点击事件
        my_tv_title.setOnRightMenuOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击图标",Toast.LENGTH_LONG).show();

            }
        });

