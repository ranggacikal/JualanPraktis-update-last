package www.starcom.com.jualanpraktis.SubKategori;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import www.starcom.com.jualanpraktis.R;

/**
 * Created by ADMIN on 06/02/2018.
 */

public class holdersub extends RecyclerView.ViewHolder {

    public ImageView gambar ;
    public LinearLayout linearWa, linearFb, linearSalin;
    public Button btnWa;
    public TextView nama_produk,harga_jual,harga_asli,diskon,txtTerjual ;
    public CardView cardView;
    public TextView txtStok, txtKota;
    public RelativeLayout relativeStokHabis;
   // public SimpleDraweeView draweeView;


    public holdersub(View itemView) {
        super(itemView);
        gambar = itemView.findViewById(R.id.gambar_kategori);
        nama_produk = itemView.findViewById(R.id.nama_produk);
        harga_jual = itemView.findViewById(R.id.harga_jual);
        harga_asli = itemView.findViewById(R.id.harga_asli);
        diskon = itemView.findViewById(R.id.diskon);
        cardView = itemView.findViewById(R.id.cardview);
        linearFb = itemView.findViewById(R.id.share_fb_home);
        linearWa = itemView.findViewById(R.id.share_whatsapp_home);
        linearSalin = itemView.findViewById(R.id.share_salin_home);
        txtStok = itemView.findViewById(R.id.item_id_stock_produk);
        txtTerjual = itemView.findViewById(R.id.text_id_qty_produk_dibeli);
        txtKota = itemView.findViewById(R.id.kota_produk);
        relativeStokHabis = itemView.findViewById(R.id.relative_stok_habis);
    }
}
