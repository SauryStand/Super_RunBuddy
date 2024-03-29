package com.fragmentation.anim;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.AnimRes;

import com.fragmentation.R;

/**
 * Fragment动画实体类
 * Created by YoKeyword on 16/2/4.
 */
public class FragmentAnimator implements Parcelable {
    @AnimRes
    protected int enter;
    @AnimRes
    protected int exit;
    @AnimRes
    protected int popEnter;
    @AnimRes
    protected int popExit;

    public FragmentAnimator() {
    }

    public FragmentAnimator(int enter, int exit) {
        this.enter = enter;
        this.exit = exit;
    }

    public FragmentAnimator(int enter, int exit, int popEnter, int popExit) {
        this.enter = enter;
        this.exit = exit;
        this.popEnter = popEnter;
        this.popExit = popExit;
    }

    protected FragmentAnimator(Parcel in) {
        enter = in.readInt();
        exit = in.readInt();
        popEnter = in.readInt();
        popExit = in.readInt();
    }

    public static final Creator<FragmentAnimator> CREATOR = new Creator<FragmentAnimator>() {
        @Override
        public FragmentAnimator createFromParcel(Parcel in) {
            return new FragmentAnimator(in);
        }

        @Override
        public FragmentAnimator[] newArray(int size) {
            return new FragmentAnimator[size];
        }
    };

    public int getEnter() {
        return enter;
    }

    public void setEnter(int enter) {
        this.enter = enter;
    }

    public int getExit() {
        return exit;
    }

    public void setExit(int exit) {
        this.exit = exit;
    }

    public int getPopEnter() {
        return popEnter;
    }

    public void setPopEnter(int popEnter) {
        this.popEnter = popEnter;
    }

    public int getPopExit() {
        return popExit;
    }

    public void setPopExit(int popExit) {
        this.popExit = popExit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(enter);
        dest.writeInt(exit);
        dest.writeInt(popEnter);
        dest.writeInt(popExit);
    }

    public void processNoAnim() {
        if (enter == 0) {
            enter = R.anim.no_anim;
        }
        if (exit == 0) {
            exit = R.anim.no_anim;
        }
        if (popEnter == 0) {
            popEnter = R.anim.no_anim;
        }
        if (popExit == 0) {
            // 用于解决 start新Fragment时,转场动画过程中上一个Fragment页面空白问题
            popExit = R.anim.pop_exit_no_anim;
        }
    }
}
