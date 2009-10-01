Names: Jimmy Shedlick, Cheney Tsai, Michael Yu
NetID: jps26, cct8, my8

How many hours you spent on this assignment:
At least 15 hours each...probably more

People with whom you consulted on this assignment (including students, TAs, tutors, professors):
Jeff Martin, our advising TA
Other Teams to compare outputs

Resources used (e.g. books, webpages, or code repositories):
Class Website, JAVA API, Links describing implementation of functions ...

Test Classes: PicassoTest contains test methods for the program in JUnit form

To Start:
Run Main and GUI will open. Type expressions into the text field and press enter to generate image.

GUI Features/Extensions:
Pressing the enter key in the input field performs the same action as the Evaluate button.
A history of all expressions evaluated in the current session is saved in InputHandler. To view this history, use the up and down arrow keys while the text field is selected. To start it, you must press down to load the most recent expression. Evaluating a new expression at this point will add it to the list so the next time you view the history, it will again start with the most recent expression.
Pressing the Preview button will open up the current expression in the text field in a new window, and any number of these windows can be opened to compare expressions. Preview will not store the expression in history, so the user can test an expression before evaluating.
Pressing the Favorite button will add the most recent successfully evaluated expression to the list of favorites (which will be the one shown on the canvas, not any new expression written in the text field but not yet evaluated).
In the file menu there is a button to View Favorites. This will open a new window where the favorites from the current session can be viewed. Scrolling through this list can be done either with the buttons or the left and right arrow keys.

For Extensions:
1. To add new functions, simply create the token in the tokens package and add a corresponding line to
the Tokens.properties in the resource package
2. Extensions to the GUI can be added by creating a new class extending EvaluatableCommand inside
view.commands.
