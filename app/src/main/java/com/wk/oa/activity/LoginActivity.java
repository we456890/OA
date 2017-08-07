package com.wk.oa.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wk.oa.OAApplication;
import com.wk.oa.R;
import com.wk.oa.base.BaseActivity;
import com.wk.oa.bean.UserDTO;
import com.wk.oa.utils.HttpUtils;
import com.wk.oa.utils.PublicUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 78560 on 2017/8/7.
 */

public class LoginActivity extends BaseActivity{
    String accid;//用户名
    String pwd;//密码
    String url;//地址

    @Bind(R.id.login_accid)
    EditText login_accid;
    @Bind(R.id.login_password)
    EditText login_password;
    @Bind(R.id.login_url)
    EditText login_url;
    @Bind(R.id.btn_sign)
    Button btn_sign;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = OAApplication.getContext();
        if(uInfo!=null){
            Intent intent = new Intent(context, MainActivity.class);
            startActivity(intent);
            finish();
            OAApplication.removeActivity(this);
        }
        init();
    }

    private void init() {
        ButterKnife.bind(this);
    }


    /**
     * 登录点击事件
     * @param v
     */
    @OnClick(R.id.btn_sign)
    void btn_sign(View v) {
        getText();
        if (isEmpty()) {
            String urlGo = url + PublicUtils.URL_FILE_TAG + PublicUtils.URL_TAG;
            Map<String, String> m = new HashMap<String, String>();
            m.put("username", accid);
            m.put("password", pwd);
            HttpUtils.doPost(urlGo, m, new okhttp3.Callback() {
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    if (PublicUtils.isNetworkAvailable(context) == false) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "网络异常无法下载", Toast.LENGTH_LONG).show();
                            }
                        });
                        return;
                    }
                }

                @Override
                public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                    String str = response.body().string();
                    //打印json
//                    Log.i("wk-login", str);
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();
//                        }
//                    });
                    getgson(str);
                }
            });
//            postAsynHttp(accid,pwd,urlGo);
        } else {
            return;
        }
    }

    /**
     * 解析json
     */
    private void getgson(String json) {
//        json=json.substring(1,json.length()-1);
//        Log.i("wk-login", json);
        Gson gson = new Gson();
        /**
         * 缓存得到数据存储
         */
        UserDTO u = gson.fromJson(json, UserDTO.class);
        mAcache.put("user", u);
//        Log.i("wk-login", u.toString() + "");
        if (u.getStatus().equals("0")) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, R.string.login_failure, Toast.LENGTH_LONG).show();
                }
            });

        } else if (u.getStatus().equals("1")) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, R.string.login_succeed, Toast.LENGTH_LONG).show();
                }
            });
            actionStartMain(LoginActivity.this);
            finish();
            OAApplication.removeActivity(this);
        }
    }

    //获取输入文字
    void getText() {
        accid = login_accid.getText().toString().trim();
        pwd = login_password.getText().toString().trim();
        url = login_url.getText().toString().trim();
    }

    //输入是否为空
    boolean isEmpty() {
        boolean isem = true;
        if (TextUtils.isEmpty(accid)) {
            Toast.makeText(OAApplication.getContext(), R.string.login_accidem, Toast.LENGTH_SHORT).show();
            login_accid.requestFocus();
            isem = false;
        } else if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(OAApplication.getContext(), R.string.login_pwdem, Toast.LENGTH_SHORT).show();
            login_password.requestFocus();
            isem = false;
        }
        return isem;
    }

    public static void actionStartMain(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }
}
