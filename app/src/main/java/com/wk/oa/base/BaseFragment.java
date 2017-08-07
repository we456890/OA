package com.wk.oa.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.wk.oa.R;
import com.wk.oa.utils.dialog.DialogUtils;


/**
 * Created by 78560 on 2017/8/4.
 */

public class BaseFragment extends Fragment{
    /**
     * <BaseFragment>
     **/
    public BaseFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    /**
     * 退出该fragment所在activity
     */
    public void finish() {
        if (isAdded()) getActivity().finish();
        //getActivity().overridePendingTransition(R.anim.side_left_in, R.anim.side_right_out);
    }
    /**
     * 请求失败，关闭当前页面
     */
    public void onRequestFail() {
        if (isAdded()) getActivity().onBackPressed();
    }

    /**
     * 关闭当前页面
     */
    public void finishSelf() {
        if (isAdded()) getActivity().finish();
    }

    public void showToast(int resId) {
        DialogUtils.toast(resId).show();
    }
    public void showToast(String resId) {
        DialogUtils.toast(resId).show();
    }

    public void showNetworkErrorTip() {
        showToast(R.string.no_network_error);
    }

    public Context getComponentContext(){
        return getContext();
    }
}
