package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_utils.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar bar = findViewById(R.id.toolbar);
        setSupportActionBar(bar);

        Utils.log("234");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private ShareActionProvider provider;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem shareItem = menu.findItem(R.id.share);
        provider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Want to join me for a pizza");
        provider.setShareIntent(intent);

        return super.onCreateOptionsMenu(menu);
    }

    public void findBeer(View view) {
        TextView brands = findViewById(R.id.brands);
        Spinner spinner = findViewById(R.id.color);

        brands.setText(spinner.getSelectedItem().toString());
    }

    public void next(View view) {
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        EditText text = findViewById(R.id.message);
        intent.putExtra("message", "" + text.getText());
        startActivity(intent);
    }

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        EditText text = findViewById(R.id.message);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text.getText() + "");
        startActivity(intent);
    }

    public void sendChosen(View view) {
        Intent intent = new Intent(Intent.EXTRA_ASSIST_CONTEXT);
        EditText text = findViewById(R.id.message);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text.getText() + "");

        Intent chosenIntent = Intent.createChooser(intent, "Choose sth");
        startActivity(chosenIntent);
    }

    public void clock(View view) {
        Intent intent = new Intent(this, ClockActivity.class);
        startActivity(intent);
    }

    public void send(View view) {
        Intent intent = new Intent(this, SendMessage.class);
        startActivity(intent);
    }

    public void frame(View view) {
        Intent intent = new Intent(this, FrameActivity.class);
        startActivity(intent);
    }

    public void constraint(View view) {
        Intent intent = new Intent(this, ConstraintActivity.class);
        startActivity(intent);
    }
}