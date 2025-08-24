# CS-360 Final Project: Weight Tracking App


  Briefly summarize the requirements and goals of the app you developed. What user needs was this app designed to address?

The weight tracking app was designed to give users a simple interface with which to view and add entries to a "weight journal", allowing them to track changes and trends in their bodyweight over a period of time.
  
  What screens and features were necessary to support user needs and produce a user-centered UI for the app? How did your UI designs keep users in mind? Why were your designs successful?

Once the user registers and logs in, they are presented with the main screen: a table displaying all of their previously entered data.
From that screen, they can delete existing rows, or click on the + button to be taken to the "Add Entry" screen to create a new row.
This design is very straight-forward and uses simple elements like icons and colors to indicate what each control does.

  How did you approach the process of coding your app? What techniques or strategies did you use? How could those techniques or strategies be applied in the future?

I utilized the Single Responsibility Principle when writing the code for my app to keep functions separated as much as possible. This allowed me to develop the program component by component, and also allowed
me to quickly isolate and resolve any problems I ran into while debugging.
  
  How did you test to ensure your code was functional? Why is this process important, and what did it reveal?

Android Studio automatically generates files to execute unit tests for new apps. Additionally, I manually tested the various components of the app by feeding a multitude of different input into the app
to check for edge cases as well as typical functionality.
  
  Consider the full app design and development process from initial planning to finalization. Where did you have to innovate to overcome a challenge?

There was very little in the way of instruction for implementing a user login system. I consulted numerous outside sources and reviewed the code for other apps before settling on a simple solution.
  
  In what specific component of your mobile app were you particularly successful in demonstrating your knowledge, skills, and experience?

The data fetching functionality of the app utilizes the SQLite libraries and operates very quickly to handle user authentication and weight data entry. Further, I tried out many different configurations for displaying
this data before I finally settled on the final product which I believe to be clean and neat.
