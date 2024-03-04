package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv_result;

    //第一个数
    private String firstNum = "";
    //第二个数
    private String secondNum = "";
    //符号
    private String operator = "";
    //当前的计算结果
    private String result = "";
    //showText
    private String showText = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_result = findViewById(R.id.tv_result);

        //注册监听器
        findViewById(R.id.btn_cancel).setOnClickListener(this);
        findViewById(R.id.btn_divide).setOnClickListener(this);
        findViewById(R.id.btn_multiply).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);

        findViewById(R.id.btn_seven).setOnClickListener(this);
        findViewById(R.id.btn_eight).setOnClickListener(this);
        findViewById(R.id.btn_nine).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);

        findViewById(R.id.btn_four).setOnClickListener(this);
        findViewById(R.id.btn_five).setOnClickListener(this);
        findViewById(R.id.btn_six).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);

        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);
        findViewById(R.id.ib_rooting).setOnClickListener(this);

        findViewById(R.id.btn_reciprocal).setOnClickListener(this);
        findViewById(R.id.btn_zero).setOnClickListener(this);
        findViewById(R.id.btn_dot).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //在文本中的显示效果
        String textView = "";
        if(v.getId() == R.id.ib_rooting){
            textView = "√";
        }
        else{
            textView = ((TextView)v).getText().toString();
        }

        switch(v.getId()){
            //回退一格
            case(R.id.btn_cancel):
                break;
            //清空
            case(R.id.btn_clear):
                break;
            //加、减、乘、除
            case(R.id.btn_divide):
            case(R.id.btn_multiply):
            case(R.id.btn_plus):
            case(R.id.btn_minus):
                operator = textView;
                refreshText(showText + textView);
                break;
            //开根号
            case(R.id.ib_rooting):
                break;
            //等号
            case(R.id.btn_equal):
                double resultFour = returnFour();
                refreshText(showText + "=" + resultFour);
                refreshResult(String.valueOf(resultFour));
                break;
            //数字+小数点
            default:
                //
                if(operator.equals(""))
                        firstNum += textView;
                else
                        secondNum += textView;
                //确保数字的开头不为0
                if(!(showText.equals("0") && !textView.equals(".")))
                    refreshText(showText + textView);
                break;
        }
    }

    private double returnFour() {
        switch(operator){
            case ("+"):return Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
            case ("-"):return Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
            case ("*"):return Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
            default:
                //四舍五入
                return Double.parseDouble(firstNum) / Double.parseDouble(secondNum) + 0.5;
        }
    }


    //刷新结果
    public void refreshResult(String new_result){
        result = new_result;
        firstNum = result;
        secondNum = "";
        operator = "";

    }
    //刷新文本显示
    public void refreshText(String text){
        showText = text;
        tv_result.setText(showText);
    }
}