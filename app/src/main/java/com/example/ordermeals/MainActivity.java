package com.example.ordermeals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView price, totalPrice;

    private RadioGroup tips;
    private ImageView FoodImage;
    private CheckBox confirm;
    private Button btn_order;
    private int tipPercent = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spinner//
        Spinner spinner = findViewById(R.id.meals_spinner);
        price = findViewById(R.id.price);
        totalPrice = findViewById(R.id.total_price);
        tips = findViewById(R.id.tip);
        FoodImage = findViewById(R.id.food_image);
        confirm = findViewById(R.id.confirm);
        btn_order = findViewById(R.id.order_food);

        FoodImage.setImageResource(R.drawable.test);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.foods_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        //Spinner//

        //Seekbar//
        SeekBar quantity = findViewById(R.id.quantity);
        quantity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        tips.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.tip_10:
                    System.out.println("Tip 10");
                    tipPercent = 10;
                    break;
                case R.id.tip_15:
                    System.out.println("Tip 15");
                    tipPercent = 15;
                    break;
                case R.id.tip_20:
                    System.out.println("Tip 20");
                    tipPercent = 20;
                    break;
                default:
                    System.out.println(checkedId);
            }
        });
        btn_order.setOnClickListener(view -> {
            System.out.println(confirm.isChecked());
            price.clearFocus();
            totalPrice.clearFocus();
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("quantity" , quantity.getProgress());
            intent.putExtra("tip", tipPercent);
            intent.putExtra("name", spinner.getSelectedItem().toString());
            startActivity(intent);
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        switch (item) {
            case "Butter Masala Dosa":
                TextView p = new TextView(this);
                p.setText(String.valueOf(20));
                break;
            case "Daal Makhni":
                TextView p1 = new TextView(this);
                p1.setText(String.valueOf(25));
                break;
            case "Vadda Pav":
                TextView p2 = new TextView(this);
                p2.setText(String.valueOf(4));
                break;
            case "Aloo da Parantha":
                TextView p3 = new TextView(this);
                p3.setText(String.valueOf(5));
                break;
            case "Nachos":
                TextView p4 = new TextView(this);
                p4.setText(String.valueOf(12));
                break;
            case "Dhokla":
                TextView p5 = new TextView(this);
                p5.setText(String.valueOf(15));
                break;
            case "Biryani":
                TextView p6 = new TextView(this);
                p6.setText(String.valueOf(40));
                break;
            case "Pani Puri":
                TextView p7 = new TextView(this);
                p7.setText(String.valueOf(14));
                break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Please Select a Dish", Toast.LENGTH_SHORT).show();

    }


}
