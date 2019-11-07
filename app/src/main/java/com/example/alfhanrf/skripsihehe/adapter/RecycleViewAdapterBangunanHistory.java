package com.example.alfhanrf.skripsihehe.adapter;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.example.alfhanrf.skripsihehe.BangunanViewHistory;
import com.example.alfhanrf.skripsihehe.DetailBangun;
import com.example.alfhanrf.skripsihehe.R;
import com.example.alfhanrf.skripsihehe.model.bangungedung.Bangunan;
import com.example.alfhanrf.skripsihehe.network.APIClient;
import com.example.alfhanrf.skripsihehe.network.APIInterface;
import com.example.alfhanrf.skripsihehe.network.RequestResponse;
import com.example.alfhanrf.skripsihehe.sessionmanager.UserSession;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alfhanrf on 8/29/2018.
 */

public class RecycleViewAdapterBangunanHistory extends RecyclerView.Adapter<RecycleViewAdapterBangunanHistory.ViewHolder> implements AdapterView.OnItemLongClickListener {

    private static final String TAG = RecyclerView.class.getSimpleName();
    UserSession userSession;
    private Context mContext;
    private List<Bangunan> mList;
    private List<Bangunan> bangunan;
    private AdapterView.OnItemClickListener mListener;
    private RecycleViewAdapterBangunan.OnItemLongClickListener mLongListener;

    public RecycleViewAdapterBangunanHistory(Context context, List<Bangunan> bangunan) {
        this.mContext = context;
        this.bangunan = bangunan;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bangunan, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Bangunan item = bangunan.get(position);
        holder.txtNamaBangunan.setText(item.getNama_bangunan());
        holder.txtNamaDepar.setText("Nama Departemen : " + item.getNama_departemen());
        holder.txtNamaPemilik.setText("Nama Pemilik : " + item.getNama_pemilik_tanah());

        final ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
        final int color2 = generator.getColor(item.getNama_bangunan());
        final TextDrawable.IBuilder builder = TextDrawable.builder()
                .beginConfig()
                .endConfig()
                .round();
        TextDrawable ic2 = builder.build(item.getNama_bangunan().toUpperCase().substring(0, 1), color2);
        holder.imgIconBangunan.setImageDrawable(ic2);

        holder.cvItemBangunan.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                final PopupMenu popup = new PopupMenu(mContext, holder.cvItemBangunan);
                popup.getMenuInflater().inflate(R.menu.menu_perusahaan, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(final MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.action_delete: {
                                final AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
                                alert.setTitle("Hapus Data");
                                alert.setMessage("Apakah Anda Yakin Menghapus Data ? ");
                                alert.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        deleteData(bangunan.get(position));
                                    }
                                })
                                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        }).show();

                            }
                        }
                        return true;
                    }

                });
                popup.show();
                return true;


            }

        });


        holder.cvItemBangunan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, DetailBangun.class);
                i.putExtra("bangunan", bangunan.get(position));
                mContext.startActivity(i);


            }

        });

    }

    private void deleteData(Bangunan position) {

        final BangunanViewHistory bangunanViewHistory = new BangunanViewHistory();

        userSession = new UserSession(mContext);

        final ProgressDialog mRegProgres = new ProgressDialog(mContext);
        mRegProgres.setTitle("Processing Data");
        mRegProgres.setMessage("Please Wait...");
        mRegProgres.setCanceledOnTouchOutside(false);
        mRegProgres.show();
        userSession = new UserSession(mContext);
        APIInterface apiInterface = APIClient.getClientAuthorize().create(APIInterface.class);
        Call<RequestResponse> call = apiInterface.deleteBangunan(userSession.getUserToken(), userSession.getIdUser(), position.getId_bangunan());
        call.enqueue(new Callback<RequestResponse>() {
            @Override
            public void onResponse(Call<RequestResponse> call, Response<RequestResponse> response) {
                mRegProgres.dismiss();
                Toast.makeText(mContext, "Data Berhasil Di Hapus", Toast.LENGTH_SHORT).show();
                bangunanViewHistory.loadDataBangunan();

            }

            @Override
            public void onFailure(Call<RequestResponse> call, Throwable t) {
                mRegProgres.dismiss();
                Toast.makeText(mContext, "Error : " + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.txtNamaBangunan)
        TextView txtNamaBangunan;
        @BindView(R.id.txtNamaDepar)
        TextView txtNamaDepar;
        @BindView(R.id.txtNamaPemilik)
        TextView txtNamaPemilik;
        @BindView(R.id.imgIconBangunan)
        ImageView imgIconBangunan;
        @BindView(R.id.cvItemBangunan)
        CardView cvItemBangunan;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }

        @Override
        public void onClick(View v) {

        }
    }
}
