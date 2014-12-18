package com.fortysevendeg.swipelistview;

import com.fortysevendeg.swipelistview.SwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;

public class BaseSwipeListViewListener implements SwipeListViewListener {
    @Override
    public void onOpened(int position, boolean toRight) {
        System.err.println("Inside onOpened() of BaseSwipeListViewListener.java");
    }

    @Override
    public void onClosed(int position, boolean fromRight) {
        System.err.println("Inside onClosed() of BaseSwipeListViewListener.java");
    }

    @Override
    public void onListChanged() {
        System.err.println("Inside onListChanged() of BaseSwipeListViewListener.java");
    }

    @Override
    public void onMove(int position, float x) {
        System.err.println("Inside onMove() of BaseSwipeListViewListener.java");
    }

    @Override
    public void onStartOpen(int position, int action, boolean right) {
        System.err.println("Inside onStartOpen() of BaseSwipeListViewListener.java");
    }

    @Override
    public void onStartClose(int position, boolean right) {
        System.err.println("Inside onStartClose() of BaseSwipeListViewListener.java");
    }

    @Override
    public void onClickFrontView(int position) {
        System.err.println("Inside onClickFrontView() of BaseSwipeListViewListener.java");
    }

    @Override
    public void onClickBackView(int position) {
        System.err.println("Inside onClickBackView() of BaseSwipeListViewListener.java");
    }

    @Override
    public void onDismiss(int[] reverseSortedPositions) {
        System.err.println("Inside onDimiss() of BaseSwipeListViewListener.java");
    }

    @Override
    public int onChangeSwipeMode(int position) {
        System.err.println("Inside onChangeSwipeMode() of BaseSwipeListViewListener.java");
        return SwipeListView.SWIPE_MODE_DEFAULT;
    }

    @Override
    public void onChoiceChanged(int position, boolean selected) {
        System.err.println("Inside onChoiceChanged() of BaseSwipeListViewListener.java");
    }

    @Override
    public void onChoiceStarted()  {
        System.err.println("Inside onChoiceStarted() of BaseSwipeListViewListener.java");
    }

    @Override
    public void onChoiceEnded() {
        System.err.println("Inside onChoiceEnded() of BaseSwipeListViewListener.java");
    }

    @Override
    public void onFirstListItem() {
        System.err.println("Inside onFirstListItem() of BaseSwipeListViewListener.java");
    }

    @Override
    public void onLastListItem() {
        System.err.println("Inside onLastListItem() of BaseSwipeListViewListener.java");
    }
}
