package com.mehmetarikan.dgspuanhesaplama;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    Button hesapla;
    EditText td,ty,md,my,op;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        MobileAds.initialize(this, "ca-app-pub-3194507391897588~5474540036");
        final InterstitialAd mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3194507391897588/9825559023");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();

            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mInterstitialAd.show();
            }
        });


    }

    public void hesaplaClick(View view) {

        int sayiver = 0;
        hesapla = findViewById(R.id.hesapla);
        td = findViewById(R.id.td);
        ty = findViewById(R.id.ty);
        md = findViewById(R.id.md);
        my = findViewById(R.id.my);
        op = findViewById(R.id.op);

        if (td.getText().toString().isEmpty()) {
            td.setText("0");
        }

        if (ty.getText().toString().isEmpty()) {
            ty.setText("0");
        }
        if (md.getText().toString().isEmpty()) {
            md.setText("0");
        }
        if (my.getText().toString().isEmpty()) {
            my.setText("0");
        }
        if (op.getText().toString().isEmpty()) {
            op.setText("40");
        }





        double turkcedogrusayisi = Double.parseDouble(td.getText().toString());
        double turkceyanlissayisi = Double.parseDouble(ty.getText().toString());
        double matematikdogrusayisi = Double.parseDouble(md.getText().toString());
        double matematikyanlissayisi = Double.parseDouble(my.getText().toString());
        double opuani = Double.parseDouble(op.getText().toString());



                if (turkcedogrusayisi < 0 || turkcedogrusayisi > 61) {
                    Toast.makeText(this, "Türkçe doğru sayınız; 0-60 arasında olmalıdır.", Toast.LENGTH_LONG).show();
                    td.setText("30");
                    Toast.makeText(this, "Varsayılan değerler atanarak hesaplama yapıldı.", Toast.LENGTH_LONG).show();
                }

                if (turkceyanlissayisi < 0 || turkceyanlissayisi > 61) {
                    Toast.makeText(this, "Türkçe yanlış sayınız; 0-60 arasında olmalıdır.", Toast.LENGTH_LONG).show();
                    ty.setText("30");
                    Toast.makeText(this, "Varsayılan değerler atanarak hesaplama yapıldı.", Toast.LENGTH_LONG).show();
                }
                if (matematikdogrusayisi < 0 || matematikdogrusayisi > 61) {
                    Toast.makeText(this, "Matematik doğru sayınız; 0-60 arasında olmalıdır.", Toast.LENGTH_LONG).show();
                    md.setText("30");
                    Toast.makeText(this, "Varsayılan değerler atanarak hesaplama yapıldı.", Toast.LENGTH_LONG).show();
                }
                if (matematikyanlissayisi < 0 || matematikyanlissayisi > 61) {
                    Toast.makeText(this, "Matematik yanlış sayınız; 0-60 arasında olmalıdır.", Toast.LENGTH_LONG).show();
                    my.setText("30");
                    Toast.makeText(this, "Varsayılan değerler atanarak hesaplama yapıldı.", Toast.LENGTH_LONG).show();
                }
                if (opuani < 40 || opuani > 81) {
                    Toast.makeText(this, "OBP Puanınız; 40-80 arasında olmalıdır.", Toast.LENGTH_LONG).show();
                    op.setText("60");
                    Toast.makeText(this, "Varsayılan değerler atanarak hesaplama yapıldı.", Toast.LENGTH_LONG).show();
                }

                Intent intent = new Intent(MainActivity.this,Puan.class);
                intent.putExtra("td",turkcedogrusayisi);
                intent.putExtra("ty",turkceyanlissayisi);
                intent.putExtra("md",matematikdogrusayisi);
                intent.putExtra("my",matematikyanlissayisi);
                intent.putExtra("op",opuani);
                startActivity(intent);

    }


}
