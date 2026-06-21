import socket

data=16
format="utf-8"
server_port=4501
hostname=socket.gethostname()
client_ip=socket.gethostbyname(hostname)
server_ip=client_ip
server_socket_add=(server_ip, server_port)

server=socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind(server_socket_add)

server.listen()
print("Server is listening...")

while True:
    server_sock, client_addr=server.accept()
    print("Connected to client: ", client_addr)
    connected=True
    while connected:
        length_upcoming=server_sock.recv(data).decode(format)
        print("Length of client message is: ", length_upcoming)
        if length_upcoming:
            message=server_sock.recv(int(length_upcoming)).decode(format)
            
            if message == "disconnect":
                connected=False
                print("Connection terminated with: ",client_addr)
                server_sock.send("BYEEEEE".encode(format))
            else: 
                print("Message from client is: ", message)
                
                count=0
                for i in message:
                    if i.lower()=="a" or i.lower()=="e" or i.lower()=="i" or i.lower()=="o" or i.lower()=="u":
                        count+=1
                        
                if count==0:
                    server_sock.send("Not enough vowels".encode(format))
                elif count<=2:
                    server_sock.send("Enough vowels I guess".encode(format))
                else:
                    server_sock.send("Too many vowels".encode(format))
                
    server_sock.close()