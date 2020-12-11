package alexnewcomer.cs360.com;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList item_id, item_name, item_description, item_size, item_notes;

    CustomAdapter(Activity activity, Context context, ArrayList item_id, ArrayList item_name, ArrayList item_description,
                  ArrayList item_size, ArrayList item_notes){

        this.activity = activity;
        this.context = context;
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_description = item_description;
        this.item_size = item_size;
        this.item_notes = item_notes;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.item_id_txt.setText(String.valueOf(item_id.get(position)));
        holder.item_name_txt.setText(String.valueOf(item_name.get(position)));
        holder.item_description_txt.setText(String.valueOf(item_description.get(position)));
        holder.item_size_txt.setText(String.valueOf(item_size.get(position)));
        holder.item_notes_txt.setText(String.valueOf(item_notes.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(item_id.get(position)));
                intent.putExtra("name", String.valueOf(item_name.get(position)));
                intent.putExtra("description", String.valueOf(item_description.get(position)));
                intent.putExtra("size", String.valueOf(item_size.get(position)));
                intent.putExtra("notes", String.valueOf(item_notes.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return item_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView item_id_txt, item_name_txt, item_description_txt, item_size_txt, item_notes_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_id_txt = itemView.findViewById(R.id.item_id_txt);
            item_name_txt = itemView.findViewById(R.id.item_name_txt);
            item_description_txt = itemView.findViewById(R.id.item_description_txt);
            item_size_txt = itemView.findViewById(R.id.item_size_txt);
            item_notes_txt = itemView.findViewById(R.id.item_notes_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }
    }
}
