package id.adipati.challenge1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import id.adipati.challenge1.databinding.ActivityTampilBinding;

public class TampilActivity extends AppCompatActivity {
    public ActivityTampilBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTampilBinding.inflate(getLayoutInflater());
        setContentView((View) binding.getRoot());

        String nama = getIntent().getStringExtra("nama");
        Integer tahunLahir = getIntent().getIntExtra("tahun_lahir", 1970);
        String jenis = getIntent().getStringExtra("jenis");
        String status = getIntent().getStringExtra("status");

        Toast.makeText(getApplicationContext(),
                "Mohon Tunggu...\nnama:" + nama
                        + "\ntahun:" + tahunLahir.toString()
                        + "\njenis:" + jenis
                        + "\nstatus:" + status,
                Toast.LENGTH_LONG).show();

        new android.os.Handler(Looper.getMainLooper()).postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Integer umur = Calendar.getInstance().get(Calendar.YEAR) - tahunLahir;
                        binding.txtData.setText(
                                "Halo, " + nama + ". Terimakasih sudah menggunakan aplikasi kami.\n\n"
                                + "kami mendapatkan bahwa pada " + status + "mu di umur ke-" + umur
                                        + " akan menjadi " + jenis + " yang bahagia dan sentosa.\n\n"
                                + "Maka dari itu, terima kasih atas waktunya dan semoga harimu menyenangkan."
                        );
                    }
                },
        400);
    }

    public void btnKembali(View view){
        finish();
    }
}