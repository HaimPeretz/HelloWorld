package com.example.helloworld;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private CameraCaptureSession myCamptureSession;
    private CameraManager myCameraManager;
    private CameraDevice myCameraDevice;
    private TextureView myTextureView;
    private CaptureRequest.Builder myCaptureBuilder;
    private Button cameraButtonHaim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myCameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
        editText = findViewById(R.id.firstEditTxt);
        textView = findViewById(R.id.EinavTxt);
        cameraButtonHaim = findViewById(R.id.button);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //לפני ששיניתי את הטקסט
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //בזמן ששיניתי את הטקסט
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //אחרי ששיניתי את הטקסט
                textView.setText("שלום " + editable.toString());
            }
        });

        cameraButtonHaim.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openCamera();
            }
        });
    }


    public void cameraPreview (View view) {

    }

    private void openCamera () {
        try {
            System.out.println("TEST");
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                myCameraManager.openCamera(myCameraManager.getCameraIdList()[0], myStateCallback, null);
                return;
            }
            System.out.println("TEST");
            myCameraManager.openCamera(myCameraManager.getCameraIdList()[0], myStateCallback, null);
        } catch (Exception e) {
          e.printStackTrace ();
        }
    }

    private CameraDevice.StateCallback myStateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(CameraDevice cameraDevice) {

        }

        @Override
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {

        }

        @Override
        public void onError(CameraDevice cameraDevice, int i) {

        }
    };
}