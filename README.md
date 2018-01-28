# Our Goal
High school athletics is powered by a passion to compete through all physical pain and mental barriers, but this dedication can lead to chronic health problems and worsened injuries.  With the excitement of the game unfolding, many serious injuries go unnoticed or are intentionally ignored to keep players in the game, which can increase health costs for families. Our software analyzes images from sports events in real-time and notifies trainers and coaches when players appear to have experienced injuries to help increase accountability and awareness of these conditions.

# Collecting images 
Images of injuries of interest were searched in Bing.com and the links to the queried images were scraped from the page using the Google Chrome plugin called "Link Klipper."  The relevant URL's were placed in a text file, and were processed by parseBing.cpp to translate the Bing link to the original image link.

# Training the model
We populated a machine learning model using the Clarifai API with images from sports and paired these with the condition of the players in the photos.  Conditions, such as "concussion", "broken ankle", and our healthy control, were trained with 100-300 images each to allow the model to predict the probability of the injury occurance.

# Injury Notifications


# Future Directions
Our current model is trained by single images, but it would provide more accurate analysis if it compared actions in sequence and was trained on videos of injury occurences.  Use of Amazon Web Services Rekognition API would allow for training on video clips to compare how a succession of clips can be used to understand the impact of a collision on the players.
