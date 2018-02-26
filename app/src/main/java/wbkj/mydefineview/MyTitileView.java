package wbkj.mydefineview;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/2/26.
 */

public class MyTitileView extends RelativeLayout {

    //标题
    private final TextView tv_title;
    //返回按钮
    private final ImageView iv_back;
    //状态栏背景颜色
    private final RelativeLayout rl_bg;

    private Activity activity;
    //状态栏的占位控件
    private final View v;
    private final TextView tv_right_title;
    private final ImageView iv_right_menu;

    public MyTitileView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.activity= (Activity) context;

        //加载布局
        LayoutInflater.from(context).inflate(R.layout.title_layout,this);

        //标题栏背景
        rl_bg = findViewById(R.id.rl_bg);
        //状态栏占位控件
        v = findViewById(R.id.v_toolbar_height);
        //左侧返回按钮
        iv_back = findViewById(R.id.iv_back);
        //中间标题
        tv_title = findViewById(R.id.tv_title);
        //右侧文字标题
        tv_right_title = findViewById(R.id.tv_right_title);
        //右侧图形标题
        iv_right_menu = findViewById(R.id.iv_right_menu);


    }

    //设置返回按钮的点击事件
    public void setOnLeftClickListener(OnClickListener onLeftClickListener){
        iv_back.setOnClickListener(onLeftClickListener);
    }
    //设置标题文字
     public void setMiddleTvTitleText(String text){
        tv_title.setText(text);
     }
     //设置中间标题的字体颜色
    public void setMiddleTvTitleColor(int color){
        tv_title.setTextColor(getResources().getColor(color));
    }
    //设置背景色
    public void setBGColor(int color){
         rl_bg.setBackgroundResource(color);
    }

    //设置是否全屏和状态栏颜色
    public void setIsFullScreen(boolean isFullScreen,int color) {
        if (isFullScreen) {
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = activity.getWindow().getDecorView();
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                activity.getWindow().setStatusBarColor(color);

                //获取状态栏高度
                int statusBarHeight = getStatusBarHeight(activity);
                //显示占位控件
                v.setVisibility(VISIBLE);
                //给占位控件设置和状态栏一样的高度
                ViewGroup.LayoutParams lp=v.getLayoutParams();
                lp.height=statusBarHeight;
                v.setLayoutParams(lp);
                //给占位控件设置背景色
                v.setBackgroundResource(color);

                //将状态栏设置为透明的避免出现状态栏本身颜色和占位状态栏控件的颜色产生叠加
                Window window = activity.getWindow();
                //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            }else{
                v.setVisibility(GONE);
            }
        }
    }
    //设置返回按钮的显示和隐藏
    public void setIvBackVisiable(boolean ivBackVisiable){
        if(ivBackVisiable){
            iv_back.setVisibility(VISIBLE);
        }else{
            iv_back.setVisibility(GONE);
        }
    }

    //设置左侧图标菜单的图标
    public void setLeftMenuImgResource(int imgResource){
        iv_back.setImageResource(imgResource);
    }

    //设置中间标题的显示和隐藏
    public void setMiddleTitleVisiable(boolean middleTitleVisiable){
        if(middleTitleVisiable){
            tv_title.setVisibility(VISIBLE);
        }else{
            tv_title.setVisibility(GONE);
        }
    }

    //设置右侧文字标题的显示和隐藏
    public void setRightTitleVisiable(boolean rightTitleVisiable){
        if(rightTitleVisiable){
            tv_right_title.setVisibility(VISIBLE);
        }else{
            tv_right_title.setVisibility(GONE);
        }
    }
    //设置中间标题的字体颜色
    public void setRightTvTitleColor(int color){
        tv_right_title.setTextColor(getResources().getColor(color));

    }

    //设置右侧图标菜单的显示和隐藏
    public void setRightMenuVisiable(boolean rightMenuVisiable){
        if(rightMenuVisiable){
            iv_right_menu.setVisibility(VISIBLE);
        }else{
            iv_right_menu.setVisibility(GONE);
        }
    }

    //设置右侧图标菜单的图标
    public  void setRightMenuImgResource(int imgResource){
        iv_right_menu.setImageResource(imgResource);
    }

    //设置右侧文字图标的文字
    public  void setRightTitileText(String rightTitileText){
        tv_right_title.setText(rightTitileText);
    }
    //设置右侧文字标题的点击事件
    public void setOnRightTitleOnClickListener(OnClickListener clickListener){
        tv_right_title.setOnClickListener(clickListener);
    }

    //设置右侧图标菜单的点击事件
    public void setOnRightMenuOnClickListener(OnClickListener clickListener){
        iv_right_menu.setOnClickListener(clickListener);
    }


    /**
     * 计算手机状态栏高度
     * @param context
     * @return
     */
    private int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
