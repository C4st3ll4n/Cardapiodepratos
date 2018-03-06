package cardapiodepratos.com.cardapiodepratos;

import android.content.Intent;
<<<<<<< HEAD
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
=======
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cardapiodepratos.com.cardapiodepratos.DadaBase.DadosOpenHelper;

>>>>>>> 77a179c3cea1a413ea37f35dc09d6363f69cb637

public class MainActivity extends AppCompatActivity {

    private RecyclerView lstDados;
    private FloatingActionButton fab;

    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;
    private ConstraintLayout LayoutlistaCardaoioMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        lstDados = (RecyclerView)findViewById(R.id.lstDados);
        LayoutlistaCardaoioMain = (ConstraintLayout) findViewById(R.id.LayoutlistaCardaoioMain);

        criarConexao();
    }

    private void criarConexao(){
        try {

            dadosOpenHelper = new DadosOpenHelper(this);

            conexao = dadosOpenHelper.getWritableDatabase();

            Snackbar.make(LayoutlistaCardaoioMain, R.string.message_conexao_criada_com_secesso, Snackbar.LENGTH_SHORT)
                .setAction(R.string.lbl_ok, null).show();

        }catch(SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.title_erro);
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton(R.string.lbl_ok,null);
            dlg.show();
        }
    }

    public void cadastrar (View view){
        Intent it = new Intent(MainActivity.this, ActCadPratos.class);
        startActivity(it);
    }

    public void goToLista(View v){
        Intent t = new Intent(this,ActCadPratos.class);
        startActivity(t);
    }
}
