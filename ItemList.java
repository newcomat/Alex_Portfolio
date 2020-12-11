package alexnewcomer.cs360.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import alexnewcomer.cs360.com.Interface.ItemClickListener;
import alexnewcomer.cs360.com.Model.Item;
import alexnewcomer.cs360.com.ViewHolder.ItemViewHolder;

public class ItemList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference itemList;

    String categoryId = "";

    FirebaseRecyclerAdapter<Item, ItemViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Make this page full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_item_list);

        //Firebase
        database = FirebaseDatabase.getInstance();
        itemList = database.getReference("Items");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_item);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Get intent here
        if(getIntent() != null)
            categoryId = getIntent().getStringExtra("CategoryId");
        if(!categoryId.isEmpty() && categoryId != null)
        {
            loadListItem(categoryId);
        }

    }

    private void loadListItem(String categoryId) {

        adapter = new FirebaseRecyclerAdapter<Item, ItemViewHolder>(Item.class,
                R.layout.item_item,
                ItemViewHolder.class,
                itemList.orderByChild("MenuId").equalTo(categoryId) //this performs the SELECT * SQL function from items where MenuId = categoryId
                ) {
            @Override
            protected void populateViewHolder(ItemViewHolder viewHolder, Item model, int position) {

                viewHolder.item_name.setText(model.getName());
                Picasso.get().load(model.getImage())
                        .into(viewHolder.item_image);

                final Item local = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        //Start new activity
                        Intent itemDetail = new Intent(ItemList.this, ItemDetail.class);
                        itemDetail.putExtra("ItemId",adapter.getRef(position).getKey());  //Sent Item Id to new activity
                        startActivity(itemDetail);
                    }
                });

            }
        };

        //Set Adapter
        recyclerView.setAdapter(adapter);

    }
}
