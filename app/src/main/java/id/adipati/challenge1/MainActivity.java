package id.adipati.challenge1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import id.adipati.challenge1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView((View) binding.getRoot());
    }

    // https://stackoverflow.com/a/2091482/5832341
    public void cekData(View view){
        Intent intent = new Intent(getApplicationContext(), TampilActivity.class);

        intent.putExtra("nama", binding.txtNama.getText().toString());
        intent.putExtra("tahun_lahir",  Integer.valueOf(binding.txtTahunLahir.getText().toString()));
        intent.putExtra("jenis", ((RadioButton) findViewById(binding.rgJenis.getCheckedRadioButtonId())).getText().toString());
        intent.putExtra("status", binding.spStatus.getSelectedItem().toString());

        startActivity(intent);
    }
}