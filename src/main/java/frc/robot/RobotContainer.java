/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Drive;
import frc.robot.commands.DriveControl;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drive m_robotDrive = new Drive(Constants.DriveConstants.frontRightChannel, Constants.DriveConstants.rearRightChannel,
  Constants.DriveConstants.frontLeftChannel, Constants.DriveConstants.rearLeftChannel);
  
  private final Climb m_climb = new Climb();
  private final XboxController m_controller = new XboxController(Constants.ControllerConstants.XboxControllerChannel);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_robotDrive.setDefaultCommand(new DriveControl(() -> m_controller.getX(Hand.kRight) * Constants.DriveConstants.speed_multiplier, 
    () -> -m_controller.getY(Hand.kLeft) * Constants.DriveConstants.speed_multiplier, m_robotDrive)); // robot rotation direction is opposite
    
    m_climb.startCompressor();

    new JoystickButton(m_controller, 1)
      .whenPressed(m_climb::frontDown)
      .whenReleased(m_climb::frontUp);
    
    new JoystickButton(m_controller, 2)
    .whenPressed(m_climb::rearDown)
    .whenReleased(m_climb::rearUp);
    
    new JoystickButton(m_controller, 3)
    .whenPressed(m_robotDrive::shoot);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }

  // public Command getAutonomousCommand() {
  //   // An ExampleCommand will run in autonomosus
  //   return m_autoCommand;
  // }
}
