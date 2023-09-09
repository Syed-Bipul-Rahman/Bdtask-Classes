package com.classwork.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView productname, productprice, increase, decrease, quantity;
    ImageView productimage, backarrow, carttop,call;
    LinearLayout homeli, orderhobe, carthobe;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        productimage = findViewById(R.id.productimagessingle);
        productname = findViewById(R.id.productnamesingle);
        productprice = findViewById(R.id.productpricesingle);
        backarrow = findViewById(R.id.back_arroworder);
        homeli = findViewById(R.id.homesingele);
        increase = findViewById(R.id.increasequantity);
        decrease = findViewById(R.id.decreasequantity);
        quantity = findViewById(R.id.quantityofproduct);
        orderhobe = findViewById(R.id.orderhobe);
        carthobe = findViewById(R.id.carthoeb);
        carttop = findViewById(R.id.cardtop);
        call = findViewById(R.id.callsinge);

        getSupportActionBar().hide();

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int imagess = intent.getIntExtra("image", 0);
        String price = intent.getStringExtra("price");


        productimage.setImageResource(imagess);
        productname.setText(name);

        productprice.setText(price);


        backarrow.setOnClickListener(v -> {

            finish();
        });
        homeli.setOnClickListener(view -> {
            finish();
        });
        increase.setOnClickListener(view -> {
            int i = 1;
            i += 1;
            quantity.setText(i + "");

        });
        decrease.setOnClickListener(view -> {
            int i = Integer.parseInt(quantity.getText().toString());

            if (i == 2) {
                i -= 1;

                quantity.setText(i + "");
            }
        });


        carttop.setOnClickListener(view -> {
            showmessage("Added", "This product is added to cart from top");
        });
        carthobe.setOnClickListener(view -> {
            showmessage("Added", "This product is added to cart");
        });
        orderhobe.setOnClickListener(view -> {
            showmessage("Order Placed", "Your order has been placed");
        });

        call.setOnClickListener(v->{
            Intent callintent=new Intent(Intent.ACTION_DIAL);
            callintent.setData(Uri.parse("+tel:8801792932818"));
            startActivity(callintent);
        });


    }

    private void showmessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(DetailsActivity.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", (dialog, which) -> {
            dialog.dismiss();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}