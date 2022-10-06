The app use two sensor to measure the movement of the phone, type_accelerometer and type gravity.

use current acceleroment minus gravity in each axis will get each accleration. The biggest accleration in on direction will get reaction in the app.
if the accleration is greater than 2 and less than 7, it will open some web. 
in  x direction, you will load https://www.ecosia.org/
In y direction, you will load https://www.dogpile.com/
in z direction, you will load https://webb.nasa.gov/
If the accleration is greater than 7 in any direction, it will be considered as a shake movement.
which will open : https://jumpingjaxfitness.files.wordpress.com/2010/07/dizziness.jpg 
There is seekbar on top left of the screen which will control sensetive of the sensor. It has 6 levels and default is 2.

it will automaticly open the gravity sensor and accelerometer sensor when the app is opened and will pause when the app is not used.