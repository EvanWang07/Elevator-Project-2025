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

    /* Elevator Motor Configs */
    public static final int elevatorMotorOneID = 9;
    public static final int elevatorMotorTwoID = 10;
    public static final InvertedValue elevatorMotorInvert = InvertedValue.CounterClockwise_Positive;
    public static final NeutralModeValue elevatorMotorNeutralMode = NeutralModeValue.Brake;

    /* Elevator Bounds */
    public static final double elevatorLowerBound = Units.rotationsToDegrees(0.1 * elevatorGearRatio);; // in degrees - how many degrees of spin away from the lower bound should the motor brake at?
    public static final double elevatorUpperBound = Units.rotationsToDegrees(3.5 * elevatorGearRatio); // in degrees - ditto, but upper bound

    // approx travel in rotations - 0 -> 3.545

    // 1.757 in Elevator gear diameter
  }

  public static final class MailboxConstants {
    /* Elevator Motor Configs */
    public static final int MailboxMotorID = 62;
    public static final int MailboxMotorMaxVoltage = 6;

    /* Beam Breaker Configs */
    public static final int beamBreakerChannel = 102; // Placeholder
  }
}
