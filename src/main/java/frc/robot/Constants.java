/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants {
        public static final int frontRightChannel = 11;
        public static final int rearRightChannel = 10;
        public static final int frontLeftChannel = 13; 
        public static final int rearLeftChannel = 12;
        public static final double speed_multiplier = 1;
    }

    public static final class ShooterConstants {
        public static final int rightMotorChannel = 14;
        public static final int leftMotorChannel = 15;
        public static final int shooterPneumaticChannel = 0; // equivalent to PneumaticConstants.shooterSolenoidChannel
    }

    public static final class IntakeConstants {
        public static final int intakeMotorChannel = 4;
        public static final int intakePneumaticChannel = 1; // equivalent to PneumaticConstants.intakeSolenoidChannel
    }

    public static final class PneumaticConstants{
        public static final int PCMChannel = 5;
        public static final int shooterSolenoidChannel = 0; // equivalent to ShooterConstants.shooterPneumaticChannel
        public static final int intakeSolenoidChannel = 1; // equivalent to IntakeConstants.intakePneumaticChannel
    }
    
    public static final class ControllerConstants {
        public static final int XboxControllerChannel = 1;
    }
}
