package demo.wangningning.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lenovo on 2018/1/13.
 */

public class AddPrayActivity extends AppCompatActivity {
    private Button mButtonCommit;
    private TextView mTvCount;
    private EditText mEditText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_pray_input );
        mEditText =  findViewById( R.id.input );
        mButtonCommit = findViewById( R.id.button_commit );
        mTvCount = findViewById( R.id.textview_content_count );

        mEditText.addTextChangedListener( mTextWatcher );
        mTvCount.setText( "0 / 200 ");
        mButtonCommit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = mEditText.getText().toString();
                if (TextUtils.isEmpty( content )){
                    Toast.makeText( AddPrayActivity.this, "请输入祈祷内容", Toast.LENGTH_SHORT ).show();
                    return;
                }

                Toast.makeText( AddPrayActivity.this, "添加成功！", Toast.LENGTH_SHORT ).show();
            }
        } );

    }

    TextWatcher mTextWatcher = new TextWatcher() {
        private CharSequence temp;
        private int editStart;
        private int editEnd;

        @Override
        public void beforeTextChanged(CharSequence s, int arg1, int arg2,
                                      int arg3) {
            temp = s;
        }

        @Override
        public void onTextChanged(CharSequence s, int arg1, int arg2,
                                  int arg3) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            editStart = mEditText.getSelectionStart();
            editEnd = mEditText.getSelectionEnd();
            if(temp.length() < 1 ){
                Toast.makeText( AddPrayActivity.this,
                        "请输入祈祷内容！",Toast.LENGTH_SHORT ).show();
            }
            else if (temp.length() > 200) {
                Toast.makeText( AddPrayActivity.this,
                        "你输入的字数已经超过了限制！", Toast.LENGTH_SHORT )
                        .show();
                s.delete( editStart - 1, editEnd );
                int tempSelection = editStart;
                mEditText.setText( s );
                mEditText.setSelection( tempSelection );
            }
            mTvCount.setText( s.length() +" / " + "200" );
        }
    };
}

