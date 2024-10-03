## Class Contract

**Constructor**

`RGB24(int red, int green, int blue)`: Creates a new RGB24 object using integers from 0 to 255 for red, green, and blue respectively.

`RGB24(string hexOrBit)`: Creates a new RGB24 object using a string representing a 24-bit binary or a 6-digit hexadecimal.

**Properties**

`red`: An integer representing the red component of the color. Ranges from 0 to 255.

`green`: An integer representing the green component of the color. Ranges from 0 to 255.

`blue`: An integer representing the blue component of the color. Ranges from 0 to 255.

**Methods**

`setColorsByHex(string hex)`: Changes the color of the RGB24 object using a 6-digit hexadecimal. It represents red, green, and blue in order.

`setColorsByBin(string bin)`: Changes the color of the RGB24 object using a 24-bit binary. It represents red, green, and blue in order.

`setAsBlack()`: Sets the color of the RGB24 to black.

`getHex()`: Returns the hexadecimal representation of the current RGB24 color.

`getBits()`: Returns the binary representation of the current RGB24 color.

`getColorShade()`: Determines and returns whether the current RGB24 color is primarily red, green, blue, or grayscale.

`toString()`: Returns the information of the current RGB24 color as a string.
