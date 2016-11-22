package org.firstinspires.ftc.teamcode;
/*test*/
/*plotnw*/

import android.app.Activity;
import android.graphics.Color;
import android.provider.SearchRecentSuggestions;
import android.provider.Settings;
import android.view.View;

import com.qualcomm.ftcrobotcontroller.R;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.Comparator;


@Autonomous(name = "timeAutonRGBBlue", group = "ITERATIVE_AUTON")
public class timeAutonRGBBlue extends OpMode {
    //Constants, used for determining timing, movement, magic numbers, etc
    //magic numbers for motors, makes the bot move straight when this(or multiple?) are used
    double leftMotorM = 0.5;
    double rightMotorM = 0.7;
    //Magic numbers for the servo
    private double maxPos = 0.78;
    private double minPos = 0.18;
    private double startPos = 0.48;
    //Durations. Use tuples, since that makes the organization easier. Note that the times are in milliseconds
    Tuple moveToShoot = new Tuple(new Integer(0), new Integer(700));
    Tuple shootBall1 = new Tuple(new Integer(700), new Integer(1700));
    Tuple elevateBall = new Tuple(new Integer(1400), new Integer(2400));
    Tuple shootBall2 = new Tuple(new Integer(2400), new Integer(3400));

    long start_time;
    long current_time;
    long wait_time;
    long time;

    DcMotor rightMotor = null;
    DcMotor leftMotor  = null;
    DcMotor elevator = null;
    DcMotor shooter = null;
    Servo poker = null;

    private double currentPos = startPos;
    private int beacons = 0;
    private boolean isWorkingBeacons = false;
    ColorSensor colorSensor;
    boolean bLedOn = false;

    @Override
    public void init() {

        poker = hardwareMap.servo.get("poker");
        poker.setPosition(startPos);

        colorSensor = hardwareMap.colorSensor.get("color sensor");
        colorSensor.enableLed(bLedOn);

        leftMotor = hardwareMap.dcMotor.get("left motor");
        rightMotor = hardwareMap.dcMotor.get("right motor");
        elevator = hardwareMap.dcMotor.get("elevator");
        shooter = hardwareMap.dcMotor.get("shooter");

        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        rightMotor.setDirection(DcMotor.Direction.FORWARD);
        elevator.setDirection(DcMotor.Direction.FORWARD);
    }

    @Override
    public void start() {
        super.start();
        // Save the system clock when start is pressed
        start_time = System.currentTimeMillis();
    }

    @Override
    public void loop() {
        Comparator timer = new Comparator(start_time);
        if (timer.c(moveToShoot))
        {
            leftMotor.setPower(.5);
            rightMotor.setPower(.7);
            elevator.setPower(0.0);
            shooter.setPower(0.0);
        }
        else if (timer.c(shootBall1))
        {
            leftMotor.setPower(0.0);
            rightMotor.setPower(0.0);
            elevator.setPower(0.0);
            shooter.setPower(1.0);
        }
        else if (timer.c(elevateBall))
        {
            leftMotor.setPower(0.0);
            rightMotor.setPower(0.0);
            elevator.setPower(1.0);
            shooter.setPower(0.0);
        }
        else if (timer.c(shootBall2))
        {
            leftMotor.setPower(0.0);
            rightMotor.setPower(0.0);
            elevator.setPower(0.0);
            shooter.setPower(1.0);
        }
        else if (time > 3500 && time < 300000) {
            if (beacons > 2) {
                leftMotor.setPower(0.0);
                rightMotor.setPower(0.0);
            } else {
                leftMotor.setPower(0.5);
                rightMotor.setPower(0.7);
            }

            if (colorSensor.blue() >= 2 && colorSensor.red() < 2 && beacons < 2) {
                if (!isWorkingBeacons) {
                    beacons++;
                    isWorkingBeacons = true;
                }
                wait_time = System.currentTimeMillis() - start_time;
                leftMotor.setPower(0.0);
                rightMotor.setPower(0.0);
                elevator.setPower(0.0);
                shooter.setPower(0.0);
                if (wait_time > 500)
                {
                    currentPos = minPos;
                }
                if(wait_time > 1500)
                {
                    currentPos = startPos;
                    leftMotor.setPower(0.5);
                    rightMotor.setPower(0.7);
                }
            }
        }
        else
        {
            leftMotor.setPower(0.0);//Magic numbers
            rightMotor.setPower(0.0);//Do not touch
            elevator.setPower(0.0);
            shooter.setPower(0.0);
            currentPos = startPos;
            isWorkingBeacons = false;
        }


        poker.setPosition(currentPos);

        telemetry.addData("LED", bLedOn ? "On" : "Off");
        telemetry.addData("Clear", colorSensor.alpha());
        telemetry.addData("Red  ", colorSensor.red());
        telemetry.addData("Blue ", colorSensor.blue());

        telemetry.update();

    }
    @Override
    public void stop() {
        poker.setPosition(startPos);
    }
}
