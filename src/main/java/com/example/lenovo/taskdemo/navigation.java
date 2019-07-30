package com.example.lenovo.taskdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , ExampleDialog.poplistner,BottomShet.bottomsheetlistner {
    private ImageView imageView1,imageView2;
    private CardView cv1,cv2,cv3,cv4,cv5,cv6,cv7,cv8,cv9,cv10,cv11,cv12;
   // private TextView textView;
    private static int PICK_IMAGE=123;
    private static int REQUEST_CAMERA=12;
    Uri image;



   @Override
   protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       super.onActivityResult(requestCode, resultCode, data);
       if (((requestCode == REQUEST_CAMERA)) && ((resultCode == RESULT_OK)) && data.getExtras() != null) {
           Bitmap tbitmap = ( Bitmap ) data.getExtras().get("data");
           imageView2.setImageBitmap(tbitmap);
       } else if (((requestCode == PICK_IMAGE)) && ((resultCode == RESULT_OK)) && data.getData() != null) {
           image = data.getData();
           imageView2.setImageURI(image);

       }
   }

   public void opendialog(){
       ExampleDialog exampleDialog= new ExampleDialog();
       exampleDialog.show(getSupportFragmentManager(),"Example Dialog");
   }

    @Override
    public void apply(String to, String subject, String message) {
        String[] To=to.split(",");
        Intent shareintent = new Intent();
        shareintent.setAction(Intent.ACTION_SEND);
        shareintent.setData(Uri.parse("mailto:"));
        shareintent.setType("text/plain");
        shareintent.putExtra(Intent.EXTRA_EMAIL,To);
        shareintent.putExtra(Intent.EXTRA_SUBJECT,subject);
        shareintent.putExtra(Intent.EXTRA_TEXT,message);
        try {
            startActivity(Intent.createChooser(shareintent,"Choose an Email"));
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
   }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


       // textView=findViewById(R.id.hprofile);
        cv1=findViewById(R.id.mobilerecharge);
        cv2=findViewById(R.id.dth);
        cv3=findViewById(R.id.moviebook);
        cv4=findViewById(R.id.trainbook);
        cv5=findViewById(R.id.hotelbook);
        cv6=findViewById(R.id.shop);
        cv7=findViewById(R.id.mouse);
        cv8=findViewById(R.id.keyboard);
        cv9=findViewById(R.id.headphone);
        cv10=findViewById(R.id.pendrive);
        cv11=findViewById(R.id.speaker);
        cv12=findViewById(R.id.location);
        imageView1=findViewById(R.id.myprofile);
       // imageView2=findViewById(R.id.himage);

        Animation UD= AnimationUtils.loadAnimation(this,R.anim.anim1);
        imageView1.setAnimation(UD);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(navigation.this, profile.class));
            }
        });

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browse =new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.paytm.com/recharge"));
                startActivity(browse);
            }
        });
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browse =new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.paytm.com/dth-recharge"));
                startActivity(browse);
            }
        });
        cv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browse =new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.flipkart.com"));
                startActivity(browse);
            }
        });
        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browse =new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.paytm.com/train-tickets"));
                startActivity(browse);
            }
        });
        cv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browse =new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.oyorooms.com"));
                startActivity(browse);
            }
        });
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browse =new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.bookmyshow.com"));
                startActivity(browse);
            }
        });
        cv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(navigation.this, thanks.class));
                overridePendingTransition(R.anim.animactivitity1,R.anim.animactivity2);
            }
        });
        cv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(navigation.this, thanks.class));
                overridePendingTransition(R.anim.animactivitity1,R.anim.animactivity2);
            }
        });
        cv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(navigation.this, thanks.class));
                overridePendingTransition(R.anim.animactivitity1,R.anim.animactivity2);
            }
        });
        cv10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(navigation.this, thanks.class));
                overridePendingTransition(R.anim.animactivitity1,R.anim.animactivity2);
            }
        });
        cv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(navigation.this, thanks.class));
                overridePendingTransition(R.anim.animactivitity1,R.anim.animactivity2);
            }
        });
        cv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:28.671988, 77.419887"));
                Intent chooser=Intent.createChooser(intent,"Launch Map");
                startActivity(chooser);
                }
        });
        /*

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(navigation.this, profile.class));
            }
        });*/

        FloatingActionButton fab = ( FloatingActionButton ) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomShet bottomShet=new BottomShet();
                bottomShet.show(getSupportFragmentManager(),"Bottomsheet");

            }
        });


        Toolbar toolbar = ( Toolbar ) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = ( DrawerLayout ) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = ( NavigationView ) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = ( DrawerLayout ) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if(id == R.id.Logout){
            startActivity(new Intent(navigation.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
          Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
          startActivityForResult(intent,REQUEST_CAMERA);
        }
        else if (id == R.id.contact) {
            Intent contactintent = new Intent(Intent.ACTION_DIAL);
            contactintent.setData(Uri.parse("tel:7838102821"));
            startActivity(contactintent);

        }  else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {
            Intent shareintent = new Intent();
            shareintent.setAction(Intent.ACTION_SEND);
            shareintent.putExtra(Intent.EXTRA_TEXT,"http://play.google.com/store/apps/details?id="+ getApplicationContext().getPackageName());
            shareintent.setType("text/plain");
            startActivity(Intent.createChooser(shareintent,"share via"));

        } else if (id == R.id.nav_send) {
            opendialog();

        }

        DrawerLayout drawer = ( DrawerLayout ) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void listner(int i) {
       switch (i){
           case 1:Intent browse =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paytm.com"));
                  startActivity(browse);
                  break;
           case 2:Intent hbrowse =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hdfcbank.com"));
                  startActivity(hbrowse);
                  break;
           case 3: Intent abrowse =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.axisbank.com"));
                   startActivity(abrowse);
                   break;
           case 4: Intent pbrowse =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paytm.com"));
                   startActivity(pbrowse);
                   break;
       }

   }
}