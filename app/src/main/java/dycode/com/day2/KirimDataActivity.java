package dycode.com.day2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KirimDataActivity extends AppCompatActivity {

    @BindView(R.id.edt_hasil_nama)
    EditText edtHasilNama;
    @BindView(R.id.result_age)
    TextView resultAge;
    @BindView(R.id.result_jk)
    TextView resultJk;
    @BindView(R.id.button_result_value)
    Button buttonResultValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kirim_data);
        ButterKnife.bind(this);

        Intent getData = getIntent();
        String nama = getData.getStringExtra(Constraint.nama);
        String umur = getData.getStringExtra(Constraint.umur);
        String jk = getData.getStringExtra(Constraint.jk);

        edtHasilNama.setText(nama);
        resultAge.setText("Umur :"+umur);
        resultJk.setText("Jenis Kelamin :"+jk);

    }

    @OnClick(R.id.button_result_value)
    public void onClick() {
        Intent intent = new Intent();
        intent.putExtra(Constraint.nama,edtHasilNama.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
