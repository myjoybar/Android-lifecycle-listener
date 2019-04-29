package com.lifecycle.joybar.androidlifecyclelistener.lifetest.drop;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lifecycle.joybar.androidlifecyclelistener.R;
import com.lifecycle.joybar.lifecyclelistener.util.DropInnerReference;

public class DropInnerObjActivity extends Activity {

    private Button mRefreshBtn;
    private TextView mNameTv;
    private Button mFinishBtn;
    private Handler mHandler = new Handler();
    private CallBack mCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_inner);
        mRefreshBtn = (Button) findViewById(R.id.refresh_btn);
        mNameTv = (TextView) findViewById(R.id.name_tv);
        mFinishBtn = (Button)findViewById(R.id.finish_btn);


        /**
         * callBack是一个匿名内部类，编译之后会生成一个独立类，在onRefresh中访问了nNameTv
         * 所以持有了外部类DropInnerObjActivity的对象
         * callBack又被Thread持有，所以callback的生命周期已经脱离了主线程，容易造成内存泄漏.
         * lifecycle方案没法解决此类场景
         * mCallBack是接口类型无法用，静态内部类+弱引用也无法解决
         * 在onDestroy阶段，断开callBack对DropInnerObjActivity的引用，回收Activity,即可以解决问题
         * 此后无论异步线程执行多长时间，Activity与之没有关系。
         * 因为在断开是在onDestroy阶段，需要匿名内部类对象，所以匿名内部类需要定义为activity的成员变量
         * todo 还要处理另外一种情况，比如在其他匿名内部类中执行如下逻辑，dropReference（obj,type）,type
         * 应该是为其他匿名内部类生成的类的类名，这种情况比较复杂，暂时没有解决方案。
         */

        mCallBack = new CallBack() {
            @Override
            public void onRefresh(final String newName) {
                if (!DropInnerReference.isNull(mCallBack,
                        DropInnerObjActivity.class.getName())) {
                    mNameTv.setText(newName);
                }
            }
        };

        Thread thread = new AsyncThread(mCallBack);
        thread.start();


        mFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DropInnerObjActivity.this.finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //断开引用,回收Activity
        if (mCallBack != null) {
            DropInnerReference.dropReference(mCallBack, DropInnerObjActivity.class.getName());
        }
    }
}
