# -*- coding: utf-8 -*-
"""
Created on Sat Feb 11 05:51:24 2023

@author: Pham Ba Huy
"""

import cv2
import math

cap = cv2.VideoCapture("video1.mkv")
frameRate = cap.get(5)
x=1
while(cap.isOpened()):
    frameId= cap.get(1)
    ret,frame = cap.read()
    if(ret!=True):
        break
    if(frameId % math.floor(frameRate)==0):
        filename = './b2' + str(int(x))+ ".jpg";x+=1
        cv2.imwrite(filename,frame)
cap.release()
print("Xong!")