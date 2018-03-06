package cardapiodepratos.com.cardapiodepratos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cardapiodepratos.com.cardapiodepratos.Dominio.Entidades.Pratos;

/**
 * Created by Antonio Carlos on 05/03/2018.
 */

public class PratoAdapet extends RecyclerView.Adapter<PratoAdapet.ViewHolderPratos> {

    private List<Pratos> dados;

    public PratoAdapet(List<Pratos> dados){
        this.dados = dados;
    }

    @Override
    public PratoAdapet.ViewHolderPratos onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.linha_pratos, parent, false);

        ViewHolderPratos holderPratos = new ViewHolderPratos(view);

        return holderPratos;
    }

    @Override
    public void onBindViewHolder(PratoAdapet.ViewHolderPratos holder, int position) {

        if ( (dados != null) && (dados.size() > 0 )) {

            Pratos pratos = dados.get(position);

            holder.txtNomePrato.setText(pratos.nomePrato);
            holder.txtdescricaoPrato.setText(pratos.DescriçaoPrato);
            holder.txtPreco.setText(pratos.Preco);
            holder.txtURLdaFoto.setText(pratos.URLdaFoto);
        }
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ViewHolderPratos extends RecyclerView.ViewHolder{

        public TextView txtNomePrato;
        public TextView txtdescricaoPrato;
        public TextView txtPreco;
        public TextView txtURLdaFoto;

        public ViewHolderPratos(View itemView) {
            super(itemView);

            txtNomePrato = (TextView) itemView.findViewById(R.id.txtNomePrato);
            txtdescricaoPrato = (TextView) itemView.findViewById(R.id.txtdescricaoPrato);
            txtPreco = (TextView) itemView.findViewById(R.id.txtPreco);
            txtURLdaFoto = (TextView) itemView.findViewById(R.id.txtURLdaFoto);

        }
    }
}
