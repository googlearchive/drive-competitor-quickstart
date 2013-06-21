package org.aliafshar.competitorquickstart;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.app.Activity;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    final static int actionCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
            dispatchTakePictureIntent();
          }
       });
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
      if (requestCode == actionCode) {
        if (resultCode == RESULT_OK)
          handleSmallCameraPhoto(data);
      }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void saveToCloud(Bitmap imageBitmap) {
       // IMPLEMENT SOMETHING HERE!!!
        Log.i("Competitor Analysis example.", "Photo taken: " + imageBitmap.toString());
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, actionCode);
    }

    private void handleSmallCameraPhoto(Intent intent) {
        Bundle extras = intent.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        saveToCloud(imageBitmap);
    }

}
