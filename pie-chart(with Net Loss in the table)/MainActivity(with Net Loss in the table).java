package com.example.myapplication;
// Import the required libraries
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {
        // Create the object of ScrollView, TextView, PieChart.
        TextView tvEntertainment, tvFood, tvShopping, tvTravel, tvMedicine, tvMiscellaneous, tvSave,
                tvNetLoss, tvRow1;
        View vLine1;
        //PieChart
        PieChart pieChart;
        //scroll in the table
        private ScrollView scrollView;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //find the ScrollView id in XML
            scrollView = findViewById(R.id.scorellView);
            // find categories' id in XML
            tvEntertainment = findViewById(R.id.Entertainment);
            tvFood = findViewById(R.id.Food);
            tvShopping = findViewById(R.id.Shopping);
            tvTravel = findViewById(R.id.Travel);
            tvMedicine = findViewById(R.id.Medicine);
            tvMiscellaneous = findViewById(R.id.Miscellaneous);
            tvSave = findViewById(R.id.Save);
            vLine1 = findViewById(R.id.line1);
            tvNetLoss = findViewById(R.id.NetLoss);
            tvRow1 = findViewById(R.id.row1);

            pieChart = findViewById(R.id.piechart);

            // Creating a method setData()
            // to set the text in text view and pie chart
            setData();
        }

        //These variables are used to help me test
        //you can change the value for categories
        public float salary = 5000f;
        public float a = 1230.12f;
        public float b = 344.01f;
        public float c = 283.56f;
        public float d = 287.29f;
        public float e = 500.48f;
        public float f = 1000f;

        private void setData() {
            //use to record the value for each categories
            //there is save and saving. The purpose is to ensure the pie chart is correct when
            //the value of the category of save is less than 0.
            float entertainment, food, shopping, travel, medicine, miscellaneous, save,
                    saving = 0f, netLoss = 0f;

            //assign values for each category
            entertainment = a;
            food = b;
            shopping = c;
            travel = d;
            medicine = e;
            miscellaneous = f;
            save = salary - entertainment - food - shopping - travel - medicine - miscellaneous;

            //make sure the value of save has two decimal places.
            BigDecimal bd = new BigDecimal((double)save);
            bd = bd.setScale(2, 4);
            save = bd.floatValue();

            // Set the value of each category for the pie chart
            tvEntertainment.setText(Float.toString(entertainment));
            tvFood.setText(Float.toString(food));
            tvShopping.setText(Float.toString(shopping));
            tvTravel.setText(Float.toString(travel));
            tvMedicine.setText(Float.toString(medicine));
            tvMiscellaneous.setText(Float.toString(miscellaneous));

            //determine whether save is less than 0
            //if save is less than 0, there will show net loss in the table
            if (save < 0){
                tvSave.setText(Float.toString(saving));
                netLoss = Math.abs(save);
                save = saving;
                vLine1.setVisibility(View.VISIBLE);
                tvNetLoss.setText(Float.toString(netLoss));
                tvNetLoss.setVisibility(TextView.VISIBLE);
                tvRow1.setVisibility(TextView.VISIBLE);
            }
            else{
                tvSave.setText(Float.toString(save));
            }

            //add scroll to make the table can scroll down
            scrollView.fullScroll(ScrollView.FOCUS_DOWN);

            // Set the data and color to the pie chart
            pieChart.addPieSlice(
                    new PieModel(
                            "Entertainment",
                            Float.parseFloat(tvEntertainment.getText().toString()),
                            Color.parseColor("#FFA726"))
            );
            pieChart.addPieSlice(
                    new PieModel(
                            "Food",
                            Float.parseFloat(tvFood.getText().toString()),
                            Color.parseColor("#66BB6A"))
            );
            pieChart.addPieSlice(
                    new PieModel(
                            "Shopping",
                            Float.parseFloat(tvShopping.getText().toString()),
                            Color.parseColor("#EF5350")));
            pieChart.addPieSlice(
                    new PieModel(
                            "Travel",
                            Float.parseFloat(tvTravel.getText().toString()),
                            Color.parseColor("#29B6F6")));
            pieChart.addPieSlice(
                    new PieModel(
                            "Medicine",
                            Float.parseFloat(tvMedicine.getText().toString()),
                            Color.parseColor("#00FFFF")));
            pieChart.addPieSlice(
                    new PieModel(
                            "Miscellaneous",
                            Float.parseFloat(tvMiscellaneous.getText().toString()),
                            Color.parseColor("#8A2BE2")));
            pieChart.addPieSlice(
                    new PieModel(
                            "Save",
                            Float.parseFloat(tvSave.getText().toString()),
                            Color.parseColor("#ADFF2F")));

            // To animate the pie chart
            pieChart.startAnimation();

            //add $ in front of the number in the table
            tvEntertainment.setText('$' + Float.toString(entertainment));
            tvFood.setText('$' + Float.toString(food));
            tvShopping.setText('$' + Float.toString(shopping));
            tvTravel.setText('$' + Float.toString(travel));
            tvMedicine.setText('$' + Float.toString(medicine));
            tvMiscellaneous.setText('$' + Float.toString(miscellaneous));
            tvSave.setText('$' + Float.toString(save));
            tvNetLoss.setText('$' + Float.toString(netLoss));
        }
}