from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *
import random
import math


win_width, win_height= 1470, 840
camera_pos = (0, 230, 230)
fpp = False
fovY = 120

enemy_pos = []
for _ in range(5):
    x = random.randint(-288, 288)
    y = random.randint(-288, 288)
    enemy_pos.append([x, y])
    
eS = 1
grow = True

life = 5
gameover = False
score = 0
missed = 0
bullet = []
bulletSpeed = 2
gunDirr = 0
Py = 0
Px = 0
cheatmode = False
cheatView = False


def draw_text(x, y, text, font=GLUT_BITMAP_HELVETICA_18):
    glColor3f(1,1,1)
    glMatrixMode(GL_PROJECTION)
    glPushMatrix()
    glLoadIdentity()
    
    gluOrtho2D(0, 1000, 0, 800) 

    
    glMatrixMode(GL_MODELVIEW)
    glPushMatrix()
    glLoadIdentity()
    
    
    glRasterPos2f(x, y)
    for ch in text:
        glutBitmapCharacter(font, ord(ch))
    
    glPopMatrix()
    glMatrixMode(GL_PROJECTION)
    glPopMatrix()
    glMatrixMode(GL_MODELVIEW)



def info():
    global gameover
    if gameover:
        draw_text(20, 760, "Game is Over. Your score is "+ str(score) + ".")
        draw_text(20, 725, '''Press "R" to RESTART the Game.''')
    else:
        draw_text(20, 760, "Player Life Remaining: "+ str(life))
        draw_text(20, 730, "Game Score: "+ str(score))
        draw_text(20, 700, "Player Bullet Missed: "+ str(missed))
    
    



def setupCamera():
    global fpp, gunDirr, Px, Py, camera_pos, win_width, win_height, cheatView, cheatmode
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    
    gluPerspective(fovY, win_width/win_height, 0.1, 1500)
    glMatrixMode(GL_MODELVIEW)
    glLoadIdentity()
    
    if fpp:
        theta = math.radians(gunDirr)
        Cx = Px
        Cy = Py
        Cz = 35

        lx = Cx - math.sin(theta) * 100
        ly = Cy + math.cos(theta) * 100
        lz = Cz

        gluLookAt(Cx, Cy, Cz,
                lx, ly, lz,
                0, 0, 1)
    else:
        x, y, z = camera_pos
        
        gluLookAt(x, y, z,
                0, 0, 0,
                0, 0, 1)


def keyboardListener(key, x, y):
    global life, score, gameover, missed, gunDirr, bullet, enemy_pos, Py, Px, cheatmode, fpp, cheatView
    if key == b'w':
        theta = math.radians(gunDirr)
        Px -= math.sin(theta) * 5
        Py += math.cos(theta) * 5
        if Px < -280:
            Px = -280
        if Px > 280:
            Px = 280
        if Py < -280:
            Py = -280
        if Py > 280:
            Py = 280

    if key == b's':
        theta = math.radians(gunDirr)
        Px += math.sin(theta) * 5
        Py -= math.cos(theta) * 5
        if Px < -280:
            Px = -280
        if Px > 280:
            Px = 280
        if Py < -280:
            Py = -280
        if Py > 280:
            Py = 280

    if key == b'a':
        gunDirr += 1

    if key == b'd':
        gunDirr -= 1

    if key == b'c':
        cheatmode = not cheatmode

    if key == b'v':
        if cheatmode and fpp:
            cheatView = not cheatView

    if key == b'r':
        if gameover:
            life = 5
            score = 0
            missed = 0
            gameover = False
            bullet.clear()
            for enemy in enemy_pos:
                enemy[0] = random.randint(-288, 288)
                enemy[1] = random.randint(-288, 288)





def specialKeyListener(key, x, y):
    global camera_pos
    x, y, z = camera_pos
    if key == GLUT_KEY_UP:
        z += 5
        if z > 500:
            z = 500

    if key == GLUT_KEY_DOWN:
        z -= 5
        if z < 50:
            z = 50

    if key == GLUT_KEY_LEFT:
        theta = math.radians(1)

        tempx = x * math.cos(theta) - y * math.sin(theta)
        tempy = x * math.sin(theta) + y * math.cos(theta)

        x = tempx
        y = tempy  

    if key == GLUT_KEY_RIGHT:
        theta = math.radians(-1)

        tempx = x * math.cos(theta) - y * math.sin(theta)
        tempy = x * math.sin(theta) + y * math.cos(theta)

        x = tempx
        y = tempy  

    camera_pos = (x, y, z)


def mouseListener(button, state, x, y):
    global gameover, bullet, gunDirr, fpp, cheatmode, cheatView
    if button == GLUT_LEFT_BUTTON and state == GLUT_DOWN: 
        if not gameover:
            theta = math.radians(gunDirr)
            x = Px - math.sin(theta) * 13
            y = Py + math.cos(theta) * 13
            bullet.append([x, y, 24, gunDirr])

    if button == GLUT_RIGHT_BUTTON and state == GLUT_DOWN:
        fpp = not fpp


def gameBoard():
    global eS, win_height, win_width, fpp, cheatView, cheatmode, gunDirr
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    glLoadIdentity()
    
    
    
    glViewport(0, 0, win_width, win_height)
    
    setupCamera()
    
    if fpp and cheatView and cheatmode:
        glPushMatrix()
        glRotatef(-gunDirr, 0, 0, 1)
    
    # Game Board
    board_w = 600
    board_h = 600
    glBegin(GL_QUADS)
    X0, Y0 = -board_w/2, -board_h/2
    for r in range(13):
        for c in range(13):
            if r % 2 == 0:
                if c % 2 == 0:
                    glColor3f(1, 1, 1)
                else:
                    glColor3f(.7, .2, 1)
            else:
                if c % 2 == 0:
                    glColor3f(.7, .2, 1)
                else:
                    glColor3f(1, 1, 1)
            glVertex3f(X0, Y0, 0)
            glVertex3f(X0 + board_w / 13, Y0, 0)
            glVertex3f(X0 + board_w / 13, Y0 + board_h / 13, 0)
            glVertex3f(X0, Y0 + board_h / 13, 0)
            X0 += board_w / 13
        X0 = -board_w/2
        Y0 += board_h / 13
    glEnd()
    
    L, H, W = 600, 50, 10

    glPushMatrix()
    glColor(0, 1, 0)
    glTranslatef(-300, 0, H/2)
    glScalef(W, L, H)
    glutSolidCube(1)
    glPopMatrix()
    
    glPushMatrix()
    glColor(0, 0, 1)
    glTranslatef(300, 0, H/2)
    glScalef(W, L, H)
    glutSolidCube(1)
    glPopMatrix()
    
    glPushMatrix()
    glColor(1, 1, 1)
    glTranslatef(0, 300, H/2)
    glScalef(L, W, H)
    glutSolidCube(1)
    glPopMatrix()
    
    glPushMatrix()
    glColor(.5, .8, 1)
    glTranslatef(0, -300, H/2)
    glScalef(L, W, H)
    glutSolidCube(1)
    glPopMatrix()
    
        
    if fpp and cheatView and cheatmode:
        glPopMatrix()
        
        
    for x, y in enemy_pos:
        Enemy(x, y, 10, eS)

        
    Player()
    drawBullet()
    
    info()
    
    glutSwapBuffers()
    



def Enemy(x, y, z, S):
    glPushMatrix()
    glTranslatef(x, y, z)
    glScalef(S, S, S)
    
    # Bottom
    glColor3f(1, 0, 0)
    gluSphere(gluNewQuadric(), 12, 10, 10)

    # Top
    glTranslatef(0, 0, 12)
    glColor3f(0, 0, 0)
    gluSphere(gluNewQuadric(), 7, 10, 10)
    glPopMatrix()



def Player():
    global gameover, gunDirr, Px, Py
    glPushMatrix()
    glTranslatef(Px, Py, 0)
    glRotatef(gunDirr, 0, 0, 1)
    if gameover:
        glRotatef(90, 1, 0, 0)
    
    
    glPushMatrix()
    glColor3f(.5, .5, 0)
    glTranslatef(0, 0, 15)
    glScalef(10, 7, 20)
    glutSolidCube(1)
    glPopMatrix()
    
    
    glPushMatrix()
    glColor3f(1, .95, .91)
    glTranslatef(-5, 0, 23.9)
    glRotatef(-90, 1, 0, 0)
    gluCylinder(gluNewQuadric(), 2, 1, 10, 20, 20)
    glPopMatrix()
    
    glPushMatrix()
    glColor3f(1, .95, .91)
    glTranslatef(5, 0, 23.9)
    glRotatef(-90, 1, 0, 0)
    gluCylinder(gluNewQuadric(), 2, 1, 10, 20, 20)
    glPopMatrix()
    
    
    glPushMatrix()
    glColor3f(0, 0, 1)
    glTranslatef(-5, 0, 7)
    glRotatef(180, 0, 1, 0)
    gluCylinder(gluNewQuadric(), 3, 1.5, 15, 20, 20)
    glPopMatrix()
    
    glPushMatrix()
    glColor3f(0, 0, 1)
    glTranslatef(5, 0, 7)
    glRotatef(180, 0, 1, 0)
    gluCylinder(gluNewQuadric(), 3, 1.5, 15, 20, 20)
    glPopMatrix()
    
    
    glPushMatrix()
    glColor3f(.7, .7, .7)
    glTranslatef(0, 0, 24)
    glRotatef(-90, 1, 0, 0)
    gluCylinder(gluNewQuadric(), 2.5, 1, 13, 20, 20)
    glPopMatrix()
    
    
    glPushMatrix()
    glColor3f(0, 0, 0)
    glTranslatef(0, 0, 29)
    gluSphere(gluNewQuadric(), 3, 10, 10)
    glPopMatrix()
    
    glPopMatrix()



def drawBullet():
    for bul in bullet:
        x = bul[0]
        y = bul[1]
        z = bul[2]
        
        glPushMatrix()
        glColor3f(1, 0, 0)
        glTranslatef(x, y, z)
        glutSolidCube(5)
        glPopMatrix()


def moveBullet():
    global bulletSpeed, missed, gameover
    for bul in bullet:
        angle = bul[3]
        theta = math.radians(angle)
        bul[0] -= math.sin(theta) * bulletSpeed
        bul[1] += math.cos(theta) * bulletSpeed
        
        if -300 > bul[0] or bul[0] > 300 or -300 > bul[1] or bul[1] > 300:
            missed += 1
            bullet.remove(bul)
            if missed > 9:
                gameover = True
    


def hit():
    global score
    for bul in bullet:
        for enemy in enemy_pos:
            bx = bul[0]
            by = bul[1]
            
            ex = enemy[0]
            ey = enemy[1]
            
            if ex - 15 < bx < ex + 15 and ey - 15 < by < ey + 15:
                score += 1
                enemy[0] = random.randint(-288, 288)
                enemy[1] = random.randint(-288, 288)
                bullet.remove(bul)
                break



def moveEnemy():
    global eS, grow, Px, Py
    for enemy in enemy_pos:
        x = enemy[0]
        y = enemy[1]
        
        if x > Px:
            x -= .05
        elif x < Px: 
            x += .05
            
        if y > Py:
            y -= .05
        elif y < Py: 
            y += .05
        
        enemy[0] = x
        enemy[1] = y
        
        if grow:
            eS += .001
            if eS >= 1.3:
                grow = False
        else:
            eS -= .001
            if eS <= .7:
                grow = True


def enemyTouched():
    global life, gameover, Py, Px
    for enemy in enemy_pos:
        x = enemy[0]
        y = enemy[1]
        
        if Px - 20 < x < Px + 20 and Py - 20 < y < Py + 20:
            life -= 1
            enemy[0] = random.randint(-288, 288)
            enemy[1] = random.randint(-288, 288)
            
            if life < 1:
                gameover = True



def cheatMode():
    global gunDirr, bullet

    if cheatmode:
        gunDirr += 2
        
        if gunDirr >= 360:
            gunDirr = 0
            
        for enemy in enemy_pos:
            x = enemy[0]
            y = enemy[1]

            dx = x - Px
            dy = y - Py
            enemyAt = math.degrees(math.atan2(-dx, dy))
            
            if enemyAt < 0:
                enemyAt += 360

            playerAt = gunDirr

            gap = abs(playerAt - enemyAt)

            if gap > 180:
                gap = 360 - gap

            if gap < 2 and len(bullet) == 0:

                theta = math.radians(gunDirr)

                x = Px - math.sin(theta) * 13
                y = Py + math.cos(theta) * 13

                bullet.append([x, y, 24, gunDirr])
                break



def idle():
    global gameover
    if not gameover:
        if cheatmode:
            cheatMode()
        moveEnemy()
        enemyTouched()
        moveBullet()
        hit()
    glutPostRedisplay()


def main():
    glutInit()
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH)
    glutInitWindowSize(win_width, win_height) 
    glutInitWindowPosition(0, 0)
    wind = glutCreateWindow(b"Shooting Game")

    glutDisplayFunc(gameBoard)
    glutKeyboardFunc(keyboardListener)
    glutSpecialFunc(specialKeyListener)
    glutMouseFunc(mouseListener)
    glutIdleFunc(idle)

    glutMainLoop()

if __name__ == "__main__":
    main()
