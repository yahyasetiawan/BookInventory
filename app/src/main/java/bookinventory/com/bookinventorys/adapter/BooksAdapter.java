package bookinventory.com.bookinventorys.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bookinventory.com.bookinventorys.R;
import bookinventory.com.bookinventorys.activity.Book;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by id on 09/08/2016.
 */
public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.MyViewHolder> implements Filterable {
    private List<Book> books;
    private List<Book> booksOri;
    private Context mContext;
    private Filter filter;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtBookTitle)TextView txtBookTitle;
        @BindView(R.id.txtOtherInfo)TextView txtOtherInfo;

        public MyViewHolder(View view){
            super (view);
            ButterKnife.bind(this, view);
        }
    }


    public BooksAdapter(Context context, List<Book> bookList) {
        this.books = bookList;
        this.booksOri = bookList;
        mContext = context;
    }
    public Filter getFilter () {
        if(filter == null)
            filter = new BookFilter();
        return  filter;
    };

    private class BookFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();
            String substr = constraint.toString().toLowerCase();
            if (substr == null || substr.length() == 0) {
                results.values = booksOri;
                results.count = booksOri.size();
            } else {
                final ArrayList<Book> nlist = new ArrayList<Book>();
                int count = booksOri.size();


                for (int i = 0; i < count; i++) {
                    final Book book = booksOri.get(i);
                    String value = " ", value2 = " ";
                    value2 = book.getBook_author().toLowerCase();
                    if (value.contains(substr) || value2.contains(substr)) {
                        nlist.add(book);
                    }
                }
                results.values = nlist;
                results.count = nlist.size();
            }
            return results;
        }

        @SuppressWarnings("unchecked")
        @Override

        protected  void publishResults(CharSequence constraint,
                                      FilterResults results) {
        books = (List<Book>) results.values;
            notifyDataSetChanged();
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        Book book = books.get(position);
        holder.txtBookTitle.setText(book.getBook_title());
        holder.txtOtherInfo.setText(book.getBook_author());
    }

    @Override
    public int getItemCount(){return books == null ? 0 : books.size();}

}
