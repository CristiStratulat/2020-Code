package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

public class wizzTechDcMotor {

    private String name;
    private DcMotor motor;

    public wizzTechDcMotor(String name, DcMotor motor) {
        this.name = name;
        this.motor = motor;

    }

    public String getName() {
        return name;
    }

    public DcMotor getMotor() {
        return motor;
    }

}