package com.zhangteng.coursescheduledemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 班级课表
 */
public class HomeCourseScheduleFragment extends BaseFragment {
    MyHorizontalScrollView mHorizontalScrollView, mPinnedHorizontalScrollView;
    ObservableScrollView main_scrollview, root_scrollview;
    WrapContentListView mLeftListView;
    WrapContentListView mRightListView;
    LeftAdapter mLeftAdapter;
    RightAdapter mRightAdapter;
    LinearLayout mPinned;

    @Override
    protected int getResourceId() {
        return R.layout.fragment_home_course_schedule;
    }

    @Override
    protected void initView(View view) {
        mPinned = (LinearLayout) view.findViewById(R.id.home_course_schedule_pinned);
        mHorizontalScrollView = (MyHorizontalScrollView) view.findViewById(R.id.home_course_schedule_hscrollview);
        mPinnedHorizontalScrollView = (MyHorizontalScrollView) view.findViewById(R.id.home_course_schedule_pinnedhscrollview);
        mLeftListView = (WrapContentListView) view.findViewById(R.id.home_course_schedule_left_lv);
        mRightListView = (WrapContentListView) view.findViewById(R.id.home_course_schedule_right_lv);
        main_scrollview = (ObservableScrollView) view.findViewById(R.id.home_course_schedule_main_scrollview);
        root_scrollview = (ObservableScrollView) view.findViewById(R.id.home_course_schedule_root_scrollview);

        mLeftAdapter = new LeftAdapter(this.getContext());
        mRightAdapter = new RightAdapter(this.getContext());
        mLeftListView.setAdapter(mLeftAdapter);
        mRightListView.setAdapter(mRightAdapter);
        mLeftAdapter.notifyDataSetChanged();
        mRightAdapter.notifyDataSetChanged();

        mHorizontalScrollView.setOnScrollChangedCallback(new MyHorizontalScrollView.OnScrollChangedCallback() {
            @Override
            public void onScroll(int l, int t, int oldl, int oldt) {
                allScroll(l, t);
            }
        });

        mPinnedHorizontalScrollView.setOnScrollChangedCallback(new MyHorizontalScrollView.OnScrollChangedCallback() {
            @Override
            public void onScroll(int l, int t, int oldl, int oldt) {
                allScroll(l, t);
            }
        });

        main_scrollview.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                if (y == 0) {
                    //可以写下拉刷新逻辑
                }
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    public void OnFragmentBackOrComing() {
        super.OnFragmentBackOrComing();
    }

    private synchronized void allScroll(int l, int t) {
        mPinnedHorizontalScrollView.scrollTo(l, t);
        mHorizontalScrollView.scrollTo(l, t);
    }

    /*左标题*/
    public class LeftAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mLayoutInflater;

        public LeftAdapter(Context context) {
            mContext = context;
            mLayoutInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return 14;
        }

        @Override
        public String getItem(int position) {
            return "left:" + position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LeftHolder holder;
            if (convertView == null) {
                convertView = mLayoutInflater.inflate(R.layout.layout_home_course_schedule_item_left, null);
                holder = new LeftHolder();
                holder.tv_fundname = (TextView) convertView.findViewById(R.id.home_course_schedule_tv_fundname);
                holder.tv_num = (TextView) convertView.findViewById(R.id.home_course_schedule_tv_num);
                convertView.setTag(holder);

            } else {
                holder = (LeftHolder) convertView.getTag();

            }

            switch (position) {
                //上午
                case 0:
                    holder.tv_fundname.setBackgroundColor(HomeCourseScheduleFragment.this.getResources().getColor(R.color.forenoon_color));
                    holder.tv_num.setText("1");
                    holder.tv_fundname.setText("");
                    break;
                case 1:
                    holder.tv_fundname.setBackgroundColor(HomeCourseScheduleFragment.this.getResources().getColor(R.color.forenoon_color));
                    holder.tv_fundname.setText("上");
                    holder.tv_num.setText("2");
                    break;
                case 2:
                    holder.tv_fundname.setBackgroundColor(HomeCourseScheduleFragment.this.getResources().getColor(R.color.forenoon_color));
                    holder.tv_fundname.setText("午");
                    holder.tv_num.setText("3");
                    break;
                case 3:
                    holder.tv_fundname.setBackgroundColor(HomeCourseScheduleFragment.this.getResources().getColor(R.color.forenoon_color));
                    holder.tv_num.setText("4");
                    break;
                //下午
                case 5:
                    holder.tv_fundname.setBackgroundColor(HomeCourseScheduleFragment.this.getResources().getColor(R.color.afternoon_color));
                    holder.tv_num.setText("1");
                    break;
                case 6:
                    holder.tv_fundname.setBackgroundColor(HomeCourseScheduleFragment.this.getResources().getColor(R.color.afternoon_color));
                    holder.tv_num.setText("2");
                    holder.tv_fundname.setText("下");
                    break;
                case 7:
                    holder.tv_fundname.setBackgroundColor(HomeCourseScheduleFragment.this.getResources().getColor(R.color.afternoon_color));
                    holder.tv_num.setText("3");
                    holder.tv_fundname.setText("午");
                    break;
                case 8:
                    holder.tv_fundname.setBackgroundColor(HomeCourseScheduleFragment.this.getResources().getColor(R.color.afternoon_color));
                    holder.tv_num.setText("4");
                    break;
                //晚上
                case 10:
                    holder.tv_fundname.setBackgroundColor(HomeCourseScheduleFragment.this.getResources().getColor(R.color.night_color));
                    holder.tv_num.setText("1");
                    break;
                case 11:
                    holder.tv_fundname.setBackgroundColor(HomeCourseScheduleFragment.this.getResources().getColor(R.color.night_color));
                    holder.tv_fundname.setText("晚");
                    holder.tv_num.setText("2");
                    break;
                case 12:
                    holder.tv_fundname.setBackgroundColor(HomeCourseScheduleFragment.this.getResources().getColor(R.color.night_color));
                    holder.tv_fundname.setText("上");
                    holder.tv_num.setText("3");
                    break;
                case 13:
                    holder.tv_fundname.setBackgroundColor(HomeCourseScheduleFragment.this.getResources().getColor(R.color.night_color));
                    holder.tv_num.setText("4");
                    break;

            }

            return convertView;
        }

        private class LeftHolder {
            TextView tv_fundname;
            TextView tv_num;
        }
    }

    /*主体内容*/
    public class RightAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mLayoutInflater;

        public RightAdapter(Context context) {
            mContext = context;
            mLayoutInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return 14;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            RightHolder holder = null;
            if (convertView == null) {
                convertView = mLayoutInflater.inflate(R.layout.layout_home_course_schedule_item_right, null);
                holder = new RightHolder();
                holder.tv_1 = (TextView) convertView.findViewById(R.id.home_course_schedule_tv_1);
                holder.tv_2 = (TextView) convertView.findViewById(R.id.home_course_schedule_tv_2);
                holder.tv_3 = (TextView) convertView.findViewById(R.id.home_course_schedule_tv_3);
                holder.tv_4 = (TextView) convertView.findViewById(R.id.home_course_schedule_tv_4);
                holder.tv_5 = (TextView) convertView.findViewById(R.id.home_course_schedule_tv_5);
                holder.tv_6 = (TextView) convertView.findViewById(R.id.home_course_schedule_tv_6);
                holder.tv_7 = (TextView) convertView.findViewById(R.id.home_course_schedule_tv_7);
                convertView.setTag(holder);

            } else {
                holder = (RightHolder) convertView.getTag();

            }
            if (position == 4) {
                holder.tv_1.setText("");
                holder.tv_2.setText("");
                holder.tv_3.setText("午休");
                holder.tv_4.setText("");
                holder.tv_5.setText("");
                holder.tv_6.setText("");
                holder.tv_7.setText("");
            } else if (position == 9) {
                holder.tv_1.setText("");
                holder.tv_2.setText("");
                holder.tv_3.setText("晚休");
                holder.tv_4.setText("");
                holder.tv_5.setText("");
                holder.tv_6.setText("");
                holder.tv_7.setText("");
            } else {
                holder.tv_1.setText("--");
                holder.tv_2.setText("--");
                holder.tv_3.setText("--");
                holder.tv_4.setText("--");
                holder.tv_5.setText("--");
                holder.tv_6.setText("--");
                holder.tv_7.setText("--");
            }
            return convertView;
        }

        private class RightHolder {
            TextView tv_1, tv_2, tv_3, tv_4, tv_5, tv_6, tv_7;
        }
    }
}
