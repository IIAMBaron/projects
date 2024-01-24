import requests
import time
from plyer import notification
if True :
    response = requests.get('https://www.worldometers.info/coronavirus/')
    x = response.text
    title = x.find("<title>")
    y = x[title :]
    newTitle = y.find("</title>")
    ansTitle = x[title+ len("<title>"):title + newTitle]
    startMsg = x.find("<span style=\"color:#aaa\">")
    new = x[startMsg + len("<span style=\"color:#aaa\">") :]
    endMsg = x.find("        </span>")
    msg = x[startMsg + len("<span style=\"color:#aaa\">"):endMsg]
    startMsg1 = new.find("<span>")
    endMsg1 = new.find("</span>") + startMsg1
    msg1 = new[startMsg1 + len("<span>") : endMsg1- 4]
    notification.notify(title=f'{ansTitle}',
                        message="Coronavirus Cases:"+ "\n" + f'{msg}' + "\n" + "Deaths:" + "\n" + f"{msg1}",
                        app_name='Python', app_icon='PythonIcon.ico',
                        timeout=10,
                        ticker='i',
                        toast=False,
                        hints={})
