package com.example.apurva.launchanotherappthroughintent;

import android.content.Intent;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    Button internal,external;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        internal=findViewById(R.id.btn_internal);
        external=findViewById(R.id.btn_external);
        internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
                startActivity(intent);
            }
        });

        external.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               intent=getPackageManager().getLaunchIntentForPackage("com.android.vendings");
               if (intent==null){
                    intent=getPackageManager().getLaunchIntentForPackage("com.android.vending");
                    startActivity(intent);
               }
               else {
                   startActivity(intent);
               }
            }
        });
    }
}
