package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice(Boolean isWhippedCreamChecked, Boolean isChocolateChecked) {
        int price = quantity * 5;
        if (isWhippedCreamChecked) {
            price += quantity * 1;
        }
        if (isChocolateChecked) {
            price += quantity * 2;
        }
        return price;
    }

    public String getName () {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        return nameField.getText().toString();
    }

    private String createOrderSummary() {
        CheckBox hasWhippedCream = (CheckBox) findViewById(R.id.whipped_cream_check_box);
        CheckBox hasChocolate = (CheckBox) findViewById(R.id.chocolate_check_box);
        Boolean isWhippedCreamChecked = hasWhippedCream.isChecked();
        Boolean isChocolateChecked = hasChocolate.isChecked();
        return getString(R.string.order_name_summary, getName()) +"\n" +
                getString(R.string.add_whipped_cream_summary, isWhippedCreamChecked) + "\n" +
                getString(R.string.add_chocolate_summary, isChocolateChecked) + "\n" +
                getString(R.string.quantity_summary, quantity) + "\n" +
                getString(R.string.total_summary, NumberFormat.getCurrencyInstance().format(calculatePrice(isWhippedCreamChecked,isChocolateChecked))) + "\n" +
                getString(R.string.thank_you);
    }

    public void submitOrder(View view){
        /*Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava order for "+ getName());
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*/
        displayMessage(createOrderSummary());
    }

    public void display(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(" "+number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }
    public void decrement(View view) {
        if (quantity > 1) {
            quantity = quantity - 1;
            display(quantity);
        }
    }
}
