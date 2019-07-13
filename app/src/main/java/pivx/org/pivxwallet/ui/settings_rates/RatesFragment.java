package pivx.org.pivxwallet.ui.settings_rates;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pivx.org.pivxwallet.R;
import global.N8VRate;
import pivx.org.pivxwallet.ui.base.BaseRecyclerFragment;
import pivx.org.pivxwallet.ui.base.tools.adapter.BaseRecyclerAdapter;
import pivx.org.pivxwallet.ui.base.tools.adapter.BaseRecyclerViewHolder;
import pivx.org.pivxwallet.ui.base.tools.adapter.ListItemListeners;

/**
 * Created by furszy on 7/2/17.
 */

public class RatesFragment extends BaseRecyclerFragment<N8VRate> implements ListItemListeners<N8VRate> {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        setEmptyText("No rate available");
        setEmptyTextColor(Color.parseColor("#cccccc"));
        return view;
    }

    @Override
    protected List<N8VRate> onLoading() {
        return n8VModule.listRates();
    }

    @Override
    protected BaseRecyclerAdapter<N8VRate, ? extends PivxRateHolder> initAdapter() {
        BaseRecyclerAdapter<N8VRate, PivxRateHolder> adapter = new BaseRecyclerAdapter<N8VRate, PivxRateHolder>(getActivity()) {
            @Override
            protected PivxRateHolder createHolder(View itemView, int type) {
                return new PivxRateHolder(itemView,type);
            }

            @Override
            protected int getCardViewResource(int type) {
                return R.layout.rate_row;
            }

            @Override
            protected void bindHolder(PivxRateHolder holder, N8VRate data, int position) {
                holder.txt_name.setText(data.getCode());
                if (list.get(0).getCode().equals(data.getCode()))
                    holder.view_line.setVisibility(View.GONE);
            }
        };
        adapter.setListEventListener(this);
        return adapter;
    }

    @Override
    public void onItemClickListener(N8VRate data, int position) {
        n8VApplication.getAppConf().setSelectedRateCoin(data.getCode());
        Toast.makeText(getActivity(),R.string.rate_selected,Toast.LENGTH_SHORT).show();
        getActivity().onBackPressed();
    }

    @Override
    public void onLongItemClickListener(N8VRate data, int position) {

    }

    private  class PivxRateHolder extends BaseRecyclerViewHolder{

        private TextView txt_name;
        private View view_line;

        protected PivxRateHolder(View itemView, int holderType) {
            super(itemView, holderType);
            txt_name = (TextView) itemView.findViewById(R.id.txt_name);
            view_line = itemView.findViewById(R.id.view_line);
        }
    }
}
