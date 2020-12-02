package com.example.lawnmower;

import android.os.Bundle;
import android.view.TextureView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.OutputStream;

import io.github.controlwear.virtual.joystick.android.JoystickView;

public class Steuerung extends AppCompatActivity {

    private TextureView videoStream;
    private JoystickView mJoystick;
    private TextView mTextView;
    private JoystickMessageGenerator mJoystickMessageGenerator;
    private final double DEADZONE = 0.15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steuerung);
        init();
    }

    private void init() {
        videoStream = findViewById(R.id.robotVideo);
        mJoystick = findViewById(R.id.JoystickView);
        mJoystickMessageGenerator = new JoystickMessageGenerator();
        mTextView = findViewById(R.id.textView);

        //check connection status

        //start receiving Image messages and convert them to Images and display them on @videoStream

        //publish AppControls messages for the Joystick
        mJoystick.setOnMoveListener(new JoystickView.OnMoveListener() {
            @Override
            public void onMove(int angle, int strength) {

                // rearrange the values of x,y to -1 to 1 with -1,-1 being the top left corner
                double x = (mJoystick.getNormalizedX()/50.0)-1.0;
                if(Math.abs(x) < DEADZONE) {
                    x = 0.0;
                }

                double y = (mJoystick.getNormalizedY()/50.0)-1.0;
                if(Math.abs(y) < DEADZONE) {
                    y = 0.0;
                }

                //send message.writeTo(OutputStream output) or .toByteArray()
                commands.AppControls msg = mJoystickMessageGenerator.buildMessage(x,y);
                if(ConnectThread.getSocket() != null) {
                    ConnectThread.Send(msg.toByteArray());
                }
                //mTextView.setText(msg.toString());
            }
        });
    }
}