N, M=map(int, input().split()) #Row and Column
Sx, Sy=map(int, input().split()) # Starting Coordinate
Gx, Gy=map(int, input().split()) # Ending Coordinate


Maze=[]
for i in range(N): # Maze
    row=input()[:M]
    Maze.append(row)
    

def heuristic(Cx, Cy): # Manhattan Distance
    return abs(Cx-Gx)+abs(Cy-Gy)

import heapq

def A_Star(Maze, Sx, Sy, Gx, Gy):
    
    direction=[ # Paths
        (-1, 0, 'U'),
        (1, 0, 'D'),
        (0, -1, 'L'),
        (0, 1, 'R')
    ]
    
    g_cost={} # Best known cost
    g_cost[(Sx, Sy)]=0
    parent={(Sx, Sy): None}
    move_taken={}
    
    pq=[]
    start_h=heuristic(Sx, Sy) #f(start)
    heapq.heappush(pq, (0+start_h, 0, (Sx, Sy)))
    
    while pq:
        fn, gn, current=heapq.heappop(pq)
        
        if current[0]==Gx and current[1]==Gy: # Goal Test Goal=(Gx, Gy)
            path=[]
            node=(Gx, Gy)
            
            while parent[node] is not None:
                path.append(move_taken[node])
                node=parent[node]
                
            path.reverse()
            return gn, ''.join(path)
            
            
        for Dx, Dy, move in direction:
            Nx, Ny=current[0]+Dx, current[1]+Dy
            
            if 0<=Nx<N and 0<=Ny<M and Maze[Nx][Ny]=='0':
                new_g=gn+1
                
                if (Nx, Ny) not in g_cost or new_g<g_cost[(Nx, Ny)]:
                    g_cost[(Nx, Ny)]=new_g
                    new_f=new_g+heuristic(Nx, Ny)
                    
                    heapq.heappush(pq, (new_f, new_g, (Nx, Ny)))
                    
                    parent[(Nx, Ny)]=current
                    move_taken[(Nx, Ny)]=move
                    
    return -1, ''

cost, path=A_Star(Maze, Sx, Sy, Gx, Gy)
print(cost)
if cost!=-1:
    print(path)
