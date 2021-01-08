import socket

def main(cod):

        
        try:
                miSocket=socket.socket(socket.AF_INET, socket.SOCK_STREAM)
                miSocket.connect(('192.168.12.71',65321))
                miSocket.send(cod.encode())
                respuesta = miSocket.recv(1024)
                miSocket.close()
        except:
                respuesta ="0"
        return respuesta
