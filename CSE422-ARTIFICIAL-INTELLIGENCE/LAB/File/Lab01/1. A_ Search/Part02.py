import sys
from collections import deque

# Filter out all blank lines
def read_line():
    while True:
        line = input().strip()
        if line:
            return line

n, m = map(int, read_line().split()) # n=no. of vertices; m=no. of edges
a, b = map(int, read_line().split()) # a=start node; b=goal node


heuristic = {}
for _ in range(n):
    x, y = map(int, read_line().split())
    heuristic[x] = y

edges = [] # Takes in tuple 
for _ in range(m):
    u, v = map(int, read_line().split())
    edges.append((u, v))
    
    
    

    
def bfs_from_goal(graph, goal):
    dist={goal: 0}
    queue=deque([goal])
    
    while queue:
        current=queue.popleft()
        for neighbor in graph[current]:
            if neighbor not in dist:
                dist[neighbor]=dist[current]+1
                queue.append(neighbor)
                
    return dist
        
    

    
    
    
def checkAdmissibility(n, m, a, b, heuristic, edges):
    # Adjacency List(Unweighted)
    graph={i:[] for i in range(1, n+1)}
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)
        
    # BFS
    trueCost=bfs_from_goal(graph, b)
    
    # Check Admissibility
    inadmissible=[]
    for node in range(1, n+1):
        h=heuristic[node]
        actualCost=trueCost.get(node, float('inf')) # inf for unreachable
        if h > actualCost:
            inadmissible.append(node)
            
    
    if not inadmissible:
        print(1)
    else:
        print(0)
        print(f"Here nodes {inadmissible} are inadmissible")
        
        
        
checkAdmissibility(n, m, a, b, heuristic, edges)