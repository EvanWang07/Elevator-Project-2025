// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class QuickTuning {
    /* Controller Constants */
    public static final int driveControllerID = 0;
    public static final int weaponControllerID = 1;

    public static final double driveStickDeadband = 0.1;
    public static final double weaponStickDeadband = 0.1;

    public static final double driveSlowModeMultiplier = 0.1;
  }

  public static final class Elevator {
    /* Elevator Mechanism Details */
    public static final double elevatorGearRatio = 6;
    public static final double elevatorGearRadius = Units.inchesToMeters(1.757 / 2);
    public static final double elevatorStartingHeightInRotations = 0; // Do NOT consider gear ratio here
    public static final double minimumElevatorHeightInRotations = 0; // Do NOT consider gear ratio here
    public static final double maxElevatorHeightInRotations = 3.545; // Do NOT consider gear ratio here
    public static final double elevatorRotationToDistanceMultiplier = 2; // to compensate for the fact that the chain and carriage move at a 1:2 distance ratio.

    /* Elevator Motor Configs */
    public static final int elevatorMotorOneID = 9;
    public static final int elevatorMotorTwoID = 10;
    public static final InvertedValue elevatorMotorInvert = InvertedValue.CounterClockwise_Positive;
    public static final NeutralModeValue elevatorMotorNeutralMode = NeutralModeValue.Brake;

    /* Elevator Bounds and Tolerance */
    public static final double elevatorMotorBoundsToleranceInRotations = 0.05;
    public static final double elevatorLowerBound = (minimumElevatorHeightInRotations + elevatorMotorBoundsToleranceInRotations) * elevatorGearRatio; // Angular position of the lower bound of elevator downward movement (in rotations)
    public static final double elevatorUpperBound = (maxElevatorHeightInRotations - elevatorMotorBoundsToleranceInRotations) * elevatorGearRatio; // Angular position of the upper bound of elevator upper movement (in rotations)

    /* Target Elevator Heights (Robot Reaches L1, L2, and L3) */
    public static final double levelOneHeight = Units.inchesToMeters(11); // TODO: Get a more precise value
    public static final double levelTwoHeight = Units.inchesToMeters(28); // TODO: Get a more precise value
    public static final double levelThreeHeight = Units.inchesToMeters(43); // TODO: Get a more precise value

    public static final double levelOneHeightInRotations = Units.radiansToRotations((levelOneHeight / elevatorGearRadius) / elevatorRotationToDistanceMultiplier);
    public static final double levelTwoHeightInRotations = Units.radiansToRotations((levelTwoHeight / elevatorGearRadius) / elevatorRotationToDistanceMultiplier);
    public static final double levelThreeHeightInRotations = Units.radiansToRotations((levelThreeHeight / elevatorGearRadius) / elevatorRotationToDistanceMultiplier);

    /* Elevator Feedforward & PID Tuning Constants */
    public static final double gravitationalOffsetVoltage = 0; // Offset feedforward voltage for gravity (currently a placeholder value)
    public static final double kV = 0; // Offset feedforward constant for kinetic friction (currently a placeholder value)
    public static final double kA = 0; // Offset feedforward constant for outside forces (currently a placeholder value)
    public static final double kP = 0; // Proportional feedback constant (currently a placeholder value)
    public static final double kI = 0; // Integral feedback constant (currently a placeholder value)
    public static final double kD = 0; // Derivative feedback constant (currently a placeholder value)
    public static final double elevatorPIDSpeedCap = 0.9;     // to prevent the elevator motors from overvolting (2V)
    public static final double elevatorPIDSpeedFloor = -0.9;  // to prevent the elevator motors from undervolting (-2V)
    public static final double elevatorPIDGoalTolerance = 0.05; // tolerance (in rotations) that the PID controller will allow from goal for the atGoal() method to be true.
  }

  public static final class MailboxConstants {
    /* Elevator Motor Configs */
    public static final int MailboxMotorID = 62;
    public static final int MailboxMotorMaxVoltage = 6;

    /* Beam Breaker Configs */
    public static final int beamBreakerChannel = 0; // Placeholder
  }

}
