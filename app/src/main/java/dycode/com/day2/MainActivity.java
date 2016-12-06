package dycode.com.day2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editText_nama)
    EditText editTextNama;
    @BindView(R.id.editText_umur)
    EditText editTextUmur;
    @BindView(R.id.spinner_jk)
    Spinner spinnerJk;
    @BindView(R.id.button_kirim)
    Button buttonKirim;
    @BindView(R.id.button_hapus)
    Button buttonHapus;

    String[] jenis_kelamin = {"Laki-Laki", "Perempuan"};
    String hasil_pilih = null;

    String status = "Android: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, jenis_kelamin);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJk.setAdapter(arrayAdapter);

        spinnerJk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hasil_pilih = jenis_kelamin[i];
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if (resultCode==RESULT_OK){
                String result = data.getStringExtra(Constraint.nama);
                editTextNama.setText(result);
            }
        }
    }

    @OnClick({R.id.button_kirim, R.id.button_hapus})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_kirim:
                Intent intent = new Intent(getApplicationContext(), KirimDataActivity.class);
                intent.putExtra(Constraint.nama, editTextNama.getText().toString());
                intent.putExtra(Constraint.umur, editTextUmur.getText().toString());
                intent.putExtra(Constraint.jk, hasil_pilih);
                startActivityForResult(intent, 1);

                break;
            case R.id.button_hapus:
                editTextNama.setText("");
                editTextUmur.setText("");
                break;
        }
    }
}
