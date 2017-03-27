package de.kriegergilde.daily;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


/**
 * test github
 */

public class MainActivity extends Activity {

    private String history;


    private Discipline training1;
    private Button btnTraining1Inc1;
    private Button btnTraining1Inc5;

    private Discipline training2;
    private Button btnTraining2Inc1;
    private Button btnTraining2Inc5;

    /*
    private Discipline training3;
    private Button btnTraining3Inc1;
    private Button btnTraining3Inc5;

    private Discipline training4;
    private Button btnTraining4Inc1;
    private Button btnTraining4Inc5;
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        history = getPreferences(MODE_PRIVATE).getString("history", new String());
        ((TextView)findViewById(R.id.historyTextView)).setText(history);

        String training1AsString = getPreferences(MODE_PRIVATE).getString("training.training1", null);
        if (training1AsString == null){
            training1 = new Discipline("training1",
                    new GregorianCalendar(2016, Calendar.MAY, 11).getTimeInMillis(),
                    1000 * 60 * 60 * 24 * 3, // reg Intervall
                    20, // rep per Training
                    0); // rep actual
            getPreferences(MODE_PRIVATE).edit().putString("training.training1", new Gson().toJson(training1)).commit();
        } else {
            training1 = new Gson().fromJson(training1AsString, Discipline.class);
        }
        btnTraining1Inc1 = (Button) findViewById(R.id.btnTraining1Inc1);
        btnTraining1Inc1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                training1.incBy(1);
                history += new SimpleDateFormat("dd.MM.yy HH:mm:ss ").format(new Date())+"K1\n";
                recalcSaveAndRepaint();
            }
        });
        btnTraining1Inc5 = (Button) findViewById(R.id.btnTraining1Inc5);
        btnTraining1Inc5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                training1.incBy(5);
                history += new SimpleDateFormat("dd.MM.yy HH:mm:ss ").format(new Date())+"K5\n";
                recalcSaveAndRepaint();
            }
        });

        String training2AsString = getPreferences(MODE_PRIVATE).getString("training.training2", null);
        if (training2AsString == null){
            training2 = new Discipline("training2",
                    new GregorianCalendar(2016, Calendar.MAY, 12).getTimeInMillis(),
                    1000 * 60 * 60 * 24 * 3, // reg Intervall
                    60, // rep per Training
                    0); // rep actual
            getPreferences(MODE_PRIVATE).edit().putString("training.training2", new Gson().toJson(training2)).commit();
        } else {
            training2 = new Gson().fromJson(training2AsString, Discipline.class);
        }
        btnTraining2Inc1 = (Button) findViewById(R.id.btnTraining2Inc1);
        btnTraining2Inc1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                training2.incBy(1);
                history += new SimpleDateFormat("dd.MM.yy HH:mm:ss ").format(new Date())+"L1\n";
                recalcSaveAndRepaint();
            }
        });
        btnTraining2Inc5 = (Button) findViewById(R.id.btnTraining2Inc5);
        btnTraining2Inc5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                training2.incBy(5);
                history += new SimpleDateFormat("dd.MM.yy HH:mm:ss ").format(new Date())+"L5\n";
                recalcSaveAndRepaint();
            }
        });

/*
        String training3AsString = getPreferences(MODE_PRIVATE).getString("training.training3", null);
        if (training3AsString == null){
            training3 = new Discipline("training3",
                    new GregorianCalendar(2015, Calendar.NOVEMBER, 1).getTimeInMillis(),
                    1000 * 60 * 60 * 24 * 3, // reg Intervall
                    15, // rep per Training
                    0); // rep actual
            getPreferences(MODE_PRIVATE).edit().putString("training.training3", new Gson().toJson(training3)).commit();
        } else {
            training3 = new Gson().fromJson(training3AsString, Discipline.class);
        }
        btnTraining3Inc1 = (Button) findViewById(R.id.btnTraining3Inc1);
        btnTraining3Inc1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                training3.incBy(1);
                history += new SimpleDateFormat("dd.MM.yy HH:mm:ss ").format(new Date())+"X3_1\n";
                recalcSaveAndRepaint();
            }
        });
        btnTraining3Inc5 = (Button) findViewById(R.id.btnTraining3Inc5);
        btnTraining3Inc5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                training3.incBy(5);
                history += new SimpleDateFormat("dd.MM.yy HH:mm:ss ").format(new Date())+"X3_5\n";
                recalcSaveAndRepaint();
            }
        });

        String training4AsString = getPreferences(MODE_PRIVATE).getString("training.training4", null);
        if (training4AsString == null){
            training4 = new Discipline("training4",
                    new GregorianCalendar(2015, Calendar.NOVEMBER, 2).getTimeInMillis(),
                    1000 * 60 * 60 * 24 * 7, // reg Intervall
                    30, // rep per Training
                    0); // rep actual
            getPreferences(MODE_PRIVATE).edit().putString("training.training4", new Gson().toJson(training4)).commit();
        } else {
            training4 = new Gson().fromJson(training4AsString, Discipline.class);
        }
        btnTraining4Inc1 = (Button) findViewById(R.id.btnTraining4Inc1);
        btnTraining4Inc1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                training4.incBy(1);
                history += new SimpleDateFormat("dd.MM.yy HH:mm:ss ").format(new Date())+"X4_1\n";
                recalcSaveAndRepaint();
            }
        });
        btnTraining4Inc5 = (Button) findViewById(R.id.btnTraining4Inc5);
        btnTraining4Inc5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                training4.incBy(5);
                history += new SimpleDateFormat("dd.MM.yy HH:mm:ss ").format(new Date())+"X4_5\n";
                recalcSaveAndRepaint();
            }
        });
        */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void recalcSaveAndRepaint(){

        if (history.length() > 300){
            history = history.substring(history.indexOf("\n")+1);
        }
        getPreferences(MODE_PRIVATE).edit().putString("history", history).commit();
        ((TextView)findViewById(R.id.historyTextView)).setText(history);

        training1.recalc();
        getPreferences(MODE_PRIVATE).edit().putString("training.training1", new Gson().toJson(training1)).commit();
        final TextView textViewTraining1 = (TextView) findViewById(R.id.textViewTraining1);
        textViewTraining1.setText("K: " + training1.getRepeatsOutstanding());

        training2.recalc();
        getPreferences(MODE_PRIVATE).edit().putString("training.training2", new Gson().toJson(training2)).commit();
        final TextView textViewTraining2 = (TextView) findViewById(R.id.textViewTraining2);
        textViewTraining2.setText("L: " + training2.getRepeatsOutstanding());

        /*
        training3.recalc();
        getPreferences(MODE_PRIVATE).edit().putString("training.training3", new Gson().toJson(training3)).commit();
        final TextView textViewTraining3 = (TextView) findViewById(R.id.textViewTraining3);
        textViewTraining3.setText("Y: " + training3.getRepeatsOutstanding());

        training4.recalc();
        getPreferences(MODE_PRIVATE).edit().putString("training.training4", new Gson().toJson(training4)).commit();
        final TextView textViewTraining4 = (TextView) findViewById(R.id.textViewTraining4);
        textViewTraining4.setText("A: "+training4.getRepeatsOutstanding());
        */
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up btnKlimmInc1, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        recalcSaveAndRepaint();
    }
}
