package org.firstinspires.ftc.useless.junkerino;

/*plotnw*/

//a device that can be in one of a set number of stable conditions depending
// on its previous condition and on the present values of its inputs.
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
@Disabled
@Autonomous(name = "Auton_BlueStrafe", group = "BLUE")
public class Auton_BlueStrafe extends OpMode {

    //Bot robot = new Bot();
    ElapsedTime timer = new ElapsedTime(0);

    int commandNumber = 1;

    private int x = 0;


    @Override
    public void init()
    {
        //robot.init(hardwareMap);
    }

    @Override
    public void start() { super.start();}
    @Override
    public void loop()
    {
    /*    telemetry.addData("FL Pos", robot.getCurPosFL());
        telemetry.addData("BL Pos", robot.getCurPosBL());
        telemetry.addData("FR Pos", robot.getCurPosFR());
        telemetry.addData("BR Pos", robot.getCurPosBR());
        telemetry.addData("Red Value", robot.getRed());
        telemetry.addData("Blue Value", robot.getBlue());
        telemetry.addData("Command", commandNumber);
        telemetry.addData("current time", timer.seconds());

        if (robot.getIsRunningToTarget())
        {
            if (((Math.abs(robot.getCurPosFL() - robot.FLtarget)) < 25) && ((Math.abs(robot.getCurPosFR() - robot.FRtarget)) < 25) && ((Math.abs(robot.getCurPosBL() - robot.BLtarget)) < 25) && ((Math.abs(robot.getCurPosBR() - robot.BRtarget)) < 25))
            {
                robot.setIsRunningToTarget(false);
            }
            telemetry.addData("inLoop", robot.getIsRunningToTarget());
            telemetry.update();
            return;
        }

        switch (commandNumber)
        {
            case 1:
                robot.runToPosition(0.7, 36);
                commandNumber++;
                break;

            case 2:
                if (x == 0)
                {
                    timer.reset();
                    robot.chill();
                    x++;
                }
                if (timer.milliseconds() < 2000)
                {

                }
                else if (timer.milliseconds() < 3000)
                {
                    robot.setShooter(1);
                }
                else if (timer.milliseconds() < 5000)
                {
                    robot.setShooter(0);
                    robot.setElevator(1);
                }
                else if (timer.milliseconds() < 5500)
                {
                    robot.setElevator(0);
                }
                else if (timer.milliseconds() < 6500 )
                {
                    robot.setShooter(1);
                }
                else if (timer.milliseconds() > 500)
                {
                    robot.setShooter(0);
                    robot.drive();
                    commandNumber++;
                }
                break;

            case 3:
                robot.runDiagRight(1,250);
                commandNumber++;
                break;

            case 4:
                robot.runToRight(1, 40);
                commandNumber++;
                break;

            case 5:
                robot.runToLeft(1, 10);
                commandNumber++;
                break;

            case 6:
                robot.drive();
                robot.runUsingEncoders();
                robot.drive(0, .3);
                commandNumber++;
                break;

            case 7:
                if (robot.getBlue() >= 3)
                {
                    robot.drive();
                    robot.runToPosition(.2, 8);
                    commandNumber++;
                }
                break;

            case 8:
                if (x == 0)
                {
                    timer.reset();
                    robot.drive();
                    robot.runUsingEncoders();
                    x++;
                }
                else if (timer.milliseconds() < 1500)
                {
                   robot.rightServoOut();
                }
                else if (timer.milliseconds() < 3000)
                {
                    robot.rightServoIn();
                }
                else if (timer.milliseconds() > 3000)
                {
                    robot.rightServoStop();
                    commandNumber++;
                }
                break;

            case 9:
                if (x == 1)
                {
                    timer.reset();
                    robot.drive(1, -.3);
                    x++;
                }
                else if (timer.milliseconds() < 1000){}
                else { commandNumber++; }
                break;

            case 10:
                if (robot.getBlue() >= 3)
                {
                    robot.drive();
                    robot.runToPosition(.2, 8);
                    commandNumber++;
                    x = 2;
                }
                break;
            case 11:
                if (x == 0)
                {
                    timer.reset();
                    robot.drive();
                    robot.runUsingEncoders();
                    x++;
                }
                else if (timer.milliseconds() < 1500)
                {
                    robot.rightServoOut();
                }
                else if (timer.milliseconds() < 3000)
                {
                    robot.rightServoIn();
                }
                else if (timer.milliseconds() > 3000)
                {
                    robot.rightServoStop();
                    commandNumber++;
                }
                break;
        }
        telemetry.addData("inLoop", robot.getIsRunningToTarget());
        telemetry.update();*/
    }

    @Override
    public void stop() {}
}
