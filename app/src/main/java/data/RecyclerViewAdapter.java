package data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hifz_app.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private Context context;
    private List<StudentData> dataList;

    public RecyclerViewAdapter(Context context, List<StudentData> data)
    {
        this.context =context;
        this.dataList =data;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_template,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        StudentData stData = dataList.get(position);

        holder.date.setText(stData.getDate());
        holder.surah.setText(Integer.toString(stData.getSurah()));
        holder.para.setText(Integer.toString(stData.getPara()));
        holder.sabaq.setText(stData.getSabaq());
        holder.sabqi.setText(Integer.toString(stData.getSabqi()));
        holder.manzil.setText(Integer.toString(stData.getManzil()));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView date, surah,para, sabaq, sabqi,manzil;
        public ViewHolder(@NonNull View itemView) {

             super(itemView);

             date= itemView.findViewById(R.id.dateView);
             surah= itemView.findViewById(R.id.surahView);
             para= itemView.findViewById(R.id.paraView);
             sabaq= itemView.findViewById(R.id.sabaqView);
             sabqi= itemView.findViewById(R.id.sabqiView);
             manzil= itemView.findViewById(R.id.manzilView);

        }
    }
}
