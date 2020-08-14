package com.kp.translation_tesing;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static com.kp.translation_tesing.LocaleManager.LANGUAGE_ENGLISH;
import static com.kp.translation_tesing.LocaleManager.LANGUAGE_UKRAINIAN;

public class SettingActivity extends AppCompatActivity {



        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_setting);
            //noinspection ConstantConditions
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            findViewById(R.id.en).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setNewLocale(LANGUAGE_ENGLISH, false);
                }
            });
            findViewById(R.id.en).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    setNewLocale(LANGUAGE_ENGLISH, true);

                    return true;
                }
            });
            findViewById(R.id.ukr).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setNewLocale(LANGUAGE_UKRAINIAN, false);
                }
            });
            findViewById(R.id.ukr).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    setNewLocale(LANGUAGE_UKRAINIAN, true);
                    return true;
                }
            });
        }

        private boolean setNewLocale(String language, boolean restartProcess) {
            App.localeManager.setNewLocale(this, language);

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));

            if (restartProcess) {
                System.exit(0);
            } else {
                Toast.makeText(this, "Activity restarted", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
}
