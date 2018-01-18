package pingan.com.day_tinker_0118_2;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private static final String SUFFIX = ".apk";

    private String patchPath = "";

    private Button btnAdd;
    private Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            patchPath = absolutePath.concat(File.separator).concat("tpatch/");
            Log.i(TAG, "patchPath: " + patchPath);
            File file = new File(patchPath);
            if (!file.exists()) {
                file.mkdir();
            }
        }

        btnAdd = (Button) findViewById(R.id.btn_add_function);
        btnTest = (Button) findViewById(R.id.btn_test);

        btnAdd.setOnClickListener(this);
        btnTest.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_function:
                TinkerManager.addPatch(getPatchPath());
                break;
            case R.id.btn_test:
                Toast.makeText(this, "测试", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 返回补丁路径
     *
     * @return
     */
    private String getPatchPath() {
        String path = patchPath.concat("out").concat(SUFFIX);
        Log.i(TAG, "path: " + path);
        return path;
    }
}

