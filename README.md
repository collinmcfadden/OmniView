# Our Goal
High school athletics is powered by a passion to compete through all physical pain and mental barriers, but this dedication can lead to chronic health problems and worsened injuries.  With the excitement of the game unfolding, many serious injuries go unnoticed or are intentionally ignored to keep players in the game. Our software analyzes images from sports events in real-time and notifies trainers and coaches when players appear to have experienced injuries.

# Collecting images 
Images of injuries of interest were searched in Bing.com and the links to the queried images were scraped from the page using the Google Chrome plugin called "Link Klipper."  The relevant URL's were placed in a text file, and were processed by parseBing.cpp to translate the Bing link to the original image link.

# Training the model
We populated a machine learning model using the Clarifai API with images from sports and paired these with the condition of the players in the photos.

# Injury Notifications

