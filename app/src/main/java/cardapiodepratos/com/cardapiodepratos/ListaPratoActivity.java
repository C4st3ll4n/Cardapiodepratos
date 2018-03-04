package cardapiodepratos.com.cardapiodepratos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaPratoActivity extends AppCompatActivity {
    ListView lw;
    Prato pt[] = {new Prato("Carne assada com batatas coradas","Acompanha arroz branco e batatas coradas.",22.9),
                  new Prato("Picanha com fritas","Picanha com fritas e salada.",39.9),
                  new Prato("Filé à parmegiana","Filé mignon à milanesa, arroz branco e batata frita",35.0),
                  new Prato("Frango à Milanesa","Arroz à Grega e Fritas.",23.9)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_prato);
        lw = findViewById(R.id.lw);
        String[] nome_prato = null;
        for (int c = 0; c < pt.length; c++){
            nome_prato[c] = pt[c].getNome();
        }

        ArrayAdapter<String> ad = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1,nome_prato);

        lw.setAdapter(ad);
    }
}
