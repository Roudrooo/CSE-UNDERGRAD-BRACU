import random
from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *

# My Mac Size: 1470 × 840
win_width, win_height = 1470, 840
balls = []
speed = 1
max_speed = 40
stop_flag = False
temp_speed = speed
temp_balls = balls.copy()
hide_flag = False


def mouse_listener(button, state, x, y):
    if button == GLUT_LEFT_BUTTON and state == GLUT_DOWN:
        r = random.random()
        g = random.random()
        b = random.random()
        to_x = random.choice([1, -1])
        to_y = random.choice([1, -1])
        balls.append((x, y, r, g, b, to_x, to_y))
        temp_balls.append((x, y, r, g, b, to_x, to_y))
    glutPostRedisplay()

def special_key_listener(key, x, y):
    global speed, temp_speed
    if key == GLUT_KEY_UP:
        speed = min(max_speed, speed + .5)
    elif key == GLUT_KEY_DOWN:
        speed = max(1, speed - .5)
    temp_speed = speed
    glutPostRedisplay()
    
def keyboard_listener(key, x, y):
    global speed, stop_flag, temp_speed, balls, temp_balls, hide_flag
    if key == b' ':
        if stop_flag == False:
            speed = 0
            stop_flag = True
        else:
            speed = temp_speed
            stop_flag = False
            
    if key == b'h':
        if hide_flag == False:
            temp_balls = balls.copy()
            for i in range(len(balls)):
                x, y, r, g, b, to_x, to_y = balls[i]
                balls[i] = (x, y, 0, 0, 0, to_x, to_y)
            hide_flag = True
        else:
            balls = temp_balls.copy()
            hide_flag = False
    glutPostRedisplay()
        
def draw_points():
    glPointSize(8)
    glBegin(GL_POINTS)
    for x, y, r, g, b, _, _ in balls:
        glColor(r, g, b)
        glVertex2f(x, y)
    glEnd()
    glPointSize(1)

def animate_ball():
    global balls, speed, temp_balls
    for i in range(len(balls)):
        x, y, r, g, b, to_x, to_y = balls[i]
        
        x += to_x * speed
        y += to_y * speed
        
        if x <= 0:
            x = 0
            to_x *= -1
        elif x >= win_width:
            x = win_width
            to_x *= -1
            
        if y <= 0:
            y = 0
            to_y *= -1
        elif y >= win_height:
            y = win_height
            to_y *= -1
        
        balls[i] = x, y, r, g, b, to_x, to_y
        _, _, realR, realG, realB, _, _ = temp_balls[i]
        temp_balls[i] = (x, y, realR, realG, realB, to_x, to_y)
    
    glutPostRedisplay()
    

def setup_projection():
    glViewport(0, 0, win_width, win_height)
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    glOrtho(0, win_width, win_height, 0, -1 ,1)
    glMatrixMode(GL_MODELVIEW)


def display():
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    setup_projection()
    glMatrixMode(GL_MODELVIEW)
    glLoadIdentity()
    glColor(1.0, 1.0, 1.0)
    draw_points()
    glutSwapBuffers()



def main():
    glutInit()
    glutInitDisplayMode(GLUT_RGBA)
    glutInitWindowSize(win_width, win_height)
    glutInitWindowPosition(0, 0)
    glutCreateWindow(b"Task02")
    glutDisplayFunc(display)
    glutMouseFunc(mouse_listener)
    glutIdleFunc(animate_ball)
    glutKeyboardFunc(keyboard_listener)
    glutSpecialFunc(special_key_listener)
    glutMainLoop()
    
    
if __name__ == "__main__":
    main()