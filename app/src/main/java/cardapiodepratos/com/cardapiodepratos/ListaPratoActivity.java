package cardapiodepratos.com.cardapiodepratos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collection;

public class ListaPratoActivity extends AppCompatActivity {
    ListView lw;
    Prato pt[] = {new Prato("Carne assada com batatas coradas","Acompanha arroz branco e batatas coradas.",22.9),
                  new Prato("Picanha com fritas","Picanha com fritas e salada.",39.9),
                  new Prato("Filé à parmegiana","Filé mignon à milanesa, arroz branco e batata frita",35.0),
                  new Prato("Frango à Milanesa","Arroz à Grega e Fritas.",23.9)
    };

    String[] nomes = new String[pt.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_prato);
        lw = findViewById(R.id.lw);

        for (int c = 0; c < pt.length; c++){
            String temp = pt[c].getNome();
            nomes[c] = temp;
        }

        ArrayAdapter ad = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1,nomes);

        lw.setAdapter(ad);
    }
}
