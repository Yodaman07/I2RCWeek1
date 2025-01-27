// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

//TankDrive is a command. It can package multiple elements of the robot together to make it move and work.
public class TankDrive extends CommandBase {
  public DriveTrain dt;
  //Creates an empty instance of the DriveTrain class
  public Joystick joy;

  /** Creates a new TankDrive. */
  public TankDrive(DriveTrain dt, Joystick j) {
    this.dt = dt;
    this.joy = j;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(dt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    dt.tankDrive(0.0, 0.0);
  }
  //Keeps the robot stationary on initilization

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftPowerRaw = joy.getRawAxis(1);

    double rightPowerRaw = joy.getRawAxis(5);

    dt.tankDrive(leftPowerRaw*0.7, rightPowerRaw*0.7);
  }//Runs the code to drive the robot. It makes the joystick power/position proportional to the talon power.

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    dt.tankDrive(0.0, 0.0);
  }
  //Ends the program by stopping the talons

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  //Detects if the program is finished
}
