# Java Black Jack
<p>
I'm attempting to create a blackJack that runs 
on user's input from the command line at the
moment. From there, I'll attempt to add in 
HTTP or REST API calls and put on AWS! 
Then create a react front end. 

</p>
<h3>//TODO</h3>
<ul>
<li>Add mockito and create more robust test for 
each class. <b>Done</b>
</li>
<li>Refactor classes to different packages <b>Done</b></li>
<li>Create get/post interface <b>WIP</b> </li>
<li>Add functionality of splitting the deck</li>
</ul>
<p>Idea to create get/post. Player creates a game state
by running get new game. the response is a json object
with data about questions to ask and data to show on the
client side. the response of the player can respond in two ways.
Need to determine which works best 
</p>
<ol>
<li>The response is sent as post back to server</li>
<li>The response is sent via a new type of endpoint back to the server</li>
</ol>