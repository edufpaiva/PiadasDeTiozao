package study.android.piadasdetiozao;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.oceanbrasil.libocean.Ocean;
import com.oceanbrasil.libocean.control.glide.GlideRequest;

import java.util.ArrayList;

/**
 * Created by pc on 21/10/2016.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {


    private final Context context;
    private ArrayList<Postagem> lista;

    public PostAdapter(Context context, ArrayList<Postagem> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_post, null);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Postagem postagem = lista.get(position);

        holder.
                setImgAvatar(postagem.getAvatar()).
                setNome(postagem.getNome()).
                setImgPost(postagem.getFoto()).
                setRating(postagem.getRate());


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgAvatar;
        private ImageView imgPost;
        private TextView nome;
        private RatingBar rating;


        public ViewHolder(View itemView) {
            super(itemView);

            imgAvatar = (ImageView) itemView.findViewById(R.id.img_avatar);
            imgPost = (ImageView) itemView.findViewById(R.id.img_post);
            nome = (TextView) itemView.findViewById(R.id.nickname_post);
            rating = (RatingBar) itemView.findViewById(R.id.rate_post);


        }

        public ViewHolder setImgAvatar(String imagem) {
            if (imgAvatar == null) return this;
            Ocean.glide(context).load(imagem).build(GlideRequest.BITMAP).circle().into(imgAvatar);
            return this;
        }

        public ViewHolder setImgPost(String imagem) {
            if (imgAvatar == null) return this;
            Ocean.
                    glide(context).
                    load(imagem).
                    build(GlideRequest.BITMAP).
                    into(imgPost);
            return this;
        }

        public ViewHolder setNome(String nome) {
            if (this.nome == null) return this;
            this.nome.setText(nome);
            return this;

        }

        public ViewHolder setRating(int rating) {
            if (rating > 0) {
                this.rating.setRating(1f);

            } else {

                this.rating.setRating(0f);
            }

            return this;

        }


    }
}
