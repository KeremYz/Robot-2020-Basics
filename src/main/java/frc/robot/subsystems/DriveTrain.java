/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import com.ctre.phoenix.motorcontrol.can.*;



public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  WPI_TalonSRX leftFront = new WPI_TalonSRX(Constants.DriveTrainValues.leftFrontPort);
  WPI_VictorSPX leftBack = new WPI_VictorSPX(Constants.DriveTrainValues.leftBackPort);
  WPI_TalonSRX rightFront = new WPI_TalonSRX(Constants.DriveTrainValues.rightFrontPort);
  WPI_VictorSPX rightBack = new WPI_VictorSPX(Constants.DriveTrainValues.rightBackPort);
  
  SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFront, leftBack);
  SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFront, rightBack);
  DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);
  public DriveTrain() {
    leftBack.setInverted(true);
    leftFront.setInverted(true);
    rightBack.setInverted(true);
    rightFront.setInverted(true); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void arcadeDrive(){
    drive.arcadeDrive(RobotContainer.xbox.getRawAxis(1),RobotContainer.xbox.getRawAxis(0) );
  }
  public void unnecesaryyFunc(double speed){//for testing only
    leftMotors.set(speed);
    rightMotors.set(speed);
  }
}
