package com.example.android.newsportal;

        import android.graphics.Color;
        import android.graphics.drawable.ColorDrawable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import com.baoyz.swipemenulistview.SwipeMenu;
        import com.baoyz.swipemenulistview.SwipeMenuCreator;
        import com.baoyz.swipemenulistview.SwipeMenuItem;
        import com.baoyz.swipemenulistview.SwipeMenuListView;

        import java.util.ArrayList;

public class AdminPage extends AppCompatActivity {



    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;
    //ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        SwipeMenuListView listView = (SwipeMenuListView) findViewById(R.id.listView);

        list.add("asd");
        list.add("wow");

        adapter = new ArrayAdapter(AdminPage.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth((200));
                // set item title
                openItem.setTitle("Accept");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth((200));
                // set a icon
//                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        listView.setMenuCreator(creator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        //open
                        break;

                    case 1:
                        //delete
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                        break;
                }

                return false;
            }
        });


    }


}
