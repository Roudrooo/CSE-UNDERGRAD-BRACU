import math
import random
from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *

# Camera
camera_pos = (0, 500, 500)
camera_angle = 90.0
camera_height = 500.0
camera_radius = 500.0

fovY = 120
GRID_LENGTH = 600
rand_var = 423

life = 5
score = 0
bullets_missed = 0
MAX_MISSED = 10
game_over = False

fovY = 120
GRID_LENGTH = 600
rand_var = 423

first_person = False

player_pos = [0.0, 0.0, 0.0]
player_angle = 0.0
PLAYER_SPEED = 22.0




bullets = []
BULLET_SPEED = 15.0
BULLET_SIZE = 10

NUM_ENEMIES = 5
ENEMY_SPEED = 0.4
enemies = []
ENEMY_RADIUS = 40

cheat_mode = False
auto_camera = False
frozen_angle = 0.0
CHEAT_SPIN_SPEED = 3.0
CHEAT_FIRE_GAP = 15
cheat_fire_clock = 0


def spawn_enemy():
    """Pick a random spot on the grid for an enemy, far enough from the player."""
    while True:
        ex = random.uniform(-GRID_LENGTH + 60, GRID_LENGTH - 60)
        ey = random.uniform(-GRID_LENGTH + 60, GRID_LENGTH - 60)
        if math.hypot(ex - player_pos[0], ey - player_pos[1]) > 150:
            return [ex, ey, random.uniform(0, 6.28)]


def reset_game():
    global life, score, bullets_missed, game_over, player_pos, player_angle
    global bullets, enemies, cheat_mode, auto_camera, cheat_fire_clock, frozen_angle
    life = 5
    score = 0
    bullets_missed = 0
    game_over = False
    player_pos = [0.0, 0.0, 0.0]
    player_angle = 0.0
    bullets = []
    cheat_mode = False
    auto_camera = False
    cheat_fire_clock = 0
    frozen_angle = 0.0
    enemies = [spawn_enemy() for _ in range(NUM_ENEMIES)]


reset_game()


def draw_text(x, y, text, font=GLUT_BITMAP_HELVETICA_18):
    glColor3f(1, 1, 1)
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

def draw_player():

    glPushMatrix()
    glTranslatef(player_pos[0], player_pos[1], player_pos[2])
    glRotatef(player_angle, 0, 0, 1)

    if game_over:

        glRotatef(90, 1, 0, 0)

    # legs
    glColor3f(0.1, 0.1, 0.8)
    for side in (-12, 12):
        glPushMatrix()
        glTranslatef(side, 0, 20)
        glScalef(0.6, 0.6, 1.4)
        glutSolidCube(30)
        glPopMatrix()

    # torso
    glColor3f(0.33, 0.33, 0.13)
    glPushMatrix()
    glTranslatef(0, 0, 55)
    glScalef(1.1, 0.7, 1.1)
    glutSolidCube(40)
    glPopMatrix()

    # head
    glColor3f(0.94, 0.85, 0.75)
    glPushMatrix()
    glTranslatef(0, 0, 95)
    gluSphere(gluNewQuadric(), 18, 12, 12)
    glPopMatrix()

    # gun
    glColor3f(0.8, 0.8, 0.8)
    glPushMatrix()
    glTranslatef(15, 5, 60)
    glRotatef(90, 0, 1, 0)
    gluCylinder(gluNewQuadric(), 12, 1, 90, 8, 8)
    glPopMatrix()

    glPopMatrix()


def draw_enemy(enemy):

    ex, ey, phase = enemy
    pulse = 1.0 + 0.25 * math.sin(phase)

    glPushMatrix()
    glTranslatef(ex, ey, 0)

    glColor3f(1, 0, 0)
    glPushMatrix()
    glTranslatef(0, 0, ENEMY_RADIUS * 0.5 * pulse)
    gluSphere(gluNewQuadric(), ENEMY_RADIUS * pulse, 12, 12)
    glPopMatrix()

    glColor3f(0, 0, 0)
    glPushMatrix()
    glTranslatef(0, 0, ENEMY_RADIUS * 0.95 * pulse)
    gluSphere(gluNewQuadric(), ENEMY_RADIUS * 0.5 * pulse, 10, 10)
    glPopMatrix()

    glPopMatrix()


def draw_bullet(shot):
    sx, sy, sz, heading = shot
    glPushMatrix()
    glColor3f(1, 1, 0.2)
    glTranslatef(sx, sy, sz)
    glRotatef(heading, 0, 0, 1)
    glutSolidCube(BULLET_SIZE)
    glPopMatrix()


def draw_boundaries():

    wall_h = 60
    glBegin(GL_QUADS)

    glColor3f(0, 1, 1)  # back (cyan)
    glVertex3f(-GRID_LENGTH, GRID_LENGTH, 0)
    glVertex3f(GRID_LENGTH, GRID_LENGTH, 0)
    glVertex3f(GRID_LENGTH, GRID_LENGTH, wall_h)
    glVertex3f(-GRID_LENGTH, GRID_LENGTH, wall_h)

    glColor3f(1, 0, 1)  # front (magenta)
    glVertex3f(-GRID_LENGTH, -GRID_LENGTH, 0)
    glVertex3f(GRID_LENGTH, -GRID_LENGTH, 0)
    glVertex3f(GRID_LENGTH, -GRID_LENGTH, wall_h)
    glVertex3f(-GRID_LENGTH, -GRID_LENGTH, wall_h)

    glColor3f(0, 0, 1)  # left (blue)
    glVertex3f(-GRID_LENGTH, -GRID_LENGTH, 0)
    glVertex3f(-GRID_LENGTH, GRID_LENGTH, 0)
    glVertex3f(-GRID_LENGTH, GRID_LENGTH, wall_h)
    glVertex3f(-GRID_LENGTH, -GRID_LENGTH, wall_h)

    glColor3f(0, 1, 0)  # right (green)
    glVertex3f(GRID_LENGTH, -GRID_LENGTH, 0)
    glVertex3f(GRID_LENGTH, GRID_LENGTH, 0)
    glVertex3f(GRID_LENGTH, GRID_LENGTH, wall_h)
    glVertex3f(GRID_LENGTH, -GRID_LENGTH, wall_h)

    glEnd()


def draw_grid():

    tile = 60
    glBegin(GL_QUADS)
    col = -GRID_LENGTH
    ci = 0
    while col < GRID_LENGTH:
        row = -GRID_LENGTH
        ri = 0
        while row < GRID_LENGTH:
            even = (ci + ri) % 2 == 0
            glColor3f(1, 1, 1) if even else glColor3f(0.7, 0.5, 0.95)
            glVertex3f(col, row, 0)
            glVertex3f(col + tile, row, 0)
            glVertex3f(col + tile, row + tile, 0)
            glVertex3f(col, row + tile, 0)
            row += tile
            ri += 1
        col += tile
        ci += 1
    glEnd()


def draw_shapes():
    draw_grid()
    draw_boundaries()

    for enemy in enemies:
        draw_enemy(enemy)

    for shot in bullets:
        draw_bullet(shot)

    draw_player()


def fire_bullet():
    if game_over:
        return
    rad = math.radians(player_angle)
    sx = player_pos[0] + 105 * math.cos(rad)
    sy = player_pos[1] + 105 * math.sin(rad)
    bullets.append([sx, sy, 60, player_angle])

#cheat
def fire_bullet_at(enemy):

    if game_over:
        return
    ex, ey, _ = enemy
    dx = ex - player_pos[0]
    dy = ey - player_pos[1]
    aim_deg = math.degrees(math.atan2(dy, dx))
    rad = math.radians(aim_deg)
    sx = player_pos[0] + 105 * math.cos(rad)
    sy = player_pos[1] + 105 * math.sin(rad)
    bullets.append([sx, sy, 60, aim_deg])


def enemy_in_sight(enemy, tolerance=8.0):

    ex, ey, _ = enemy
    dx = ex - player_pos[0]
    dy = ey - player_pos[1]
    bearing = math.degrees(math.atan2(dy, dx)) % 360
    gap = abs((bearing - player_angle + 180) % 360 - 180)
    return gap <= tolerance


def update_bullets():
    global bullets_missed
    survivors = []
    for shot in bullets:
        rad = math.radians(shot[3])
        shot[0] += BULLET_SPEED * math.cos(rad)
        shot[1] += BULLET_SPEED * math.sin(rad)
        if abs(shot[0]) > GRID_LENGTH or abs(shot[1]) > GRID_LENGTH:
            bullets_missed += 1
            if bullets_missed >= MAX_MISSED:
                end_game()
            continue
        survivors.append(shot)
    bullets[:] = survivors


def update_enemies():
    global life
    for idx, enemy in enumerate(enemies):
        ex, ey, phase = enemy
        dx = player_pos[0] - ex
        dy = player_pos[1] - ey
        gap = math.hypot(dx, dy)
        if gap > 1:
            enemy[0] += ENEMY_SPEED * dx / gap
            enemy[1] += ENEMY_SPEED * dy / gap
        enemy[2] = phase + 0.1

        if gap < 50:
            if not cheat_mode:
                life -= 1
            enemies[idx] = spawn_enemy()

    if life <= 0:
        end_game()


def check_hits():
    global score
    survivors = []
    for shot in bullets:
        landed = False
        for idx, enemy in enumerate(enemies):
            if math.hypot(shot[0] - enemy[0], shot[1] - enemy[1]) < ENEMY_RADIUS:
                score += 1
                enemies[idx] = spawn_enemy()
                landed = True
                break
        if not landed:
            survivors.append(shot)
    bullets[:] = survivors


def end_game():
    global game_over
    game_over = True


def update_cheat_mode():
    global player_angle, cheat_fire_clock
    if not cheat_mode or game_over:
        return
    player_angle = (player_angle + CHEAT_SPIN_SPEED) % 360
    cheat_fire_clock += 1
    if cheat_fire_clock >= CHEAT_FIRE_GAP:
        for enemy in enemies:
            if enemy_in_sight(enemy):
                fire_bullet_at(enemy)
                cheat_fire_clock = 0
                break


def keyboardListener(key, x, y):
    """
    Handles keyboard inputs for player movement """
    global player_pos, player_angle, cheat_mode, auto_camera, frozen_angle

    rad = math.radians(player_angle)


    if key == b'w' and not game_over:
        player_pos[0] += PLAYER_SPEED * math.cos(rad)
        player_pos[1] += PLAYER_SPEED * math.sin(rad)

    if key == b's' and not game_over:
        player_pos[0] -= PLAYER_SPEED * math.cos(rad)
        player_pos[1] -= PLAYER_SPEED * math.sin(rad)


    if key == b'a' and not game_over and not cheat_mode:
        player_angle = (player_angle + 5) % 360


    if key == b'd' and not game_over and not cheat_mode:
        player_angle = (player_angle - 5) % 360


    if key == b'c':
        cheat_mode = not cheat_mode
        if cheat_mode:
            frozen_angle = player_angle


    if key == b'v':
        auto_camera = not auto_camera
        if not auto_camera:
            frozen_angle = player_angle


    if key == b'r':
        reset_game()


    player_pos[0] = max(-GRID_LENGTH + 40, min(GRID_LENGTH - 40, player_pos[0]))
    player_pos[1] = max(-GRID_LENGTH + 40, min(GRID_LENGTH - 40, player_pos[1]))


def specialKeyListener(key, x, y):
    """
    Handles special key inputs (arrow keys)  """
    global camera_pos, camera_angle, camera_height
    x, y, z = camera_pos


    if key == GLUT_KEY_UP:
        camera_height += 10


    if key == GLUT_KEY_DOWN:
        camera_height = max(50, camera_height - 10)


    if key == GLUT_KEY_LEFT:
        camera_angle -= 3


    if key == GLUT_KEY_RIGHT:
        camera_angle += 3

    rad = math.radians(camera_angle)
    x = camera_radius * math.cos(rad)
    y = camera_radius * math.sin(rad)
    z = camera_height

    camera_pos = (x, y, z)


def mouseListener(button, state, x, y):
    """
    Handles mouse inputs  """
    global first_person

    # Left mouse button fires a bullet
    if button == GLUT_LEFT_BUTTON and state == GLUT_DOWN:
        fire_bullet()

    # Right mouse button toggles camera tracking mode
    if button == GLUT_RIGHT_BUTTON and state == GLUT_DOWN:
        first_person = not first_person


def setupCamera():

    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()

    gluPerspective(fovY, 1.25, 0.1, 1500)
    glMatrixMode(GL_MODELVIEW)
    glLoadIdentity()

    if first_person:
        rad = math.radians(player_angle)
        eye_x = player_pos[0] + 20 * math.cos(rad)
        eye_y = player_pos[1] + 20 * math.sin(rad)
        eye_z = player_pos[2] + 100

        if cheat_mode and not auto_camera:

            aim_rad = math.radians(frozen_angle)
        else:
            aim_rad = rad

        target_x = eye_x + 200 * math.cos(aim_rad)
        target_y = eye_y + 200 * math.sin(aim_rad)
        target_z = eye_z

        gluLookAt(eye_x, eye_y, eye_z,
                  target_x, target_y, target_z,
                  0, 0, 1)
    else:
        x, y, z = camera_pos
        gluLookAt(x, y, z,
                  0, 0, 0,
                  0, 0, 1)


def idle():
    """
    Idle function that runs continuously:
    - Updates bullets, enemies and cheat-mode .
    - Triggers screen redraw for real-time updates.
    """
    if not game_over:
        update_cheat_mode()
        update_bullets()
        check_hits()
        update_enemies()

    # Ensure the screen updates with the latest changes
    glutPostRedisplay()


def showScreen():
    """
    Display function to render the game scene:
    - Clears the screen and sets up the camera.
    - Draws everything of the screen
    """
    # Clear color and depth buffers
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    glLoadIdentity()  # Reset modelview matrix
    glViewport(0, 0, 1000, 800)  # Set viewport size

    setupCamera()  # Configure camera perspective

    # HUD text
    if not game_over:
        draw_text(10, 770, f"Player Life Remaining: {life}")
        draw_text(10, 740, f"Game Score: {score}")
        draw_text(10, 710, f"Player Bullet Missed: {bullets_missed}")
    else:
        draw_text(150, 700, f"Game is Over. Your Score is {score}.")
        draw_text(150, 660, 'Press "R" to RESTART the Game.')

    draw_shapes()

    # Swap buffers for smooth rendering (double buffering)
    glutSwapBuffers()


# Main function to set up OpenGL window and loop
def main():
    glutInit()
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH)  # Double buffering, RGB color, depth test
    glutInitWindowSize(1000, 800)  # Window size
    glutInitWindowPosition(0, 0)  # Window position
    wind = glutCreateWindow(b"Bullet Frenzy")  # Create the window

    glutDisplayFunc(showScreen)  # Register display function
    glutKeyboardFunc(keyboardListener)  # Register keyboard listener
    glutSpecialFunc(specialKeyListener)
    glutMouseFunc(mouseListener)
    glutIdleFunc(idle)  # Register the idle function to move the bullet automatically

    glutMainLoop()  # Enter the GLUT main loop


if __name__ == "_main_":
    main()