package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends ActionBarActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox cbWhippedCream = (CheckBox)findViewById(R.id.cbWhippedCream);
        CheckBox cbChocolate = (CheckBox)findViewById(R.id.cbChocolate);
        EditText txtName = (EditText)findViewById(R.id.txtName);
        int price = calculatePrice(quantity, cbWhippedCream.isChecked(), cbChocolate.isChecked());
        displayPrice(price, cbWhippedCream.isChecked(), cbChocolate.isChecked(), txtName.getText().toString());
    }

    public void increment(View view) {
        if (quantity < 300) quantity++;
        else Toast.makeText(this, "You cannot have more than 300 cups of coffee", Toast.LENGTH_SHORT).show();
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity > 0) quantity--;
        else Toast.makeText(this, "You cannot have less than 0 cups of coffee", Toast.LENGTH_SHORT).show();
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private int calculatePrice(int quantity, boolean wantsWhippedCream, boolean wantsChocolate) {
        int basePrice = 5;
        if (wantsWhippedCream) basePrice += 1;
        if (wantsChocolate) basePrice += 2;
        return basePrice * quantity;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayPrice(int price, boolean wantsWhippedCream, boolean wantsChocolate,
                              String name) {
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        String orderSummary = String.format("Name: %s\n"+
                                            "Add whipped cream? %b\n"+
                                            "Add chocolate? %b\n"+
                                            "Total: %s\nThank you!",
                                            name, wantsWhippedCream, wantsChocolate,
                                            NumberFormat.getCurrencyInstance().format(price));
        priceTextView.setText(orderSummary);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}
