package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;





@TeleOp(name="Basic: Linear OpMode", group="Linear OpMode")

public class PIDseam extends LinearOpMode {
 
    double kp = 0.4;
    double ki = 0.6;
    double kd = 0.7;
 
   double integError = 0;
   double prevError = 0;
   

 
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontRight = null;
    private DcMotor frontLeft = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
   

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        frontLeft  = hardwareMap.get(DcMotor.class, "left_drive");
        frontRight = hardwareMap.get(DcMotor.class, "left_drive");
        backRight = hardwareMap.get(DcMotor.class, "right_drive");
        backLeft = hardwareMap.get(DcMotor.class, "left_drive");

   
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);

     
        runtime.reset();
     
        while (opModeIsActive()) {

         
            double leftPower;
            double rightPower;



         
            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

         
            frontLeft.setPower(leftPower);
            frontRight.setPower(rightPower);

         
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
 
     public double PIDcontroller(double TargetPoint, double PositionRobot) {
   
   //ram is him
   
   double propError;
   int width = 0.5;
    for (int timeInterval = 0; int timeInterval < int totalTime; int timeInterval+=0.5){
     propError = TargetPoint - PositionRobot;
    integerror += porperror * width;
 
}


    integError += propError * runtime.seconds();
    double derivError = (propError - prevError) / runtime.seconds();
    double error = (kp * propError) + (ki * integError) + (kd * derivError);
    runtime.reset();
    return error;
 }
 

}
