package com.example.android.twoactivitylifecycle;
import android.content.Intent;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.util.Log;
 import android.view.View;
 import android.widget.EditText;
 import android.widget.TextView;
public class SecondActivity extends AppCompatActivity {
     // Unique tag for the intent reply.
            public static final String EXTRA_REPLY =
                       "com.example.android.twoactivitieslifecycle.extra.REPLY";


           // Class name for Log tag.
            private static final String LOG_TAG = SecondActivity.class.getSimpleName();


            // EditText for the reply.
          private EditText mReply = null;

            @Override
     protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_second_life_cycle);


                // Initialize view variables.
               mReply = (EditText) findViewById(R.id.editText_second);


                // Get the intent that launched this activity, and the message in
                // the intent extra.
                Intent intent = getIntent();
                String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);


               // Put that message into the text_message TextView
                TextView textView = (TextView) findViewById(R.id.text_message);
                if (textView != null) {
                       textView.setText(message);
                    }


                 Log.d(LOG_TAG, "-------");
                Log.d(LOG_TAG, "onCreate");
            }
          public void returnReply(View view) {
                // Get the reply message from the edit text.
            String reply = mReply.getText().toString();



               Intent replyIntent = new Intent();
                replyIntent.putExtra(EXTRA_REPLY, reply);
                setResult(RESULT_OK, replyIntent);


               Log.d(LOG_TAG, "End SecondaryActivity");


               finish();
            }

           @Override
    protected void onStart() {
                super.onStart();
                Log.d(LOG_TAG, "onStart");
           }
            @Override
    public void onRestart() {
                super.onRestart();
                Log.d(LOG_TAG, "onRestart");
            }
             @Override
     public void onResume() {
               super.onResume();
                Log.d(LOG_TAG, "onResume");
            }
            @Override
     public void onPause() {
                super.onPause();
                Log.d(LOG_TAG, "onPause");
           }



             @Override
    public void onStop() {
                 super.onStop();
                 Log.d(LOG_TAG, "onStop");
             }

             @Override
    public void onDestroy() {
                 super.onDestroy();
                Log.d(LOG_TAG, "onDestroy");
            }
 }





