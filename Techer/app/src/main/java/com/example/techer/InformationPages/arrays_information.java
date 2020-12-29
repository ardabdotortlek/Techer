package com.example.techer.InformationPages;
import com.example.techer.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class arrays_information extends AppCompatActivity  {
    TextView informationText;
    Button backButton;
    ImageView image;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_canvas);
        informationText = findViewById(R.id.informationText);
        String para = "Arrays are used to store multiple values in a single variable, instead of declaring separate variables for each value.\n" +
                "\n" +
                "To declare an array, define the variable type with square brackets:\n" +
                "String[] cars;\n" +
                "\n" +
                "We have now declared a variable that holds an array of strings. To insert values to it, we can use an array literal -\n" +
                "place the values in a comma-separated list, inside curly braces:\n" +
                "String[] cars = {\"Volvo\", \"BMW\", \"Ford\", \"Mazda\"};\n" +
                "\n" +
                "To create an array of integers, you could write:\n" +
                "int[] myNum = {10, 20, 30, 40};\n" +
                "\n" +
                "You access an array element by referring to the index number.\n" +
                "\n" +
                "This statement accesses the value of the first element in cars:\n" +
                "String[] cars = {\"Volvo\", \"BMW\", \"Ford\", \"Mazda\"};\n" +
                "System.out.println(cars[0]);\n" +
                "// Outputs Volvo\n" +
                "\n" +
                "To change the value of a specific element, refer to the index number:\n" +
                "String[] cars = {\"Volvo\", \"BMW\", \"Ford\", \"Mazda\"};\n" +
                "cars[0] = \"Opel\";\n" +
                "System.out.println(cars[0]);\n" +
                "// Now outputs Opel instead of Volvo\n" +
                "\n" +
                "To find out how many elements an array has, use the length property:\n" +
                "String[] cars = {\"Volvo\", \"BMW\", \"Ford\", \"Mazda\"};\n" +
                "System.out.println(cars.length);\n" +
                "// Outputs 4\n" +
                "\n" +
                "You can loop through the array elements with the for loop, and use the length property to specify how many\n" +
                "times the loop should run.\n" +
                "The following example outputs all elements in the cars array:\n" +
                "String[] cars = {\"Volvo\", \"BMW\", \"Ford\", \"Mazda\"};\n" +
                "for (int i = 0; i < cars.length; i++) {\n" +
                "  System.out.println(cars[i]);\n" +
                "}\n" +
                "\n" +
                "A multidimensional array is an array containing one or more arrays.\n" +
                "\n" +
                "To create a two-dimensional array, add each array within its own set of curly braces:\n" +
                "int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };\n" +
                "int x = myNumbers[1][2];\n" +
                "System.out.println(x); // Outputs 7";

        informationText.setText(para);
        informationText.setMovementMethod(new ScrollingMovementMethod());

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        image = findViewById(R.id.imageInfo);
        image.setBackgroundResource(R.drawable.arrays_image);

        title = findViewById(R.id.infoTitle);
        title.setText("Arrays");
    }
}