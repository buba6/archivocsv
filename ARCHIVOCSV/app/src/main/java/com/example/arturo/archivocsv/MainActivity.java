package com.example.arturo.archivocsv;

import android.content.res.AssetManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
//private Button savebutton;
    private EditText edittext1,edittext2,edittext3,edittext4,ed;
    CSVFileWriter csv;
    StringBuffer filePath;
    File file;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public class CSVFileWriter { private PrintWriter csvWriter; private File file; public CSVFileWriter(File file) {
        this.file = file;
    }
        public void writeHeader(String data) {
            try {
                if (data != null) {
                    csvWriter = new PrintWriter(new FileWriter(file, true));
                    csvWriter.print(",");
                    csvWriter.print(data);
                    csvWriter.close();
                } } catch (IOException e)
            { e.printStackTrace(); } } }







            //savebutton = (Button) findViewById(R.id.button);



        public void on(View view) {
            try {
                edittext1 = (EditText) findViewById(R.id.uno);
                edittext2 = (EditText) findViewById(R.id.dos);
                edittext3 = (EditText) findViewById(R.id.tres);
                edittext4 = (EditText) findViewById(R.id.cuatro);
                filePath = new StringBuffer();
                filePath.append("/sdcard/abc.csv");
                file = new File(filePath.toString());
                csv = new CSVFileWriter(file);
                csv.writeHeader(edittext1.getText().toString());

                csv.writeHeader(edittext2.getText().toString());
                csv.writeHeader(edittext3.getText().toString());
                csv.writeHeader(edittext4.getText().toString());
                Toast.makeText(getApplicationContext(), "datos guardados", Toast.LENGTH_SHORT).show();
            }catch (Exception e){

                Toast.makeText(getApplicationContext(), "e", Toast.LENGTH_SHORT).show();
            }
    }

public void ver(View view) {



    ed = (EditText) findViewById(R.id.pe);
        try {

            FileInputStream fileIN = new FileInputStream("/sdcard/abc.csv");
            BufferedReader buffer = new BufferedReader(new InputStreamReader(fileIN));
            String readString = new String();
            while ((readString = buffer.readLine()) != null) {
                //ed.(getClass().getName() + "edittext1: ", readString);
                ed.setText(readString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }











