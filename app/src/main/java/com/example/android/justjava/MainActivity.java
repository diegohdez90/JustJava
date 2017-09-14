package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

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
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    public String getName () {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        return nameField.getText().toString();
    }

    private String createOrderSummary() {
        CheckBox hasWhippedCream = (CheckBox) findViewById(R.id.whipped_cream_check_box);
        CheckBox hasChocolate = (CheckBox) findViewById(R.id.chocolate_check_box);
        return "Name: "+ getName() +"\n" +
                "Add Whipped Cream? "+ hasWhippedCream.isChecked() +"\n" +
                "Add Chocolate? "+ hasChocolate.isChecked() +"\n" +
                "Quantity: "+ quantity +"\nTotal: $" + calculatePrice() + "\nThank you!";
    }

    public void submitOrder(View view){
        String message = createOrderSummary();
        displayMessage(message);
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
