package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity
{
    int quantity=1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment(View view)
    {
        quantity=quantity+1;
        if(quantity>=1 && quantity<=20)
        { displayQuantity(quantity);}
        else{
            Toast.makeText(this,"Limit extended",Toast.LENGTH_SHORT).show();
            quantity=20;
        }
    }
    public void decrement(View view)
    {
        quantity=quantity-1;
        if(quantity>=1 && quantity<=20)
        { displayQuantity(quantity);}
        else{
            Toast.makeText(this,"Minimum order is 1",Toast.LENGTH_SHORT).show();
            quantity=1;
        }

    }
    public void submitOrder(View view)
    {
        EditText text=findViewById(R.id.name_field);
        String name=text.getText().toString();
        CheckBox whippedCreamCheckBox=findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckBox=findViewById(R.id.chocolate_checkbox);
        boolean hasWhippedCream=whippedCreamCheckBox.isChecked();
        boolean hasChocolate=chocolateCheckBox.isChecked();
        int price=calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessage=createOrderSummary(name,price,hasWhippedCream,hasChocolate);
        displayMessage(priceMessage);

    }
    private  int calculatePrice(boolean addWhippedCream,boolean addChocolate)
    {
        int baseprice=10;
        if(addWhippedCream)
        {
            baseprice+=1;
        }
        if(addChocolate)
        {
            baseprice+=2;
        }

        return quantity*baseprice;
    }
    public void displayQuantity(int number)
    {
        TextView quantityTextView= findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }

    private String createOrderSummary(String Name,int price,boolean addWhippedCream,boolean addChocolate)
    {
        if(Name.equals("")==false) {
                String priceMessage = "Name: " + Name;
                priceMessage += "\nAdd whipped cream? : " + addWhippedCream;
                priceMessage += "\nAdd chocolate? : " + addChocolate;
                priceMessage += "\nQuantity:" + quantity;
                priceMessage += "\nTotal: $ " + price;
                priceMessage += "\nThank You!";
                return priceMessage;
        }

        else{
            String priceMessage="Please enter your name.";
            return priceMessage;
        }
    }
    public void displayMessage(String priceMessage)
    {
        TextView summaryTextView= findViewById(R.id.price_text_view);
        summaryTextView.setText(priceMessage);
    }
}
