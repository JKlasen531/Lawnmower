package com.example.lawnmower;

public class btnMessageGenerator {

    public btnMessageGenerator() {
    }

    public commands.AppControls buildMessage(int i) {
        commands.AppControls btn;
        switch(i) {
            case (1):
                btn = commands.AppControls.newBuilder().setCmd(commands.AppControls.Command.START).build();
            break;
            case(2):
                btn = commands.AppControls.newBuilder().setCmd(commands.AppControls.Command.STOP).build();
                break;
            case(3):
                btn = commands.AppControls.newBuilder().setCmd(commands.AppControls.Command.PAUSE).build();
                break;
            case(4):
                btn = commands.AppControls.newBuilder().setCmd(commands.AppControls.Command.HOME).build();
                break;
        default:
            btn = null;
            break;
        }
        return btn;
    }
}
