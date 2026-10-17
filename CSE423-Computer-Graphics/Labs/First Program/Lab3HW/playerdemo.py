def Player():
    
    # Head
    glPushMatrix()
    glColor3f(0, 0, 0)
    glTranslatef(0, 0, 145)
    gluSphere(gluNewQuadric(), 15, 10, 10)
    glPopMatrix()
    
    # Body
    glPushMatrix()
    glColor3f(.5, .5, 0)
    glTranslatef(0, 0, 75)
    glScalef(50, 35, 75)
    glutSolidCube(1)
    glPopMatrix()
    
    # Hand
    glPushMatrix()
    glColor3f(.8, .6, .4)
    glTranslatef(-25, 0, 110)
    glRotatef(-90, 1, 0, 0)
    gluCylinder(gluNewQuadric(), 10, 3, 35, 20, 20)
    glPopMatrix()
    
    glPushMatrix()
    glColor3f(.8, .6, .4)
    glTranslatef(25, 0, 110)
    glRotatef(-90, 1, 0, 0)
    gluCylinder(gluNewQuadric(), 10, 3, 35, 20, 20)
    glPopMatrix()
    
    # Leg
    glPushMatrix()
    glColor3f(0, 0, 1)
    glTranslatef(-20, 0, 35)
    glRotatef(180, 0, 1, 0)
    gluCylinder(gluNewQuadric(), 12, 5, 70, 20, 20)
    glPopMatrix()
    
    glPushMatrix()
    glColor3f(0, 0, 1)
    glTranslatef(20, 0, 35)
    glRotatef(180, 0, 1, 0)
    gluCylinder(gluNewQuadric(), 12, 5, 70, 20, 20)
    glPopMatrix()
    
    # Gun
    glPushMatrix()
    glColor3f(.7, .7, .7)
    glTranslatef(0, 35, 125)
    glRotatef(-90, 1, 0, 0)
    gluCylinder(gluNewQuadric(), 10, 2, 90, 20, 20)
    glPopMatrix()
    
    
    
    
    
    
    
    
    
    
    
    
    
def Player():
    
    # Head
    glPushMatrix()
    glColor3f(0, 0, 0)
    glTranslatef(0, 0, 28)
    gluSphere(gluNewQuadric(), 3, 10, 10)
    glPopMatrix()
    
    # Body
    glPushMatrix()
    glColor3f(.5, .5, 0)
    glTranslatef(0, 0, 15)
    glScalef(10, 7, 20)
    glutSolidCube(1)
    glPopMatrix()
    
    # Hand
    glPushMatrix()
    glColor3f(.8, .6, .4)
    glTranslatef(-5, 0, 22)
    glRotatef(-90, 1, 0, 0)
    gluCylinder(gluNewQuadric(), 2.5, .5, 10, 20, 20)
    glPopMatrix()
    
    glPushMatrix()
    glColor3f(.8, .6, .4)
    glTranslatef(5, 0, 22)
    glRotatef(-90, 1, 0, 0)
    gluCylinder(gluNewQuadric(), 2.5, .5, 10, 20, 20)
    glPopMatrix()
    
    # Leg
    glPushMatrix()
    glColor3f(0, 0, 1)
    glTranslatef(-3, 0, 5)
    glRotatef(180, 0, 1, 0)
    gluCylinder(gluNewQuadric(), 2.5, 0, 14, 20, 20)
    glPopMatrix()
    
    glPushMatrix()
    glColor3f(0, 0, 1)
    glTranslatef(3, 0, 5)
    glRotatef(180, 0, 1, 0)
    gluCylinder(gluNewQuadric(), 2.5, 0, 14, 20, 20)
    glPopMatrix()
    
    # Gun
    glPushMatrix()
    glColor3f(.7, .7, .7)
    glTranslatef(0, 0, 20)
    glRotatef(-90, 1, 0, 0)
    gluCylinder(gluNewQuadric(), 2.5, 0, 22, 20, 20)
    glPopMatrix()






def Enemy(x, y, z, scale):

    glPushMatrix()

    glTranslatef(x, y, z)
    glScalef(scale, scale, scale)

    # Bottom sphere
    glColor3f(1, 0, 0)
    gluSphere(gluNewQuadric(), 10, 10, 10)

    # Top sphere
    glTranslatef(0, 0, 12)

    glColor3f(1, 0, 0)
    gluSphere(gluNewQuadric(), 7, 10, 10)

    glPopMatrix()
    
    
    
Enemy(100, 100, 10, 1)
Enemy(-100, 100, 10, 1)
Enemy(100, -100, 10, 1)
Enemy(-100, -100, 10, 1)
Enemy(200, 0, 10, 1)




def checkBulletCollision():

    for bullet in bullets:

        for enemy in enemy_positions:

            bullet_x = bullet[0]
            bullet_y = bullet[1]

            enemy_x = enemy[0]
            enemy_y = enemy[1]

            if bullet_x > enemy_x - 20 and bullet_x < enemy_x + 20:
                if bullet_y > enemy_y - 20 and bullet_y < enemy_y + 20:

                    print("Enemy hit")
                    
                    
                    
                    
def drawGameInfo():

    draw_text(20, 760, "Score: " + str(score))
    draw_text(20, 730, "Life: " + str(life))
    draw_text(20, 700, "Missed: " + str(missed))
    
    
    
    
if key == b'w':
    angle = math.radians(gunDirr)

    player_x -= math.sin(angle) * 5
    player_y += math.cos(angle) * 5


if key == b's':
    angle = math.radians(gunDirr)

    player_x += math.sin(angle) * 5
    player_y -= math.cos(angle) * 5
    
    
    
# Move forward
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


# Move backward
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
        
        
camera_angle = 0
camera_height = 230
first_person = False

fovY = 120
