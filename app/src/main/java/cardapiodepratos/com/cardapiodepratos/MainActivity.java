package cardapiodepratos.com.cardapiodepratos;

import android.annotation.SuppressLint;
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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import cardapiodepratos.com.cardapiodepratos.DadaBase.DadosOpenHelper;
import cardapiodepratos.com.cardapiodepratos.Dominio.Entidades.Pratos;
import cardapiodepratos.com.cardapiodepratos.Dominio.Repositorio.PratoRepositorio;

>>>>>>> 77a179c3cea1a413ea37f35dc09d6363f69cb637

public class MainActivity extends AppCompatActivity {

    private RecyclerView lstDados;
    private FloatingActionButton fab;

    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;
    private ConstraintLayout LayoutlistaCardaoioMain;

    private PratoAdapet pratoAdapet;

    private PratoRepositorio pratoRepositorio;

    private ImageView fotoImageView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        lstDados = (RecyclerView)findViewById(R.id.lstDados);
        LayoutlistaCardaoioMain = (ConstraintLayout) findViewById(R.id.LayoutlistaCardaoioMain);

        criarConexao();

        lstDados.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lstDados.setLayoutManager(linearLayoutManager);

        pratoRepositorio = new PratoRepositorio(conexao);

        List<Pratos> dados = pratoRepositorio.buscarPratos();

        pratoAdapet = new PratoAdapet(dados);

        lstDados.setAdapter(pratoAdapet);

        fotoImageView = (ImageView) findViewById(R.id.txtURLdaFoto);



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
