import socket

data=16
format="utf-8"
server_port=4501
hostname=socket.gethostname()
client_ip=socket.gethostbyname(hostname)
server_ip=client_ip
server_socket_add=(server_ip, server_port)

client=socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(server_socket_add)

def sending_msg(msg):
    message=msg.encode(format)
    msg_length=len(message)
    msg_length_str=str(msg_length).encode(format)
    msg_length_str+=b" "*(data-len(msg_length_str))
    
    client.send(msg_length_str)
    client.send(message)
    
    sent_by_server=client.recv(128).decode(format)
    print("Message from server is: ", sent_by_server)
    
sending_msg(f"Client device name is {hostname} and ip address of client is {client_ip}")
sending_msg("disconnect")