package com.example.lawnmower;

public class JoystickMessageGenerator {

    public JoystickMessageGenerator() {
    }

    public commands.AppControls buildMessage(double X, double Y) {
        commands.AppControls.JoyStick joystick = commands.AppControls.JoyStick.newBuilder().setX(X).setY(Y).build();
        commands.AppControls appControls = commands.AppControls.newBuilder().setCmd(commands.AppControls.Command.NO_CMD).setJoy(joystick).build();
        return appControls;
    }
}
