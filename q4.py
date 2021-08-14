#Ivan Nataren CRC549 Assignment 3 question 4
"""Write program to create the line chart"""
#I would like to say this was the hardest thing I had to do
#The complexity of this assignment overwhelmed me
#I still don't know how to properly do this

import turtle
months =["Jan","Feb", "Mar","Apr","May", "Jun"]
desktop = [80, 45,25,20,10,5]
laptop = [30,25,35,50,45,55]
tablet = [10,15,20,35,60,95]



def main(v):
  yValues = v
  t = turtle.Turtle()
  t.hideturtle()
  drawLine(t, 0, 0, 300,0 )      # Draw x-axis.
  drawLine(t, 0, 0, 0, 250)      # Draw y-axis.
  for i in range(5):
        drawLineWithDots(t, 40 + (40 * i), 2.18 * yValues[i],
                         40 + (40 * (i + 1)),2.18 * yValues[i + 1], "blue")
  drawTickMarks(t,yValues)
  displayText(t,yValues)

def drawLine(t, x1, y1, x2, y2, colorP="black"):
    ## Draw line segment from (x1, y1) to (x2, y2) having color colorP.
    t.up()
    t.goto(x1, y1)
    t.down()
    t.pencolor(colorP)
    t.goto(x2, y2)

def drawLineWithDots(t, x1, y1, x2, y2, colorP="black"):
    ## Draw line segment from (x1, y1) to (x2, y2) having color
    ## colorP and insert dots at both ends of the line segment.
    t.pencolor(colorP)
    t.up()
    t.goto(x1, y1)
    # beginning of line segment
    t.dot(5)
    t.down()
    t.goto(x2, y2)
    # end of line segment
    t.dot(5)
def drawTickMarks(t,v):
    yValues = v
    ## Draw tick marks along x-axis.
    for i in range(1, 7):
        drawLine(t, 40 * i, 0, 40 * i , 10)
    # Draw tick mark on y-axis to indicate greatest value.
    drawLine(t, 0, 15 * max(yValues), 10, 15 * max(yValues))
    # Draw tick mark on y-axis to indicate least value.
    drawLine(t, 0, 15 * min(yValues), 10, 15 * min(yValues))
def displayText(t,v):
    yValues = v
    t.pencolor("blue")
    t.up()
    # Display greatest y-value next to upper tick mark on y-axis.
    t.goto(-3, 2.18*( max(yValues)) )
    t.write(max(yValues), align="right")
    # Display least y-value next to lower tick mark on y-axis.
    t.goto(-3, 2.18*( min(yValues)))
    t.write(min(yValues), align="right")
    # Display the months below the tick marks on x-axis.
    x = 40
    for i in months:
        t.goto(x, -20)
        t.write(str(i), align="center")
        x += 40
    # Display title of graph.
    t.goto(0, -50)
    t.write("Product Trends By Month")


    



main(desktop)
main(laptop)
main(tablet)
