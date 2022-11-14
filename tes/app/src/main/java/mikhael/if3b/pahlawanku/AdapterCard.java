package mikhael.if3b.pahlawanku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.Instant;
import java.util.ArrayList;

public class AdapterCard extends
RecyclerView.Adapter<AdapterCard.CardViewHolder>{
    private ArrayList<Modelpahlawan> dataPahlawan;
    private Instant Glide;

    public AdapterCard(ArrayList<Modelpahlawan> dataPahlawan)
    {
        this.dataPahlawan = dataPahlawan;
    }
    @NonNull
    @Override
    public CardViewHolder onCreatViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Modelpahlawan pahlawan = dataPahlawan.get(position);

        holder.tvNama.setText(pahlawan.getNama());
        holder.tvTentang.setText(pahlawan.getTentang());


        Glide.with(holder.itemView.getContext()).load(pahlawan.getFoto()).apply(new RequestOption().override(350,550)).into(holder.ivFoto);
    }
    
    public class CardViewHolder extends
            RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvNama, tvTentang;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.iv_foto);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvTentang = itemView.findViewById(R.id.tv_tentang);
        }
    }
}
