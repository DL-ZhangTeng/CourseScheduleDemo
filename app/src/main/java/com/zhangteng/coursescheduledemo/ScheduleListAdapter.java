package com.zhangteng.coursescheduledemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Lanxumit on 2017/3/7.
 */
public class ScheduleListAdapter extends BaseAdapter {

    //private ArrayList<SyllabusData> list = new ArrayList<>();
    private Context context;
    private int weekDay;


    public ScheduleListAdapter(Context context, int weekday) {
        //this.list = list;
        this.context = context;
        this.weekDay = weekday;
    }

    @Override
    public int getCount() {
        return 14;
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.schedule_item, null);
            holder.linearSyllabus = (LinearLayout)convertView.findViewById(R.id.linear_syllabus);
            holder.ssTime = (TextView)convertView.findViewById(R.id.ss_time);
            holder.mondaySS = (TextView)convertView.findViewById(R.id.monday_ss);
            holder.tuesdaySS = (TextView)convertView.findViewById(R.id.tuesday_ss);
            holder.wednesdaySS = (TextView)convertView.findViewById(R.id.wednesday_ss);
            holder.thursdaySS = (TextView)convertView.findViewById(R.id.thursday_ss);
            holder.fridaySS = (TextView)convertView.findViewById(R.id.friday_ss);
            holder.saturdaySS = (TextView)convertView.findViewById(R.id.saturday_ss);
            holder.sundaySS = (TextView)convertView.findViewById(R.id.sunday_ss);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //SyllabusData data = list.get(position);
        if(position % 2 != 0) {
            holder.linearSyllabus.setBackgroundResource(R.color.popdown_menu_background_color);
        }else if(position % 2 == 0) {
            holder.linearSyllabus.setBackgroundResource(R.color.white);
        }

//        if(position == 0) {
//            holder.linearSyllabus.setBackgroundResource(R.color.login_btn_color);
//            textDay(holder);
//        }
        if(!(position == 4 || position == 9)) {
            switch (weekDay) {//设置颜色
                case 1:
                    whichDay(holder.mondaySS);
                    break;
                case 2:
                    whichDay(holder.tuesdaySS);
                    break;
                case 3:
                    whichDay(holder.wednesdaySS);
                    break;
                case 4:
                    whichDay(holder.thursdaySS);
                    break;
                case 5:
                    whichDay(holder.fridaySS);
                    break;
                case 6:
                    whichDay(holder.saturdaySS);
                    break;
                case 7:
                    whichDay(holder.sundaySS);
                    break;
            }
        }
        if(position < 4) {
            syllabusSort(position + 1, holder.ssTime);
        }else if(position > 4 && position < 9) {
            syllabusSort(position, holder.ssTime);
        }else if(position > 9) {
            syllabusSort(position -1, holder.ssTime);
        }

        switch (position) {
            case 4:
                syllabusTest(holder, "午");
                break;

            case 9:
                syllabusTest(holder, "晚");
                break;
        }

//        switch (data.getSequence()) {//第一列显示
//            case 1:
//                syllabusSort(R.string.schedule_one, holder);
//                break;
//            case 2:
//                syllabusSort(R.string.schedule_two, holder);
//                break;
//            case 3:
//                syllabusSort(R.string.schedule_three, holder);
//                break;
//            case 4:
//                syllabusSort(R.string.schedule_four, holder);
//                break;
//            case 5:
//                //syllabusSort(R.string.schedule_rest, holder);
//                syllabusTest(holder);
//                break;
//            case 6:
//                syllabusSort(R.string.schedule_five, holder);
//                break;
//            case 7:
//                syllabusSort(R.string.schedule_six, holder);
//                break;
//            case 8:
//                syllabusSort(R.string.schedule_seven, holder);
//                break;
//            case 9:
//                syllabusSort(R.string.schedule_eight, holder);
//                break;
//        }

//        for(SyllabusResult result : data.getList()) {
//            switch (data.getSequence()) {
//                case 1:
//                    textValue(result, holder);
//                    break;
//                case 2:
//                    textValue(result, holder);
//                    break;
//                case 3:
//                    textValue(result, holder);
//                    break;
//                case 4:
//                    textValue(result, holder);
//                    break;
//                case 5:
//                    syllabusTest(holder);
//                    //textValue(result, holder);
//                    break;
//                case 6:
//                    textValue(result, holder);
//                    break;
//                case 7:
//                    textValue(result, holder);
//                    break;
//                case 8:
//                    textValue(result, holder);
//                    break;
//                case 9:
//                    textValue(result, holder);
//                    break;
//            }
//        }

        return convertView;
    }

    private void syllabusTest(ViewHolder holder, String text) {
        holder.ssTime.setText("");
        holder.mondaySS.setText("");
        holder.tuesdaySS.setText("");
        holder.fridaySS.setText("");
        holder.saturdaySS.setText("");
        holder.sundaySS.setText("");
        holder.wednesdaySS.setText(text);
        holder.thursdaySS.setText("休");
    }

    private void syllabusSort(int time, TextView tv) {
        tv.setText(time + "");
    }

//    private void textValue(SyllabusResult result, ViewHolder holder) {
//        if(holder != null) {
//            if(result != null) {
//                switch (result.getWhichDay()) {//课表内容
//                    case 1:
//                        holder.mondaySS.setText(result.getCourseName());
//                        break;
//                    case 2:
//                        holder.tuesdaySS.setText(result.getCourseName());
//                        break;
//                    case 3:
//                        holder.wednesdaySS.setText(result.getCourseName());
//                        break;
//                    case 4:
//                        holder.thursdaySS.setText(result.getCourseName());
//                        break;
//                    case 5:
//                        holder.fridaySS.setText(result.getCourseName());
//                        break;
//                    case 6:
//                        holder.saturdaySS.setText(result.getCourseName());
//                        break;
//                    case 7:
//                        holder.sundaySS.setText(result.getCourseName());
//                        break;
//                }
//            }
//        }
//    }

    private void whichDay(TextView tv) {
        tv.setBackgroundResource(R.color.title_start_color);
    }


    class ViewHolder {
        private TextView ssTime;
        private TextView mondaySS;
        private TextView tuesdaySS;
        private TextView wednesdaySS;
        private TextView thursdaySS;
        private TextView fridaySS;
        private TextView saturdaySS;
        private TextView sundaySS;
        private LinearLayout linearSyllabus;
    }

//    public void refreshValue(ArrayList<SyllabusData> data) {
//        if(data == null) {
//            data = new ArrayList<SyllabusData>();
//        }
//        list.clear();
//        list.addAll(data);
//        notifyDataSetChanged();
//    }
}
