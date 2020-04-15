package org.firstinspires.ftc.teamcode;

import com.qualcomm.ftccommon.configuration.EditLegacyServoControllerActivity;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotor.RunMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.Axis;
import org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "AutoFirst")

public class AutonomousFirst extends LinearOpMode {
    private int TICK_PER_REVOLUTION = 384;
    private double COUNTS_PER_CM = ((TICK_PER_REVOLUTION / 16.5) * 2.54);

    @Override
    public void runOpMode() throws InterruptedException {
        Robot.getInstance().init(this);
        Robot.getInstance().initGyro(BNO055IMU.AngleUnit.DEGREES);
        waitForStart();

       // sleep(12000);

        Robot.getInstance().getLeftCatcher().getServo().setPosition(0.44);
        Robot.getInstance().getRightCatcher().getServo().setPosition(0.45);

        slideRight(0.2,7);
        sleep(1000);

        driveForwardDistance(0.3, 32);
        sleep(1000);

        Robot.getInstance().getLeftCatcher().getServo().setPosition(0.75);
        Robot.getInstance().getRightCatcher().getServo().setPosition(0.15);
        sleep(1000);


        driveBackwardsDistance(0.3, 35);
        sleep(1000);

        Robot.getInstance().getLeftCatcher().getServo().setPosition(0.44);
        Robot.getInstance().getRightCatcher().getServo().setPosition(0.45);
        sleep(1000);



        slideLeft(0.3, 53);
        sleep(1000);

        driveForwardDistance(0.3, 23);
    }


    public void driveForwardDistance(double power, int x) {
        int distance = (int) (x * COUNTS_PER_CM);
        Robot.getInstance().getLeftMotorUp().getMotor().setMode(RunMode.RESET_ENCODERS);
        Robot.getInstance().getRightMotorUp().getMotor().setMode(RunMode.RESET_ENCODERS);
        Robot.getInstance().getLeftMotorDown().getMotor().setMode(RunMode.RESET_ENCODERS);
        Robot.getInstance().getRightMotorDown().getMotor().setMode(RunMode.RESET_ENCODERS);

        Robot.getInstance().getLeftMotorUp().getMotor().setTargetPosition(-distance);
        Robot.getInstance().getRightMotorUp().getMotor().setTargetPosition(distance);
        Robot.getInstance().getLeftMotorDown().getMotor().setTargetPosition(-distance);
        Robot.getInstance().getRightMotorDown().getMotor().setTargetPosition(distance);

        Robot.getInstance().getLeftMotorUp().getMotor().setMode(RunMode.RUN_TO_POSITION);
        Robot.getInstance().getRightMotorUp().getMotor().setMode(RunMode.RUN_TO_POSITION);
        Robot.getInstance().getLeftMotorDown().getMotor().setMode(RunMode.RUN_TO_POSITION);
        Robot.getInstance().getRightMotorDown().getMotor().setMode(RunMode.RUN_TO_POSITION);

        Robot.getInstance().getLeftMotorUp().getMotor().setPower(power);
        Robot.getInstance().getRightMotorUp().getMotor().setPower(power);
        Robot.getInstance().getLeftMotorDown().getMotor().setPower(power);
        Robot.getInstance().getRightMotorDown().getMotor().setPower(power);

        while (Robot.getInstance().getLeftMotorDown().getMotor().isBusy() && Robot.getInstance().getRightMotorDown().getMotor().isBusy() && Robot.getInstance().getLeftMotorUp().getMotor().isBusy() && Robot.getInstance().getRightMotorUp().getMotor().isBusy()) {

        }

        Robot.getInstance().getLeftMotorUp().getMotor().setPower(0);
        Robot.getInstance().getRightMotorUp().getMotor().setPower(0);
        Robot.getInstance().getLeftMotorDown().getMotor().setPower(0);
        Robot.getInstance().getRightMotorDown().getMotor().setPower(0);

        Robot.getInstance().getLeftMotorUp().getMotor().setMode(RunMode.RUN_USING_ENCODERS);
        Robot.getInstance().getRightMotorUp().getMotor().setMode(RunMode.RUN_USING_ENCODERS);
        Robot.getInstance().getLeftMotorDown().getMotor().setMode(RunMode.RUN_USING_ENCODERS);
        Robot.getInstance().getRightMotorDown().getMotor().setMode(RunMode.RUN_USING_ENCODERS);
    }

    public void driveBackwardsDistance(double power, int x) {
        int distance = (int) (x * COUNTS_PER_CM);
        Robot.getInstance().getLeftMotorUp().getMotor().setMode(RunMode.RESET_ENCODERS);
        Robot.getInstance().getRightMotorUp().getMotor().setMode(RunMode.RESET_ENCODERS);
        Robot.getInstance().getLeftMotorDown().getMotor().setMode(RunMode.RESET_ENCODERS);
        Robot.getInstance().getRightMotorDown().getMotor().setMode(RunMode.RESET_ENCODERS);

        Robot.getInstance().getLeftMotorUp().getMotor().setTargetPosition(distance);
        Robot.getInstance().getRightMotorUp().getMotor().setTargetPosition(-distance);
        Robot.getInstance().getLeftMotorDown().getMotor().setTargetPosition(distance);
        Robot.getInstance().getRightMotorDown().getMotor().setTargetPosition(-distance);

        Robot.getInstance().getLeftMotorUp().getMotor().setMode(RunMode.RUN_TO_POSITION);
        Robot.getInstance().getRightMotorUp().getMotor().setMode(RunMode.RUN_TO_POSITION);
        Robot.getInstance().getLeftMotorDown().getMotor().setMode(RunMode.RUN_TO_POSITION);
        Robot.getInstance().getRightMotorDown().getMotor().setMode(RunMode.RUN_TO_POSITION);

        Robot.getInstance().getLeftMotorUp().getMotor().setPower(power);
        Robot.getInstance().getRightMotorUp().getMotor().setPower(power);
        Robot.getInstance().getLeftMotorDown().getMotor().setPower(power);
        Robot.getInstance().getRightMotorDown().getMotor().setPower(power);

        while (Robot.getInstance().getLeftMotorDown().getMotor().isBusy() && Robot.getInstance().getRightMotorDown().getMotor().isBusy() && Robot.getInstance().getLeftMotorUp().getMotor().isBusy() && Robot.getInstance().getRightMotorUp().getMotor().isBusy()) {

        }

        Robot.getInstance().getLeftMotorUp().getMotor().setPower(0.1);
        Robot.getInstance().getRightMotorUp().getMotor().setPower(0.1);
        Robot.getInstance().getLeftMotorDown().getMotor().setPower(0.1);
        Robot.getInstance().getRightMotorDown().getMotor().setPower(0.1);

        sleep(300);

        Robot.getInstance().getLeftMotorUp().getMotor().setPower(0);
        Robot.getInstance().getRightMotorUp().getMotor().setPower(0);
        Robot.getInstance().getLeftMotorDown().getMotor().setPower(0);
        Robot.getInstance().getRightMotorDown().getMotor().setPower(0);

        Robot.getInstance().getLeftMotorUp().getMotor().setMode(RunMode.RUN_USING_ENCODERS);
        Robot.getInstance().getRightMotorUp().getMotor().setMode(RunMode.RUN_USING_ENCODERS);
        Robot.getInstance().getLeftMotorDown().getMotor().setMode(RunMode.RUN_USING_ENCODERS);
        Robot.getInstance().getRightMotorDown().getMotor().setMode(RunMode.RUN_USING_ENCODERS);
    }

    public void slideRight(double power, int x) {
        int distance = (int) (x * COUNTS_PER_CM);
        Robot.getInstance().getLeftMotorUp().getMotor().setMode(RunMode.RESET_ENCODERS);
        Robot.getInstance().getRightMotorUp().getMotor().setMode(RunMode.RESET_ENCODERS);
        Robot.getInstance().getLeftMotorDown().getMotor().setMode(RunMode.RESET_ENCODERS);
        Robot.getInstance().getRightMotorDown().getMotor().setMode(RunMode.RESET_ENCODERS);

        Robot.getInstance().getLeftMotorUp().getMotor().setTargetPosition(-distance);
        Robot.getInstance().getRightMotorUp().getMotor().setTargetPosition(-distance);
        Robot.getInstance().getLeftMotorDown().getMotor().setTargetPosition(distance);
        Robot.getInstance().getRightMotorDown().getMotor().setTargetPosition(distance);

        Robot.getInstance().getLeftMotorUp().getMotor().setMode(RunMode.RUN_TO_POSITION);
        Robot.getInstance().getRightMotorUp().getMotor().setMode(RunMode.RUN_TO_POSITION);
        Robot.getInstance().getLeftMotorDown().getMotor().setMode(RunMode.RUN_TO_POSITION);
        Robot.getInstance().getRightMotorDown().getMotor().setMode(RunMode.RUN_TO_POSITION);

        Robot.getInstance().getLeftMotorUp().getMotor().setPower(power);
        Robot.getInstance().getRightMotorUp().getMotor().setPower(power);
        Robot.getInstance().getLeftMotorDown().getMotor().setPower(power);
        Robot.getInstance().getRightMotorDown().getMotor().setPower(power);

        while (Robot.getInstance().getLeftMotorDown().getMotor().isBusy() && Robot.getInstance().getRightMotorDown().getMotor().isBusy() && Robot.getInstance().getLeftMotorUp().getMotor().isBusy() && Robot.getInstance().getRightMotorUp().getMotor().isBusy()) {

        }

        Robot.getInstance().getLeftMotorUp().getMotor().setPower(0.1);
        Robot.getInstance().getRightMotorUp().getMotor().setPower(0.1);
        Robot.getInstance().getLeftMotorDown().getMotor().setPower(0.1);
        Robot.getInstance().getRightMotorDown().getMotor().setPower(0.1);

        sleep(300);

        Robot.getInstance().getLeftMotorUp().getMotor().setPower(0);
        Robot.getInstance().getRightMotorUp().getMotor().setPower(0);
        Robot.getInstance().getLeftMotorDown().getMotor().setPower(0);
        Robot.getInstance().getRightMotorDown().getMotor().setPower(0);

        Robot.getInstance().getLeftMotorUp().getMotor().setMode(RunMode.RUN_USING_ENCODERS);
        Robot.getInstance().getRightMotorUp().getMotor().setMode(RunMode.RUN_USING_ENCODERS);
        Robot.getInstance().getLeftMotorDown().getMotor().setMode(RunMode.RUN_USING_ENCODERS);
        Robot.getInstance().getRightMotorDown().getMotor().setMode(RunMode.RUN_USING_ENCODERS);
    }

    public void slideLeft(double power, int x) {
        int distance = (int) (x * COUNTS_PER_CM);
        Robot.getInstance().getLeftMotorUp().getMotor().setMode(RunMode.RESET_ENCODERS);
        Robot.getInstance().getRightMotorUp().getMotor().setMode(RunMode.RESET_ENCODERS);
        Robot.getInstance().getLeftMotorDown().getMotor().setMode(RunMode.RESET_ENCODERS);
        Robot.getInstance().getRightMotorDown().getMotor().setMode(RunMode.RESET_ENCODERS);

        Robot.getInstance().getLeftMotorUp().getMotor().setTargetPosition(distance);
        Robot.getInstance().getRightMotorUp().getMotor().setTargetPosition(distance);
        Robot.getInstance().getLeftMotorDown().getMotor().setTargetPosition(-distance);
        Robot.getInstance().getRightMotorDown().getMotor().setTargetPosition(-distance);

        Robot.getInstance().getLeftMotorUp().getMotor().setMode(RunMode.RUN_TO_POSITION);
        Robot.getInstance().getRightMotorUp().getMotor().setMode(RunMode.RUN_TO_POSITION);
        Robot.getInstance().getLeftMotorDown().getMotor().setMode(RunMode.RUN_TO_POSITION);
        Robot.getInstance().getRightMotorDown().getMotor().setMode(RunMode.RUN_TO_POSITION);

        Robot.getInstance().getLeftMotorUp().getMotor().setPower(power);
        Robot.getInstance().getRightMotorUp().getMotor().setPower(power);
        Robot.getInstance().getLeftMotorDown().getMotor().setPower(power);
        Robot.getInstance().getRightMotorDown().getMotor().setPower(power);

        while (Robot.getInstance().getLeftMotorDown().getMotor().isBusy() && Robot.getInstance().getRightMotorDown().getMotor().isBusy() && Robot.getInstance().getLeftMotorUp().getMotor().isBusy() && Robot.getInstance().getRightMotorUp().getMotor().isBusy()) {

        }

        Robot.getInstance().getLeftMotorUp().getMotor().setPower(0);
        Robot.getInstance().getRightMotorUp().getMotor().setPower(0);
        Robot.getInstance().getLeftMotorDown().getMotor().setPower(0);
        Robot.getInstance().getRightMotorDown().getMotor().setPower(0);

        Robot.getInstance().getLeftMotorUp().getMotor().setMode(RunMode.RUN_USING_ENCODERS);
        Robot.getInstance().getRightMotorUp().getMotor().setMode(RunMode.RUN_USING_ENCODERS);
        Robot.getInstance().getLeftMotorDown().getMotor().setMode(RunMode.RUN_USING_ENCODERS);
        Robot.getInstance().getRightMotorDown().getMotor().setMode(RunMode.RUN_USING_ENCODERS);
    }

}

