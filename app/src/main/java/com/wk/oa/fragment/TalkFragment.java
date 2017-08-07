package com.wk.oa.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wk.oa.R;
import com.wk.oa.base.BaseFragment;


/**
 * Created by 78560 on 2017/8/4.
 */

public class TalkFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_talk, container, false);
        return view;
    }
}
