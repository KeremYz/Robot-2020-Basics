/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */
  WPI_VictorSPX shooterMotor1 = new WPI_VictorSPX(Constants.ShooterValues.shooterMotor1Port);
  WPI_VictorSPX shooterMotor2 = new WPI_VictorSPX(Constants.ShooterValues.shooterMotor2Port);
  SpeedControllerGroup shooterMotors = new SpeedControllerGroup(shooterMotor1, shooterMotor2);
  public Shooter() {
    shooterMotor1.setInverted(true);
    shooterMotor2.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shoot(double speed){
    shooterMotors.set(speed);
  }



}
