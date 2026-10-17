import random
from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *

# My Mac Size: 1470 × 840
win_width, win_height = 1470, 840

skyColor = 0
thunder = True
speed = .03
rain_x = [random.uniform(-1, 1) for _ in range (150)]
rain_y = [random.uniform(-.7, 1) for _ in range (len(rain_x))]
angle = 0
wind = 0


def reference_drawings():
    
    # For my own reference
    # glBegin(GL_LINES)
    # glColor(1.0, 1.0, 1.0)
    # glVertex2d(left, 0)
    # glVertex2d(right, 0)
    # glVertex2d(0, top)
    # glVertex2d(0, bottom)
    # glEnd()
    
    glBegin(GL_LINES)
    glColor(1.0, 1.0, 1.0)
    
    # X axis and Y axis
    glVertex2f(-1, 0)
    glVertex2f(1, 0)
    glVertex2f(0, -1)
    glVertex2f(0, 1)
    
    # Diagonals
    glVertex2f(-1, 1)
    glVertex2f(1, -1)
    glVertex2f(-1, -1)
    glVertex2f(1, 1)
    
    # Top of the Ground
    glVertex2f(-1, 0.415)
    glVertex2f(1, 0.415)
    
    # Top and Bottom of grass
    glVertex2f(-1, 0.37)
    glVertex2f(1, 0.37)
    glVertex2f(-1, 0.155)
    glVertex2f(1, 0.155)
    
    # Left and right of House ceiling
    glVertex2f(-.4, 1)
    glVertex2f(-.4, -1)
    glVertex2f(.4, 1)
    glVertex2f(.4, -1)
    
    # Top and Bottom of House ceiling
    glVertex2f(-1, .46)
    glVertex2f(1, .46)
    glVertex2f(-1, .185)
    glVertex2f(1, .185)
    
    # Left and Right of the house body
    glVertex2f(-.35, 1)
    glVertex2f(-.35, -1)
    glVertex2f(.35, -1)
    glVertex2f(.35, 1)
    
    # Top and Bottom of the house body
    glVertex2f(-1, .09)
    glVertex2f(1, .09)
    glVertex2f(-1, -.185)
    glVertex2f(1, -.185)
    
    # Door and window top
    glVertex2f(-1, -.185)
    glVertex2f(1, -.185)
    
    # Door Bottom
    glVertex2f(-1, -.09)
    glVertex2f(1, -.09)
    
    # Window Bottom
    glVertex2f(-1, -.055)
    glVertex2f(1, -.055)
    
    # Left and Right of Door
    glVertex2f(-0.045, 1)
    glVertex2f(-0.045, -1)
    glVertex2f(0.045, 1)
    glVertex2f(0.045, -1)
    
    # Left Window's Left and Right
    glVertex2f(-.1, 1)
    glVertex2f(-.1, -1)
    glVertex2f(-.195, 1)
    glVertex2f(-.195, -1)
    
    # Right Window's Left and Right
    glVertex2f(.1, 1)
    glVertex2f(.1, -1)
    glVertex2f(.195, 1)
    glVertex2f(.195, -1)
    
    glEnd()
    
    # Center (0, 0)
    glPointSize(10)
    glBegin(GL_POINTS)
    glColor3f(1, 0, 0)
    glVertex2f(0, 0)
    glEnd()
    
    
    
def keyboard_listener(key, x, y):
    global skyColor, thunder
    if key == b' ':
        if thunder == True:
            skyColor += .125
            if(skyColor >=1):
                skyColor = 1
                thunder = False
        else:
            skyColor -= .125
            if skyColor <= 0:
                skyColor = 0
                thunder = True
    glutPostRedisplay()
    
    
    
def special_key_listener(key, x, y):
    global rain_x, rain_y, speed, angle, wind
    if key == GLUT_KEY_LEFT:
        angle = max(-1, angle - 1/5)
        wind = max(-.03, wind - .03/5)
    elif key == GLUT_KEY_RIGHT:
        angle = min(1, angle + 1/5)
        wind = min(.03, wind + .03/5)
    elif key == GLUT_KEY_DOWN:
        angle = 0
        wind = 0
    glutPostRedisplay()
    
    
def animate_rain():
    global rain_x, rain_y, speed, angle, wind
    
    for i in range(len(rain_x)):
        rain_x[i] += wind 
        rain_y[i] -= speed
        if rain_y[i] < -.7:
            rain_y[i] = 1
        if rain_x[i] < -1:
            rain_x[i] = 1
        if rain_x[i] > 1:
            rain_x[i] = -1
    glutPostRedisplay()
    
    
    
def draw_ground():
    glBegin(GL_TRIANGLES)
    glColor(110/255, 82/255, 18/255)
    glVertex2f(-1, -1)
    glVertex2f(1, -1)
    glVertex2f(1, 0.415)
    glVertex2f(1, 0.415)
    glVertex2f(-1, 0.415)
    glVertex2f(-1, -1)
    glEnd()
    
def draw_grasses():
    glBegin(GL_TRIANGLES)
    grassX = -1
    while grassX <= 1:
        glColor(90/255, 1, 0)
        glVertex2f(grassX, 0.155)
        glVertex2f(grassX+(1/10), 0.155)
        glColor4f(90/255, 1, 0, 0.01)
        glVertex2f(grassX+(1/10)/2, 0.37)
        grassX+=1/10
    glEnd()
    
def draw_house():
    glBegin(GL_TRIANGLES)
    
    # Ceiling
    glColor(75/255, 0, 130/255)
    glVertex2f(-.4, .185)
    glVertex2f(.4, .185)
    glVertex2f(0, .46)
    
    # House Body
    glColor(240/255, 240/255, 240/255)
    glVertex2f(-.35, -.185)
    glVertex2f(.35, -.185)
    glVertex2f(.35, .185)
    glVertex2f(.35, .185)
    glVertex2f(-.35, .185)
    glVertex2f(-.35, -.185)
    
    # Door
    glColor(23/255, 142/255, 1)
    glVertex2f(.045, -.185)
    glVertex2f(-.045, -.185)
    glVertex2f(-.045, .09)
    glVertex2f(-.045, .09)
    glVertex2f(.045, .09)
    glVertex2f(.045, -.185)
    
    # Left Window
    glVertex2f(-.1, -.055)
    glVertex2f(-.195, -.055)
    glVertex2f(-.195, .09)
    glVertex2f(-.195, .09)
    glVertex2f(-.1, .09)
    glVertex2f(-.1, -.055)
    
    # Right Window
    glVertex2f(.1, -.055)
    glVertex2f(.195, -.055)
    glVertex2f(.195, .09)
    glVertex2f(.195, .09)
    glVertex2f(.1, .09)
    glVertex2f(.1, -.055)
    
    glEnd()
    
    glLineWidth(3)
    glBegin(GL_LINES)
    
    # Lines inside window
    
    glColor(0, 0, 0)
    glVertex2f(-.1475, .09)
    glVertex2f(-.1475, -.055)
    glVertex2f(-.1, .0175)
    glVertex2f(-.195, .0175)
    
    glVertex2f(.1475, .09)
    glVertex2f(.1475, -.055)
    glVertex2f(.1, .0175)
    glVertex2f(.195, .0175)
    glEnd()
    glLineWidth(1)
    
    glPointSize(9)
    glBegin(GL_POINTS)
    
    # Door Handle
    glVertex2f(0.02, -.055)
    glEnd()
    glPointSize(1)


def draw_rains():
    global rain_x, rain_y, angle
    glLineWidth(2)
    glBegin(GL_LINES)
    for i in range(len(rain_x)):
        R, G, B , A= random.choice([(1, 1, 1, .3), (23/255, 142/255, 1, .8)])
        glColor(R, G, B, A)
        rain_l = random.uniform(.04, .15)
        slope = angle * rain_l 
        glVertex2f(rain_x[i], rain_y[i])
        glVertex2f(rain_x[i] + slope, rain_y[i] - rain_l)
    glEnd()
    glLineWidth(1)

def draw_sky():
    glBegin(GL_TRIANGLES)
    glColor(skyColor, skyColor, skyColor)
    glVertex2f(-1, .415)
    glVertex2f(1, .415)
    glVertex2f(1, 1)
    glVertex2f(1, 1)
    glVertex2f(-1, 1)
    glVertex2f(-1, .415)
    glEnd()


def setup_projection():
    glViewport(0, 0, win_width, win_height)
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    glOrtho(-1, 1, -1, 1, 0 ,1)
    glMatrixMode(GL_MODELVIEW)
    

def display():
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    glLoadIdentity()
    setup_projection()
    glColor(1.0, 1.0, 1.0)
    draw_ground()
    draw_grasses()
    draw_sky()
    draw_house()
    draw_rains()
    # reference_drawings()

    glutSwapBuffers()

def main():
    glutInit()
    glutInitDisplayMode(GLUT_RGBA)
    glutInitWindowSize(win_width, win_height)
    glutInitWindowPosition(0, 0)
    glutCreateWindow(b"Task01")
    glEnable(GL_BLEND)
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA)
    glutDisplayFunc(display)
    glutIdleFunc(animate_rain)
    glutKeyboardFunc(keyboard_listener)
    glutSpecialFunc(special_key_listener)
    glutMainLoop()
    
    
if __name__ == "__main__":
    main()
    
