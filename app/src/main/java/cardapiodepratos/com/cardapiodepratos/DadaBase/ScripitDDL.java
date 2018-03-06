package cardapiodepratos.com.cardapiodepratos.DadaBase;

/**
 * Created by Antonio Carlos on 05/03/2018.
 */

public class ScripitDDL {

    public static String getCreateTableCardapio(){
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE IF NOT EXISTS CARDAPIO(");
        sql.append("    CODIGO          INTERGER      PRYMARY AUTOINCREMENT NOT NULL,");
        sql.append("    NOMEPRATO       VARCHAR(250)  NOT NULL DEFAULT(''),");
        sql.append("    DESCRICAOPRATO  VARRCHAR(255) NOT NULL DEFAULT(''),");
        sql.append("    PRECO           VARCHAR(20)   NOT NULL DEFAULT(''),");
        sql.append("    URLDAFOTO       VARCHAR(255)  NOT NULL DEFAULT('') )");

        return sql.toString();

    }



}
