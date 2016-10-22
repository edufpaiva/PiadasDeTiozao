package study.android.piadasdetiozao;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.oceanbrasil.libocean.Ocean;
import com.oceanbrasil.libocean.control.http.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Request.RequestListener {
    ArrayList<Postagem> postagems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Ocean.newRequest("https://gist.githubusercontent.com/edufpaiva/90a7c287b58489ac27b09572a13cadc5/raw/7afb4a44e24aa3496e9081172f6f39ca092e209d/tiozao.json", this).get().send();
    }


    @Override
    public void onRequestOk(String resposta, JSONObject jsonObject, int code) {

        if (code == Request.NENHUM_ERROR) {
            postagems = new ArrayList<>();

            stringToJson(resposta);


            criarAdapter(postagems);
        }
    }

    public void stringToJson(String resposta) {

        if (resposta != null) {
            try {
                JSONObject object = new JSONObject(resposta);
                JSONArray posts = object.getJSONArray("posts");

                for (int i = 0; i < posts.length(); i++) {


                    JSONObject post = posts.getJSONObject(i);
                    String avatar = post.getString("avatar");
                    String nome = post.getString("nome");
                    String foto = post.getString("foto");
                    int rate = post.getInt("rate");

                    Log.d("NOME: ",nome);
                    Log.d("Avatar: ",avatar);
                    Log.d("foto: ",foto);
                    Log.d("rate: ",""+rate);

                    postagems.add(new Postagem(avatar, nome, foto, rate));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public void criarAdapter(ArrayList lista) {
        PostAdapter adapter = new PostAdapter(this, lista);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_post);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Log.d("LOG", "Adapter Criado");
    }
}
