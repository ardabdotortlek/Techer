package com.example.techer.InformationPages;
import com.example.techer.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class variable_information extends AppCompatActivity  {
    TextView informationText;
    Button backButton;
    ImageView image;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_canvas);
        informationText = findViewById(R.id.informationText);
        String para = " There are 3 types of variables: Instance Variables (Non-Static Fields) , Class Variables (Static Fields) , Local Variables.\n" +
                "\n" +
                "Instance variables(non-static) : Non-static fields are also known as instance variables because their values \n" +
                "are unique to each instance of a class (to each object, in other words); the currentSpeed of one bicycle is \n" +
                "independent from the currentSpeed of another.\n" +
                "\n" +
                "Class Variables(static): A class variable is any field declared with the static modifier; this tells the compiler\n" +
                " that there is exactly one copy of this variable in existence, regardless of how many times the class has been \n" +
                "instantiated. A field defining the number of gears for a particular kind of bicycle could be marked as static since\n" +
                " conceptually the same number of gears will apply to all instances. The code static int numGears = 6; would create \n" +
                "such a static field. Additionally, the keyword final could be added to indicate that the number of gears will never change.\n" +
                "\n" +
                "Local Variables: There is no special keyword designating a variable as local; that determination comes entirely from the \n" +
                "location in which the variable is declared\n" +
                "\n" +
                " When naming java variables there are some rules and suggestions.\n" +
                "1. Variable names are case-sensitive. A variable's name can be any legal identifier — an unlimited-length sequence of Unicode\n" +
                " letters and digits, beginning with a letter, the dollar sign \"$\", or the underscore character \"_\". The convention, however, \n" +
                "is to always begin your variable names with a letter, not \"$\" or \"_\". Additionally, the dollar sign character, by convention,\n" +
                " is never used at all. You may find some situations where auto-generated names will contain the dollar sign, but your variable\n" +
                " names should always avoid using it. A similar convention exists for the underscore character; while it's technically legal to\n" +
                " begin your variable's name with \"_\", this practice is discouraged. White space is not permitted.\n" +
                "\n" +
                "2. Subsequent characters may be letters, digits, dollar signs, or underscore characters. Conventions (and common sense) apply\n" +
                " to this rule as well. When choosing a name for your variables, use full words instead of cryptic abbreviations. Doing so will\n" +
                " make your code easier to read and understand. In many cases it will also make your code self-documenting; fields named cadence,\n" +
                " speed, and gear, for example, are much more intuitive than abbreviated versions, such as s, c, and g. Also keep in mind that the\n" +
                " name you choose must not be a keyword or reserved word.\n" +
                "\n" +
                "3. If the name you choose consists of only one word, spell that word in all lowercase letters. If it consists of more than one word,\n" +
                " capitalize the first letter of each subsequent word. The names gearRatio and currentGear are prime examples of this convention. If \n" +
                "your variable stores a constant value, such as static final int NUM_GEARS = 6, the convention changes slightly, capitalizing every \n" +
                "letter and separating subsequent words with the underscore character. By convention, the underscore character is never used elsewhere.\n" +
                "\n" +
                "\n" +
                "Below there are primitive types of variables and their corresponding bits\n" +
                "boolean => 1bit\n" +
                "byte => 8 bit \n" +
                "char => 16bit\n" +
                "short => 16bit\n" +
                "int => 32 bit \n" +
                "long => 64bit\n" +
                "float => 32bit\n" +
                "double => 64bit";

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
        image.setBackgroundResource(R.drawable.java_variable_new);

        title = findViewById(R.id.infoTitle);
        title.setText("Variables");
    }
}