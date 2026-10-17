import random
import os
from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *
from time import time

win_width, win_height = 415, 620
diamond_speed = 15
diamond_x = random.uniform(4, 96)
diamond_y = 90
diamond_r = random.uniform(0.3, 1)
diamond_g = random.uniform(0.3, 1)
diamond_b = random.uniform(0.3, 1)
pause = False
gameover = False
catching_fail = False
catcher_x = 35
catcher_speed = 5
score = 0
t0 = time()
cheatmode = False


def reference_drawings():
    
    glBegin(GL_LINES)
    glVertex2f(Xs(5), Ys(100))
    glVertex2f(Xs(5), Ys(0))
    glVertex2f(Xs(14), Ys(100))
    glVertex2f(Xs(14), Ys(0))
    
    glVertex2f(Xs(9.5), Ys(100))
    glVertex2f(Xs(9.5), Ys(0))
    

    glVertex2f(Xs(95), Ys(100))
    glVertex2f(Xs(95), Ys(0))
    glVertex2f(Xs(86), Ys(100))
    glVertex2f(Xs(86), Ys(0))
    
    glVertex2f(Xs(45.5), Ys(100))
    glVertex2f(Xs(45.5), Ys(0))
    glVertex2f(Xs(54.5), Ys(100))
    glVertex2f(Xs(54.5), Ys(0))
    
    glVertex2f(Xs(47), Ys(100))
    glVertex2f(Xs(47), Ys(0))
    glVertex2f(Xs(53), Ys(100))
    glVertex2f(Xs(53), Ys(0))
    
    glVertex2f(Xs(0), Ys(97))
    glVertex2f(Xs(100), Ys(97))
    glVertex2f(Xs(0), Ys(91))
    glVertex2f(Xs(100), Ys(91))
    
    glVertex2f(Xs(0), Ys(94))
    glVertex2f(Xs(100), Ys(94))
    
    
    glEnd()

def mouse_listener(button, state, x, y):
    global pause, score, diamond_speed, catching_fail, gameover, t0, cheatmode
    if button == GLUT_LEFT_BUTTON and state == GLUT_DOWN:
        y = win_height - y
        
        if Xs(5) <= x <= Xs(14) and Ys(91) <= y <= Ys(97):
            print("Starting over!")
            pause = False
            score = 0
            diamond_speed = 15
            catching_fail = False
            gameover = False
            cheatmode = False
            t0 = time()
            newDiamond()
        elif Xs(45.5) <= x <= Xs(54.5) and Ys(91) <= y <= Ys(97):
            pause = not pause
        elif Xs(86) <= x <= Xs(95) and Ys(91) <= y <= Ys(97):
            print("Goodbye! Score:", score)
            # glutLeaveMainLoop()
            os._exit(0)
    glutPostRedisplay()


def keyboard_listener(key, x, y):
    global diamond_speed, catcher_speed, cheatmode
    
    if key == b'w':
        diamond_speed += 1
    elif key == b's':
        if diamond_speed > 1:
            diamond_speed -= 1
    elif key == b'a':
        if catcher_speed > 1:
            catcher_speed -= 1
    elif key == b'd':
        catcher_speed += 1
    elif key == b'c':
        cheatmode = not cheatmode
    
    glutPostRedisplay()
    

def special_key_listener(key, x, y):
    global catcher_x, catcher_speed, pause, gameover, cheatmode
    
    if not (pause or gameover or cheatmode):
        if key == GLUT_KEY_LEFT:
            catcher_x = max(0, catcher_x - catcher_speed) 
        elif key == GLUT_KEY_RIGHT:
            catcher_x = min(70, catcher_x + catcher_speed)
    glutPostRedisplay()


def newDiamond():
    global diamond_x, diamond_y, diamond_r, diamond_g, diamond_b
    diamond_x = random.uniform(4, 96)
    diamond_y = 90
    diamond_r = random.uniform(0.3, 1)
    diamond_g = random.uniform(0.3, 1)
    diamond_b = random.uniform(0.3, 1)


def FindZone(dx, dy):
    if(abs(dx) >= abs(dy)):
        if(dx >= 0 and dy >= 0): return 0
        if(dx < 0 and dy >= 0): return 3
        if(dx < 0 and dy < 0): return 4
        if(dx > 0 and dy < 0): return 7
    else:
        if(dx >= 0 and dy >= 0): return 1
        if(dx < 0 and dy >= 0): return 2
        if(dx < 0 and dy < 0): return 5
        if(dx > 0 and dy < 0): return 6
        
def FromZone0(x, y, DesiredZone):
    X, Y = x, y
    if DesiredZone == 1: 
        X = y
        Y = x
    elif DesiredZone == 2:
        X = -y
        Y = x
    elif DesiredZone == 3:
        X = -x
        Y = y
    elif DesiredZone == 4:
        X = -x
        Y = -y
    elif DesiredZone == 5:
        X = -y
        Y = -x
    elif DesiredZone == 6:
        X = y
        Y = -x
    elif DesiredZone == 7:
        X = x
        Y = -y
    return X, Y

def ToZone0(x, y, CurrentZone):
    X, Y = x, y
    if CurrentZone == 1:
        X = y
        Y = x
    elif CurrentZone == 2:
        X = y
        Y = -x
    elif CurrentZone == 3:
        X = -x
        Y = y
    elif CurrentZone == 4:
        X = -x
        Y = -y
    elif CurrentZone == 5:
        X = -y
        Y = -x
    elif CurrentZone == 6:
        X = -y
        Y = x
    elif CurrentZone == 7:
        X = x
        Y = -y
    return X, Y

def MPL(x1, y1, x2, y2):
    dx = x2 - x1
    dy = y2 - y1
    
    CurrentZone = FindZone(dx, dy)
    if CurrentZone != 0:
        x1, y1 = ToZone0(x1, y1, CurrentZone)
        x2, y2 = ToZone0(x2, y2, CurrentZone)
        
    dx = x2 - x1
    dy = y2 - y1
    
    D = 2 * dy - dx
    D_NE = 2 * (dy - dx)
    D_E = 2 * dy
    
    glBegin(GL_POINTS)
    while(x1 <= x2):
        x, y = FromZone0(x1, y1, CurrentZone)
        glVertex2f(x, y)
        x1 += 1
        if D > 0:
            y1 += 1
            D += D_NE
        else:
            D += D_E
    
    glEnd()

def BackButton():
    glColor(0, 128/255, 128/255)
    glPointSize(2)
    MPL(Xs(5), Ys(94), Xs(14), Ys(94))
    MPL(Xs(5), Ys(94), Xs(9.5), Ys(97))
    MPL(Xs(5), Ys(94), Xs(9.5), Ys(91))
    glPointSize(1)
    
def EndButton():
    glColor(1, 0, 0)
    glPointSize(2)
    MPL(Xs(86), Ys(91), Xs(95), Ys(97))
    MPL(Xs(86), Ys(97), Xs(95), Ys(91))
    glPointSize(1)
    
def PlayButton():
    glColor(1, 0.75, 0)
    glPointSize(2)
    MPL(Xs(49), Ys(91), Xs(49), Ys(97))
    MPL(Xs(51), Ys(91), Xs(51), Ys(97))
    glPointSize(1)

def PauseButton():
    glColor(1, 0.75, 0)
    glPointSize(2)
    MPL(Xs(45.5), Ys(91), Xs(45.5), Ys(97))
    MPL(Xs(45.5), Ys(91), Xs(54.5), Ys(94))
    MPL(Xs(45.5), Ys(97), Xs(54.5), Ys(94))
    glPointSize(1)
    
def Diamond():
    global diamond_x, diamond_y, diamond_r,  diamond_g, diamond_b
    glColor(diamond_r, diamond_g, diamond_b)
    glPointSize(2)
    x, y = diamond_x, diamond_y
    MPL(Xs(x), Ys(y), Xs(x+2), Ys(y+2))
    MPL(Xs(x+2), Ys(y+2), Xs(x+4), Ys(y))
    MPL(Xs(x+4), Ys(y), Xs(x+2), Ys(y-2))
    MPL(Xs(x+2), Ys(y-2), Xs(x), Ys(y))
    glPointSize(1)
    
def Catcher():
    global catcher_x, catching_fail
    if catching_fail:
        glColor(1, 0, 0)
    else:
        glColor(1, 1, 1)
    glPointSize(2)
    x = catcher_x
    MPL(Xs(x), Ys(3), Xs(x+30), Ys(3))
    MPL(Xs(x+3), Ys(0.5), Xs(x+27), Ys(0.5))
    MPL(Xs(x+3), Ys(0.5), Xs(x), Ys(3))
    MPL(Xs(x+30), Ys(3), Xs(x+27), Ys(0.5))
    glPointSize(1)
    

def hasCollided():
    global diamond_x, diamond_y, catcher_x
    return diamond_x < catcher_x + 30 and diamond_x + 4 > catcher_x and diamond_y - 2 < 3 and diamond_y + 2 > 0.5

def animate_diamond():
    global diamond_y, score, diamond_speed, catching_fail, gameover, t0, cheatmode, catcher_x, catcher_speed
    
    t1 = time()
    deltaTime = t1 - t0
    t0 = t1
    
    if not (pause or gameover):
        
        if cheatmode:
            if diamond_x < catcher_x:
                catcher_x = max(catcher_x - catcher_speed, diamond_x)
            elif diamond_x + 4 > catcher_x + 30:
                catcher_x = min(catcher_x + catcher_speed, diamond_x + 4 - 30)
            
            if catcher_x < 0:
                catcher_x = 0
            elif catcher_x > 70:
                catcher_x = 70
                
        
        diamond_y -= diamond_speed * deltaTime
        
        if hasCollided():
            score += 1
            print("Score:", score)
            diamond_speed += .5
            newDiamond()
        elif diamond_y < -4:
            catching_fail = True
            gameover = True
            print("Game Over! Score:", score)
            
    glutPostRedisplay()

def Xs(x):
    return x * win_width / 100
def Ys(y):
    return y * win_height / 100

def setup_projection():
    glViewport(0, 0, win_width, win_height)
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    glOrtho(0, win_width, 0, win_height, 0 ,1)
    glMatrixMode(GL_MODELVIEW)
    

def display():
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    glLoadIdentity()
    setup_projection()
    glColor(1.0, 1.0, 1.0)
    # reference_drawings()
    BackButton()
    EndButton()
    if pause:
        PauseButton()
    else:
        PlayButton()
    Diamond()
    Catcher()

    glutSwapBuffers()

def main():
    glutInit()
    glutInitDisplayMode(GLUT_RGBA)
    glutInitWindowSize(win_width, win_height)
    glutInitWindowPosition(527, 150)
    glutCreateWindow(b"Catch the Diamonds")
    glutDisplayFunc(display)
    glutMouseFunc(mouse_listener)
    glutKeyboardFunc(keyboard_listener)
    glutSpecialFunc(special_key_listener)
    glutIdleFunc(animate_diamond)
    glutMainLoop()
    
    
if __name__ == "__main__":
    main()