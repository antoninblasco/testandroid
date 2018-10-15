package fr.dream.antoninb.layoutsdynamiques;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import fr.dream.antoninb.layoutsdynamiques.databinding.UserBinding;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private List<User> users;
    private Context c;
    private ItemClickListener listener;


    public MyAdapter(List<User> users, Context c, ItemClickListener listener){
        this.users = users;
        this.c = c;
        this.listener = listener;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private LinearLayout v;
        UserBinding binding;
        public MyViewHolder(View view) {
            super(view);
            this.binding = DataBindingUtil.bind(view);
            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());

        }
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // instancie la vue d'un item en allant chercher le layout particulier
        UserBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.user, parent, false);
        MyViewHolder vh = new MyViewHolder(binding.getRoot());
        return vh;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        User user = users.get(position);
        holder.binding.setUser(user);
    }

    @Override
    public int getItemCount(){
        return users.size();
    }

    interface ItemClickListener {
        void onClick(View view, int position);
    }
}
