package gene.com.swipelistviewexample;

import java.util.ArrayList;
import java.util.List;
 
import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;

import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
 
/*
This App uses SwipeListViewLibrary. 
SwipeListViewLibrary uses NineOldAndroids as a library. 
See "Description of Each App.doc" inside workspace folder 
for more details. 
*/

public class MainActivity extends Activity {
 
      SwipeListView swipelistview;
      ItemAdapter adapter;
      List<ItemRow> itemData;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.err.println("Inside onCreate() of MainActivity.java");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
 
        swipelistview=(SwipeListView)findViewById(R.id.example_swipe_lv_list);
        itemData=new ArrayList<ItemRow>();
        //Original Code
        //adapter=new ItemAdapter(this,R.layout.custom_row,itemData);

        adapter=new ItemAdapter(this,R.layout.custom_row,itemData, swipelistview);

        swipelistview.setSwipeListViewListener(new BaseSwipeListViewListener());
/*        swipelistview.setSwipeListViewListener(new BaseSwipeListViewListener() {
            @Override
            public void onOpened(int position, boolean toRight) {
            }
 
            @Override
            public void onClosed(int position, boolean fromRight) {
            }
 
            @Override
            public void onListChanged() {
            }
 
            @Override
            public void onMove(int position, float x) {
            }
 
            @Override
            public void onStartOpen(int position, int action, boolean right) {
                Log.d("swipe", String.format("onStartOpen %d - action %d", position, action));
            }
 
            @Override
            public void onStartClose(int position, boolean right) {
                Log.d("swipe", String.format("onStartClose %d", position));
            }
 
            @Override
            public void onClickFrontView(int position) {
                Log.d("swipe", String.format("onClickFrontView %d", position));
 
                swipelistview.openAnimate(position); //when you touch front view it will open

            }
 
            @Override
            public void onClickBackView(int position) {
                Log.d("swipe", String.format("onClickBackView %d", position));
 
                swipelistview.closeAnimate(position);//when you touch back view it will close
            }
 
            @Override
            public void onDismiss(int[] reverseSortedPositions) {
 
            }

        });
*/

        //These are the swipe listview settings. you can change these
        //setting as your requirement
        swipelistview.setSwipeMode(SwipeListView.SWIPE_MODE_LEFT); // there are five swiping modes
        swipelistview.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL); //there are four swipe actions
        swipelistview.setSwipeActionRight(SwipeListView.SWIPE_ACTION_REVEAL);
        swipelistview.setOffsetLeft(convertDpToPixel(260f)); // left side offset
        swipelistview.setOffsetRight(convertDpToPixel(0f)); // right side offset
        swipelistview.setAnimationTime(50); // Animation time
        swipelistview.setSwipeOpenOnLongPress(true); // enable or disable SwipeOpenOnLongPress
        swipelistview.setAdapter(adapter);

        for(int i=0;i<10;i++)
        {   System.err.println("itemData.add("+i+")");
            itemData.add(new ItemRow("item"+i,getResources().getDrawable(R.drawable.ic_launcher) ));
        }

        adapter.notifyDataSetChanged();
        System.err.println("End of onCreate() of MainActivity.java");
    }

    public int convertDpToPixel(float dp) {
        System.err.println("Inside convertDpToPixel() of MainActivity.java");
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return (int) px;
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
 
}
