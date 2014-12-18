package gene.com.swipelistviewexample;


import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fortysevendeg.swipelistview.SwipeListView;

public class ItemAdapter extends ArrayAdapter {

    List data;
    Context context;
    int layoutResID;

//----------START of Code to Change How Far Front View Moves to the Left--------------
    private SwipeListView mSwipeListView; //Allows me to adjust the mSwipeListView.setOffsetLeft().
    private int button_swipe_button1_width, button_swipe_button2_width, button_swipe_button3_width;

//----------END of Code to Change How Far Front View Moves to the Left--------------

    //Original Constructor
    public ItemAdapter(Context context, int layoutResourceId, List data) {
        super(context, layoutResourceId, data);
        System.err.println("Inside constructor() of ItemAdapter.java");

        this.data = data;
        this.context = context;
        System.err.println("this.context= "+ this.context);
        System.err.println("this.context.getString(layoutResourceId))= "+ this.context.getString(layoutResourceId));
        this.layoutResID = layoutResourceId;
        System.err.println("this.layoutResID= "+ this.layoutResID);
    }

    //This constructor I added so that I can access SwipeListView from this class.
    public ItemAdapter(Context context, int layoutResourceId, List data, SwipeListView s) {
        super(context, layoutResourceId, data);
        System.err.println("Inside constructor() of ItemAdapter.java");

        this.data = data;
        this.context = context;
        System.err.println("this.context= "+ this.context);
        System.err.println("this.context.getString(layoutResourceId))= "+ this.context.getString(layoutResourceId));
        this.layoutResID = layoutResourceId;
        System.err.println("this.layoutResID= "+ this.layoutResID);

        mSwipeListView= s;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.err.println("Inside getView() of ItemAdapter.java");
        NewsHolder holder = null;
        System.err.println("convertView= "+ convertView);
        View row = convertView;
        //System.out.println("row.getMeasuredWidth()1= "+ row.getMeasuredWidth());

        if (row == null) {
            System.err.println("Inside if(convertView==null)");

            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResID, parent, false);
            System.out.println("row.getMeasuredWidth()2= "+ row.getMeasuredWidth());

            holder = new NewsHolder();

            holder.itemName = (TextView) row.findViewById(R.id.example_itemname);
            holder.icon = (ImageView) row.findViewById(R.id.example_image);
            holder.button1 = (Button) row.findViewById(R.id.swipe_button1);
            holder.button2 = (Button) row.findViewById(R.id.swipe_button2);
            holder.button3 = (Button) row.findViewById(R.id.swipe_button3);
            System.out.println("holder.button3(1).getMeasuredWidth()= "+ holder.button3.getMeasuredWidth());
            row.setTag(holder);
        } else {
            System.err.println("Inside if(convertView!=null)");
            holder = (NewsHolder) row.getTag();
        }

        ItemRow itemdata = (ItemRow) data.get(position);
        holder.itemName.setText(itemdata.getItemName());
        holder.icon.setImageDrawable(itemdata.getIcon());

        holder.button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "Button 1 Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        holder.button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "Button 2 Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        System.out.println("holder.button3(2).getMeasuredWidth()= "+ holder.button3.getMeasuredWidth());
        holder.button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "Button 3 Clicked", Toast.LENGTH_SHORT);
            }
        });
//----------START of Code to Change How Far Front View Moves to the Left--------------
        button_swipe_button1_width= holder.button1.getMeasuredWidth();
        button_swipe_button2_width= holder.button2.getMeasuredWidth();
        button_swipe_button3_width= holder.button3.getMeasuredWidth();
        System.out.println("holder.button3(3).getMeasuredWidth()= "+ holder.button3.getMeasuredWidth());
        System.out.println("button_swipe_button3_width= "+ button_swipe_button3_width);
        System.out.println("");

        System.out.println("row.getMeasuredWidth()3= "+ row.getMeasuredWidth());
        //Bottom code fixes the bug where if u swipe left and then right, the whole front
        //view disappears.
        mSwipeListView.setOffsetRight(row.getMeasuredWidth());

        int leftOffSet= row.getMeasuredWidth()-(button_swipe_button3_width+button_swipe_button2_width)-5;
        mSwipeListView.setOffsetLeft(leftOffSet);
//----------END of Code to Change How Far Front View Moves to the Left--------------

        return row;
    } //End of getView()

    //Bottom is original code:
    //static class NewsHolder {
    class NewsHolder {  //It also works if not static

        TextView itemName;
        ImageView icon;
        Button button1;
        Button button2;
        Button button3;
    }

}