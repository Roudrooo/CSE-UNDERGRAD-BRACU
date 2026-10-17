# ===== OpenGL 2D Point Drawing Example =====
# This program displays a single yellow point using PyOpenGL + GLUT.

import random

from OpenGL.GL import *     # Core OpenGL functions (drawing, colors, etc.)
from OpenGL.GLUT import *   # GLUT library (window creation, display, loop)
from OpenGL.GLU import *    # OpenGL Utility Library (projection utilities)

# --- Global coordinates of the point ---
x, y = 250, 250


# ===== Function to draw a single point =====
def draw_points(x, y):
    glPointSize(25)          # Set pixel size of the point (default = 1)
    glBegin(GL_POINTS)      # Start drawing points
    glVertex2f(x+50, y+50)        # Specify the (x, y) coordinate of the point
    
    # Add new point
    # glColor(1, 0, 1)  
    glColor(random.random(), random.random(), random.random())      
    glVertex2f(200, 200)    
    
    glEnd()                 # Finish drawing
    
    # Add a new Line
    glLineWidth(10)
    glBegin(GL_LINES)
    glColor(0.45, 0.6, 0.25)
    glVertex2f(0, 250)
    glColor(0, 0, 1)
    glVertex2f(500, 250)
    
    glColor(.65, 0, 0.35)
    glVertex2f(250, 0)
    glVertex2f(250, 500)
    glEnd()
    
    # Drawing Triangle
    glBegin(GL_TRIANGLES)
    glColor(1, 0, 0)
    glVertex2f(10, 10)
    glColor(0, 1, 0)
    glVertex2f(150, 10)
    glColor(0, 0, 1)
    glVertex2f(80, 131.24)
    glEnd()
    
    # Drawing Quads
    glBegin(GL_QUADS)
    glVertex2f(300, 10)
    glVertex2f(450, 10)
    glVertex2f(450, 200)
    glVertex2f(300, 200)
    glEnd()
    


# ===== Set up 2D coordinate system =====
def setup_projection():
    glViewport(0, 0, 500, 500)     # Define the portion of the window to render to
    glMatrixMode(GL_PROJECTION)    # Switch to the projection matrix; How the world is view - The camera Lens
    glLoadIdentity()               # Reset the projection matrix
    glOrtho(0.0, 500, 0.0, 500, 0.0, 1.0)  # Define a 2D orthographic projection
    glMatrixMode(GL_MODELVIEW)     # Switch back to the modelview matrix; WHere objects are placed - Moving objects in the world


# ===== Display callback =====
def display():
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)  # Clear screen and depth buffer
    glLoadIdentity()                                    # Reset transformations
    setup_projection()                                  # Set up coordinate system
    glColor3f(1.0, 1.0, 0.0)                            # Set color (R, G, B) → Yellow
    draw_points(x, y)                                   # Draw the point
    glutSwapBuffers()                                   # Swap buffers (double buffering)


# ===== Main entry point =====
def main():
    glutInit()                               # Initialize GLUT
    glutInitDisplayMode(GLUT_RGBA)           # Set display mode: RGBA color; A --> Alpha: Controls Transparency
    glutInitWindowSize(500, 500)             # Set window size (width, height)
    glutInitWindowPosition(0, 0)             # Set window position (top-left corner)
    glutCreateWindow(b"OpenGL 2D Point")     # Create window with a title - bistring, cause opnegl
    glutDisplayFunc(display)                 # Register display callback
    glutMainLoop()                           # Start the main event-processing loop


# ===== Run the program =====
if __name__ == "__main__":
    main()
