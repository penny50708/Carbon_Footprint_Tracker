package nz.ac.wgtn.ecs.carbonfootprintgroupapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;

import java.util.Locale;
@SuppressWarnings("deprecation")
public class SplashPage extends BaseActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Change the language
        setDefaultLanguage();
        setContentView(R.layout.activity_splash_page);
    }

    public void getStartedButtonClick(View view){
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }

    //Get the selected language from the SharedPreferences
    private void setDefaultLanguage() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String language = preferences.getString("language","");
        if(!language.equalsIgnoreCase("")) {
            Resources resources = getResources();
            DisplayMetrics metrics = resources.getDisplayMetrics();
            Configuration configuration = resources.getConfiguration();
            configuration.setLocale(new Locale(language));
            resources.updateConfiguration(configuration, metrics);
        }
    }
}