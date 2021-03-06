package com.zxn.divider;

import android.content.Context;

import com.yanyusong.y_divideritemdecoration.Y_Divider;
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder;

/**
 * RecyclerView均匀分隔的格子列表分割线.
 * RvItemDecoration,GridDecoration
 * Created by zxn on 2019/1/27.
 */
public class GridDecoration extends RvItemDecoration {


    protected GridDecoration(Context context) {
        super(context);
    }

    @Override
    public Y_Divider getDivider(int itemPosition) {
        mBgColor = mContext.getResources()
                .getColor(mBgColoerId);

        Y_DividerBuilder builder = new Y_DividerBuilder();

        //每一列,第一行要显示顶部分隔线
        if (itemPosition < mSpanCount) {
            builder.setTopSideLine(true, mBgColor, mWidthDp, 0, 0);
        }

        //第一列条目显示每一个left,rignt和bottom(第1列的显示分隔线)
        if (itemPosition % mSpanCount == 0) {
            builder.setLeftSideLine(true, mBgColor, mWidthDp, 0, 0)
                    .setRightSideLine(true, mBgColor, mWidthDp, 0, 0)
                    .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0);
        } else {
            //每一行每一个rignt和bottom(2--->5列的显示分隔线.)
            builder.setRightSideLine(true, mBgColor, mWidthDp, 0, 0)
                    .setBottomSideLine(true, mBgColor, mWidthDp, 0, 0);

        }

        return builder.create();
    }
}
