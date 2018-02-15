# Notification Challenge
Description: modify an existing threaded application to make notification of state changes and toggle buttons that start and stop the threaded tasks based on the state. The buttons are to display Start Task n when the task is not running and End Task n when the task is running.

Purpose: gain experience with threads, notifications, and JavaFX UI.

Requirements:

Project Name: AudioViz
Target Platform: Java 8
Programming Language: Java 8
IDE: NetBeans 8.2

This project is to be managed in a public GitHub repository. For the challenge assignment submit the URL for the repository. The final project work is to be in the master branch.

You are to use NotifcationExamples_v2.zip provided in this module as the starting point for your application.

Modify the code to do the following:

change the notification mechanism so that states are conveyed (you come up with the states) and make it possible to detect when a thread has ended (either naturally or because ending the thread was requested).

in the UI controller make it possible to click the buttons again after the thread the start has ended.

displaying “Start Task 1”, “Start Task 2”, “Start Task 3” and when clicked start their respective tasks. When a task is running change the button to display “End Task 1” (or 2 or 3). When the “End Task n” button is displayed it can be used to stop the task. When a task stops (either because it was clicked to stop or the task naturally ends" the label on the button should change to “Start Task n”.
