@smoke
Feature: Feedback Functionality

Scenario: Submit and receive feedback on JavaTpoint.com
  Given the user navigates to JavaTpoint.com
  When the user clicks on Feedback
  Then the Feedback page opens
  And the user submits feedback message
  Then feedback should be received on the admin page
  And the admin can reply to the user
