package alexnewcomer.cs360.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YourOrders extends AppCompatActivity {

    Button place_an_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_orders);

        place_an_order = findViewById(R.id.order_button_redirect);
        place_an_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YourOrders.this, PlaceOrder.class);
                startActivity(intent);
            }
        });
    }
}
