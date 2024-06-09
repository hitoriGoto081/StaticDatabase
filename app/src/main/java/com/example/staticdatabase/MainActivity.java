package com.example.staticdatabase;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button prosesBtn = findViewById(R.id.proses);
        final TextView hasilTextView = findViewById(R.id.hasil_text_view);
        final ScrollView scrollView = findViewById(R.id.main);
        final RelativeLayout layout = findViewById(R.id.layout1);

        prosesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText namaET = findViewById(R.id.ip_nama);
                EditText nimET = findViewById(R.id.ip_nim);
                EditText jurusanET = findViewById(R.id.ip_jurusan);
                EditText absenET = findViewById(R.id.nilai_absen);
                EditText tugasET = findViewById(R.id.nilai_tugas);
                EditText midET = findViewById(R.id.nilai_mid);
                EditText finalET = findViewById(R.id.nilai_final);

                String nama = namaET.getText().toString();
                String nim = nimET.getText().toString();
                String jurusan = jurusanET.getText().toString();
                String absenStr = absenET.getText().toString();
                String tugasStr = tugasET.getText().toString();
                String midStr = midET.getText().toString();
                String finalStr = finalET.getText().toString();

                double absen = Double.parseDouble(absenStr);
                double tugas = Double.parseDouble(tugasStr);
                double mid = Double.parseDouble(midStr);
                double finalScore = Double.parseDouble(finalStr);

                if (TextUtils.isEmpty(nama) || TextUtils.isEmpty(nim) || TextUtils.isEmpty(jurusan) ||
                        TextUtils.isEmpty(absenStr) || TextUtils.isEmpty(tugasStr) || TextUtils.isEmpty(midStr) ||
                        TextUtils.isEmpty(finalStr)) {
                    hasilTextView.setText("Semua input harus diisi.");
                    return;
                }

                double nilaiAkhir = hitungNilaiAkhir(absen, tugas, mid, finalScore);
                String nilaiHuruf;

                if(absen == 0 || tugas == 0 || mid == 0 || finalScore == 0){
                    nilaiHuruf = "E";
                }
                else {
                    nilaiHuruf = hitungNilaiHuruf(nilaiAkhir);
                }
                String keterangan = hitungKeterangan(nilaiHuruf);

                String hasil = "Nama : " + nama + "\n" +
                        "Nim : " + nim + "\n" +
                        "Jurusan : " + jurusan + "\n" +
                        "Nilai Absen : " + (int)absen + "\n" +
                        "Nilai Tugas : " + (int)tugas + "\n" +
                        "Nilai Mid : " + (int)mid + "\n" +
                        "Nilai Final : " + (int)finalScore + "\n" +
                        "Nilai Akhir : " + nilaiAkhir + "\n" +
                        "Nilai Huruf : " + nilaiHuruf + "\n" +
                        "Keterangan : " + keterangan;

                hasilTextView.setText(hasil);
//                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }

    private double hitungNilaiAkhir(double absen, double tugas, double mid, double finalScore) {
        double nilaiAkhir = (absen * 0.2) + (tugas * 0.3) + (mid * 0.25) + (finalScore * 0.25);
        return nilaiAkhir;
    }

    private String hitungNilaiHuruf(double nilaiAkhir) {
        if(nilaiAkhir > 100){
            return "Tidak Terdefinisi";
        }
        if (nilaiAkhir >= 86 && nilaiAkhir <= 100) {
            return "A";
        } else if (nilaiAkhir >= 81 && nilaiAkhir <= 85) {
            return "A-";
        } else if (nilaiAkhir >= 76 && nilaiAkhir <= 80) {
            return "B+";
        } else if (nilaiAkhir >= 71 && nilaiAkhir <= 75) {
            return "B";
        } else if (nilaiAkhir >= 66 && nilaiAkhir <= 70) {
            return "B-";
        } else if (nilaiAkhir >= 61 && nilaiAkhir <= 65) {
            return "C+";
        } else if (nilaiAkhir >= 56 && nilaiAkhir <= 60) {
            return "C";
        } else if (nilaiAkhir >= 41 && nilaiAkhir <= 55) {
            return "D";
        } else {
            return "E";
        }
    }

    private String hitungKeterangan(String nilaiHuruf) {
        if (nilaiHuruf.equals("A") || nilaiHuruf.equals("A-") || nilaiHuruf.equals("B") || nilaiHuruf.equals("B-")) {
            return "LULUS";
        } else if (nilaiHuruf.equals("C+") || nilaiHuruf.equals("C")) {
            return "HAMPIR TIDAK LULUS";
        }
        else if(nilaiHuruf.equals("Tidak Terdefinisi")){
            return "Tidak Terdefinisi";
        }
        else {
            return "HAMPIR LULUS";
        }
    }
}

