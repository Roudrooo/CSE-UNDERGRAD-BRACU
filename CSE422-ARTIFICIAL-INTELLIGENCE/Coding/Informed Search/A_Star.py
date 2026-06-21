import heapq

def A_Star_Graph_Search(graph, heuristics, start, goal):
    PriorityQueue=[]
    g_cost={node: float('inf') for node in graph}
    g_cost[start]=0
    
    heapq.heappush(PriorityQueue, (0+heuristics[start], 0, start, [start]))
    
    while PriorityQueue:
        fn, gn, parent, path=heapq.heappop(PriorityQueue)
        
        if parent==goal:
            return path, gn
        
        for successor in graph.get(parent, {}):
            new_g=gn+graph[parent][successor]
            if new_g<g_cost.get(successor, float('inf')):
                g_cost[successor]=new_g
                new_f=new_g+heuristics[successor]
                heapq.heappush(PriorityQueue, (new_f, new_g, successor, path+[successor]))
                
    return None, None
    
    
    
    
graph = {'A': {'B': 75, 'C': 118, 'E': 140},
        'B': {'A': 75},
        'C': {'A': 118,'D': 111},
        'D': {'C': 111},
        'E': {'A': 140, 'G': 80, 'F': 99},
        'F': {'E': 99, 'I': 211},
        'G': {'E':80, 'H': 97},
        'H': {'G': 97, 'I': 101}}
heuristics = {'A': 366, 'B': 374, 'C': 329, 'D': 244, 'E': 253, 'F': 178, 'G': 193, 'H': 98, 'I': 0}

# graph = {
#     'A': {'B': 2, 'C': 2},
#     'B': {'D': 5},
#     'C': {'D': 1},
#     'D': {}
# }

# heuristics = {
#     'A': 4,  # inconsistent
#     'B': 0,
#     'C': 10,
#     'D': 0
# }


path, cost=A_Star_Graph_Search(graph, heuristics, 'A', 'I')
print(path, cost)