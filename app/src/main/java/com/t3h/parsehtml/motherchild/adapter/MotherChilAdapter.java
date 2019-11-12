package com.t3h.parsehtml.motherchild.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.t3h.parsehtml.GlideApp;
import com.t3h.parsehtml.R;
import com.t3h.parsehtml.model.MotherChildModel;

public class MotherChilAdapter extends RecyclerView.Adapter<MotherChilAdapter.MotherChildHolder> {
    private IMotherChilAdapter inter;

    public MotherChilAdapter(IMotherChilAdapter inter) {
        this.inter = inter;
    }

    @NonNull
    @Override
    public MotherChildHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MotherChildHolder(
                LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_item, viewGroup, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MotherChildHolder motherChildHolder, int position) {
        MotherChildModel data = inter.getData(position);
        if (data.getLinkImage() == null ||
                data.getLinkImage().equals("")) {
            GlideApp.with(motherChildHolder.ivImg.getContext())
                    .load(R.drawable.be)
                    .into(motherChildHolder.ivImg);
        }else {
            GlideApp.with(motherChildHolder.ivImg.getContext())
                    .load(data.getLinkImage())
                    .placeholder(R.drawable.be)
                    .error(R.drawable.be)
                    .into(motherChildHolder.ivImg);
        }
        motherChildHolder.tvTitle.setText(data.getTitle());
        motherChildHolder.tvContent.setText(data.getContent());
    }

    @Override
    public int getItemCount() {
        return inter.getCount();
    }

    public interface IMotherChilAdapter {
        int getCount();

        MotherChildModel getData(int position);
    }

    static class MotherChildHolder extends RecyclerView.ViewHolder {
        private ImageView ivImg;
        private TextView tvTitle, tvContent;

        public MotherChildHolder(@NonNull View itemView) {
            super(itemView);
            itemView.findViewById(R.id.ll).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            ivImg = itemView.findViewById(R.id.iv_img);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
