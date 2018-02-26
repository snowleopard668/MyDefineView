package wbkj.mydefineview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyTitileView my_tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
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
        my_tv_title.setMiddleTvTitleColor(R.color.white_color);

        //设置标题栏的背景色
        my_tv_title.setBGColor(R.color.colorAccent);
        //设置状态栏颜色
        my_tv_title.setIsFullScreen(true,R.color.colorAccent);


       //显示右侧文字标题
        my_tv_title.setRightTitleVisiable(true);
        //设置右标题文字
        my_tv_title.setRightTitileText("右标题");
        //设置右文字标题的点击事件
        my_tv_title.setOnRightTitleOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击右侧标题",Toast.LENGTH_LONG).show();

            }
        });
        //设置右侧标题文字颜色
        my_tv_title.setRightTvTitleColor(R.color.white_color);

       /* //设置右侧图标菜单显示
        my_tv_title.setRightMenuVisiable(true);
        //设置右侧图标
        my_tv_title.setRightMenuImgResource(R.mipmap.fbu_white);
        //设置右侧图标的点击事件
        my_tv_title.setOnRightMenuOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击图标",Toast.LENGTH_LONG).show();

            }
        });*/
    }
}
