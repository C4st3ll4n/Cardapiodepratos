package cardapiodepratos.com.cardapiodepratos;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.*;

import cardapiodepratos.com.cardapiodepratos.DadaBase.DadosOpenHelper;
import cardapiodepratos.com.cardapiodepratos.Dominio.Entidades.Pratos;
import cardapiodepratos.com.cardapiodepratos.Dominio.Repositorio.PratoRepositorio;

public class ActCadPratos extends AppCompatActivity {

    EditText edtNomeDoPrato;
    EditText edtDescricaoPrato;
    EditText edtPreco;
    EditText edtURLdaFoto;

    private ConstraintLayout LayoutContat_Cad_Pratos;

    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;
    private PratoRepositorio pratoRepositorio;

    private Pratos pratos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_cad_pratos);
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

<<<<<<< HEAD
        edtNomeDoPrato = findViewById(R.id.edtNomeDoPrato);
        edtDescricaoPrato = findViewById(R.id.edtDescricaoDoPrato);
        edtPreco = findViewById(R.id.edtPreco);
        edtURLdaFoto = findViewById(R.id.edtURLdaFoto);

=======
        edtNomeDoPrato    = (EditText)findViewById(R.id.edtNomeDoPrato);
        edtDescricaoPrato = (EditText)findViewById(R.id.edtDescricaoDoPrato);
        edtPreco          = (EditText)findViewById(R.id.edtPreco);
        edtURLdaFoto      = (EditText)findViewById(R.id.edtURLdaFoto);

        LayoutContat_Cad_Pratos = (ConstraintLayout)findViewById(R.id.LayoutContat_Cad_Pratos);

        criarConexao();
    }

    private void criarConexao(){
        try {

            dadosOpenHelper = new DadosOpenHelper(this);

            conexao = dadosOpenHelper.getWritableDatabase();

            Snackbar.make(LayoutContat_Cad_Pratos, R.string.message_conexao_criada_com_secesso, Snackbar.LENGTH_SHORT)
                    .setAction(R.string.lbl_ok, null).show();

            pratoRepositorio = new PratoRepositorio(conexao);

        }catch(SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.title_erro);
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton(R.string.lbl_ok,null);
            dlg.show();
        }
    }

    private void confirmar(){

        pratos = new Pratos();

        if (validaCampos() == false){
            try {

                pratoRepositorio.inserir(pratos);

                finish();

            }catch(SQLException ex){

                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle(R.string.title_erro);
                dlg.setMessage(ex.getMessage());
                dlg.setNeutralButton(R.string.lbl_ok,null);
                dlg.show();
            }
        }

    }

    private boolean validaCampos(){

        boolean res = false;

        String nomePrato      = edtNomeDoPrato.getText().toString();
        String DescricaoPrato = edtDescricaoPrato.getText().toString();
        String preco          = edtPreco.getText().toString();
        String URLdaFoto      = edtURLdaFoto.getText().toString();

        pratos.nomePrato = nomePrato;
        pratos.DescriçaoPrato = DescricaoPrato;
        pratos.Preco = preco;
        pratos.URLdaFoto = URLdaFoto;

        if (res = isCampoVazio(nomePrato)){
            edtNomeDoPrato.requestFocus();
        }else
            if (res = isCampoVazio(DescricaoPrato)){
                edtDescricaoPrato.requestFocus();
            }else
                if (res = isCampoVazio(preco)){
                edtPreco.requestFocus();
            }else
                if (res = isCampoVazio(URLdaFoto)){
                    edtURLdaFoto.requestFocus();
                }

                if (res){
                    AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                    dlg.setTitle(R.string.title_aviso);
                    dlg.setMessage(R.string.message_campos_invalidos_Brancos);
                    dlg.setNeutralButton(R.string.lbl_ok, null);
                    dlg.show();
                }
        return res;
    }

    private boolean isCampoVazio(String valor){
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_cad_pratos, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getGroupId();

        switch (id){
            case R.id.action_OK:
                confirmar();
                //Toast.makeText(this,"Botão OK selecionado", Toast.LENGTH_SHORT).show();
                break;

                case R.id.action_cancelar:
                Toast.makeText(this,"Botão Cancelar selecionado", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
>>>>>>> 77a179c3cea1a413ea37f35dc09d6363f69cb637

        return super.onOptionsItemSelected(item);
    }
}
