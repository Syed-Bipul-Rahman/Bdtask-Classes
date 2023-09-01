package com.storedata.allviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.storedata.allviews.databinding.ActivityButtonsBinding;
import com.storedata.allviews.databinding.ActivityMainBinding;

public class ButtonsActivity extends AppCompatActivity {
    ActivityButtonsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityButtonsBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);


        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        binding.switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischecked) {
                if (ischecked) {
                    binding.idlinearlayout.setVisibility(View.VISIBLE);
                    binding.rradiogroup.setVisibility(View.GONE);
                } else {
                    binding.idlinearlayout.setVisibility(View.GONE);
                    binding.rradiogroup.setVisibility(View.VISIBLE);
                }
            }
        });
//        binding.floatingActionButton.setOnClickListener(v -> {
//            //startActivity(new Intent(ButtonsActivity.this, WebviewActivity.class));
//        });


        binding.rradiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedbuttonid = radioGroup.getCheckedRadioButtonId();

                int imageDrawableId = 0;
                String name = "";
                String description = "";


                if (selectedbuttonid == binding.radioButton.getId()) {
                    binding.imageButton.setImageResource(R.drawable.surongom);


                } else if (selectedbuttonid == binding.radioButto2.getId()) {

                    binding.imageButton.setImageResource(R.drawable.jawan);
                } else if (selectedbuttonid == binding.radioButton3.getId()) {

                    binding.imageButton.setImageResource(R.drawable.hollywood);
                } else if (selectedbuttonid == binding.radioButto4.getId()) {

                    binding.imageButton.setImageResource(R.drawable.robot);
                } else if (selectedbuttonid == binding.radioButto5.getId()) {

                    binding.imageButton.setImageResource(R.drawable.rosrar);
                }

            }
        });
        binding.floatingActionButton.setOnClickListener(v -> {
            int selectedRadioButtonId = binding.rradiogroup.getCheckedRadioButtonId();

            // Initialize variables
            int imageDrawableId = 0;
            String name = "";
            String description = "";

            StringBuilder checkeddata = new StringBuilder();


            if (selectedRadioButtonId == binding.radioButton.getId()) {
                imageDrawableId = R.drawable.surongo;
                name = "Surongo";
                description = "Surongo (Bengali: সুড়ঙ্গ, transl. Tunnel) is a 2023 Bangladeshi crime thriller film directed by Raihan Rafi and produced by Alpha-i and Chorki. The film features Afran Nisho and Toma Mirza as lead roles. It's debut film of Afran Nisho on big screen";
            } else if (selectedRadioButtonId == binding.radioButto2.getId()) {
                imageDrawableId = R.drawable.jawan;
                name = "Jawan";
                description = "Jawan (transl. Soldier) is an upcoming Indian Hindi-language action thriller film co-written and directed by Atlee, in his first Hindi film. It is produced by Gauri Khan and Gaurav Verma under Red Chillies Entertainment. The film stars Shah Rukh Khan in a dual role, alongside Nayanthara, Vijay Sethupathi, Deepika";
            } else if (selectedRadioButtonId == binding.radioButton3.getId()) {
                imageDrawableId = R.drawable.hollywood;
                name = "Ender\'s Game";
                description = "Ender's Game is a 2013 American military science-fiction action film based on Orson Scott Card's 1985 novel of the same name. Written and directed by Gavin Hood, the film stars Asa Butterfield as Andrew \"Ender\" Wiggin, an unusually gifted child who is sent to an advanced military academy in space to prepare for a";
            } else if (selectedRadioButtonId == binding.radioButto4.getId()) {
                imageDrawableId = R.drawable.robot;
                name = "Robot 2.0";
                description = "As the second instalment in the Enthiran film series, 2.0 is a standalone sequel to Enthiran (2010), featuring Rajinikanth reprising the roles of Vaseegaran and Chitti the Robot, alongside Akshay Kumar as Pakshi Rajan and Amy Jackson as Nila. also Sudhanshu Pandey, Adil Hussain, Kalabhavan Shajohn, and";
            } else if (selectedRadioButtonId == binding.radioButto5.getId()) {
                imageDrawableId = R.drawable.rosrar;
                name = "Rorschach";
                description = "Rorschach (transl. Rorschach test) is a 2022 Indian Malayalam-language neo-noir psychological thriller film directed by Nissam Basheer and produced by Mammootty under, Mammootty Kampany. It stars Mammootty, Sharafudheen, Jagadish, Grace Antony, Bindu Panicker, Kottayam Nazeer, Sanju Sivram and Asif";
            }


            //check box

            if (binding.check1.isChecked()) {
                checkeddata.append(binding.check1.getText().toString()).append("\n");
            } else if (binding.check2.isChecked()) {
                checkeddata.append(binding.check2.getText().toString()).append("\n");
            } else if (binding.check3.isChecked()) {
                checkeddata.append(binding.check3.getText().toString()).append("\n");
            }


            Intent intent = new Intent(ButtonsActivity.this, DeatailsofMovie.class);
            intent.putExtra("imageDrawableId", imageDrawableId);
            intent.putExtra("name", name);
            intent.putExtra("description", description);
            intent.putExtra("checkbox", checkeddata.toString());

            startActivity(intent);
        });


        //toggglebutton
        binding.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    binding.parenta.setBackgroundColor(ContextCompat.getColor(ButtonsActivity.this, R.color.green));
                    binding.toggleButton.setText("Green");
                } else {
                    binding.parenta.setBackgroundColor(ContextCompat.getColor(ButtonsActivity.this, R.color.greendark));
                    binding.toggleButton.setText("Red");
                }
            }
        });


    }
}
