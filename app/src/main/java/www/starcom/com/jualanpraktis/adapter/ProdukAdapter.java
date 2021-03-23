package www.starcom.com.jualanpraktis.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import www.starcom.com.jualanpraktis.MainActivity;
import www.starcom.com.jualanpraktis.R;
import www.starcom.com.jualanpraktis.feature.produk.ProdukDetailActivity;
import www.starcom.com.jualanpraktis.SubKategori.holdersub;
import www.starcom.com.jualanpraktis.feature.pembayaran.FormatText;
import www.starcom.com.jualanpraktis.model.ListProduk;

/**
 * Created by ADMIN on 06/02/2018.
 */

public class ProdukAdapter extends RecyclerView.Adapter<holdersub> {

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    private List<ListProduk.ObjectSub.Results> results ;
    private List<ListProduk.ObjectSub.Results> dataFilter;
    private String statusList;
    public Context context;

    private static final String RP = "Rp.";

    public ProdukAdapter(Context context, List<ListProduk.ObjectSub.Results> results,String statusList){
        this.context = context;
        this.results = results ;
        this.dataFilter = results;
        this.statusList = statusList;
    }

    @Override
    public holdersub onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (statusList.equals("home")){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_sub_kategori, null);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_sub_kategori, null);
        }

        holdersub holder = new holdersub(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(holdersub holder, final int position) {
        final String UrlImage = "https://trading.my.id/img/";
        final String Image = results.get(position).gambar;
        final Uri uri = Uri.parse(UrlImage+Image);
        final String harga = results.get(position).harga_asli ;
        final String diskom;
        final int harga_disc;

       /** if (results.get(position).end_disc!=null){
            String valid_until = results.get(position).end_disc;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            Date strDate = null;
            try {
                strDate = sdf.parse(valid_until);
                if (new Date().after(strDate)) {
                    results.get(position).diskon = "0";
                }else if (new Date().equals(strDate)){
                    results.get(position).diskon = "0";
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        } **/

        if ( results.get(position).diskon.equals("0")||results.get(position).diskon==null||results.get(position).diskon.equals("")){
            diskom = "1";
            harga_disc = Integer.parseInt(harga)*Integer.parseInt(diskom);
            holder.harga_asli.setVisibility(View.GONE);
            holder.diskon.setVisibility(View.GONE);
        }else {
          diskom  = results.get(position).diskon;
            int total_disc_harga = Integer.parseInt(harga)*Integer.parseInt(diskom)/100;
            harga_disc = Integer.parseInt(harga)-total_disc_harga;
        }
      //  final int harga_disc = Integer.parseInt(harga)*Integer.parseInt(diskom)/100;
        NumberFormat nf = new DecimalFormat("#,###");
        final String hrg = nf.format(Integer.parseInt(harga));
        holder.nama_produk.setText(results.get(position).nama_produk);
     //   holder.harga_jual.setText(String.format("%s%s", RP, hrg));
        holder.harga_asli.setText(FormatText.rupiahFormat(Double.parseDouble(results.get(position).harga_asli)));
        holder.diskon.setText("("+results.get(position).diskon +"%)");
        holder.harga_asli.setPaintFlags(holder.harga_jual.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        holder.harga_jual.setText(FormatText.rupiahFormat(harga_disc));
      //  Picasso.get().load(UrlImage+Image).into(holder.gambar);


        Glide.with(context)
                .load(UrlImage+Image)
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).override(200,200).skipMemoryCache(false))
                .into(holder.gambar);

        holder.btnWa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_ubah_password);
                dialog.show();
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProdukDetailActivity.class);
                intent.putExtra("id_sub_kategori_produk",results.get(position).id_sub_kategori_produk);
                intent.putExtra("kode",results.get(position).kode);
                intent.putExtra("id_member",results.get(position).id_member);
                intent.putExtra("id_produk",results.get(position).id_produk);
                intent.putExtra("nama_produk",results.get(position).nama_produk);
                intent.putExtra("harga_jual",Integer.toString(harga_disc));
                intent.putExtra("keterangan_produk", results.get(position).keterangan);
                intent.putExtra("image_o",results.get(position).gambar);
                intent.putExtra("berat",results.get(position).berat);
                intent.putExtra("harga_asli",results.get(position).harga_asli);
                intent.putExtra("stok","0");
                intent.putExtra("diskon",results.get(position).diskon);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    results = dataFilter;
                } else {
                    ArrayList<ListProduk.ObjectSub.Results> filteredList = new ArrayList<>();
                    for (ListProduk.ObjectSub.Results row : dataFilter) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.nama_produk.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    results = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = results;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                results = (ArrayList<ListProduk.ObjectSub.Results>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

}
