package com.example.lenovo.taskdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class profile extends AppCompatActivity {
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ImageView imageView1, imageView2;
    FileOutputStream outputStream = null;
    BitmapDrawable drawable;
    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView1 = findViewById(R.id.resume);
        imageView2 = findViewById(R.id.resume1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.download, menu);
        return true;
    }
    private File getdisc(){
        File Pictures = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        return new File(Pictures,"Images Demo");
    }
    private Bitmap viewToBitmap(ImageView imageView1, int width, int height) {
        bitmap=Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        return bitmap;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.download: {
                File file=getdisc();
                if(!file.exists()&& !file.mkdir()) {
                    Toast.makeText(profile.this, "Can't create directory", Toast.LENGTH_SHORT).show();
                }
                SimpleDateFormat simpleD= new SimpleDateFormat("yyyymmsshhmss");
                String data= simpleD.format(new Date());
                String name="Img"+data+".jpg";
                String file_name=file.getAbsolutePath()+"/"+name;
                File new_file=new File(file_name);
                try{
                    outputStream = new FileOutputStream(new_file);
                    bitmap = viewToBitmap(imageView1,imageView1.getWidth(),imageView1.getHeight());
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
                    Toast.makeText(this,"Image Saved",Toast.LENGTH_SHORT).show();
                    outputStream.flush();
                    outputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent=new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intent.setData(Uri.fromFile(new_file));
                sendBroadcast(intent);



                /*drawable=(BitmapDrawable) imageView1.getDrawable();
                bitmap = drawable.getBitmap();
                FileOutputStream outputStream=null;

                File Pictures = Environment.getExternalStorageDirectory();
                File dir= new File(Pictures.getAbsolutePath()+"/Demo");
                dir.mkdir();
                File outfile=new File(dir,System.currentTimeMillis()+".jpg");
               // String file= String.format("%d.jpg",System.currentTimeMillis());
               // File outfile=new File(dir,file);

                try{
                    outputStream= new FileOutputStream(outfile);
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
                    outputStream.flush();
                    outputStream.close();
                    Intent intent=new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                    intent.setData(Uri.fromFile(outfile));
                    sendBroadcast(intent);
                    Toast.makeText(getApplicationContext(),"Image Saved",Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();

                }
                */

            }
        }
            return super.onOptionsItemSelected(item);

    }


}