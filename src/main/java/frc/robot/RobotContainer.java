// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.Constants.QuickTuning;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class RobotContainer {
  /* Controllers */
  private final Joystick weapons = new Joystick(QuickTuning.weaponControllerID);

  /* Weapon Controls */
  private final int elevatorAxis = XboxController.Axis.kLeftY.value;

  /* Weapon Buttons */
  private final JoystickButton intakeCoral = new JoystickButton(weapons, XboxController.Button.kLeftBumper.value);
  private final JoystickButton scoreCoral = new JoystickButton(weapons, XboxController.Button.kRightBumper.value);
  private final JoystickButton floorElevator = new JoystickButton(weapons, XboxController.Button.kA.value);
  private final JoystickButton levelOneElevator = new JoystickButton(weapons, XboxController.Button.kB.value);
  private final JoystickButton levelTwoElevator = new JoystickButton(weapons, XboxController.Button.kX.value);
  private final JoystickButton levelThreeElevator = new JoystickButton(weapons, XboxController.Button.kY.value);

  /* Subsystems */
  private final Elevator e_Elevator = new Elevator();
  private final Mailbox m_Mailbox = new Mailbox();

  /* Robot Container */
  public RobotContainer() {

    e_Elevator.setDefaultCommand(
      new TeleopElevator(
        e_Elevator,
        () -> -weapons.getRawAxis(elevatorAxis)
      )
    );
    
    // Configure the trigger bindings
    configureBindings();
  }

  /* Button Bindings */
  private void configureBindings() {
    /* Weapon Buttons */
    intakeCoral.whileTrue(new Intake(m_Mailbox, true));
    scoreCoral.whileTrue(new Intake(m_Mailbox, false)); // Could possibly use intakeCoral and have directionIsIntake be true

    floorElevator.whileTrue(new AutoElevator(e_Elevator, Constants.Elevator.elevatorLowerBound));
    levelOneElevator.whileTrue(new AutoElevator(e_Elevator, Constants.Elevator.levelOneHeightInRotations));
    levelTwoElevator.whileTrue(new AutoElevator(e_Elevator, Constants.Elevator.levelTwoHeightInRotations));
    levelThreeElevator.whileTrue(new AutoElevator(e_Elevator, Constants.Elevator.levelThreeHeightInRotations));
  }

  public Command getAutonomousCommand() {
    return null; // Leave this as null
  }
}
