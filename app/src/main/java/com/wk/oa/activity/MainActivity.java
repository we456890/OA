package com.wk.oa.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wk.oa.OAApplication;
import com.wk.oa.R;
import com.wk.oa.base.BaseActivity;
import com.wk.oa.fragment.FragmentFactory;
import com.wk.oa.view.TabButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    private String mCurrentFragment = FragmentFactory.FLAG_FRAGMENT_HOME;

    Context context;
    @Bind(R.id.tl_custom)
    Toolbar mToolbar;

    @Bind(R.id.dl_left)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.lv_left_menu)
    ListView lv_left_menu;


    @Bind(R.id.main_tab_home)
    TabButton mHomeTab;

    @Bind(R.id.main_tab_talk)
    TabButton mTalkTab;

    @Bind(R.id.main_tab_mine)
    TabButton mMineTab;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        ButterKnife.bind(this);
        setSelectedTab(true, false, false);
        switchContent(mCurrentFragment, FragmentFactory.FLAG_FRAGMENT_HOME);
        context = OAApplication.getContext();
        initBar();
        mLvMenue();
    }

    public void setCurrentFragment(String mCurrentFragment) {
        this.mCurrentFragment = mCurrentFragment;
    }

    @OnClick(R.id.main_tab_home)
    public void onHomeTabClick() {
        setSelectedTab(true, false, false);
        switchContent(mCurrentFragment, FragmentFactory.FLAG_FRAGMENT_HOME);
        mCurrentFragment = FragmentFactory.FLAG_FRAGMENT_HOME;
    }

    @OnClick(R.id.main_tab_talk)
    public void onTalkTabClick() {
        setSelectedTab(false, true, false);
        switchContent(mCurrentFragment, FragmentFactory.FLAG_FRAGMENT_TALK);
        mCurrentFragment = FragmentFactory.FLAG_FRAGMENT_TALK;
    }

    @OnClick(R.id.main_tab_mine)
    public void onMineTabClick() {
        setSelectedTab(false, false, true);
        switchContent(mCurrentFragment, FragmentFactory.FLAG_FRAGMENT_MINE);
        mCurrentFragment = FragmentFactory.FLAG_FRAGMENT_MINE;
    }

    public void setSelectedTab(boolean isHomeSelected, boolean isTalkSelected, boolean isMineSelected) {
        mHomeTab.setSelected(isHomeSelected);
        mTalkTab.setSelected(isTalkSelected);
        mMineTab.setSelected(isMineSelected);
    }


    public void switchContent(String from, String to) {
        switchFragment(from, to);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            new AlertDialog.Builder(MainActivity.this, AlertDialog.BUTTON_POSITIVE)
                    .setMessage("是否退出程序?")
                    .setTitle("退出程序")
                    .setPositiveButton("确定",
                            new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    dialog.dismiss();
                                    OAApplication.finishAll();
                                }
                            })
                    .setNegativeButton("取消",
                            new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    dialog.dismiss();

                                }
                            }).show();
            return true;
        } else
            return super.onKeyDown(keyCode, event);
    }

    private void initBar() {
        setSupportActionBar(mToolbar);  //将ToolBar设置成ActionBar
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("YkOa");
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void mLvMenue() {
        lv_left_menu.setAdapter(new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, lvMenuList));
        lv_left_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("wk-menue", "position:" + position);
                Log.d("wk-menue", "uInfo:" + uInfo);
                if (position == 3 && uInfo != null) {
                    mAcache.clear();
                    tost(R.string.login_close);
                    actionStartLogin(MainActivity.this);
                    finish();
                } else {
                    tost("请重新登录！");
                    actionStartLogin(MainActivity.this);
                }
                mDrawerLayout.closeDrawers();/*收起抽屉*/
            }
        });
    }

    public static void actionStartLogin(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);

    }

    private List<String> lvMenuList = new ArrayList<String>() {{
        add("angry");
        add("happy");
        add("sad");
        add("End");
    }};
}
