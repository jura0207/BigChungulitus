package hr.fer.ppij.bigchungulitus;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @SuppressLint("ResourceType")
    public boolean openMainMenu(BigChungus bigChungus){

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.new_feed);
                /**Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        return true;
    }

    public boolean openSignUp(View view){
        setContentView(R.layout.sign_up);
        //public TextView passWarningTextView = (TextView) findViewById(R.id.passWarning);
        return true;
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }


    public void closeLogIn(View view){
        EditText username = (EditText) findViewById(R.id.editTextUserNameLogIn);
        EditText password = (EditText) findViewById(R.id.editTextPasswordLogIn);

        //TODO check in database for a log in credentials

        BigChungus bigChungus = new BigChungus();
        openMainMenu(bigChungus);
    }

    public boolean closeSignUp(View view){
        EditText username = (EditText) findViewById(R.id.editTextSignUpUserName);
        EditText email = (EditText) findViewById(R.id.editTextSignUpEmail);
        EditText passwd = (EditText) findViewById(R.id.editTextSignUpPassword);
        EditText passwdConfirm = (EditText) findViewById(R.id.editTextSignUpRepPassword);
        EditText personFirstName = (EditText) findViewById(R.id.editTextSignUpName);
        EditText personLastName = (EditText) findViewById(R.id.editTextSignUpLastName);

        TextView passWarningTextView = (TextView) findViewById(R.id.passWarning);
        TextView passWarningConfirmTextView = (TextView) findViewById(R.id.confirmPassWarning);
        boolean signUpCheck = true;

        //Creates regex for password
        Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(String.valueOf(passwd.getText()));

        if (matcher.find()){
            passWarningTextView.setVisibility(View.INVISIBLE);
        } else {
            passWarningTextView.setVisibility(View.VISIBLE);
            signUpCheck = false;
        }

        //Compares if the second password is matching the first one
        if (String.valueOf(passwd.getText()).equals(String.valueOf(passwdConfirm.getText()))){
            passWarningConfirmTextView.setVisibility(View.INVISIBLE);
        } else {
            passWarningConfirmTextView.setVisibility(View.VISIBLE);
            signUpCheck = false;
        }

        @SuppressLint("ResourceType") BigChungus bigChungus = new BigChungus(String.valueOf(username.getText()), String.valueOf(passwd.getText()),
                String.valueOf(email.getText()), String.valueOf(personFirstName.getText()), String.valueOf(personLastName.getText()));

        //Clearing variables so it doeasn't crash
        username = null;
        passwd = null;
        passwdConfirm = null;
        email = null;
        personFirstName = null;
        personLastName = null;
        pattern = null;


        if (signUpCheck){
            openMainMenu(bigChungus);
        }
        return true;
    }

    public void openSettings(View view){
        setContentView(R.layout.settings);
    }

    @Override
    public void onBackPressed(){
        setContentView(R.layout.log_in);
    }


}