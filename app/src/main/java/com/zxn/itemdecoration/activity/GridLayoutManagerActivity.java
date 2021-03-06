package com.zxn.itemdecoration.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
//import com.yanyusong.divideritemdecoration.y_recycleradapter.GeneralRecyclerViewHolder;
//import com.yanyusong.divideritemdecoration.y_recycleradapter.Y_ItemEntityList;
//import com.yanyusong.divideritemdecoration.y_recycleradapter.Y_MultiRecyclerAdapter;
//import com.yanyusong.divideritemdecoration.y_recycleradapter.Y_OnBind;
import com.yanyusong.y_divideritemdecoration.Y_Divider;
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder;
import com.yanyusong.y_divideritemdecoration.Y_DividerItemDecoration;
import com.zxn.itemdecoration.R;
import com.zxn.itemdecoration.recycleradapter.GeneralRecyclerViewHolder;
import com.zxn.itemdecoration.recycleradapter.Y_ItemEntityList;
import com.zxn.itemdecoration.recycleradapter.Y_MultiRecyclerAdapter;
import com.zxn.itemdecoration.recycleradapter.Y_OnBind;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mac on 2017/4/6.
 */

public class GridLayoutManagerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private Y_ItemEntityList itemEntityList = new Y_ItemEntityList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        List<String> items = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            items.add("item" + i);
        }
        itemEntityList.addItems(R.layout.item_recyclerview_text, items)
                .addOnBind(R.layout.item_recyclerview_text, new Y_OnBind() {
                    @Override
                    public void onBindChildViewData(GeneralRecyclerViewHolder holder, Object itemData, int position) {
                        holder.setText(R.id.textView, (String) itemData);
                    }
                });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);//
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new Y_MultiRecyclerAdapter(this, itemEntityList));

        recyclerView.addItemDecoration(new DividerItemDecoration(this));


    }


    private class DividerItemDecoration extends Y_DividerItemDecoration {

        private DividerItemDecoration(Context context) {
            super(context);
        }

        @Override
        public Y_Divider getDivider(int itemPosition) {
            Y_Divider divider = null;
            switch (itemPosition % 3) {
                case 0:
                case 1:
                    //每一行第一个和第二个显示rignt和bottom
                    divider = new Y_DividerBuilder()
                            .setRightSideLine(true, 0xff666666, 6, 0, 0)
                            .setBottomSideLine(true, 0xff666666, 6, 0, 0)
                            .create();
                    break;
                case 2:
                    //最后一个只显示bottom
                    divider = new Y_DividerBuilder()
                            .setBottomSideLine(true, 0xff666666, 6, 0, 0)
                            .create();
                    break;
                default:
                    break;
            }
            return divider;
        }
    }


}
