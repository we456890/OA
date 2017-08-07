package com.wk.oa.fragment;


import android.support.v4.app.Fragment;

/**
 * Created by 78560 on 2017/8/4.
 */

public class FragmentFactory {
    public final static String FLAG_FRAGMENT_NONE = "fragment_none";
    public final static String FLAG_FRAGMENT_HOME = "fragment_home";
    public final static String FLAG_FRAGMENT_TALK = "fragment_talk";
    public final static String FLAG_FRAGMENT_MINE = "fragment_mine";
    public static Fragment getFragment(String state) {
        switch (state) {
            case FLAG_FRAGMENT_HOME:
                return new HomeFragment();
            case FLAG_FRAGMENT_TALK:
                return new TalkFragment();
            case FLAG_FRAGMENT_MINE:
                return new MineFragment();
        }
        return null;
    }
}
