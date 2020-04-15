package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;

public class wizzTechServoMotor {

    private String name;
    private Servo servo;

    public wizzTechServoMotor(String name, Servo servo) {
        this.name = name;
        this.servo = servo;
    }

    public String getName() {
        return name;
    }

    public Servo getServo() {
        return servo;
    }
}
