package cardapiodepratos.com.cardapiodepratos.Dominio.Repositorio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cardapiodepratos.com.cardapiodepratos.Dominio.Entidades.Pratos;



/**
 * Created by Antonio Carlos on 05/03/2018.
 */

public class PratoRepositorio {

    private SQLiteDatabase conexao;

    public PratoRepositorio(SQLiteDatabase conexao){
        this.conexao = conexao;
    }

    public void inserir(Pratos prato){
        ContentValues contentValues = new ContentValues();
        contentValues.put("NOMEPRATO", prato.nomePrato);
        contentValues.put("DESCRICAOPRATO", prato.DescriçaoPrato);
        contentValues.put("PRECO", prato.Preco);
        contentValues.put("URLDAFOTO", prato.URLdaFoto);

        conexao.insertOrThrow("CARDAPIO", null, contentValues);
    }

    public void excluir(int codigo){
        String[] parametros = new String[1];
        parametros[0] = String.valueOf(codigo);

        conexao.delete("CARDAPIO",  "CODIGO = ?", parametros);
    }

    public void alterar(Pratos prato){
        ContentValues contentValues = new ContentValues();
        contentValues.put("NOMEPRATO", prato.nomePrato);
        contentValues.put("DESCRICAOPRATO", prato.DescriçaoPrato);
        contentValues.put("PRECO", prato.Preco);
        contentValues.put("URLDAFOTO", prato.URLdaFoto);

        String[] parametros = new String[1];
        parametros[0] = String.valueOf(prato.codigo);

        conexao.update("CARDAPIO", contentValues, "CODIGO = ?", parametros);

    }

    public List<Pratos> buscarPratos(){

        List<Pratos> pratos = new ArrayList<Pratos>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CODIGO, NOMEPRATO, DESCRICAOPRATO, PRECO, URLDAFOTO");
        sql.append("FROM CARDAPIO");

        Cursor resultado = conexao.rawQuery(sql.toString(),null);

        if (resultado.getCount() > 0) {

            resultado.moveToFirst();

            do {

                Pratos pra = new Pratos();

                pra.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("CODIGO"));
                pra.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("NOMEPRATO"));
                pra.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("DESCRICAOPRATO"));
                pra.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("PRECO"));
                pra.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("URLDAFOTO"));

                pratos.add(pra);

            }while (resultado.moveToNext());
        }

        return pratos;
    }

    public Pratos buscarPratos(int codigo){

        Pratos pratos = new Pratos();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CODIGO, NOMEPRATO, DESCRICAOPRATO, PRECO, URLDAFOTO");
        sql.append("FROM CARDAPIO");
        sql.append("WHERE CODICO = ?");

        String[] parametros = new String[1];
        parametros[0] = String.valueOf(codigo);

        Cursor resultado = conexao.rawQuery(sql.toString(),parametros);

        if (resultado.getCount() > 0) {

            resultado.moveToFirst();

            pratos.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("CODIGO"));
            pratos.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("NOMEPRATO"));
            pratos.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("DESCRICAOPRATO"));
            pratos.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("PRECO"));
            pratos.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("URLDAFOTO"));

            return pratos;
        }
            return null;
    }
}
