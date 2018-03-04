package cardapiodepratos.com.cardapiodepratos;

import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;

public class ActCadPratos extends AppCompatActivity {

    EditText edtNomeDoPrato;
    EditText edtDescricaoPrato;
    EditText edtPreco;
    EditText edtURLdaFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_cad_pratos);
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtNomeDoPrato = (EditText)findViewById(R.id.edtNomeDoPrato);
        edtDescricaoPrato = (EditText)findViewById(R.id.edtDescricaoDoPrato);
        edtPreco = (EditText)findViewById(R.id.edtPreco);
        edtURLdaFoto = (EditText)findViewById(R.id.edtURLdaFoto);

    }
}
