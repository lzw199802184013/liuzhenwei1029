package soexample.umeng.com.liuzhenwei1029;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ShowView extends RelativeLayout {
    private LinearLayout layout_vertical;

    public ShowView(Context context) {
        super(context);
        init(context);
    }



    public ShowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ShowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private  Context context;
    private void init(Context context) {
        this.context= context;
        View view = View.inflate(context,R.layout.layout_ver,null);
        //找到垂直布局的id
        layout_vertical=view.findViewById(R.id.layout_vertical);
        addView(view);
    }
    public  void  setList(List<String> stringList){
        layout_vertical.removeAllViews();
        //水平布局
           LinearLayout view=(LinearLayout) View.inflate(context,R.layout.layout_hor,null);
           //添加到垂直布局里
        layout_vertical.addView(view);
            //定义一个变量
        int len=0;
        view.removeAllViews();
            for (int a=0;a<stringList.size();a++){
                String s = stringList.get(a);
                len+=s.length();
                if (len>22){
                    view=(LinearLayout) View.inflate(context,R.layout.layout_hor,null);
                    layout_vertical.addView(view);
                    len=0;
                }
                //textview布局
               View viewText =View.inflate(context,R.layout.layout_context,null);
                final TextView tv_content = (TextView) viewText.findViewById(R.id.tv_content);
                tv_content.setText(s);
                view.addView(viewText);
                //设置宽高
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewText.getLayoutParams();
                params.weight=1;
                params.leftMargin=10;
                params.rightMargin=10;
                params.topMargin=10;
                viewText.setLayoutParams(params);
                tv_content.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,tv_content.getText().toString(),Toast.LENGTH_SHORT).show();
                    }
                });
            }


    }


    public void setListData(List<String> listData) {
        //不为空添加
        if (!listData.isEmpty()){
            setList(listData);
        }
    }
}
